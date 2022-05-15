package fr.nohas.go4food.resto.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.nohas.go4food.R;
import fr.nohas.go4food.databinding.FragmentRestoAddedErrorBinding;

//si l'enregistrement dans la bdd failed !
public class RestoAddedErrorFragment extends Fragment {
    Button errorButton;
    Fragment fragmentChoise;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_resto_added_error, container, false);
        errorButton = root.findViewById(R.id.btt_save_error);
        errorButton.setOnClickListener(View->{ // on va vers le fragement de choix
            fragmentChoise = new RestoSelectOptionFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragmentChoise).addToBackStack(null).commit();
        });
        return root;
    }
}