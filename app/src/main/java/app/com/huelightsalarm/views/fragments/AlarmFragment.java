package app.com.huelightsalarm.views.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.viewmodels.AlarmListViewModel;
import app.com.huelightsalarm.viewmodels.SharedViewModel;
import app.com.huelightsalarm.views.adapters.AlarmCardAdapter;

import static android.content.Context.MODE_PRIVATE;

public class AlarmFragment extends Fragment {

    private SharedPreferences sharedPreferences;
    private AlarmListViewModel viewModel;
    private RecyclerView recyclerView;

    public AlarmFragment(AlarmListViewModel alarmListViewModel) {
        this.viewModel = alarmListViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alarm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.recyclerView = view.findViewById(R.id.RecyclerView_AlarmsList);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        AlarmCardAdapter adapter = new AlarmCardAdapter(viewModel);
        this.recyclerView.setAdapter(adapter);


        viewModel.subscribe(adapter);
        adapter.notifyDataSetChanged();

        FloatingActionButton fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(v -> {
            FragmentManager fm = getFragmentManager();
            AddAlarmFragment addAlarmFragment = AddAlarmFragment.newInstance(viewModel);
            addAlarmFragment.show(fm, null);
        });
    }


    public static Fragment newInstance(AlarmListViewModel alarmListViewModel) {
        return new AlarmFragment(alarmListViewModel);
    }
}
