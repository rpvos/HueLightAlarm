package app.com.huelightsalarm.viewmodels;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SharedViewModelTest {
    private SharedViewModel sharedViewModel;

    @Before
    public void setUp() throws Exception {
        this.sharedViewModel = new SharedViewModel();
    }

    @Test
    public void getAlarmListViewModel() {
        assert (this.sharedViewModel.getAlarmListViewModel() instanceof AlarmListViewModel);
    }

    @Test
    public void getHueControlViewModel() {
        assert (this.sharedViewModel.getHueControlViewModel() instanceof HueControlViewModel);
    }
}