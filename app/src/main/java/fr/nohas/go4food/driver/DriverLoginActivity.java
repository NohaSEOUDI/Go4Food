package fr.nohas.go4food.driver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import fr.nohas.go4food.PasswordForgotten;
import fr.nohas.go4food.R;

public class DriverLoginActivity extends AppCompatActivity {
    TextView passwordForgetten;
    EditText edtMail,edtPassword;
    ProgressBar progressBar;
    Button next;
    FirebaseAuth driverSignInAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        progressBar=findViewById(R.id.progBarre_login);
        edtMail=findViewById(R.id.edt_email_adress);
        edtPassword=findViewById(R.id.edt_pass);
        passwordForgetten= findViewById(R.id.tv_iforgetPass);
        next= findViewById(R.id.btnNext);
        next.setOnClickListener(View->{
            driverLogin();
        });
        passwordForgetten.setOnClickListener(View->{
            startActivity(new Intent(DriverLoginActivity.this, PasswordForgotten.class));
        });
        driverSignInAuth=FirebaseAuth.getInstance();
    }
    public void driverLogin(){
        String edtMailStr,edtPasswordStr;
        edtMailStr=edtMail.getText().toString();
        edtPasswordStr=edtPassword.getText().toString();

        if(edtMailStr.isEmpty()){
            edtMail.setError(getString(R.string.email_adress_required));
            edtMail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(edtMailStr).matches()){
            edtMail.setError(getString(R.string.email_not_valid));
            edtMail.requestFocus();
            return;
        }
        if(edtPasswordStr.isEmpty()){
            edtPassword.setError(getString(R.string.paswd_required));
            edtPassword.requestFocus();
            return;
        }
        if(edtPasswordStr.length() < 6){
            edtPassword.setError(getString(R.string.paswd_lenght));
            edtPassword.requestFocus();
            return;
        }
        //-----------
        progressBar.setVisibility(View.VISIBLE);
        driverSignInAuth.signInWithEmailAndPassword(edtMailStr,edtPasswordStr)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){//has been login
                            //redirect to user profile
                            startActivity(new Intent(DriverLoginActivity.this, DriverMenuActivity.class));
                            progressBar.setVisibility(View.GONE);
                        }else{
                            Toast.makeText(DriverLoginActivity.this, "Failed to login !please try again", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

        return;
    }
}