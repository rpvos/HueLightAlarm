package app.com.huelightsalarm.interfaces;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.models.data.AlarmModel;
import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.viewmodels.HueLightViewModel;

public interface HueControl {
    void setSchedule(AlarmModel alarmModel);
    List<HueLightViewModel> getLights();

    void addListener(DataSetChanged listener);
}
