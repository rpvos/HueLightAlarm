package app.com.huelightsalarm.viewmodels;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.interfaces.OnSelfRemove;
import app.com.huelightsalarm.models.data.AlarmModel;
import app.com.huelightsalarm.models.data.WeekModel;
import app.com.huelightsalarm.views.adapters.AlarmCardAdapter;
import app.com.huelightsalarm.views.holders.AlarmCardHolder;

public class AlarmViewModel implements View.OnClickListener {
    private final AlarmModel alarmModel;
    private AlarmCardHolder alarmCardHolder;
    private OnSelfRemove onSelfRemove;


    public AlarmViewModel(AlarmModel alarmModel) {
        this.alarmModel = alarmModel;
    }

    @SuppressLint("SetTextI18n")
    public void fillCardHolder(AlarmCardHolder holder) {
        this.alarmCardHolder = holder;
        holder.getAlarmSwitch().setChecked(alarmModel.isActivated());
        holder.getAlarmSwitch().setOnClickListener(this);
        holder.getTrashImage().setOnClickListener(this);
        for(Button weekButton : holder.getButtons()){
            weekButton.setOnClickListener(this);
        }

        // todo add 12 hour support
        if (alarmModel.getAlarmTime().getMinutes() > 9) {
            holder.getClockTextView().setText(alarmModel.getAlarmTime().getHour() + ":" + alarmModel.getAlarmTime().getMinutes());
        } else {
            holder.getClockTextView().setText(alarmModel.getAlarmTime().getHour() + ":" + "0" + alarmModel.getAlarmTime().getMinutes());
        }
    }

    @Override
    public void onClick(View view) {
        if(view instanceof Switch){
            boolean isActivated = ((Switch) view).isChecked();
            alarmModel.setActivated(isActivated);
        } else if(view instanceof Button){
            Button weekButton = (Button)view;
            int index = alarmCardHolder.getButtons().indexOf(weekButton);

            WeekModel weekModel = this.alarmModel.getWeekModel();

            switch (index){
                case 0:
                    weekModel.setMonday(!weekModel.isMonday());

                    if(weekModel.isMonday()){
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Apricot));
                    } else {
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Old_Lavender));
                    }
                    break;
                case 1:
                    weekModel.setTuesday(!weekModel.isTuesday());

                    if(weekModel.isTuesday()){
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Apricot));
                    } else {
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Old_Lavender));
                    }
                    break;
                case 2:
                    weekModel.setWednesday(!weekModel.isWednesday());

                    if(weekModel.isWednesday()){
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Apricot));
                    } else {
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Old_Lavender));
                    }
                    break;
                case 3:
                    weekModel.setThursday(!weekModel.isThursday());

                    if(weekModel.isThursday()){
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Apricot));
                    } else {
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Old_Lavender));
                    }
                    break;
                case 4:
                    weekModel.setFriday(!weekModel.isFriday());

                    if(weekModel.isFriday()){
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Apricot));
                    } else {
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Old_Lavender));
                    }
                    break;
                case 5:
                    weekModel.setSaturday(!weekModel.isSaturday());

                    if(weekModel.isSaturday()){
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Apricot));
                    } else {
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Old_Lavender));
                    }
                    break;
                case 6:
                    weekModel.setSunday(!weekModel.isSunday());

                    if(weekModel.isSunday()){
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Apricot));
                    } else {
                        weekButton.setBackgroundColor(view.getContext().getColor(R.color.Old_Lavender));
                    }
                    break;
            }
        } else if(view instanceof ImageView){
            this.onSelfRemove.OnSelfRemove(alarmCardHolder.getAdapterPosition());
        }
    }

    public void setOnSelfRemove(OnSelfRemove onSelfRemove) {
        this.onSelfRemove = onSelfRemove;
    }
}
