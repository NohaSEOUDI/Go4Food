package fr.nohas.go4food.client.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.nohas.go4food.R;

public class ClientInterfaceActivity extends AppCompatActivity {
    Button btt_register,btt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_interface);

        btt_register=findViewById(R.id.butt_register);
        btt_register.setOnClickListener(view -> {
            startActivity(new Intent(ClientInterfaceActivity.this,ClientMenuActivity.class));
           //startActivity(new Intent(ClientInterfaceActivity.this,ClientRegisterActivity.class));
        });

        btt_login=findViewById(R.id.butt_signIn);
        btt_login.setOnClickListener(view -> {
            startActivity(new Intent(ClientInterfaceActivity.this,ClientLoginActivity.class));
        });

    }
}