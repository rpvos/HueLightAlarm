package app.com.huelightsalarm.views.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.interfaces.OnResult;
import app.com.huelightsalarm.viewmodels.HueControlViewModel;
import app.com.huelightsalarm.views.adapters.HueLightCardAdapter;

public class HueControlFragment extends Fragment implements View.OnClickListener, OnResult, SwipeRefreshLayout.OnRefreshListener {
    private HueControlViewModel hueControlViewModel;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;


    public HueControlFragment(HueControlViewModel hueControlViewModel) {
        this.hueControlViewModel = hueControlViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler uiHandler = new Handler();
        hueControlViewModel.setUiHandler(uiHandler);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_huecontrol, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.recyclerView = view.findViewById(R.id.RecyclerView_HueLights);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        HueLightCardAdapter adapter = new HueLightCardAdapter(hueControlViewModel, this);

        this.recyclerView.setAdapter(adapter);

        hueControlViewModel.addListener(adapter);

        this.swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        this.swipeRefreshLayout.setOnRefreshListener(this);
    }

    public static Fragment newInstance(HueControlViewModel sharedViewModel) {
        return new HueControlFragment(sharedViewModel);
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        ColorPickerFragment colorPickerFragment = ColorPickerFragment.newInstance();
        colorPickerFragment.setOnResult(this);
        colorPickerFragment.show(fm, (String) v.getTag());
    }

    @Override
    public void onResult(float hue, float saturation, float brightness, String id) {
        this.hueControlViewModel.getLightsModifier().setLightColor(id, hue, saturation, brightness);
    }

    /**
     * Method created to refresh the list of lamps
     */
    @Override
    public void onRefresh() {
        hueControlViewModel.refresh();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 300);
    }
}
