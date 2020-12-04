package app.com.huelightsalarm.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.models.data.Light;

public class HueControlModelTest {
    private HueControlModel hueControlModel;

    @Before
    public void setUp() throws Exception {
        this.hueControlModel = new HueControlModel();
    }

    @Test
    public void getLights() {
        List list = hueControlModel.getLights();
        assert (list != null);

        if (list.size() > 0) {
            assert (list.get(0) instanceof Light);
        }
    }

    @Test
    public void setLights() {
        List list = new ArrayList<Light>();

        list.add(new Light(getData(), "1"));

        hueControlModel.setLights(list);

        assert (hueControlModel.getLights().size() == list.size());
    }

    public JsonObject getData() {
        String json = "{\n" +
                "        \"modelid\": \"LCT001\",\n" +
                "        \"name\": \"Hue Lamp 1\",\n" +
                "        \"swversion\": \"65003148\",\n" +
                "        \"state\": {\n" +
                "            \"xy\": [\n" +
                "                0,\n" +
                "                0\n" +
                "            ],\n" +
                "            \"ct\": 0,\n" +
                "            \"alert\": \"none\",\n" +
                "            \"sat\": 254,\n" +
                "            \"effect\": \"none\",\n" +
                "            \"bri\": 254,\n" +
                "            \"hue\": 4444,\n" +
                "            \"colormode\": \"hs\",\n" +
                "            \"reachable\": true,\n" +
                "            \"on\": true\n" +
                "        },\n" +
                "        \"type\": \"Extended color light\",\n" +
                "        \"pointsymbol\": {\n" +
                "            \"1\": \"none\",\n" +
                "            \"2\": \"none\",\n" +
                "            \"3\": \"none\",\n" +
                "            \"4\": \"none\",\n" +
                "            \"5\": \"none\",\n" +
                "            \"6\": \"none\",\n" +
                "            \"7\": \"none\",\n" +
                "            \"8\": \"none\"\n" +
                "        },\n" +
                "        \"uniqueid\": \"00:17:88:01:00:d4:12:08-0a\"\n" +
                "    }";
        return JsonParser.parseString(json).getAsJsonObject();
    }

    @Test
    public void getAPIHandler() {
        assert (hueControlModel.getAPIHandler() instanceof APIHandler);
    }
}