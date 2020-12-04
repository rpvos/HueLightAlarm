package app.com.huelightsalarm.models.data;

public class AlarmModel {

    private TimeModel alarmTime;
    private WeekModel weekModel;
    private boolean activated;
    private String selectedLightID;

    public AlarmModel(TimeModel alarmTime, boolean activated, WeekModel weekModel) {
        this.alarmTime = alarmTime;
        this.activated = activated;
        this.weekModel = weekModel;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
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

    public void setSelectedLamp(String selectedLampID) {
        this.selectedLightID = selectedLampID;
    }

    public String getSelectedLight() {
        return selectedLightID;
    }
}
