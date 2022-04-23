package fr.nohas.go4food.driver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import fr.nohas.go4food.R;
import fr.nohas.go4food.client.ClientLoginActivity;
import fr.nohas.go4food.client.ClientMenuActivity;

public class DriverLoginActivity extends AppCompatActivity {
    private TextView passwordForgetten;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        passwordForgetten= findViewById(R.id.iforgetPass);
        next= findViewById(R.id.next);
        next.setOnClickListener(View->{
            startActivity(new Intent(DriverLoginActivity.this, DriverMenuActivity.class));
        });
        passwordForgetten.setOnClickListener(View->{
            // startActivity(new Intent(ClientLoginActivity,passwordForgetten.class));
        });

    }
}