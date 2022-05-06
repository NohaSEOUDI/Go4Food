package fr.nohas.go4food.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import fr.nohas.go4food.R;


public class ClientMenuActivity extends AppCompatActivity {
    private ClientHomeFragment clientHomeFragment;
    private ClientSettingsFragment clientSettingsFragment;
    BottomNavigationView bottomNavig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_menu);
        bottomNavig = findViewById(R.id.navigButtClient);
        bottomNavig.setBackground(null); //pour enlever le background


        //we inizalize all our fragment, we will add others later
        clientHomeFragment=new ClientHomeFragment();
        clientSettingsFragment=new ClientSettingsFragment();

        makeCurrentFragment(clientHomeFragment); // by default we get home page in first

        bottomNavig.setOnItemSelectedListener(item -> {
            //home , settings or other
            switch(item.getItemId()){
                case R.id.id_home:  makeCurrentFragment(clientHomeFragment); return true;
                case R.id.id_account:  makeCurrentFragment(clientSettingsFragment); return true;
            }
            return false;
        });
    }

    private void makeCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.client_main_fragment_holder,fragment).commit();
    }

}