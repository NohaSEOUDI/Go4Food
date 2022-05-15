package fr.nohas.go4food.resto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import fr.nohas.go4food.R;
import fr.nohas.go4food.resto.fragments.SettingsFragment;
import fr.nohas.go4food.resto.fragments.HomeFragment;
//page de home où il ya la buttom bar jaunne
public class RestoMenuActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private SettingsFragment settingsFragment;
    BottomNavigationView btt_Navig;
    FloatingActionButton flap_action_button; // round button

    public RestoMenuActivity() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_menu);

        flap_action_button=findViewById(R.id.flabActionbutton);
        flap_action_button.setOnClickListener(View->{
            startActivity(new Intent(RestoMenuActivity.this,RestoAddOfferActivity.class));
        });
        btt_Navig = findViewById(R.id.navigButt);

        //to disable button under plus button
        btt_Navig.setBackground(null);
        btt_Navig.getMenu().getItem(2).setEnabled(false);

        //we inizalize all our fragment
        homeFragment=new HomeFragment();
        settingsFragment=new SettingsFragment();

        makeCurrentFragment(homeFragment); // by default we get home page in first
        btt_Navig.setOnItemSelectedListener(item -> {
            //home , settings or other
            switch(item.getItemId()){
                case R.id.id_home:  makeCurrentFragment(homeFragment); return true;
                case R.id.id_account:  makeCurrentFragment(settingsFragment); return true;
            }
            return false;
        });
    }
    private void makeCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_holder,fragment).commit();
       /* FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment_holder,fragment); // R.id.frameLayout dans l'activity main .xml
        fragmentTransaction.commit();*/
    }
}