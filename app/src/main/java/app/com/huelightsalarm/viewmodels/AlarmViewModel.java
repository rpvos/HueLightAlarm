package app.com.huelightsalarm.viewmodels;

import app.com.huelightsalarm.models.AlarmModel;
import app.com.huelightsalarm.models.TimeModel;
import app.com.huelightsalarm.views.adapters.AlarmCardAdapter;

public class AlarmViewModel {
    private AlarmModel alarmModel;

    public AlarmViewModel(AlarmModel alarmModel) {
        this.alarmModel = alarmModel;
    }

    public void fillCardHolder(AlarmCardAdapter.CardHolder holder) {

        holder.getSwitchMaterial().setChecked(alarmModel.isActivated());
        holder.getTextClock().setFormat24Hour(alarmModel.getAlarmTime().getHour() + ":" + alarmModel.getAlarmTime().getMinutes());
    }
}
