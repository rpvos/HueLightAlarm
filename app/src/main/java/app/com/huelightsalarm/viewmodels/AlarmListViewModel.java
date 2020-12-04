package app.com.huelightsalarm.viewmodels;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import app.com.huelightsalarm.interfaces.AlarmListProvider;
import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.HueControl;
import app.com.huelightsalarm.models.data.AlarmModel;
import app.com.huelightsalarm.interfaces.OnAddingAlarm;
import app.com.huelightsalarm.models.data.TimeModel;
import app.com.huelightsalarm.models.data.WeekModel;

public class AlarmListViewModel extends ViewModel implements AlarmListProvider, OnAddingAlarm {

    private final ArrayList<AlarmViewModel> alarmArrayList;
    private final ArrayList<DataSetChanged> subscribers;
    private HueControl hueControl;

    public AlarmListViewModel() {
        this.alarmArrayList = new ArrayList<>();
        this.subscribers = new ArrayList<>();

        this.alarmArrayList.add(new AlarmViewModel(new AlarmModel(new TimeModel(12, 50), true, new WeekModel())));
    }

    public void addAlarm(int hours, int minutes) {

        TimeModel alarmTime = new TimeModel(hours, minutes);
        WeekModel weekModel = new WeekModel();

        AlarmModel newAlarm = new AlarmModel(alarmTime, true, weekModel);

        alarmArrayList.add(new AlarmViewModel(newAlarm));

        notifySubscribers();
    }

    public void subscribe(DataSetChanged subscriber) {
        subscribers.add(subscriber);
    }

    public void notifySubscribers() {
        for (DataSetChanged subscriber : subscribers) {
            subscriber.notifyDataSetChanged();
        }
    }

    public void unsubscribe(DataSetChanged unsubscriber) {
        if (subscribers.contains(unsubscriber))
            subscribers.remove(unsubscriber);
    }


    @Override
    public ArrayList<AlarmViewModel> getAlarmViewModelList() {
        return alarmArrayList;
    }

    public void setHueControl(HueControl hueControl) {
        this.hueControl = hueControl;
    }

    public HueControl getHueControl() {
        return hueControl;
    }
}
