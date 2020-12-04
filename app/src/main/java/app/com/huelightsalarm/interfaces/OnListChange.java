package app.com.huelightsalarm.interfaces;

import app.com.huelightsalarm.models.data.AlarmModel;
import app.com.huelightsalarm.viewmodels.AlarmViewModel;

public interface OnListChange {
    void OnSelfRemove(int position);
    void NotifyChanges(AlarmModel alarmModel);
}
