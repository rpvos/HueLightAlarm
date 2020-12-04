package app.com.huelightsalarm.views.holders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.R;

public class AlarmCardHolder extends RecyclerView.ViewHolder {

    private final TextView clockTextView;
    private final Switch alarmSwitch;
    private final List<Button> buttons ;
    private final ImageView trashImage;
    private final Spinner spinner;

    public AlarmCardHolder(@NonNull View itemView) {
        super(itemView);
        this.trashImage = itemView.findViewById(R.id.ImageView_TrashButton);
        this.clockTextView = itemView.findViewById(R.id.DigitalClock_AlarmClock);
        this.alarmSwitch = itemView.findViewById(R.id.Switch_CardSwitch);
        this.spinner = itemView.findViewById(R.id.Spinner_Alarm);

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

    public Spinner getSpinner() { return spinner; }

    public List<Button> getButtons() {
        return buttons;
    }

    public ImageView getTrashImage() {
        return trashImage;
    }

    public Switch getAlarmSwitch() {
        return alarmSwitch;
    }

    public TextView getClockTextView() {
        return clockTextView;
    }
}
