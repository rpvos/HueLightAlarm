package app.com.huelightsalarm.viewmodels;

import android.view.View;
import android.widget.Switch;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import app.com.huelightsalarm.interfaces.LightsModifier;
import app.com.huelightsalarm.models.data.Light;
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

        this.lightsModifier = lightsModifier;
    }

    @Override
    public void onClick(View view) {
        if(view instanceof Switch){
            lightsModifier.setLightState(light.getId(),((Switch)view).isChecked());
        }
    }
}
