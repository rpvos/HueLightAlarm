package app.com.huelightsalarm.models;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.HueLightListCallBack;
import app.com.huelightsalarm.interfaces.LightsModifier;
import app.com.huelightsalarm.models.data.Light;

public class HueControlModel implements HueLightListCallBack, DataSetChanged {
    private APIHandler handler;
    private List<Light> lights;
    private ArrayList<DataSetChanged> listeners;

    public HueControlModel() {
        this.handler = new APIHandler(this);
        this.lights = new ArrayList<>();
        this.listeners = new ArrayList<>();

        this.handler.addListener(this);
        handler.getLights();
    }

    public HueControlModel(DataSetChanged listener) {
        this();
        listeners.add(listener);
    }

    public List<Light> getLights() {
        return lights;
    }

    @Override
    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    public void notifyDataSetChanged() {
        for (DataSetChanged listener : listeners) {
            listener.notifyDataSetChanged();
        }
    }

    public LightsModifier getAPIHandler() {
        return handler;
    }


}

