package app.com.huelightsalarm.viewmodels;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.interfaces.HueControl;
import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.tests.MockUpListener;

import static org.junit.Assert.*;

public class AlarmListViewModelTest {
    private AlarmListViewModel alarmListViewModel;

    @Before
    public void setUp() throws Exception {
        this.alarmListViewModel = new AlarmListViewModel();
    }

    @Test
    public void getAlarmViewModelList() {
        List list = alarmListViewModel.getAlarmViewModelList();
        assert (list != null);

        if (list.size() > 0) {
            assert (list.get(0) instanceof AlarmViewModel);
        }
    }

    @Test
    public void addAlarm() {
        int size = alarmListViewModel.getAlarmViewModelList().size();

        alarmListViewModel.addAlarm(11, 11);

        int sizeAfter = alarmListViewModel.getAlarmViewModelList().size();

        assert (size + 1 == sizeAfter);
    }

    @Test
    public void getAndSetHueControl() {
        // hue control should be null until we set one
        assert (alarmListViewModel.getHueControl() == null);

        alarmListViewModel.setHueControl(new HueControlViewModel());

        assert (alarmListViewModel.getHueControl() instanceof HueControl);
    }


    @Test
    public void subscribe() {
        MockUpListener listener = new MockUpListener();

        assert (listener.isNotified() == false);

        alarmListViewModel.subscribe(listener);

        alarmListViewModel.notifySubscribers();

        assert (listener.isNotified());
    }

    @Test
    public void unsubscribe() {
        MockUpListener listener = new MockUpListener();

        assert (listener.isNotified() == false);

        alarmListViewModel.subscribe(listener);

        alarmListViewModel.unsubscribe(listener);

        alarmListViewModel.notifySubscribers();

        assert (listener.isNotified() == false);
    }
}