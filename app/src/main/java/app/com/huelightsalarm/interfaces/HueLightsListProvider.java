package app.com.huelightsalarm.interfaces;

import java.util.ArrayList;

import app.com.huelightsalarm.viewmodels.HueLightViewModel;


public interface HueLightsListProvider {
    ArrayList<HueLightViewModel> getHueLightViewModelList();

}
