package fr.nohas.go4food.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import fr.nohas.go4food.R;
import fr.nohas.go4food.driver.DriverLoginActivity;
import fr.nohas.go4food.driver.DriverRegisterActivity;

public class RestoRegisterActivity extends AppCompatActivity {
    private FirebaseAuth restoAuth;
    private EditText restoName,adress,city,mail,password,phoneNumber;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_register);

        restoName = findViewById(R.id.edt_resto_name);
        adress = findViewById(R.id.edt_adress);
        city = findViewById(R.id.edt_city);
        mail = findViewById(R.id.edt_email_adress);
        password = findViewById(R.id.edt_pass);
        phoneNumber = findViewById(R.id.edt_numTel);
        Button nextButton = findViewById(R.id.btt_next);
        progressBar=findViewById(R.id.pbar_progressBarRound);

        //initialize Firebase auth
        restoAuth = FirebaseAuth.getInstance();
        /*if(restoAuth.getCurrentUser() != null){
            Toast.makeText(this, "You have already an account !", Toast.LENGTH_SHORT).show();
        }*/
        nextButton.setOnClickListener(View->{
            if(registerResto())
                startActivity(new Intent(RestoRegisterActivity.this,RestoWeelyPlanningActivity.class));
            else
                Toast.makeText(this, getString(R.string.error_toast_msg), Toast.LENGTH_SHORT).show();
        });
    }
    public boolean registerResto(){
        String restoNameStr,adressStr,cityStr,mailStr,passwordStr,phoneNumberStr;

        //get data from EditText ointo String variables
           restoNameStr = restoName.getText().toString();
           adressStr = adress.getText().toString();
           cityStr = city.getText().toString();
           mailStr = mail.getText().toString();
           passwordStr = password.getText().toString();
           phoneNumberStr = phoneNumber.getText().toString();

        //check if user fill all the fields before sending data to firebase
        if(restoNameStr.isEmpty()){
            restoName.setError(getString(R.string.nameResto_required));
            restoName.requestFocus();
            return false;
        }
        if(adressStr.isEmpty()){
            adress.setError(getString(R.string.adress_required));
            adress.requestFocus();
            return false;
        }
        if(cityStr.isEmpty()){
            city.setError(getString(R.string.city_required));
            city.requestFocus();
            return false;
        }
        if(mailStr.isEmpty()){
            mail.setError(getString(R.string.email_adress_required));
            mail.requestFocus();
            return false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(mailStr).matches()){
            mail.setError(getString(R.string.email_not_valid));
            mail.requestFocus();
            return false;
        }

        if(passwordStr.isEmpty()){
            password.setError(getString(R.string.paswd_required));
            password.requestFocus();
            return false;
        }
        if(passwordStr.length() < 6){
            password.setError(getString(R.string.paswd_lenght));
            password.requestFocus();
            return false;
        }

        if(phoneNumberStr.isEmpty()){
            phoneNumber.setError(getString(R.string.phone_required));
            phoneNumber.requestFocus();
            return false;
        }
        //--------si tout va bien
        progressBar.setVisibility(View.VISIBLE);
        restoAuth.createUserWithEmailAndPassword(mailStr,passwordStr)
                .addOnCompleteListener(task->{
                    if(task.isSuccessful()){
                        //we create a resto object
                        Resto resto= new Resto(restoNameStr,adressStr,mailStr,cityStr,passwordStr,phoneNumberStr);
                        FirebaseDatabase.getInstance().getReference("Resto")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(resto).addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()){
                                        Toast.makeText(RestoRegisterActivity.this, "Resto has been registred :)", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                        //redirect to login layout
                                    }else{
                                        Toast.makeText(RestoRegisterActivity.this, "Error ! ", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                });
                    }else{
                        Toast.makeText(RestoRegisterActivity.this, "Error occuered !", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
        return true;
    }
}