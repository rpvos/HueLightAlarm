package app.com.huelightsalarm.models;

public class AlarmCardModel {

    private TimeModel alarmTime;
    private WeekModel weekModel;
    private boolean activated;

    public AlarmCardModel(TimeModel alarmTime, boolean activated, WeekModel weekModel) {
        this.alarmTime = alarmTime;
        this.activated = activated;
        this.weekModel = weekModel;
    }

    public TimeModel getAlarmTime() {
        return alarmTime;
    }

    public WeekModel getWeekModel() {
        return weekModel;
    }

    public boolean isActivated() {
        return activated;
    }
}
