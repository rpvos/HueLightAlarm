package app.com.huelightsalarm.interfaces;

public interface LightsModifier {
    void setLightColor(String id, float hue, float saturation, float brightness);
    void setLightState(String id, boolean isOn);

    void refresh();
}
