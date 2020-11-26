package app.com.huelightsalarm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.models.WeekModel;
import app.com.huelightsalarm.models.AlarmModel;
import app.com.huelightsalarm.models.TimeModel;
import app.com.huelightsalarm.viewmodels.AlarmListViewModel;
import app.com.huelightsalarm.views.adapters.AlarmCardAdapter;

public class AlarmFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO alarm logic

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO Alarm view
        return inflater.inflate(R.layout.fragment_alarm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AlarmListViewModel viewModel = new ViewModelProvider(this).get(AlarmListViewModel.class);

        this.recyclerView = view.findViewById(R.id.RecyclerView_AlarmsList);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        AlarmCardAdapter adapter = new AlarmCardAdapter(viewModel);
        this.recyclerView.setAdapter(adapter);


        viewModel.subscribe(adapter);
        adapter.notifyDataSetChanged();

    }


    public static Fragment newInstance() {
        return new AlarmFragment();
    }
}
