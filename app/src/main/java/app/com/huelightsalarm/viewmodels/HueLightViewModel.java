package app.com.huelightsalarm.viewmodels;

import android.view.DragEvent;
import android.view.View;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.slider.Slider;

import app.com.huelightsalarm.interfaces.LightsModifier;
import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.utils.ColorCalculator;
import app.com.huelightsalarm.views.fragments.ColorPickerFragment;
import app.com.huelightsalarm.views.holders.HueLightCardHolder;

public class HueLightViewModel implements View.OnClickListener {
    private Light light;
    private LightsModifier lightsModifier;

    public HueLightViewModel(Light light) {
        this.light = light;
    }

    public void fillCardHolder(HueLightCardHolder holder, LightsModifier lightsModifier) {
        holder.getHueLightSwitch().setChecked(light.isOn());

        holder.getHueLightSwitch().setOnClickListener(this);

        holder.getLightName().setText(light.getName());

        holder.getImageView().setColorFilter(light.getColor());

        holder.getCardView().setTag(light.getId());

            holder.getSlider().setValue(light.getPercentageBrightness());


        holder.getSlider().addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

                }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                float sliderValue = slider.getValue();
                int value = ColorCalculator.map(0, 1, 0, 254, sliderValue);
                lightsModifier.setBrightness(light.getId(), value);
            }
        });

        this.lightsModifier = lightsModifier;
    }

    @Override
    public void onClick(View view) {
        if (view instanceof Switch) {
            lightsModifier.setLightState(light.getId(), ((Switch) view).isChecked());
        }
    }
}
