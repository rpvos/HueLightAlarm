package app.com.huelightsalarm.viewmodels;

import android.view.DragEvent;
import android.view.View;
import android.widget.Switch;

import androidx.annotation.NonNull;

import com.google.android.material.slider.Slider;

import app.com.huelightsalarm.interfaces.LightsModifier;
import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.utils.ColorCalculator;
import app.com.huelightsalarm.views.holders.HueLightCardHolder;

public class HueLightViewModel implements View.OnClickListener, Slider.OnSliderTouchListener {
    private Light light;
    private LightsModifier lightsModifier;
    private float lastValue;

    public HueLightViewModel(Light light) {
        this.light = light;
    }

    public void fillCardHolder(HueLightCardHolder holder, LightsModifier lightsModifier) {
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

}
