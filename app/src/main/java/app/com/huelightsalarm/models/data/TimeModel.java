package app.com.huelightsalarm.models.data;

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

    public String getStringHour() {
        if (hour < 10)
            return "0" + hour;
        return "" + hour;
    }

    public String getStringMinutes() {
        if (minutes < 10)
            return "0" + minutes;
        return "" + minutes;
    }

    public int getMinutes() {
        return minutes;
    }
}
