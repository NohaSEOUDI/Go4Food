package fr.nohas.go4food.client.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import fr.nohas.go4food.client.Adaptor.CartAdapter;
import fr.nohas.go4food.R;
import fr.nohas.go4food.client.models.CartModel;


public class ClientCartFragment extends Fragment {
    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    Button buttonMakeOrder;
    Fragment fragmentPayment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_client_cart, container, false);
        recyclerView = rootView.findViewById(R.id.cart_rec);
        buttonMakeOrder = rootView.findViewById(R.id.buttonTotalCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.add(new CartModel(R.drawable.tacos5,"Order 1","30","4.4"));
        list.add(new CartModel(R.drawable.pizza6,"Order 2","10","4.9"));
        list.add(new CartModel(R.drawable.fish4,"Order 3","23","4.3"));
        list.add(new CartModel(R.drawable.frites7,"Order 4","39","4.1"));
        list.add(new CartModel(R.drawable.pizza_1,"Order 5","10","4.9"));
        list.add(new CartModel(R.drawable.fish7,"Order 6","23","4.3"));
        list.add(new CartModel(R.drawable.frites5,"Order 7","39","4.1"));

        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);
        buttonMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentPayment = new PaymentFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.client_main_fragment_holder,fragmentPayment).addToBackStack(null).commit();
            }
        });
       return rootView;
    }
}