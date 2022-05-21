package fr.nohas.go4food.client.dailyMeal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.nohas.go4food.R;

/*Fragment qui contient daily meal */
public class ClientDailyMealFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View rootView = inflater.inflate(R.layout.fragment_client_daily_meal, container, false);


         return rootView;
    }
}