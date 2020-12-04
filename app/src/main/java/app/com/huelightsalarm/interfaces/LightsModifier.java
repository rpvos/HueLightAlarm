package app.com.huelightsalarm.interfaces;

import app.com.huelightsalarm.models.data.AlarmModel;

public interface LightsModifier {
    void setLightColor(String id, float hue, float saturation, float brightness);
    void setLightState(String id, boolean isOn);

    void refresh();

    void setBrightness(String id, int brightness);

    void setSchedule(AlarmModel alarmModel);
}
