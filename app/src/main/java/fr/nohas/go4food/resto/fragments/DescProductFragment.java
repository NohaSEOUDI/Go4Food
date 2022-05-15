package fr.nohas.go4food.resto.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import fr.nohas.go4food.R;


public class DescProductFragment extends Fragment {
    ImageView im;
    TextView name,description,price,variation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_desc_product, container, false);

        im = v.findViewById(R.id.imageView);
        name=v.findViewById(R.id.tv_name);
        price=v.findViewById(R.id.tv_price);
        variation=v.findViewById(R.id.tv_variation);
        description=v.findViewById(R.id.tv_description);
        return v;
    }
}