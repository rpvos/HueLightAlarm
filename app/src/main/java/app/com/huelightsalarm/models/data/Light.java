package app.com.huelightsalarm.models.data;

import android.graphics.Color;

import com.google.gson.JsonObject;

import app.com.huelightsalarm.utils.ColorCalculator;

public class Light {
    private String id; // id in hue bridge
    private String modelID; // id of the model
    private String name; // name of the lamp
    private int saturation; // 0 to 254
    private boolean isOn; // true or false
    private int brightness; // 1 to 254
    private int hue; // 0 to 65535
    private ColorMode colormode;


    public Light(JsonObject data, String key) {
        this.id = key;
        this.modelID = data.get("modelid").getAsString();
        this.name = data.get("name").getAsString();
        JsonObject state = data.getAsJsonObject("state");
        this.brightness = state.get("bri").getAsInt();
        this.isOn = state.get("on").getAsBoolean();

        if (modelID.contains("LCT")) {
            this.saturation = state.get("sat").getAsInt();
            this.hue = state.get("hue").getAsInt();
            this.colormode = ColorMode.valueOf(state.get("colormode").getAsString());
        }
    }

    public String getName() {
        return name;
    }

    public String getModelID() {
        return modelID;
    }

    public int getSaturation() {
        return saturation;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getBrightness() {
        return brightness;
    }

    public int getHue() {
        return hue;
    }

    public ColorMode getColormode() {
        return colormode;
    }

    public String getId() {
        return id;
    }

    public int getColor() {
        float[] floats = new float[3];

        floats[0] = ColorCalculator.map(0, 65535, 0, 360, hue);
        floats[1] = saturation;
        floats[2] = brightness;

        return Color.HSVToColor(floats);
    }




    /**
     * Indicates the color mode in which the light is working, this is the last command type it received.
     * Values are “hs” for Hue and Saturation, “xy” for XY and “ct” for Color Temperature.
     * This parameter is only present when the light supports at least one of the values.
     */
    public enum ColorMode {
        hs,
        xy,
        ct
    }
}
