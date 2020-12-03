package app.com.huelightsalarm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.models.HueControlModel;
import app.com.huelightsalarm.viewmodels.AlarmListViewModel;
import app.com.huelightsalarm.viewmodels.HueControlViewModel;
import app.com.huelightsalarm.viewmodels.SharedViewModel;
import app.com.huelightsalarm.views.adapters.AlarmCardAdapter;
import app.com.huelightsalarm.views.adapters.HueLightCardAdapter;

public class HueControlFragment extends Fragment implements View.OnClickListener {
    private HueControlViewModel hueControlViewModel;
    private RecyclerView recyclerView;


    public HueControlFragment(HueControlViewModel hueControlViewModel) {
        this.hueControlViewModel = hueControlViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO Hue control view
        return inflater.inflate(R.layout.fragment_huecontrol, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.recyclerView = view.findViewById(R.id.RecyclerView_HueLights);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        HueLightCardAdapter adapter = new HueLightCardAdapter(hueControlViewModel, this);

        this.recyclerView.setAdapter(adapter);
    }

    public static Fragment newInstance(HueControlViewModel sharedViewModel) {
        return new HueControlFragment(sharedViewModel);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        DialogFragment colorPickerFragment = ColorPickerFragment.newInstance();
        colorPickerFragment.show(fm, null);
    }
}
