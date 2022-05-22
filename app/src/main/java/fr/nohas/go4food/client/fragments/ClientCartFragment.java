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

import fr.nohas.go4food.Adaptor.CartAdapter;
import fr.nohas.go4food.R;
import fr.nohas.go4food.client.models.CartModel;


public class ClientCartFragment extends Fragment {
    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_client_cart, container, false);
        recyclerView = rootView.findViewById(R.id.cart_rec);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.add(new CartModel(R.drawable.french_takos,"Order 1","30","4.4"));
        list.add(new CartModel(R.drawable.pizza_1,"Order 2","10","4.9"));
        list.add(new CartModel(R.drawable.pizza_hut,"Order 3","23","4.3"));
        list.add(new CartModel(R.drawable.burger_king_1,"Order 4","39","4.1"));
        list.add(new CartModel(R.drawable.pizza_1,"Order 5","10","4.9"));
        list.add(new CartModel(R.drawable.pizza_hut,"Order 6","23","4.3"));
        list.add(new CartModel(R.drawable.burger_king_1,"Order 7","39","4.1"));

        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);

       return rootView;
    }
}