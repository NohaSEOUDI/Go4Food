package fr.nohas.go4food.resto.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import fr.nohas.go4food.R;


public class NextResourcesFragment extends Fragment {
    ImageView image;
    TextView tv1,tv2;
    public NextResourcesFragment(int img, String s1,String s2){
        //this.image = img;
        //tv1,tv2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_next_resources, container, false);

        return viewRoot;
    }
}