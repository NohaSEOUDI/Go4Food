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

//tt ça doit être enregister dans la base de donénes !!
// on stocke la photo dans storage
// les données sont dans realTimeDatabase
public class RestoOneProductFragment extends Fragment {
    ImageView productPic;
    TextView textViewPic;//et_photo
    EditText edName,edVariation,edPrice,edDescription;
    Button buttonValidation;
    ActivityResultLauncher<String> mTakePhoto; //to upload photo from galerie

    //pour stocker dans la base de données
    FirebaseStorage storageReference; // ici on stocke le dossier image dans Storage
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    Uri imageUri;
    Produit product; // notre classe de produit

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //1) Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_resto_one_product, container, false);

        //2) get all composants
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
        //on stocke dans la bdd
        buttonValidation.setOnClickListener(View->{
            uploadImage();
        });

        return rootView;
    }
    private void uploadImage(){
        String nameStr = edName.getText().toString();
        String priceStr = edPrice.getText().toString();
        String variationStr = edVariation.getText().toString();
        String descriptionStr = edDescription.getText().toString();
        double priceDouble = Double.parseDouble(priceStr);


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
                        Toast.makeText(getActivity(), "image uploaded successfuly", Toast.LENGTH_SHORT).show();
                        //(String photo, String name, String description, String variation, double prix)
                        // Create a new user with a first and last name
                        Map<String, Object> product = new HashMap<>();
                        product.put("photo", task.getResult().toString());
                        product.put("name", nameStr);
                        product.put("description", descriptionStr);
                        product.put("variation", variationStr);
                        product.put("prix", priceDouble);

                        // Add a new document with a generated ID
                        db.collection("users")
                                .add(product)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                        Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                        Toast.makeText(getActivity(), "pas ok!!!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                      //  product = new Produit(task.getResult().toString(),nameStr,descriptionStr,variationStr,priceDouble);
                      //  String ImageUploadId =  databaseReference.push().getKey();
                       // databaseReference.child(ImageUploadId).setValue(product);
                    }else{
                        //failed
                        Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



}