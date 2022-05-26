package fr.nohas.go4food.resto.fragments;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import fr.nohas.go4food.R;
import fr.nohas.go4food.resto.Produit;

// on stocke la photo dans storage
// les données sont dans realTimeDatabase
//page pour choisir une seule produit et l'enregister dans la bdd
public class RestoOneProductFragment extends Fragment {
    Fragment nextFragment;
    ImageView productPic;
    TextView textViewPic;
    EditText edName,edVariation,edPrice,edDescription;
    Button buttonValidation;
    ActivityResultLauncher<String> mTakePhoto; //to upload photo from galerie

    //pour stocker dans la base de données
    FirebaseStorage storageReference; // ici on stocke l'image dans Storage
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("Procduct"); // doit être changer en produit

    FirebaseFirestore db;

    ProgressDialog progressDialog;
    Uri imageUri;
    Produit product; // notre classe de produit

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //1) Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_resto_one_product, container, false);

        //2) get all composants from xml
        edName = rootView.findViewById(R.id.et_name);
        edPrice = rootView.findViewById(R.id.et_price);
        edVariation = rootView.findViewById(R.id.et_variations);
        edDescription = rootView.findViewById(R.id.et_description);
        productPic = rootView.findViewById(R.id.et_photo);
        textViewPic = rootView.findViewById(R.id.tv_uploadPhoto);

        progressDialog = new ProgressDialog(getActivity());

        storageReference= FirebaseStorage.getInstance();

        //initialize cloud FireStore
        db = FirebaseFirestore.getInstance();

        //3) to get image
        mTakePhoto = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        productPic.setImageURI(result);
                        imageUri = result; // result will be set in imageUir
                    }
                }

        );

        //4) when we click on image , we chose a new image
        textViewPic.setOnClickListener(View ->{
            mTakePhoto.launch("image/*"); //all images on data
        });

        buttonValidation = rootView.findViewById(R.id.btt_save);
        //quand on click sur le button ,on stocke les données dans la bdd
        buttonValidation.setOnClickListener(View->{
            uploadImage();
        });

        return rootView;
    }
    private void uploadImage(){
        //String photo = productPic.getResources().toString();
        String nameStr = edName.getText().toString();
        String priceStr = edPrice.getText().toString();
        String variationStr = edVariation.getText().toString();
        String descriptionStr = edDescription.getText().toString();

        if(nameStr.isEmpty()){
            edName.setError(getString(R.string.nameResto_required));
            edName.requestFocus();
            return;
        }
        if(priceStr.isEmpty()){
            edPrice.setError("Price is required");
            edPrice.requestFocus();
            return;
        }
        if(variationStr.isEmpty()){
            edVariation.setError("Error");
            edVariation.requestFocus();
            return;
        }
        if(descriptionStr.isEmpty()){
            edDescription.setError("Error");
            edDescription.requestFocus();
            return;
        }


        if(imageUri != null){
            progressDialog.setTitle("Image is Uploading....");
            progressDialog.show();
            StorageReference storageReference2 = storageReference.getReference().child("images/"+ UUID.randomUUID().toString());
            //we are creating a ref to store the image in firebase storage
            storageReference2.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        //image uploaded successfuly
                        Toast.makeText(getActivity(), "All uploaded successfuly", Toast.LENGTH_SHORT).show();
                        //(String photo, String name, String description, String variation, double prix)
                        // Create a new user with a first and last name
                        Map<String, Object> product = new HashMap<>();
                        Log.d("ImageUri",""+imageUri);
                        Log.d("taskgetResulttoString:",task.getResult().toString());
                        Log.d("storageReference2:",""+storageReference2.getDownloadUrl().toString());
                        product.put("photo", storageReference2.getDownloadUrl().toString());//task.getResult().toString());//le lien vers la photo
                        product.put("name", nameStr);
                        product.put("description", descriptionStr);
                        product.put("variation", variationStr);
                        product.put("prix", priceStr);

                        // Add a new document with a generated ID query to store Data
                        db.collection("Product")
                                .add(product)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                        Toast.makeText(getActivity(), "successfully registered :) ", Toast.LENGTH_SHORT).show();
                                        //ici on fait une rédirection vers une autre page yoo
                                        nextFragment=new NextResourcesFragment();
                                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,nextFragment).addToBackStack(null).commit();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                        Toast.makeText(getActivity(), "Error adding document!"+e.getMessage(), Toast.LENGTH_SHORT).show();
                                        nextFragment=new RestoAddedErrorFragment();
                                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,nextFragment).addToBackStack(null).commit();
                                    }
                                });
                    }else{
                        //failed
                        Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



}