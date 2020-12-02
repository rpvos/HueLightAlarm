package app.com.huelightsalarm.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextClock;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.AlarmListProvider;
import app.com.huelightsalarm.DataSetChanged;
import app.com.huelightsalarm.R;
import app.com.huelightsalarm.models.AlarmModel;
import app.com.huelightsalarm.viewmodels.AlarmListViewModel;
import app.com.huelightsalarm.viewmodels.AlarmViewModel;

public class AlarmCardAdapter extends RecyclerView.Adapter<AlarmCardAdapter.CardHolder> implements DataSetChanged {

    private final AlarmListProvider listProvider;

    public AlarmCardAdapter(AlarmListProvider listProvider) {
        this.listProvider = listProvider;
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
        AlarmViewModel model = this.listProvider.getAlarmViewModelList().get(position);
        model.fillCardHolder(holder);
    }

    @Override
    public int getItemCount() {
        return this.listProvider.getAlarmViewModelList().size();
    }


    public static class CardHolder extends RecyclerView.ViewHolder {

        private final TextClock textClock;
        private final SwitchMaterial switchMaterial;
        //TODO week buttons
        private final List<Button> buttons ;

        public CardHolder(@NonNull View itemView) {
            super(itemView);

            this.textClock = itemView.findViewById(R.id.DigitalClock_AlarmClock);
            this.switchMaterial = itemView.findViewById(R.id.Switch_CardSwitch);
            this.buttons= new ArrayList<>();
            this.buttons.add(itemView.findViewById(R.id.Button_Monday));
            this.buttons.add(itemView.findViewById(R.id.Button_Tuesday));
            this.buttons.add(itemView.findViewById(R.id.Button_Wednesday));
            this.buttons.add(itemView.findViewById(R.id.Button_Thursday));
            this.buttons.add(itemView.findViewById(R.id.Button_Friday));
            this.buttons.add(itemView.findViewById(R.id.Button_Saturday));
            this.buttons.add(itemView.findViewById(R.id.Button_Sunday));

            for(Button button : buttons){
                button.setBackgroundColor(itemView.getResources().getColor(R.color.Old_Lavender));
                button.setTextColor(itemView.getResources().getColor(R.color.white));
            }

        }

        public SwitchMaterial getSwitchMaterial() {
            return switchMaterial;
        }

        public TextClock getTextClock() {
            return textClock;
        }
    }
}
