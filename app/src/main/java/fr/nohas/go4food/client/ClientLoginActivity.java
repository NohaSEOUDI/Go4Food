package fr.nohas.go4food.client;

import androidx.appcompat.app.AppCompatActivity;
import fr.nohas.go4food.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ClientLoginActivity extends AppCompatActivity {
    private TextView passwordForgetten;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_login);

        passwordForgetten= findViewById(R.id.iforgetPass);
        next= findViewById(R.id.next);
        next.setOnClickListener(View->{
            startActivity(new Intent(ClientLoginActivity.this, ClientMenuActivity.class));
        });
        passwordForgetten.setOnClickListener(View->{
           // startActivity(new Intent(ClientLoginActivity,passwordForgetten.class));
        });
    }
}