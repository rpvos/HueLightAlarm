package app.com.huelightsalarm.models;

public class TimeModel {

    private final int hour;
    private final int minutes;

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
