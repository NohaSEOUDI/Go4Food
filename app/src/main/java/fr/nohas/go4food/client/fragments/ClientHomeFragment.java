package fr.nohas.go4food.client.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import fr.nohas.go4food.Adaptor.HomeHorAdapter;
import fr.nohas.go4food.Adaptor.HomeVerAdapter;
import fr.nohas.go4food.R;
import fr.nohas.go4food.client.interfaces.UpdateVerticalRec;
import fr.nohas.go4food.client.models.HomeHorModel;
import fr.nohas.go4food.client.models.HomeVerModel;

/*Fragment qui contiend notre recycler view */
public class ClientHomeFragment extends Fragment implements UpdateVerticalRec {
    RecyclerView homeHorizontalRecyclerView,homeVerticalRecyclerView;
    ArrayList<HomeHorModel> listHomeHorModels;
    HomeHorAdapter homeHorAdapter;

    ///////////////////vertical
    ArrayList<HomeVerModel> listhomeVerModels;
    HomeVerAdapter homeVerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_client__home_, container, false);
        homeHorizontalRecyclerView = root.findViewById(R.id.home_hor_recyclerView);
        homeVerticalRecyclerView = root.findViewById(R.id.home_ver_recyclerView);

        //////////////////////////////Horizontal Recycler view
        listHomeHorModels = new ArrayList<>();

        //à modifier
        listHomeHorModels.add(new HomeHorModel(R.drawable.pizza_1,"Pizza"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.burger,"Burger"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.pizza_1,"Pizza"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.pizza_1,"Pizza"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.pizza_1,"Pizza"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.pizza_1,"Pizza"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),listHomeHorModels);
        homeHorizontalRecyclerView.setAdapter(homeHorAdapter);
        homeHorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRecyclerView.setHasFixedSize(true);
        homeHorizontalRecyclerView.setNestedScrollingEnabled(false);

        //////////////////////////////Vertical Recycler view
        listhomeVerModels = new ArrayList<>();
        /*à modifier
        listhomeVerModels.add(new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
        listhomeVerModels.add(new HomeVerModel(R.drawable.pizza_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
        listhomeVerModels.add(new HomeVerModel(R.drawable.pizza_hut,"Burger King","10:00 -23:00","4.9","Min - $34"));
        listhomeVerModels.add(new HomeVerModel(R.drawable.french_takos,"Burger King","10:00 -23:00","4.9","Min - $34"));
        listhomeVerModels.add(new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
        listhomeVerModels.add(new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
        listhomeVerModels.add(new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
        listhomeVerModels.add(new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
        listhomeVerModels.add(new HomeVerModel(R.drawable.burger_king_1,"Burger King","10:00 -23:00","4.9","Min - $34"));
        */
        homeVerAdapter = new HomeVerAdapter(getActivity(),listhomeVerModels);
        homeVerticalRecyclerView.setAdapter(homeVerAdapter);
        homeVerticalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        //homeVerticalRecyclerView.setHasFixedSize(true);
        //homeVerticalRecyclerView.setNestedScrollingEnabled(false);

        return root;
    }


    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRecyclerView.setAdapter(homeVerAdapter);
    }
}