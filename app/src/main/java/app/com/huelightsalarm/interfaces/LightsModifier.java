package app.com.huelightsalarm.interfaces;

public interface LightsModifier {
    void setLightColor(String id, int hue, int saturation, int brightness);
    void setLightState(String id, boolean isOn);
}
