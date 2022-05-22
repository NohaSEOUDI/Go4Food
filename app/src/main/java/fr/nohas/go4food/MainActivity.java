package fr.nohas.go4food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.nohas.go4food.client.activities.ClientInterfaceActivity;
import fr.nohas.go4food.driver.DriverInterfaceActivity;
import fr.nohas.go4food.resto.RestoInterfaceActivity;
//la page ou l'utilisateur fait le choix enter les 3 interfaces possibles
public class MainActivity extends AppCompatActivity {

    private Button buttonClient,buttonDriver,buttonResto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClient=findViewById(R.id.butt_client);
        buttonDriver=findViewById(R.id.butt_Driver);
        buttonResto=findViewById(R.id.butt_Resto);

        buttonClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ClientInterfaceActivity.class));
            }
        });
        buttonDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DriverInterfaceActivity.class));
            }
        });
        buttonResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RestoInterfaceActivity.class));
            }
        });

    }
}