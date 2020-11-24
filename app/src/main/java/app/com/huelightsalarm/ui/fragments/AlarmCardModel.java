package app.com.huelightsalarm.ui.fragments;

import java.sql.Time;
import java.time.LocalDateTime;

import app.com.huelightsalarm.ui.DaysOfWeek;

public class AlarmCardModel {

    private LocalDateTime alarmTime;
    private DaysOfWeek.WeekDays weekDays;
    private boolean activated;

    public AlarmCardModel(LocalDateTime alarmTime, boolean activated, DaysOfWeek.WeekDays weekDays) {
        this.alarmTime = alarmTime;
        this.activated = activated;
        this.weekDays = weekDays;
    }
}
