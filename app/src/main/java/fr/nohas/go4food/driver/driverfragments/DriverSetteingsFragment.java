package fr.nohas.go4food.driver.driverfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.nohas.go4food.R;
import fr.nohas.go4food.driver.driverAdapter.DriverSettingsItemAdapter;
import fr.nohas.go4food.resto.adapter.SettingItemAdapter;

public class DriverSetteingsFragment extends Fragment {
    RecyclerView recyclerViewSettings;
    String driverlistSettings[], driverlistDescSettings[];
    int imagesIconsSettings[] = {R.drawable.ic_account_circle, R.drawable.ic_location_on,
            R.drawable.ic_event_note,R.drawable.ic_circle_notifications,
            R.drawable.ic_calendar_month, R.drawable.ic_notifications,R.drawable.ic_history};//icons
    Fragment fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_driver_setteings, container, false);
        recyclerViewSettings = rootView.findViewById(R.id.driver_settings_recyclerView);

        driverlistSettings = getResources().getStringArray(R.array.setting_item_name);
        driverlistDescSettings = getResources().getStringArray(R.array.description_setting_item_name);

        ///----------------

        if(driverlistSettings[0] == "Account"){
            fragment = new DriverAccountFragment();//driverListIcons[position],driverListSittings[position],driverListDesc[position]);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.driver_fragment_holder,fragment).addToBackStack(null).commit();
        }
        if(driverlistSettings[1] == "Position"){
            fragment = new DriverPositionFragment();//driverListIcons[position],driverListSittings[position],driverListDesc[position]);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.driver_fragment_holder,fragment).addToBackStack(null).commit();
        }
        if(driverlistSettings[2] == "Evaluation"){
            fragment = new DriverEvaluationFragment();//driverListIcons[position],driverListSittings[position],driverListDesc[position]);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.driver_fragment_holder,fragment).addToBackStack(null).commit();
        }
        if(driverlistSettings[3] == "Alertes"){
            fragment = new DriverAlertesFragment();//driverListIcons[position],driverListSittings[position],driverListDesc[position]);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.driver_fragment_holder,fragment).addToBackStack(null).commit();
        }
        if(driverlistSettings[4] == "Schedual"){
            fragment = new DriverSchedualFragment();//driverListIcons[position],driverListSittings[position],driverListDesc[position]);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.driver_fragment_holder,fragment).addToBackStack(null).commit();
        }
        if(driverlistSettings[5] == "Notifications"){
            fragment = new DriverNotificationsFragment();//driverListIcons[position],driverListSittings[position],driverListDesc[position]);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.driver_fragment_holder,fragment).addToBackStack(null).commit();
        }


        DriverSettingsItemAdapter myAdapter = new DriverSettingsItemAdapter(getContext(),driverlistSettings,driverlistDescSettings,imagesIconsSettings,fragment);
        recyclerViewSettings.setAdapter(myAdapter);
        recyclerViewSettings.setLayoutManager(new LinearLayoutManager(getContext())); // 2)


        return rootView;
    }
}