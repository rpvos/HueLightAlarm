package app.com.huelightsalarm.viewmodels;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Switch;

import app.com.huelightsalarm.models.AlarmModel;
import app.com.huelightsalarm.views.adapters.AlarmCardAdapter;

public class AlarmViewModel implements View.OnClickListener {
    private final AlarmModel alarmModel;

    public AlarmViewModel(AlarmModel alarmModel) {
        this.alarmModel = alarmModel;
    }

    @SuppressLint("SetTextI18n")
    public void fillCardHolder(AlarmCardAdapter.CardHolder holder) {
        holder.getAlarmSwitch().setChecked(alarmModel.isActivated());

        holder.getAlarmSwitch().setOnClickListener(this);

        // todo add 12 hour support
        if (alarmModel.getAlarmTime().getMinutes() > 9) {
            holder.getClockTextView().setText(alarmModel.getAlarmTime().getHour() + ":" + alarmModel.getAlarmTime().getMinutes());
        } else {
            holder.getClockTextView().setText(alarmModel.getAlarmTime().getHour() + ":" + "0" + alarmModel.getAlarmTime().getMinutes());
        }
    }


    @Override
    public void onClick(View view) {
        boolean isActivated = ((Switch) view).isChecked();
        alarmModel.setActivated(isActivated);
    }
}
