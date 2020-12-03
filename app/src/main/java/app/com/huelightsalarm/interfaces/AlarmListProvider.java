package app.com.huelightsalarm.interfaces;

import java.util.ArrayList;

import app.com.huelightsalarm.viewmodels.AlarmViewModel;

public interface AlarmListProvider {
    ArrayList<AlarmViewModel> getAlarmViewModelList();
}
