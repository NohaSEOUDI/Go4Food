package fr.nohas.go4food.resto;

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
import fr.nohas.go4food.client.ClientLoginActivity;
import fr.nohas.go4food.client.ClientMenuActivity;
import fr.nohas.go4food.driver.DriverLoginActivity;
import fr.nohas.go4food.driver.DriverMenuActivity;

public class RestoLoginActivity extends AppCompatActivity {
    TextView passwordForgetten;
    Button next;
    EditText mail,mdp;
    ProgressBar progressBar;
    FirebaseAuth restoSignInAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_login);

        mail=findViewById(R.id.edt_email_adress);
        mdp=findViewById(R.id.edt_pass);

        next = findViewById(R.id.btt_continue);
        progressBar = findViewById(R.id.progb_round);
        passwordForgetten= findViewById(R.id.tv_iforgetPass);

        next.setOnClickListener(View->{
            restoLogin();
        });

      passwordForgetten.setOnClickListener(View->{
             startActivity(new Intent(RestoLoginActivity.this, PasswordForgotten.class));
        });

        restoSignInAuth=FirebaseAuth.getInstance();
    }

    public void restoLogin(){
        String mailStr,passwordStr;

        mailStr=mail.getText().toString();
        passwordStr=mdp.getText().toString();

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
            mdp.setError(getString(R.string.paswd_required));
            mdp.requestFocus();
            return;
        }
        if(passwordStr.length() < 6){
            mdp.setError(getString(R.string.paswd_lenght));
            mdp.requestFocus();
            return;
        }
        //-----------
        progressBar.setVisibility(View.VISIBLE);
        restoSignInAuth.signInWithEmailAndPassword(mailStr,passwordStr)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){//has been login
                            //redirect to user profile
                            startActivity(new Intent(RestoLoginActivity.this, RestoMenuActivity.class));
                            progressBar.setVisibility(View.GONE);
                        }else{
                            Toast.makeText(RestoLoginActivity.this, "Failed to login !please try again", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

        return;
    }
}