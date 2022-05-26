package fr.nohas.go4food.client.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import fr.nohas.go4food.PasswordForgotten;
import fr.nohas.go4food.R;

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

public class ClientLoginActivity extends AppCompatActivity {
    TextView passwordForgetten;
    EditText mail,password;
    Button login;
    ProgressBar roundProgBarre;
    FirebaseAuth clientSignInAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);

        mail=findViewById(R.id.edt_email_adress);
        password=findViewById(R.id.edt_pass);
        roundProgBarre=findViewById(R.id.progBarr_cl_login);


        passwordForgetten= findViewById(R.id.tv_iforgetPass);
        login= findViewById(R.id.btn_next);

        login.setOnClickListener(View->{
            userLogin();
        });
        passwordForgetten.setOnClickListener(View->{
            startActivity(new Intent(ClientLoginActivity.this, PasswordForgotten.class));
        });

        clientSignInAuth=FirebaseAuth.getInstance();
    }
    public void userLogin(){
       String mailStr,passwordStr;
        mailStr=mail.getText().toString();
        passwordStr=password.getText().toString();

        if(mailStr.isEmpty()){
            mail.setError(getString(R.string.email_adress_required));
            mail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mailStr).matches()){
            mail.setError(getString(R.string.email_not_valid));
            mail.requestFocus();
            return;
        }
        if(passwordStr.isEmpty()){
            password.setError(getString(R.string.paswd_required));
            password.requestFocus();
            return;
        }
        if(passwordStr.length() < 6){
            password.setError(getString(R.string.paswd_lenght));
            password.requestFocus();
            return;
        }
        //-----------
        roundProgBarre.setVisibility(View.VISIBLE);
        clientSignInAuth.signInWithEmailAndPassword(mailStr,passwordStr)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){//has been login
                            //redirect to user profile
                            startActivity(new Intent(ClientLoginActivity.this, ClientMenuActivity.class));
                            roundProgBarre.setVisibility(View.GONE);
                        }else{
                            Toast.makeText(ClientLoginActivity.this, "Failed to login ! please check your connexion", Toast.LENGTH_SHORT).show();
                            roundProgBarre.setVisibility(View.GONE);
                        }
                    }
                });

        return;
    }
}