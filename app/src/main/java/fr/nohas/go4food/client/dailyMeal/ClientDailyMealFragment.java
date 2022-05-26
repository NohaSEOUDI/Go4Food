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

import fr.nohas.go4food.client.Adaptor.DailyMealAdapter;
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

        listDailyMealModels.add(new DailyMealModel(R.drawable.bf4,"Breakfast","30% OFF","Description","Breakfast"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.lunch1,"Lunch","10% OFF","Description","Lunch"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.dinner2,"Dinner","20% OFF","Description","Dinner"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.drinks1,"Drinkes","50% OFF","Description","Drinkes"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.ice_creem1,"Ice cream","30% OFF","Description","Ice cream"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.coffee3,"Coffee","66% OFF","Description","Coffee"));
        listDailyMealModels.add(new DailyMealModel(R.drawable.gateau1,"Gateau","20% OFF","Description","Gateau"));

        dailyMealAdapter = new DailyMealAdapter(getContext(),listDailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();
         return rootView;
    }
}