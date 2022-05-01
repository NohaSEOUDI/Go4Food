package fr.nohas.go4food.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.nohas.go4food.R;
import fr.nohas.go4food.client.ClientLoginActivity;
import fr.nohas.go4food.client.ClientMenuActivity;

public class RestoLoginActivity extends AppCompatActivity {
    private TextView passwordForgetten;
    private Button next;
    private EditText mail,mdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_login);

        mail=findViewById(R.id.edt_email_adress);
        mdp=findViewById(R.id.edt_pass);

        next= findViewById(R.id.btt_continue);
        passwordForgetten= findViewById(R.id.iforgetPass);

        next.setOnClickListener(View->{
            String email = mail.getText().toString();
            String passwordTxt = mdp.getText().toString();
            //vérification
            if(email.isEmpty() || passwordTxt.isEmpty()){
                Toast.makeText(this,getString(R.string.error_toast_msg), Toast.LENGTH_SHORT).show();
            }else{
                startActivity(new Intent(RestoLoginActivity.this, RestoMenuActivity.class));
            }
        });

      /*  passwordForgetten.setOnClickListener(View->{
            // startActivity(new Intent(ClientLoginActivity,passwordForgetten.class));
        });*/
    }
}