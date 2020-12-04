package app.com.huelightsalarm.interfaces;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.viewmodels.AlarmViewModel;

public interface Database {
    void setListPointer(ArrayList<AlarmViewModel> alarmArrayList);
    void loadList();
    void saveList(List<AlarmViewModel> alarms);
}
