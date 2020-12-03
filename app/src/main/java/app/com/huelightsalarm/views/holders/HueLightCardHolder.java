package app.com.huelightsalarm.views.holders;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import app.com.huelightsalarm.R;

public class HueLightCardHolder extends RecyclerView.ViewHolder {

    private final TextView lightName;
    private final Switch hueLightSwitch;

    public HueLightCardHolder(@NonNull View itemView) {
        super(itemView);

        this.lightName = itemView.findViewById(R.id.TextView_HueLight);
        this.hueLightSwitch = itemView.findViewById(R.id.Switch_HueLight);
    }

    public TextView getLightName() {
        return lightName;
    }

    public Switch getHueLightSwitch() {
        return hueLightSwitch;
    }
}
