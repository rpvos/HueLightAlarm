package app.com.huelightsalarm.views.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.skydoves.colorpickerview.flag.BubbleFlag;
import com.skydoves.colorpickerview.flag.FlagMode;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.interfaces.OnResult;
import app.com.huelightsalarm.models.data.Light;

public class LightSettingsFragment extends DialogFragment implements View.OnClickListener {
    private OnResult onResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_light_settings, container);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.Theme_AppCompat_DayNight_Dialog);//todo
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.Button_ConfirmSettings);
        button.setOnClickListener(this);

    }

    public static LightSettingsFragment newInstance() {
        return new LightSettingsFragment();
    }

    public void setOnResult(OnResult onResult) {
        this.onResult = onResult;
    }

    @Override
    public void onClick(View v) {
        String name = "";
        String group = "";

        onResult.onResult(group,name, getTag());

        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}
