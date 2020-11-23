package app.com.huelightsalarm.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import app.com.huelightsalarm.R;

public class SettingsFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO settings logic
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO settings view
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    public static Fragment newInstance() {
        return new SettingsFragment();
    }
}
