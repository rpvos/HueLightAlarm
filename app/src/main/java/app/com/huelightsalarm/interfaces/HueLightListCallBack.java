package app.com.huelightsalarm.interfaces;

import java.util.List;

import app.com.huelightsalarm.models.data.Light;

public interface HueLightListCallBack {
    void setLights(List<Light> lights);
}
