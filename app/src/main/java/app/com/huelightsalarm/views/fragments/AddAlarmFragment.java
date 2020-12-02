package app.com.huelightsalarm.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.models.AlarmModel;
import app.com.huelightsalarm.models.OnAddingAlarm;
import app.com.huelightsalarm.models.WeekModel;
import app.com.huelightsalarm.models.TimeModel;
import app.com.huelightsalarm.viewmodels.AlarmListViewModel;

public class AddAlarmFragment extends DialogFragment {

    private final OnAddingAlarm onAddingAlarmListener;
    private TimePicker timePicker;

    public AddAlarmFragment(OnAddingAlarm onAddingAlarmListener) {
        this.onAddingAlarmListener = onAddingAlarmListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addalarm_popup, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.Button_AddAlarm);
        button.setOnClickListener((view1 -> addAlarm()));

        this.timePicker = view.findViewById(R.id.TimePicker_AddAlarmTimePicker);
    }

    private void addAlarm() {
        // pass time
        onAddingAlarmListener.addAlarm(timePicker.getHour(),timePicker.getMinute());

//        //todo viewmodel
//        AlarmListViewModel viewModel = new ViewModelProvider(this).get(AlarmListViewModel.class);
//        viewModel.addAlarm(newAlarm);

        //todo add nicer fix
        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().remove(this).commit();
    }


    public static AddAlarmFragment newInstance(OnAddingAlarm onAddingAlarmListener) {
        return new AddAlarmFragment(onAddingAlarmListener);
    }
}
