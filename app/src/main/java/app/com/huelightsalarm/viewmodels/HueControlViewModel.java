package app.com.huelightsalarm.viewmodels;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.HueControl;
import app.com.huelightsalarm.interfaces.HueLightsListProvider;
import app.com.huelightsalarm.interfaces.LightsModifier;
import app.com.huelightsalarm.models.HueControlModel;
import app.com.huelightsalarm.models.data.AlarmModel;
import app.com.huelightsalarm.models.data.Light;

public class HueControlViewModel implements HueLightsListProvider, DataSetChanged, HueControl {
    private HueControlModel hueControlModel;
    private ArrayList<DataSetChanged> listeners;
    private Handler uiHandler;

    public HueControlViewModel() {
        this.hueControlModel = new HueControlModel(this);
        this.listeners = new ArrayList<>();
    }

    @Override
    public ArrayList<HueLightViewModel> getHueLightViewModelList() {

        ArrayList<HueLightViewModel> list = new ArrayList<>();
        for (Light light : hueControlModel.getLights()) {
            list.add(new HueLightViewModel(light));
        }

        return list;
    }

    @Override
    public LightsModifier getLightsModifier() {
        return hueControlModel.getAPIHandler();
    }

    public void setUiHandler(Handler uiHandler) {
        this.uiHandler = uiHandler;
    }

    public Handler getUiHandler() {
        return uiHandler;
    }

    public void refresh() {
        hueControlModel.getAPIHandler().refresh();
    }

    public void removeListener(DataSetChanged listener) {
        if (listeners.contains(listener))
            listeners.remove(listener);
    }

    public void addListener(DataSetChanged listener) {
        listeners.add(listener);
    }

    @Override
    public void notifyDataSetChanged() {
        for (DataSetChanged listener : listeners) {
            if (uiHandler != null)
                uiHandler.post(listener::notifyDataSetChanged);
            else
                listener.notifyDataSetChanged();
        }
    }

    @Override
    public void setSchedule(AlarmModel alarmModel) {
        hueControlModel.getAPIHandler().setSchedule(alarmModel);
    }

    @Override
    public List<HueLightViewModel> getLights() {
        return getHueLightViewModelList();
    }

    public void setName(String name, String id) {
        hueControlModel.getAPIHandler().setLightName(name,id);
    }

    public void setGroup(String group, String id) {
        hueControlModel.getAPIHandler().setGroup(group,id);
    }
}
