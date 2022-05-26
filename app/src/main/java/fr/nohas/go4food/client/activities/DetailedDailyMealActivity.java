package fr.nohas.go4food.client.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.nohas.go4food.client.Adaptor.DetailedDailyAdapter;
import fr.nohas.go4food.R;
import fr.nohas.go4food.client.models.DetailedDailyModel;

public class DetailedDailyMealActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context;
    List<DetailedDailyModel> listDetailedDailyModels;
    DetailedDailyAdapter detailedDailyAdapter;
    // Button buttonAdd;
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
            imageView.setImageResource(R.drawable.bf4);
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf1,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf2,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf3,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf4,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf5,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf6,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf7,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf8,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf9,"Breakfast","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.bf10,"Breakfast","4.4","Description","40","10h - 21h"));
            detailedDailyAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("Lunch")){
            imageView.setImageResource(R.drawable.lunch5);
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch1,"Lunch","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch2,"Lunch","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch3,"Lunch","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch4,"Lunch","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch5,"Lunch","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch6,"Lunch","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.lunch7,"Lunch","4.4","Description","40","10h - 21h"));
            detailedDailyAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("Dinner")){
            imageView.setImageResource(R.drawable.dinner6);
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.dinner1,"Dinner","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.dinner2,"Dinner","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.dinner3,"Dinner","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.dinner4,"Dinner","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.dinner5,"Dinner","4.4","Description","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.dinner6,"Dinner","4.4","Description","40","10h - 21h"));
            detailedDailyAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("drinkes")){
            imageView.setImageResource(R.drawable.drinks3);
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.drinks1,"Drinkes","4.4","Boisson gazeux","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.drinks2,"Drinkes","4.4","Boisson de fruit rouge","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.drinks3,"Drinkes","4.4","Soda","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.drinks4,"Drinkes","4.4","Boisson fresh","40","10h - 21h"));
            detailedDailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Gateau")){
            imageView.setImageResource(R.drawable.gateau3);
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.gateau1,"Gateau","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.gateau2,"Gateau","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.gateau3,"Gateau","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.gateau4,"Gateau","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.gateau5,"Macaron","Description","4.4","40","10h - 21h"));
            detailedDailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("coffee")){
            imageView.setImageResource(R.drawable.coffee2);
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee1,"coffee","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee2,"coffee","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee3,"coffee","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee4,"coffee","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee5,"coffee","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.coffee6,"coffee","Description","4.4","40","10h - 21h"));
            detailedDailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("Ice cream")){
            imageView.setImageResource(R.drawable.ice_cream4);
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.ice_creem1,"Ice cream","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.ice_cream2,"Ice cream","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.ice_cream3,"Ice cream","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.ice_cream4,"Ice cream","Description","4.4","40","10h - 21h"));
            listDetailedDailyModels.add(new DetailedDailyModel(R.drawable.ice_cream5,"Ice cream","Description","4.4","40","10h - 21h"));
            detailedDailyAdapter.notifyDataSetChanged();
        }

    }
}