package app.com.huelightsalarm.ui.fragments;

import android.view.View;
import android.view.ViewGroup;
import android.widget.DigitalClock;
import android.widget.TextClock;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.List;

import app.com.huelightsalarm.R;

public class AlarmCardAdapter extends RecyclerView.Adapter<AlarmCardAdapter.CardHolder> {

    private List<AlarmCardModel> alarmCardModels;

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return alarmCardModels.size();
    }

    public class CardHolder extends RecyclerView.ViewHolder {

        private TextClock digitalClock;
        private SwitchMaterial switchMaterial;
        //TODO week buttons

        public CardHolder(@NonNull View itemView) {
            super(itemView);
            this.digitalClock = itemView.findViewById(R.id.DigitalClock_AlarmClock);
            this.switchMaterial = itemView.findViewById(R.id.Switch_CardSwitch);
        }
    }
}
