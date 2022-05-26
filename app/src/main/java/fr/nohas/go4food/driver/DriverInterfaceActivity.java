package fr.nohas.go4food.driver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.nohas.go4food.R;

public class DriverInterfaceActivity extends AppCompatActivity {
    Button btt_register,btt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_interface);

        btt_register=findViewById(R.id.butt_register);
        btt_register.setOnClickListener(view -> {
            startActivity(new Intent(DriverInterfaceActivity.this, DriverMenuActivity.class));
            startActivity(new Intent(DriverInterfaceActivity.this, DriverRegisterActivity.class));
        });

        btt_login=findViewById(R.id.butt_signIn);
        btt_login.setOnClickListener(view -> {
            startActivity(new Intent(DriverInterfaceActivity.this, DriverLoginActivity.class));
        });
    }
}