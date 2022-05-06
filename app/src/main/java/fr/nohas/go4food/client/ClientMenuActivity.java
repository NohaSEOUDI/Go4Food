package fr.nohas.go4food.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import fr.nohas.go4food.Adaptor.CategoryAdaptor;
import fr.nohas.go4food.Domaine.CategorieDomaine;
import fr.nohas.go4food.R;

public class ClientMenuActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapteur;
    private RecyclerView recyclerViewcategorieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_menu);
        BottomNavigationView btt_Navig = findViewById(R.id.navigButt);
        btt_Navig.setBackground(null);
        recyclerViewcategorie();
    }
    private void recyclerViewcategorie(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewcategorieList = findViewById(R.id.rVCategorie);
        recyclerViewcategorieList.setLayoutManager(linearLayoutManager);

        ArrayList<CategorieDomaine> categorieDomaines=new ArrayList<>();
        categorieDomaines.add(new CategorieDomaine("Pizza","cat_1"));
        categorieDomaines.add(new CategorieDomaine("Burger","cat_2"));
        categorieDomaines.add(new CategorieDomaine("Hot Dog","cat_3"));
        categorieDomaines.add(new CategorieDomaine("Tacos","cat_4"));
        categorieDomaines.add(new CategorieDomaine("Donut","cat_5"));
        categorieDomaines.add(new CategorieDomaine("Drink","cat_6"));

        adapteur=new CategoryAdaptor(categorieDomaines);
        recyclerViewcategorieList.setAdapter(adapteur);
    }
}