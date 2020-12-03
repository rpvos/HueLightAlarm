package app.com.huelightsalarm.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.HueLightsListProvider;
import app.com.huelightsalarm.R;
import app.com.huelightsalarm.viewmodels.AlarmViewModel;
import app.com.huelightsalarm.viewmodels.HueLightViewModel;

public class HueLightCardAdapter extends RecyclerView.Adapter<HueLightCardAdapter.CardHolder> {

    private HueLightsListProvider listProvider;

    public HueLightCardAdapter(HueLightsListProvider listProvider) {
        this.listProvider = listProvider;
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_huelight, parent, false);

        return new CardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        HueLightViewModel model = this.listProvider.getHueLightViewModelList().get(position);
        model.fillCardHolder(holder);
    }

    @Override
    public int getItemCount() {
        return listProvider.getHueLightViewModelList().size();
    }

    public static class CardHolder extends RecyclerView.ViewHolder {

        private final TextView lightName;
        private final Switch hueLightSwitch;

        public CardHolder(@NonNull View itemView) {
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
}
