package app.com.huelightsalarm.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.interfaces.OnResult;

public class LightSettingsFragment extends DialogFragment implements View.OnClickListener {
    private OnResult onResult;
    private EditText editText;

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

        ImageButton button = view.findViewById(R.id.Button_ConfirmSettings);
        button.setOnClickListener(this);

        this.editText = view.findViewById(R.id.EditText_SettingsLightName);

    }

    public static LightSettingsFragment newInstance() {
        return new LightSettingsFragment();
    }

    public void setOnResult(OnResult onResult) {
        this.onResult = onResult;
    }

    @Override
    public void onClick(View v) {
        String name = editText.getText().toString();

        onResult.onResult(name, getTag());

        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}
