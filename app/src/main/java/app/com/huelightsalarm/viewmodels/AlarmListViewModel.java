package app.com.huelightsalarm.viewmodels;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.interfaces.AlarmListProvider;
import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.Database;
import app.com.huelightsalarm.interfaces.HueControl;
import app.com.huelightsalarm.interfaces.OnListChange;
import app.com.huelightsalarm.models.data.AlarmModel;
import app.com.huelightsalarm.interfaces.OnAddingAlarm;
import app.com.huelightsalarm.models.data.TimeModel;
import app.com.huelightsalarm.models.data.WeekModel;

public class AlarmListViewModel extends ViewModel implements AlarmListProvider, OnAddingAlarm, OnListChange {

    private final ArrayList<AlarmViewModel> alarmArrayList;
    private final ArrayList<DataSetChanged> subscribers;
    private HueControl hueControl;

    public AlarmListViewModel() {
        this.alarmArrayList = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void addAlarm(int hours, int minutes) {

        TimeModel alarmTime = new TimeModel(hours, minutes);
        WeekModel weekModel = new WeekModel();
        AlarmModel newAlarm = new AlarmModel(alarmTime, true, weekModel);
        this.alarmArrayList.add(new AlarmViewModel(newAlarm));

        notifySubscribers();
    }

    @Override
    public void OnSelfRemove(int position) {
        this.alarmArrayList.remove(position);

        this.notifySubscribers();
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
        subscribers.remove(unsubscriber);
    }

    public void setListRetriever(Database database){
        database.setListPointer(this.alarmArrayList);
        database.loadList();
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

    @Override
    public void NotifyChanges(AlarmModel alarmModel) {
        hueControl.setSchedule(alarmModel);
        updateDatabase();
    }

    private void updateDatabase() {
        for(DataSetChanged dataSetChanged : this.subscribers){
            if(dataSetChanged instanceof Database){
                ((Database) dataSetChanged).saveList(this.alarmArrayList);
            }
        }
    }

    @Override
    public OnListChange onSelfRemove() {
        return this;
    }

    @Override
    public List<HueLightViewModel> getLights() {
        return hueControl.getLights();
    }

    @Override
    public void addHueLightsListSubscriber(DataSetChanged subscriber) {
        hueControl.addListener(subscriber);
    }
}
