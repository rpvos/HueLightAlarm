package app.com.huelightsalarm.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import app.com.huelightsalarm.AlarmListProvider;
import app.com.huelightsalarm.DataSetChanged;
import app.com.huelightsalarm.models.AlarmModel;
import app.com.huelightsalarm.models.TimeModel;
import app.com.huelightsalarm.models.WeekModel;
import app.com.huelightsalarm.views.adapters.AlarmCardAdapter;

public class AlarmListViewModel extends ViewModel implements AlarmListProvider {

    private ArrayList<AlarmViewModel> alarmArrayList;
    private ArrayList<DataSetChanged> subscribers;

    public AlarmListViewModel() {
        this.alarmArrayList = new ArrayList<>();
        this.subscribers = new ArrayList<>();

        this.alarmArrayList.add(new AlarmViewModel(new AlarmModel(new TimeModel(12, 50), true, new WeekModel())));
    }

    public ArrayList<AlarmViewModel> getAlarmArrayList() {
        return alarmArrayList;
    }

    public void addAlarm(AlarmModel newAlarm) {
        alarmArrayList.add(new AlarmViewModel(newAlarm));

        notifySubscribers();
    }

    public void subscribe(DataSetChanged subscriber) {
        subscribers.add(subscriber);
    }

    private void notifySubscribers() {
        for (DataSetChanged subscriber : subscribers) {
            subscriber.notifyDataSetChanged();
        }
    }

    @Override
    public ArrayList<AlarmViewModel> getAlarmViewModelList() {
        return alarmArrayList;
    }
}
