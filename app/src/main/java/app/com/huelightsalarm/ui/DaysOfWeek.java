package app.com.huelightsalarm.ui;

public class DaysOfWeek {

    public enum WeekDays {
        NoDays(0),
        Monday(1),
        Tuesday(1 << 1),
        Wednesday(1 << 2),
        Thursday(1 << 3),
        Friday(1 << 4),
        Saturday(1 << 5),
        Sunday(1 << 6);

        private long statusFlagValue;

        WeekDays(long statusFlagValue) {
            this.statusFlagValue = statusFlagValue;
        }

        public void switchMonday() {
            statusFlagValue ^= 1;
        }

        public void switchTuesday() {
            statusFlagValue ^= 1 << 1;
        }

        public void switchWednesday() {
            statusFlagValue ^= 1 << 2;
        }

        public void switchThursday() {
            statusFlagValue ^= 1 << 3;
        }

        public void switchFriday() {
            statusFlagValue ^= 1 << 4;
        }

        public void switchSaturday() {
            statusFlagValue ^= 1 << 5;
        }

        public void switchSunday() {
            statusFlagValue ^= 1 << 6;
        }

        public void setStatusFlagValue(long statusFlagValue) {
            this.statusFlagValue = statusFlagValue;
        }

        public long getStatusFlagValue() {
            return statusFlagValue;
        }
    }
}
