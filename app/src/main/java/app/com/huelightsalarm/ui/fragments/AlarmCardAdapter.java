package app.com.huelightsalarm.ui.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.ui.models.AlarmCardModel;

public class AlarmCardAdapter extends RecyclerView.Adapter<AlarmCardAdapter.CardHolder> {

    private List<AlarmCardModel> alarmCardModels;

    public AlarmCardAdapter() {
        this.alarmCardModels = new ArrayList<>();
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_alarmpreset, parent, false);

        return new CardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        // Selected model based on position
        AlarmCardModel model = this.alarmCardModels.get(position);

        // Sets the ViewHolder to the right variables
        holder.switchMaterial.setChecked(model.isActivated());
        holder.textClock.setFormat24Hour(model.getAlarmTime().getHour() + ":" + model.getAlarmTime().getMinutes());
    }

    @Override
    public int getItemCount() {
        return alarmCardModels.size();
    }

    public List<AlarmCardModel> getAlarmCardModels() {
        return alarmCardModels;
    }

    public class CardHolder extends RecyclerView.ViewHolder {

        private TextClock textClock;
        private SwitchMaterial switchMaterial;
        //TODO week buttons

        public CardHolder(@NonNull View itemView) {
            super(itemView);
            this.textClock = itemView.findViewById(R.id.DigitalClock_AlarmClock);
            this.switchMaterial = itemView.findViewById(R.id.Switch_CardSwitch);
        }
    }
}
