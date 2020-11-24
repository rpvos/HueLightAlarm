package app.com.huelightsalarm.ui.fragments;

import java.time.LocalDateTime;

import app.com.huelightsalarm.ui.WeekModel;

public class AlarmCardModel {

    private LocalDateTime alarmTime;
    private WeekModel.WeekDays weekDays;
    private boolean activated;

    public AlarmCardModel(LocalDateTime alarmTime, boolean activated, WeekModel.WeekDays weekDays) {
        this.alarmTime = alarmTime;
        this.activated = activated;
        this.weekDays = weekDays;
    }
}
