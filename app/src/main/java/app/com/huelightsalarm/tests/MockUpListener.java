package app.com.huelightsalarm.tests;

import app.com.huelightsalarm.interfaces.DataSetChanged;

public class MockUpListener implements DataSetChanged {
    private boolean isNotified;

    public MockUpListener() {
        this.isNotified = false;
    }

    @Override
    public void notifyDataSetChanged() {
        this.isNotified = true;
    }

    public boolean isNotified() {
        return isNotified;
    }
}
