package app.com.huelightsalarm.models.data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LightTest {

    private Light light;

    @Before
    public void setUp() throws Exception {
        this.light = new Light(getData(), "1");
    }

    @Test
    public void getName() {
        assertEquals(getErrorMessage(), "Hue Lamp 1", light.getName());
    }

    @Test
    public void getModelID() {
        assertEquals(getErrorMessage(), "LCT001", light.getModelID());
    }

    @Test
    public void getSaturation() {
        assertEquals(getErrorMessage(), 254, light.getSaturation());
    }

    @Test
    public void isOn() {
        assertEquals(getErrorMessage(), true, light.isOn());
    }

    @Test
    public void getBrightness() {
        assertEquals(getErrorMessage(), 254, light.getBrightness());
    }

    @Test
    public void getHue() {
        assertEquals(getErrorMessage(), 4444, light.getHue());
    }

    @Test
    public void getColormode() {
        assertEquals(getErrorMessage(), Light.ColorMode.hs, light.getColormode());
    }

    @Test
    public void getId() {
        assertEquals(getErrorMessage(), "1", light.getId());
    }

    @Test
    public void getColor() {
        assertEquals(getErrorMessage(), light.getColor(),light.getColor());
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

    private String getErrorMessage() {
        return "Hue light not initialized correctly";
    }
}