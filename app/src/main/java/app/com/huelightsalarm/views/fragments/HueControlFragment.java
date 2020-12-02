package app.com.huelightsalarm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.viewmodels.HueControlViewModel;
import app.com.huelightsalarm.viewmodels.SharedViewModel;

public class HueControlFragment extends Fragment {

    public HueControlFragment(HueControlViewModel hueControlViewModel) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO Hue control view
        return inflater.inflate(R.layout.fragment_huecontrol, container, false);
    }

    public static Fragment newInstance(HueControlViewModel sharedViewModel) {
        return new HueControlFragment(sharedViewModel);
    }
}
