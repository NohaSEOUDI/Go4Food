package fr.nohas.go4food.client.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import fr.nohas.go4food.R;
import fr.nohas.go4food.client.fragments.ClientCartFragment;
import fr.nohas.go4food.client.fragments.ClientHomeFragment;
import fr.nohas.go4food.client.fragments.ClientSettingsFragment;
import fr.nohas.go4food.client.dailyMeal.ClientDailyMealFragment;


public class ClientMenuActivity extends AppCompatActivity {
    private ClientHomeFragment clientHomeFragment;
    private ClientSettingsFragment clientSettingsFragment;
    private ClientDailyMealFragment clientDailyMealFragment;
    private ClientCartFragment clientCartFragment;
    BottomNavigationView bottomNavig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_menu);
        bottomNavig = findViewById(R.id.navigButtClient);
        bottomNavig.setBackground(null); //pour enlever le background


        //we inizalize all our fragment, we will add others later
        clientHomeFragment = new ClientHomeFragment(); // fragment de home
        clientSettingsFragment = new ClientSettingsFragment(); // fragment de settings
        clientDailyMealFragment = new ClientDailyMealFragment();
        clientCartFragment = new ClientCartFragment();
        makeCurrentFragment(clientHomeFragment); // by default we get home page in first

        bottomNavig.setOnItemSelectedListener(item -> {
            //home , settings or other
            switch(item.getItemId()){
                case R.id.id_home:  makeCurrentFragment(clientHomeFragment); return true;
                case R.id.id_carts:  makeCurrentFragment(clientCartFragment); return true;
                case R.id.id_search: makeCurrentFragment(clientDailyMealFragment); return true;
                case R.id.id_account:  makeCurrentFragment(clientSettingsFragment); return true;
            }
            return false;
        });
    }

    private void makeCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.client_main_fragment_holder,fragment).commit();
    }

}