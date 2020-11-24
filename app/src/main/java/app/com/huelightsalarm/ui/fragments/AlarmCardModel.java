package app.com.huelightsalarm.ui.fragments;

import java.time.LocalDateTime;

import app.com.huelightsalarm.ui.WeekModel;

public class AlarmCardModel {

    private LocalDateTime alarmTime;
    private WeekModel weekModel;
    private boolean activated;

    public AlarmCardModel(LocalDateTime alarmTime, boolean activated, WeekModel weekModel) {
        this.alarmTime = alarmTime;
        this.activated = activated;
        this.weekModel = weekModel;
    }
}
