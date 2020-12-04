package app.com.huelightsalarm.viewmodels;

import android.view.View;

import android.os.Handler;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.HueControl;
import app.com.huelightsalarm.interfaces.HueLightsListProvider;
import app.com.huelightsalarm.interfaces.LightsModifier;
import app.com.huelightsalarm.models.HueControlModel;
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
        for (Light light : hueControlModel.getLamps()) {
            list.add(new HueLightViewModel(light));
        }

        return list;
    }

    @Override
    public LightsModifier getLightsModifier() {
        return hueControlModel.getAPIHandler();
    }

    public void addListener(DataSetChanged listener) {
        listeners.add(listener);
    }

    @Override
    public void notifyDataSetChanged() {
        for (DataSetChanged listener : listeners) {
            uiHandler.post(listener::notifyDataSetChanged);
        }
    }

    public void setUiHandler(Handler uiHandler) {
        this.uiHandler = uiHandler;
    }


    public void refresh() {
        hueControlModel.getAPIHandler().refresh();
    }
}
