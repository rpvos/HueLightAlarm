package app.com.huelightsalarm.views.holders;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import app.com.huelightsalarm.R;

public class HueLightCardHolder extends RecyclerView.ViewHolder {

    private final CardView cardView;
    private final TextView lightName;
    private final Switch hueLightSwitch;
    private final ImageView imageView;

    public HueLightCardHolder(@NonNull View itemView) {
        super(itemView);

        this.lightName = itemView.findViewById(R.id.TextView_HueLight);
        this.hueLightSwitch = itemView.findViewById(R.id.Switch_HueLight);
        this.cardView = itemView.findViewById(R.id.CardView_HueLamp);
        this.imageView = itemView.findViewById(R.id.ImageView_HueLight);
    }

    public TextView getLightName() {
        return lightName;
    }

    public Switch getHueLightSwitch() {
        return hueLightSwitch;
    }

    public void subscribeToOnClick(View.OnClickListener onClickListener) {
        this.cardView.setOnClickListener(onClickListener);
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public CardView getCardView() {
        return cardView;
    }
}
