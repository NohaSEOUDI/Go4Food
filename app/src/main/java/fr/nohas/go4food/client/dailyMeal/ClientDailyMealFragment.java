package fr.nohas.go4food.client.dailyMeal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.nohas.go4food.Adaptor.DailyMealAdapter;
import fr.nohas.go4food.R;
import fr.nohas.go4food.client.models.DailyMealModel;

/*Fragment qui contient daily meal */
public class ClientDailyMealFragment extends Fragment {
    RecyclerView recyclerView;
    List<DailyMealModel> listDailyMealModels;
    DailyMealAdapter dailyMealAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_client_daily_meal, container, false);
        recyclerView = rootView.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        listDailyMealModels = new ArrayList<>();

        listDailyMealModels.add(new DailyMealModel(R.drawable.french_takos,"Breakfast","30% OFF","Description","Breakfast"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.french_takos,"Lunch","10% OFF","Description","Breakfast"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.french_takos,"Dinner","20% OFF","Description","Breakfast"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.french_takos,"Breakfast","70% OFF","Description","Breakfast"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.french_takos,"Lunch","50% OFF","Description","Breakfast"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.french_takos,"Sweets","30% OFF","Description","Breakfast"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.french_takos,"Coffee","66% OFF","Description","Coffee"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.french_takos,"Dinner","20% OFF","Description","Dinner"));

        dailyMealAdapter = new DailyMealAdapter(getContext(),listDailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();
         return rootView;
    }
}