package fr.nohas.go4food.client.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import fr.nohas.go4food.Adaptor.DetailedDailyAdapter;
import fr.nohas.go4food.R;
import fr.nohas.go4food.client.models.DetailedDailyModel;

public class DetailedDailyMealActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DetailedDailyModel> listDetailedDailyModels;
    DetailedDailyAdapter detailedDailyAdapter;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);
        String type = getIntent().getStringExtra("type");


        recyclerView = findViewById(R.id.recycler_view_Mail_detailed);
        imageView = findViewById(R.id.detailed_daily_meal_imageView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listDetailedDailyModels = new ArrayList<>();
        detailedDailyAdapter = new DetailedDailyAdapter(listDetailedDailyModels);
        recyclerView.setAdapter(detailedDailyAdapter);

        //il faut ajouter pour chaque type
        if(type != null && type.equalsIgnoreCase("breakfast")){
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.pizza_hut,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.pizza_hut,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.pizza_hut,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.pizza_hut,"Breakfast","4.4","Description","40","10h - 21h"));
            detailedDailyAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("sweets")){
            imageView.setImageResource(R.drawable.french_takos);
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.french_takos,"Breakfast","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.french_takos,"Breakfast","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.french_takos,"Breakfast","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.french_takos,"Breakfast","Description","4.4","40","10h - 21h"));
            detailedDailyAdapter.notifyDataSetChanged();
        }

    }
}