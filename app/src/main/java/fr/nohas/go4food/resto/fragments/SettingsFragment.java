package fr.nohas.go4food.resto.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.nohas.go4food.R;
import fr.nohas.go4food.resto.adapter.SettingItemAdapter;

//page où on peut gérer les paramétres
public class SettingsFragment extends Fragment {
    RecyclerView recyclerView;
    String listSettings[], listDescSettings[];
    int imagesIcons[] = {R.drawable.ic_account_circle, R.drawable.ic_location_on,
                         R.drawable.ic_event_note,R.drawable.ic_circle_notifications,
                         R.drawable.ic_calendar_month, R.drawable.ic_notifications,R.drawable.ic_history};//icons
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
      recyclerView = rootView.findViewById(R.id.settings_recyclerView); // 1)
      listSettings = getResources().getStringArray(R.array.setting_item_name);
      listDescSettings = getResources().getStringArray(R.array.description_setting_item_name);


      ///----------------
        SettingItemAdapter myAdapter = new SettingItemAdapter(getContext(),listSettings,listDescSettings,imagesIcons);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // 2)

      return rootView;
    }
}