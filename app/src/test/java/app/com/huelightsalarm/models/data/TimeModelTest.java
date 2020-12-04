package app.com.huelightsalarm.models.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeModelTest {

    private int hour;
    private int minutes;
    private TimeModel timeModel;

    @Before
    public void setUp() throws Exception {
        this.hour = 10;
        this.minutes = 55;
    this.timeModel = new TimeModel(hour,minutes);
    }

    @Test
    public void getHour() {
        assertEquals("Hour doesn't match",timeModel.getHour(),hour);
    }

    @Test
    public void getMinutes() {
        assertEquals("Minutes doesn't match",timeModel.getMinutes(),minutes);
    }
}