package app.com.huelightsalarm.viewmodels;

import android.graphics.Color;
import android.view.View;

import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.views.adapters.HueLightCardAdapter;
import app.com.huelightsalarm.views.holders.HueLightCardHolder;

public class HueLightViewModel implements View.OnClickListener {
    private Light light;

    public HueLightViewModel(Light light) {
        this.light = light;
    }

    public void fillCardHolder(HueLightCardHolder holder) {
        holder.getHueLightSwitch().setChecked(light.isActivated());

        holder.getHueLightSwitch().setOnClickListener(this);

        holder.getLightName().setText(light.getName());

        holder.getImageView().setColorFilter(light.getColor());
    }

    @Override
    public void onClick(View view) {

    }
}
