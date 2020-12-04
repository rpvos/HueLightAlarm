package app.com.huelightsalarm.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import app.com.huelightsalarm.interfaces.HueLightListCallBack;
import app.com.huelightsalarm.models.data.Light;

import static org.junit.Assert.*;

public class APIHandlerTest implements HueLightListCallBack {

    private APIHandler aPIHandler;

    @Before
    public void setUp() throws Exception {
        this.aPIHandler = new APIHandler(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getLights() {
    }

    @Test
    public void setLightColor() {
    }

    @Test
    public void setLightState() {
    }

    @Test
    public void refresh() {
    }

    @Test
    public void notifyDataSetChanged() {
    }

    @Test
    public void addListener() {
    }

    @Override
    public void setLights(List<Light> lights) {

    }
}