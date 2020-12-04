package app.com.huelightsalarm.interfaces;

public interface OnResult {
    void onResult(float hue, float saturation, float brightness, String id);

    void onResult(String group, String name, String id);
}
