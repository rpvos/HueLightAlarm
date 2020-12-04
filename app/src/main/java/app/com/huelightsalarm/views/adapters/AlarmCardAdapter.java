package app.com.huelightsalarm.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import app.com.huelightsalarm.interfaces.AlarmListProvider;
import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.R;
import app.com.huelightsalarm.viewmodels.AlarmViewModel;
import app.com.huelightsalarm.views.holders.AlarmCardHolder;

public class AlarmCardAdapter extends RecyclerView.Adapter<AlarmCardHolder> implements DataSetChanged {

    private final AlarmListProvider listProvider;

    public AlarmCardAdapter(AlarmListProvider listProvider) {
        this.listProvider = listProvider;
    }

    @NonNull
    @Override
    public AlarmCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_alarmpreset, parent, false);

        return new AlarmCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmCardHolder holder, int position) {
        AlarmViewModel viewModel = this.listProvider.getAlarmViewModelList().get(position);
        viewModel.fillCardHolder(holder);
        viewModel.setOnListChange(this.listProvider.onSelfRemove());
    }

    @Override
    public int getItemCount() {
        return this.listProvider.getAlarmViewModelList().size();
    }
}
