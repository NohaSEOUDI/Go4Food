package fr.nohas.go4food.resto.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fr.nohas.go4food.R;

//si l'enregistrement est bien passé, on affiche Done !
public class RestoAddedDoneFragment extends Fragment {
    Button doneButton;
    Fragment fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resto_added_done, container, false);
        doneButton = rootView.findViewById(R.id.btt_save_done);

        doneButton.setOnClickListener(View->{ // on va vers le fragement de choix
            fragment = new RestoSelectOptionFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).addToBackStack(null).commit();
        });

        return rootView;
    }
}