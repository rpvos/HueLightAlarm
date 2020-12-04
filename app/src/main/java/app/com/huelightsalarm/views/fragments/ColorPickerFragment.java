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

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.flag.BubbleFlag;
import com.skydoves.colorpickerview.flag.FlagMode;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.interfaces.OnResult;

public class ColorPickerFragment extends DialogFragment implements View.OnClickListener {

    private OnResult onResult;
    private ColorPickerView colorPickerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_colorpicker, container);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.TimePickerTheme);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button selected = view.findViewById(R.id.Button_SelectColor);
        this.colorPickerView = view.findViewById(R.id.ColorPicker_HueLights);
        BubbleFlag bubbleFlag = new BubbleFlag(this.getContext());
        bubbleFlag.setFlagMode(FlagMode.FADE);
        colorPickerView.setFlagView(bubbleFlag);

        selected.setOnClickListener(this);
    }

    public void setOnResult(OnResult onResult){
        this.onResult = onResult;
    }

    public static ColorPickerFragment newInstance(){
        return new ColorPickerFragment();
    }

    @Override
    public void onClick(View v) {
        float[] floats = new float[3];
        Color.colorToHSV(colorPickerView.getColor(),floats);
        onResult.onResult(floats[0], floats[1], floats[2], getTag());
        //TODO add nicer fix
        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}
