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

        listusersHistModeles.add(new UsersHistModel(R.drawable.pic1,"Ali Magdi","Montpellier","14 rue de la fontaine","17h30","10-02-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic2,"Yassmine Louis","Paris","114 rue de la République","19h20","15-12-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic3,"Marise Faiez","Lyon","12 rue de la Mermouz","12h30","12-08-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic4,"Pierre Jean","Avignon","192 Avenue Augustin Fliche","13h33","21-05-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic5,"Tom Paul","Marseille","134 Avenue Triolet","11h00","18-09-22"));
        listusersHistModeles.add(new UsersHistModel(R.drawable.pic6,"Paul Alpha","Montpellier","99 rue de la Mosson","21h40","13-04-22"));

        //indtance de l'adapteur
        histAdapter = new HistAdapter(getContext(),listusersHistModeles);

        recyclerViewVerHistoric.setAdapter(histAdapter);
        recyclerViewVerHistoric.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}