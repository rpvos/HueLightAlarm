package app.com.huelightsalarm.interfaces;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.viewmodels.AlarmViewModel;
import app.com.huelightsalarm.viewmodels.HueLightViewModel;

public interface AlarmListProvider {
    ArrayList<AlarmViewModel> getAlarmViewModelList();
    OnListChange onSelfRemove();

    List<HueLightViewModel> getLights();
    void addHueLightsListSubscriber(DataSetChanged subscriber);
}
