package fr.nohas.go4food.resto.fragments;

import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import fr.nohas.go4food.R;

public class RestoMenuFragment extends Fragment {
    ImageView productPic;
    TextView textViewPic;//et_photo
    EditText edName,edVariation,edPrice,edDescription;
    Button buttonValidation,addItem;
    ActivityResultLauncher<String> mTakePhoto; //to upload photo from galerie

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_resto_menu, container, false);

        edName = rootView.findViewById(R.id.et_name);
        edPrice = rootView.findViewById(R.id.et_price);
        edVariation = rootView.findViewById(R.id.et_variations);
        edDescription = rootView.findViewById(R.id.et_description);
        productPic = rootView.findViewById(R.id.et_photo);
        textViewPic = rootView.findViewById(R.id.tv_uploadPhoto);
        buttonValidation = rootView.findViewById(R.id.btt_save);
        addItem = rootView.findViewById(R.id.btt_add);

        //3) to get image
        mTakePhoto = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                result -> productPic.setImageURI(result)
        );

        //4) when we click on image , we chose a new image
        textViewPic.setOnClickListener(View ->{
            mTakePhoto.launch("image/*"); //all images on data
        });

        //mécanisem d'ajout d'item à la demande



        return rootView;
    }
}