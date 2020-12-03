package app.com.huelightsalarm.viewmodels;

import android.view.View;

import java.util.ArrayList;

import app.com.huelightsalarm.HueLightsListProvider;
import app.com.huelightsalarm.models.HueControlModel;
import app.com.huelightsalarm.models.data.Light;

public class HueControlViewModel implements HueLightsListProvider {
    private HueControlModel hueControlModel;

    public HueControlViewModel() {
        this.hueControlModel = new HueControlModel();
        hueControlModel.getLamps();
    }

    @Override
    public ArrayList<HueLightViewModel> getHueLightViewModelList() {
//        hueControlModel.getLamps();
        ArrayList<HueLightViewModel> lights = new ArrayList<>();

        lights.add(new HueLightViewModel(new Light()));

        return lights;
    }
}
