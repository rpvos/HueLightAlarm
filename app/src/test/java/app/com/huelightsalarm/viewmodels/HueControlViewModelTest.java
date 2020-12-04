package app.com.huelightsalarm.viewmodels;

import android.os.Handler;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import app.com.huelightsalarm.interfaces.LightsModifier;
import app.com.huelightsalarm.tests.MockUpListener;

import static org.junit.Assert.*;

public class HueControlViewModelTest {
    private HueControlViewModel hueControlViewModel;

    @Before
    public void setUp() throws Exception {
        this.hueControlViewModel = new HueControlViewModel();
    }

    @Test
    public void setUiHandler() {
        Handler handler = new Handler();

        hueControlViewModel.setUiHandler(handler);

        assert (hueControlViewModel.getUiHandler() == handler);
    }

    @Test
    public void getHueLightViewModelList() {
        List list = hueControlViewModel.getHueLightViewModelList();
        assert (list != null);

        if (list.size() > 0) {
            assert (list.get(0) instanceof HueLightViewModel);
        }
    }

    @Test
    public void getLightsModifier() {
        LightsModifier modifier = hueControlViewModel.getLightsModifier();
        assert (modifier != null);
    }


    @Test
    public void addListener() {
        MockUpListener listener = new MockUpListener();

        assert (listener.isNotified() == false);

        hueControlViewModel.addListener(listener);

        hueControlViewModel.setUiHandler(null);

        hueControlViewModel.notifyDataSetChanged();

        assert (listener.isNotified());
    }

    @Test
    public void removeListener() {
        MockUpListener listener = new MockUpListener();

        assert (listener.isNotified() == false);

        hueControlViewModel.addListener(listener);

        hueControlViewModel.removeListener(listener);

        hueControlViewModel.setUiHandler(null);

        hueControlViewModel.notifyDataSetChanged();

        assert (listener.isNotified() == false);
    }

    @Test
    public void refresh() {

    }
}