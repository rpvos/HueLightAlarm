package app.com.huelightsalarm.ui;

public class DaysOfWeek {
    //TODO let it work :)
    public enum WeekDays {
        Monday(1),
        Tuesday(1<<1),
        Wednesday(1<<2),
        Thursday(1<<3),
        Friday(1<<4),
        Saturday(1<<5),
        Sunday(1<<6);

        private final long statusFlagValue;

        WeekDays(long statusFlagValue) {
            this.statusFlagValue = statusFlagValue;
        }

        public long getStatusFlagValue(){
            return statusFlagValue;
        }
    }
}
