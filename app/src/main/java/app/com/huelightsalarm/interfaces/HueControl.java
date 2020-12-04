package app.com.huelightsalarm.interfaces;

import app.com.huelightsalarm.models.data.AlarmModel;

public interface HueControl {
    void setSchedule(AlarmModel alarmModel);
}
