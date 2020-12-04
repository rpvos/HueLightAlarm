package app.com.huelightsalarm.viewmodels;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.List;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.interfaces.OnListChange;
import app.com.huelightsalarm.models.data.AlarmModel;
import app.com.huelightsalarm.models.data.WeekModel;
import app.com.huelightsalarm.views.holders.AlarmCardHolder;

public class AlarmViewModel implements View.OnClickListener {
    private final AlarmModel alarmModel;
    private transient AlarmCardHolder alarmCardHolder;
    private transient OnListChange onListChange;


    public AlarmViewModel(AlarmModel alarmModel) {
        this.alarmModel = alarmModel;
    }

    @SuppressLint("SetTextI18n")
    public void fillCardHolder(AlarmCardHolder holder) {
        this.alarmCardHolder = holder;
        holder.getAlarmSwitch().setChecked(alarmModel.isActivated());
        holder.getAlarmSwitch().setOnClickListener(this);
        holder.getTrashImage().setOnClickListener(this);

        List<Button> weekButtons = holder.getButtons();
        for(Button weekButton : weekButtons){
            weekButton.setOnClickListener(this);
        }
        this.updateWeekButtons(weekButtons, alarmModel.getWeekModel());
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
            this.onListChange.NotifyChanges();
        } else if(view instanceof Button){

            Button weekButton = (Button)view;
            int index = alarmCardHolder.getButtons().indexOf(weekButton);

            WeekModel weekModel = this.alarmModel.getWeekModel();

            switch (index){
                case 0:
                    weekModel.setMonday(!weekModel.isMonday());
                    break;
                case 1:
                    weekModel.setTuesday(!weekModel.isTuesday());
                    break;
                case 2:
                    weekModel.setWednesday(!weekModel.isWednesday());
                    break;
                case 3:
                    weekModel.setThursday(!weekModel.isThursday());
                    break;
                case 4:
                    weekModel.setFriday(!weekModel.isFriday());
                    break;
                case 5:
                    weekModel.setSaturday(!weekModel.isSaturday());
                    break;
                case 6:
                    weekModel.setSunday(!weekModel.isSunday());
                    break;
            }

            this.updateWeekButtons(this.alarmCardHolder.getButtons(), weekModel);

        } else if(view instanceof ImageView){
            this.onListChange.OnSelfRemove(alarmCardHolder.getAdapterPosition());
        }
    }

    public void updateWeekButtons(List<Button> buttons, WeekModel weekModel){
        Button weekButton;

        weekButton = buttons.get(0);
        if(weekModel.isMonday()){

            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Apricot));
        } else {
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Old_Lavender));
        }
        weekButton = buttons.get(1);
        if(weekModel.isTuesday()){
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Apricot));
        } else {
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Old_Lavender));
        }
        weekButton = buttons.get(2);
        if(weekModel.isWednesday()){
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Apricot));
        } else {
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Old_Lavender));
        }
        weekButton = buttons.get(3);
        if(weekModel.isThursday()){
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Apricot));
        } else {
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Old_Lavender));
        }
        weekButton = buttons.get(4);
        if(weekModel.isFriday()){
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Apricot));
        } else {
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Old_Lavender));
        }
        weekButton = buttons.get(5);
        if(weekModel.isSaturday()){
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Apricot));
        } else {
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Old_Lavender));
        }
        weekButton = buttons.get(6);
        if(weekModel.isSunday()){
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Apricot));
        } else {
            weekButton.setBackgroundColor(weekButton.getContext().getColor(R.color.Old_Lavender));
        }
        if(onListChange != null)
            this.onListChange.NotifyChanges();
    }

    public void setOnListChange(OnListChange onListChange) {
        this.onListChange = onListChange;
    }
}
