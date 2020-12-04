package app.com.huelightsalarm.models.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmModelTest {
    private AlarmModel alarmModel;
    private TimeModel timeModel;
    private WeekModel weekModel;

    @Before
    public void setUp() throws Exception {
        this.timeModel = new TimeModel(10, 10);
        this.weekModel = new WeekModel();
        this.alarmModel = new AlarmModel(timeModel, true, weekModel);
    }

    @Test
    public void setActivated() {
        boolean status = alarmModel.isActivated();

        alarmModel.setActivated(!status);

        assert (alarmModel.isActivated() != status);
    }

    @Test
    public void getAlarmTime() {
        assert (alarmModel.getAlarmTime().equals(this.timeModel));
    }

    @Test
    public void getWeekModel() {
        assert (alarmModel.getWeekModel().equals(this.weekModel));
    }

}