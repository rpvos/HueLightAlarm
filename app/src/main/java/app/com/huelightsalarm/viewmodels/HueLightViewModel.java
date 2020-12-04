package app.com.huelightsalarm.viewmodels;

import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;

import com.google.android.material.slider.Slider;

import java.util.List;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.LightsModifier;
import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.utils.ColorCalculator;
import app.com.huelightsalarm.views.holders.HueLightCardHolder;

public class HueLightViewModel implements View.OnClickListener, Slider.OnSliderTouchListener {
    private Light light;
    private LightsModifier lightsModifier;
    private float lastValue;
    private DataSetChanged listener;

    public HueLightViewModel(Light light) {
        this.light = light;
    }

    public void fillCardHolder(HueLightCardHolder holder, LightsModifier lightsModifier) {
        holder.getSettings().setTag(light.getId());

        holder.getHueLightSwitch().setChecked(light.isOn());

        holder.getHueLightSwitch().setOnClickListener(this);

        holder.getLightName().setText(light.getName());

        holder.getImageView().setColorFilter(light.getColor());

        holder.getCardView().setTag(light.getId());

        Slider slider = holder.getSlider();
        slider.setValue(light.getPercentageBrightness());
        slider.clearOnSliderTouchListeners();
        slider.addOnSliderTouchListener(this);


        this.lightsModifier = lightsModifier;
    }

    public float getLastValue() {
        return lastValue;
    }

    public void setLastValue(float lastValue) {
        this.lastValue = lastValue;
    }

    @Override
    public void onClick(View view) {
        if (view instanceof Switch) {
            lightsModifier.setLightState(light.getId(), ((Switch) view).isChecked());
        }
    }

    @Override
    public void onStartTrackingTouch(@NonNull Slider slider) {
    }

    @Override
    public void onStopTrackingTouch(@NonNull Slider slider) {
        float sliderValue = slider.getValue();
        if (getLastValue() != sliderValue) {
            setLastValue(slider.getValue());
            int value = ColorCalculator.map(0, 1, 0, 254, sliderValue);
            lightsModifier.setBrightness(light.getId(), value);

        }
    }

    @Override
    public String toString() {
        return light.getName();
    }

    public String getID() {
        return light.getId();
    }

    public DataSetChanged getListener() {
        return listener;
    }

    public void setListener(DataSetChanged listener) {
        this.listener = listener;
    }
}
