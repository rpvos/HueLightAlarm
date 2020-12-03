package app.com.huelightsalarm.viewmodels;

import android.view.View;

import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.views.adapters.HueLightCardAdapter;

public class HueLightViewModel implements View.OnClickListener {
    private Light light;

    public HueLightViewModel(Light light) {
        this.light = light;
    }

    public void fillCardHolder(HueLightCardAdapter.CardHolder holder) {
        holder.getHueLightSwitch().setChecked(light.isActivated());

        holder.getHueLightSwitch().setOnClickListener(this);

        holder.getLightName().setText(light.getName());
    }

    @Override
    public void onClick(View view) {

    }
}
