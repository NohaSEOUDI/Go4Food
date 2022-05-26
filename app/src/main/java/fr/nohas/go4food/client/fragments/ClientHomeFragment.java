package fr.nohas.go4food.client.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

import fr.nohas.go4food.client.Adaptor.HomeHorAdapter;
import fr.nohas.go4food.client.Adaptor.HomeVerAdapter;
import fr.nohas.go4food.R;
import fr.nohas.go4food.client.Client;
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
        listHomeHorModels.add(new HomeHorModel(R.drawable.frites7,"Frittes"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.burger,"Burger"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.pizza_1,"Pizza"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.tacos5,"Tacos"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.burger3,"Burger"));
        listHomeHorModels.add(new HomeHorModel(R.drawable.fish7,"Poisson"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),listHomeHorModels);
        homeHorizontalRecyclerView.setAdapter(homeHorAdapter);
        homeHorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRecyclerView.setHasFixedSize(true);
        homeHorizontalRecyclerView.setNestedScrollingEnabled(false);

        //////////////////////////////Vertical Recycler view
        listhomeVerModels = new ArrayList<>();

        homeVerAdapter = new HomeVerAdapter(getActivity(),listhomeVerModels);
        homeVerticalRecyclerView.setAdapter(homeVerAdapter);
        homeVerticalRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        return root;
    }


    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRecyclerView.setAdapter(homeVerAdapter);
    }
}