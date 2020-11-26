package app.com.huelightsalarm.ui.fragments;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import java.time.LocalDateTime;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.ui.OnAddingAlarm;
import app.com.huelightsalarm.ui.WeekModel;

public class AddAlarmFragment extends DialogFragment {

    private final OnAddingAlarm onAddingAlarmListener;

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
    }

    private void addAlarm() {
        LocalDateTime alarmTime = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            alarmTime = LocalDateTime.of(2020,11,26,14,52);
        }
        WeekModel weekModel = new WeekModel();

        AlarmCardModel newAlarm = new AlarmCardModel(alarmTime, true, weekModel);

        onAddingAlarmListener.addAlarm(newAlarm);

        //todo close fragment

    }


    public static AddAlarmFragment newInstance(OnAddingAlarm onAddingAlarmListener) {
        return new AddAlarmFragment(onAddingAlarmListener);
    }
}
