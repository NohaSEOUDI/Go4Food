package fr.nohas.go4food.client.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import fr.nohas.go4food.R;

public class ClientSettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}