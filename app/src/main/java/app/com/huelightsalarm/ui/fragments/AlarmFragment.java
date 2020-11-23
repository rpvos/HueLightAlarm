package app.com.huelightsalarm.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import app.com.huelightsalarm.R;

public class AlarmFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO alarm logic
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO Alarm view
        return inflater.inflate(R.layout.fragment_alarm, container, false);
    }

    public static Fragment newInstance() {
        return new AlarmFragment();
    }
}
