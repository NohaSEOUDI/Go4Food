package fr.nohas.go4food.driver;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.nohas.go4food.R;

public class DriverMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_menu);
        BottomNavigationView btt_Navig = findViewById(R.id.navigButt);
        btt_Navig.setBackground(null);
    }
}