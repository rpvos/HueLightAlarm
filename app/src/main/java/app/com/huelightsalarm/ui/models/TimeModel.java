package app.com.huelightsalarm.ui.models;

public class TimeModel {

    private int hour;
    private int minutes;

    public TimeModel(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }
}
