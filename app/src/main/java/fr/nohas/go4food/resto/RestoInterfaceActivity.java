package fr.nohas.go4food.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.nohas.go4food.R;

public class RestoInterfaceActivity extends AppCompatActivity {
    Button btt_register,btt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_interface);

        btt_register=findViewById(R.id.butt_register);
        btt_register.setOnClickListener(view -> {
            startActivity(new Intent(RestoInterfaceActivity.this, RestoMenuActivity.class));
           //startActivity(new Intent(RestoInterfaceActivity.this, RestoRegisterActivity.class));
        });
        btt_login=findViewById(R.id.butt_signIn);
        btt_login.setOnClickListener(view -> {
            startActivity(new Intent(RestoInterfaceActivity.this, RestoLoginActivity.class));
        });


    }
}