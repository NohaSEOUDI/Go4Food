package fr.nohas.go4food.resto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.nohas.go4food.R;
public class RestoMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_menu);
        BottomNavigationView btt_Navig = findViewById(R.id.navigButt);
        btt_Navig.setBackground(null);
        btt_Navig.getMenu().getItem(2).setEnabled(false);

    }
}