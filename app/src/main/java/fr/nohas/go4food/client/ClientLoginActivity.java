package fr.nohas.go4food.client;

import androidx.appcompat.app.AppCompatActivity;
import fr.nohas.go4food.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ClientLoginActivity extends AppCompatActivity {
    private TextView passwordForgetten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);

        passwordForgetten= findViewById(R.id.iforgetPass);
        passwordForgetten.setOnClickListener(View->{
           // startActivity(new Intent(ClientLoginActivity,passwordForgetten.class));
        });
    }
}