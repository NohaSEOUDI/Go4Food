package fr.nohas.go4food.driver.driverfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.nohas.go4food.R;
import fr.nohas.go4food.driver.driverAdapter.HistAdapter;
import fr.nohas.go4food.driver.driverModels.UsersHistModel;


public class DriverHistoricFragment extends Fragment {
    RecyclerView recyclerViewVerHistoric;
    List<UsersHistModel> listusersHistModeles;
    HistAdapter histAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_driver_historic, container, false);

        recyclerViewVerHistoric = rootView.findViewById(R.id.recycler_view_ver_historic);

        listusersHistModeles = new ArrayList<>();
      //  (int image, String name, String ville, String address, String hour, String date) {
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic1,"Ali Djamel","Montpellier","14 rue de la fontaine","12h30","10-02-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic2,"Yassmine Louis","Montpellier","14 rue de la fontaine","12h30","10-02-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic3,"Marise Djamel","Montpellier","14 rue de la fontaine","12h30","10-02-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic4,"Pierre Djamel","Montpellier","14 rue de la fontaine","12h30","10-02-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic5,"Ali Djamel","Montpellier","14 rue de la fontaine","12h30","10-02-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic6,"Ali Djamel","Montpellier","14 rue de la fontaine","12h30","10-02-22"));

        //listusersHistModeles.add(new UsersHistModel(R.drawable.pic7,"Ali Djamel","Montpellier","14 rue de la fontaine","12h30","10-02-22"));
        //listusersHistModeles.add(new UsersHistModel(R.drawable.pic8,"Ali Djamel","Montpellier","14 rue de la fontaine","12h30","10-02-22"));
        //listusersHistModeles.add(new UsersHistModel(R.drawable.pic9,"Ali Djamel","Montpellier","14 rue de la fontaine","12h30","10-02-22"));
        //listusersHistModeles.add(new UsersHistModel(R.drawable.pic10,"Ali Djamel","Montpellier","14 rue de la fontaine","12h30","10-02-22"));

        //indtance de l'adapteur
        histAdapter = new HistAdapter(getContext(),listusersHistModeles);

        recyclerViewVerHistoric.setAdapter(histAdapter);
        recyclerViewVerHistoric.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}