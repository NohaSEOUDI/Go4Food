package fr.nohas.go4food.driver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fr.nohas.go4food.R;
import fr.nohas.go4food.driver.driverfragments.DriverHistoricFragment;
import fr.nohas.go4food.driver.driverfragments.DriverHomeFragment;
import fr.nohas.go4food.driver.driverfragments.DriverSetteingsFragment;

public class DriverMenuActivity extends AppCompatActivity {
    DriverHomeFragment driverHomeFragment;
    DriverSetteingsFragment driverSetteingsFragment;
    DriverHistoricFragment driverHistoricFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_menu);
        BottomNavigationView bottomNavigationView = findViewById(R.id.drivernavigButt);
        bottomNavigationView.setBackground(null); //pour enlever le background

        driverHomeFragment= new DriverHomeFragment();
        driverSetteingsFragment = new DriverSetteingsFragment();
        driverHistoricFragment = new DriverHistoricFragment();

        makeCurrentFragment(driverHomeFragment);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            //home , settings or other
            switch(item.getItemId()){
                case R.id.id_home:  makeCurrentFragment(driverHomeFragment); return true;
                case R.id.id_search:  makeCurrentFragment(driverHistoricFragment); return true;
               // case R.id.id_?:  makeCurrentFragment(driverHistoricFragment); return true;
                case R.id.id_account:  makeCurrentFragment(driverSetteingsFragment); return true;
            }
            return false;
        });
    }

    private void makeCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.driver_fragment_holder,fragment).commit();
    }
}
