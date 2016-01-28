package es.tessier.mememaker.ui.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import es.tessier.mememaker.R;


/**
 */
public class MemeSettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
