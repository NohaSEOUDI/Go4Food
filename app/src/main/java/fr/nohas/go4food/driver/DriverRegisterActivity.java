package fr.nohas.go4food.driver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.security.identity.CipherSuiteNotSupportedException;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import fr.nohas.go4food.R;
import fr.nohas.go4food.client.ClientInterfaceActivity;
import fr.nohas.go4food.client.ClientLoginActivity;
import fr.nohas.go4food.client.ClientRegisterActivity;

public class DriverRegisterActivity extends AppCompatActivity {
    FirebaseAuth driverAuth;
    EditText fName,lName,city,age,adress,emailAdress,phoneNumber,mdp;
    Spinner spinnerTypeVehicule;
    RadioButton radioButton;
    Button validate_btn;
    ProgressBar progressBar;
    String spinnerStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_register);

        fName=findViewById(R.id.edt_fName);
        lName=findViewById(R.id.edt_lName);
        city=findViewById(R.id.edt_city);
        age=findViewById(R.id.edt_age);
        adress=findViewById(R.id.edt_adress);
        emailAdress=findViewById(R.id.edt_email_adress);
        mdp=findViewById(R.id.edt_pass);
        phoneNumber=findViewById(R.id.edt_numTel);
        radioButton=findViewById(R.id.radioButton);
        validate_btn=findViewById(R.id.btn_next);
        progressBar=findViewById(R.id.progBarre_registerDriver);


        spinnerTypeVehicule=findViewById(R.id.spinner_typeV); // We need an array adapter to fit the spinner with array String
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.spinner_type_of_vehicule, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeVehicule.setAdapter(adapter);
        spinnerTypeVehicule.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                spinnerStr=adapterView.getItemAtPosition(position)+"";
                Toast.makeText(DriverRegisterActivity.this, "Your select"+adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        //initialiez FireBase Auth
        driverAuth=FirebaseAuth.getInstance();
        /*if(driverAuth.getCurrentUser() != null){
            Toast.makeText(this, "You already have an account", Toast.LENGTH_SHORT).show();
            return;
        }*/

        validate_btn.setOnClickListener(View->{
            if(driverRegister())
                startActivity(new Intent(DriverRegisterActivity.this,DriverMenuActivity.class));
            else
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        });

    }
    public boolean driverRegister(){
        String fNameStr,lNameStr,cityStr,ageStr,adressStr,emailAdressStr,phoneNumberStr,mdpStr,radioBtn;

        fNameStr=fName.getText().toString();
        lNameStr=lName.getText().toString();
        cityStr=city.getText().toString();
        ageStr=age.getText().toString();
        adressStr=adress.getText().toString();
        emailAdressStr=emailAdress.getText().toString();
        phoneNumberStr=phoneNumber.getText().toString();
        mdpStr=mdp.getText().toString();
        radioBtn=radioButton.getText().toString();


        //for validation
        if(fNameStr.isEmpty()){
            fName.setError(getString(R.string.fName_required));
            fName.requestFocus();
            return false;
        }
        if(lNameStr.isEmpty()){
            lName.setError(getString(R.string.lName_required));
            lName.requestFocus();
            return false;
        }
        if(cityStr.isEmpty()){
            city.setError(getString(R.string.city_required));
            city.requestFocus();
            return false;
        }
        if(ageStr.isEmpty()){
            age.setError(getString(R.string.age_required));
            age.requestFocus();
            return false;
        }
        if(adressStr.isEmpty()){
            adress.setError(getString(R.string.age_required));
            adress.requestFocus();
            return false;
        }
        if(emailAdressStr.isEmpty()){
            emailAdress.setError(getString(R.string.email_adress_required));
            emailAdress.requestFocus();
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailAdressStr).matches()){
            emailAdress.setError(getString(R.string.email_not_valid));
            emailAdress.requestFocus();
            return false;
        }
        if(phoneNumberStr.isEmpty()){
            phoneNumber.setError(getString(R.string.phone_required));
            phoneNumber.requestFocus();
            return false;
        }
        if(mdpStr.isEmpty()){
            mdp.setError(getString(R.string.paswd_required));
            mdp.requestFocus();
            return false;
        }
        if(mdpStr.length() < 6){
            mdp.setError(getString(R.string.paswd_lenght));
            mdp.requestFocus();
            return false;
        }
        if(radioBtn.isEmpty()){
            radioButton.setError(getString(R.string.field_required));
            radioButton.requestFocus();
            return false;
        }
        int ageInInteger= Integer.parseInt(ageStr);
        boolean radiobtnToBool= Boolean.parseBoolean(radioBtn);

        ///------------
        progressBar.setVisibility(View.VISIBLE);
        driverAuth.createUserWithEmailAndPassword(emailAdressStr,mdpStr)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        //   String d_nom, String d_prenom,String d_city, String d_adress, String d_adressmail, String d_numTel, String d_password, int d_age,TypeVehicule d_typeVehicule, Boolean d_receve_delivery_commandes)
                        Driver driver = new Driver(fNameStr,lNameStr,cityStr,adressStr,emailAdressStr,phoneNumberStr,mdpStr,ageInInteger,spinnerStr,radiobtnToBool);
                        FirebaseDatabase.getInstance().getReference("Driver")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(driver).addOnCompleteListener(task1 -> {
                            if(task1.isSuccessful()){
                                Toast.makeText(this, "Register successfully", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }else {
                                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        });
                    }else{
                        Toast.makeText(this, "Error again", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
        return true;
    }

}
