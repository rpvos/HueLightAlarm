package app.com.huelightsalarm.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.interfaces.AlarmListProvider;
import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.R;
import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.viewmodels.AlarmViewModel;
import app.com.huelightsalarm.viewmodels.HueLightViewModel;
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
                .inflate(R.layout.card_alarm, parent, false);

        return new AlarmCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmCardHolder holder, int position) {
        AlarmViewModel viewModel = this.listProvider.getAlarmViewModelList().get(position);
        viewModel.fillCardHolder(holder);

        Spinner spinner = holder.getSpinner();
        List<HueLightViewModel> list = listProvider.getLights();

        ArrayAdapter<HueLightViewModel> spinnerArrayAdapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item, list);
        listProvider.addHueLightsListSubscriber(() -> {
            spinnerArrayAdapter.clear();
            spinnerArrayAdapter.addAll(listProvider.getLights());
            spinnerArrayAdapter.notifyDataSetChanged();
        });

        spinner.setAdapter(spinnerArrayAdapter);

        viewModel.setOnListChange(this.listProvider.onSelfRemove());
    }

    @Override
    public int getItemCount() {
        return this.listProvider.getAlarmViewModelList().size();
    }
}
