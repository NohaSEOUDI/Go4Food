package fr.nohas.go4food.resto.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import fr.nohas.go4food.R;
//fragmenet de selection de choix entre formule(Menu complet) et une seule produit
public class RestoSelectOptionFragment extends Fragment {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btt_validation;
    Fragment fragment2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resto_select_option, container, false);
        radioGroup = rootView.findViewById(R.id.rb_group);
        btt_validation = rootView.findViewById(R.id.btt_save);

        btt_validation.setOnClickListener(View ->{
            //pour avoir la valeur de radio button
            int radioId = radioGroup.getCheckedRadioButtonId();
            radioButton = rootView.findViewById(radioId);


            if(radioButton.getText()==getString(R.string.menu)) {
                fragment2= new RestoMenuFragment(); // R.id.frameLayout c'est le frameLayout qui se trouve dans Mainactivity
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment2).addToBackStack(null).commit(); // pour retourner au fragement précédent :o
                //Toast.makeText(getActivity(), "Menu", Toast.LENGTH_SHORT).show();
            }
            else {
                fragment2= new RestoOneProductFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment2).addToBackStack(null).commit(); // pour retourner au fragement précédent :o
                //Toast.makeText(getActivity(), "One product", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

}