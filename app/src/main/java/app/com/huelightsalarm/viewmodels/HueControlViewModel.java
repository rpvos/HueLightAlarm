package app.com.huelightsalarm.viewmodels;

import android.os.Handler;

import java.util.ArrayList;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.HueLightsListProvider;
import app.com.huelightsalarm.models.HueControlModel;
import app.com.huelightsalarm.models.data.Light;

public class HueControlViewModel implements HueLightsListProvider, DataSetChanged {
    private HueControlModel hueControlModel;
    private ArrayList<DataSetChanged> listeners;

    public HueControlViewModel() {
        this.hueControlModel = new HueControlModel(this);
        this.listeners = new ArrayList<>();
    }

    @Override
    public ArrayList<HueLightViewModel> getHueLightViewModelList() {

        ArrayList<HueLightViewModel> list = new ArrayList<>();
        for (Light light : hueControlModel.getLamps()) {
            list.add(new HueLightViewModel(light));
        }

        return list;
    }

    public void addListener(DataSetChanged listener) {
        listeners.add(listener);
    }

    @Override
    public void notifyDataSetChanged() {
        for (DataSetChanged listener : listeners) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    listener.notifyDataSetChanged();
                }
            });
        }
    }
}
