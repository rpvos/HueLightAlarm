package app.com.huelightsalarm.ui.models;

import app.com.huelightsalarm.ui.DaysOfWeek;
import app.com.huelightsalarm.ui.models.TimeModel;

public class AlarmCardModel {

    private TimeModel alarmTime;
    private DaysOfWeek.WeekDays weekDays;
    private boolean activated;

    public AlarmCardModel(TimeModel alarmTime, boolean activated/*, DaysOfWeek.WeekDays weekDays*/) {
        this.alarmTime = alarmTime;
        this.activated = activated;
        this.weekDays = weekDays;
    }

    public TimeModel getAlarmTime() {
        return alarmTime;
    }

    public DaysOfWeek.WeekDays getWeekDays() {
        return weekDays;
    }

    public boolean isActivated() {
        return activated;
    }
}
