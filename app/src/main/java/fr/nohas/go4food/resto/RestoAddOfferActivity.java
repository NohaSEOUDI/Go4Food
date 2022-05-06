package fr.nohas.go4food.resto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import fr.nohas.go4food.R;
import fr.nohas.go4food.resto.fragments.RestoSelectOptionFragment;
//c'est l'activité qui hold the choises options
//ordre: fragmentSelectOption -> fragmentOneProduct or -> fragmentRestoMenu
public class RestoAddOfferActivity extends AppCompatActivity {
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto_add_offer);
        fragment = new RestoSelectOptionFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(fragment.isAdded()){
            getSupportFragmentManager().putFragment(outState,"myFirstFragment",fragment);
        }
    }

}