package fr.nohas.go4food.resto.fragments;

import android.content.ContentResolver;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.net.URI;
import java.util.ArrayList;

import fr.nohas.go4food.R;
import fr.nohas.go4food.resto.Produit;
import fr.nohas.go4food.resto.adapter.ItemProductAdapter;

//Fragment où on peut voir les annonces/produit déposer, ici on gére la recycler view
public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    FirebaseFirestore databaseReference;
    ItemProductAdapter myAdapter;
    ArrayList<Produit> arrayList;
    String TAG = "HomeFragment";
    Produit p;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.product_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        arrayList = new ArrayList<>();
        myAdapter = new ItemProductAdapter(arrayList);
        recyclerView.setAdapter(myAdapter);

        databaseReference = FirebaseFirestore.getInstance();//("Product");/////
        databaseReference.collection("Product")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            p=new Produit();
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            p.setPhoto(document.getString("photo"));
                            p.setName(document.getString("name"));
                            p.setPrice(document.getString("prix"));
                            p.setVariation(document.getString("variation"));
                            p.setDescription(document.getString("description"));
                            arrayList.add(p);
                        }
                        myAdapter.notifyDataSetChanged();
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });


        return rootView;

    }


}