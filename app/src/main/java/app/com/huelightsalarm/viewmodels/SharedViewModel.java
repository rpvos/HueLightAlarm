package app.com.huelightsalarm.viewmodels;

import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private AlarmListViewModel alarmListViewModel;
    private HueControlViewModel hueControlViewModel;

    public SharedViewModel() {
        this.alarmListViewModel = new AlarmListViewModel();
        this.hueControlViewModel = new HueControlViewModel();

        this.alarmListViewModel.setHueControl(this.hueControlViewModel);
    }

    public AlarmListViewModel getAlarmListViewModel() {
        return alarmListViewModel;
    }

    public HueControlViewModel getHueControlViewModel() {
        return hueControlViewModel;
    }
}
