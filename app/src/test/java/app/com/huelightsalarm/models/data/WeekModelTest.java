package app.com.huelightsalarm.models.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeekModelTest {

    private WeekModel weekModel;

    @Before
    public void setUp() throws Exception {
        this.weekModel = new WeekModel();
    }

    @Test
    public void turnAllOnAndOff() {
        weekModel.turnAllOn();
        assert (weekModel.isMonday());
        assert (weekModel.isTuesday());
        assert (weekModel.isWednesday());
        assert (weekModel.isThursday());
        assert (weekModel.isFriday());
        assert (weekModel.isSaturday());

        weekModel.turnAllOff();
        assert (!weekModel.isMonday());
        assert (!weekModel.isTuesday());
        assert (!weekModel.isWednesday());
        assert (!weekModel.isThursday());
        assert (!weekModel.isFriday());
        assert (!weekModel.isSaturday());
    }

    @Test
    public void monday() {
        boolean state = weekModel.isMonday();

        weekModel.setMonday(!state);

        assertTrue("Setter is incorrect", weekModel.isMonday() != state);
    }

    @Test
    public void tuesday() {
        boolean state = weekModel.isTuesday();

        weekModel.setTuesday(!state);

        assertTrue("Setter is incorrect", weekModel.isTuesday() != state);
    }

    @Test
    public void wednesday() {
        boolean state = weekModel.isWednesday();

        weekModel.setWednesday(!state);

        assertTrue("Setter is incorrect", weekModel.isWednesday() != state);
    }

    @Test
    public void thursday() {
        boolean state = weekModel.isThursday();

        weekModel.setThursday(!state);

        assertTrue("Setter is incorrect", weekModel.isThursday() != state);
    }

    @Test
    public void friday() {
        boolean state = weekModel.isFriday();

        weekModel.setFriday(!state);

        assertTrue("Setter is incorrect", weekModel.isFriday() != state);
    }

    @Test
    public void saturday() {
        boolean state = weekModel.isSaturday();

        weekModel.setSaturday(!state);

        assertTrue("Setter is incorrect", weekModel.isSaturday() != state);
    }

    @Test
    public void sunday() {
        boolean state = weekModel.isSunday();

        weekModel.setSunday(!state);

        assertTrue("Setter is incorrect", weekModel.isSunday() != state);
    }

    @Test
    public void getByte() {
        weekModel.turnAllOff();
        assert (weekModel.getByte().equals("0"));
        weekModel.turnAllOn();
        assert(weekModel.getByte().equals("127"));
    }
}