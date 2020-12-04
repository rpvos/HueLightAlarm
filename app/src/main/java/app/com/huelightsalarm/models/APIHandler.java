package app.com.huelightsalarm.models;

import android.graphics.Color;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.HueLightListCallBack;
import app.com.huelightsalarm.interfaces.LightsModifier;
import app.com.huelightsalarm.models.data.AlarmModel;
import app.com.huelightsalarm.models.data.Light;
import app.com.huelightsalarm.utils.ColorCalculator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APIHandler implements LightsModifier {
    private final String BASE_URL = "http://10.0.2.2:8000/api/newdeveloper/";
    private final HueLightListCallBack callback;

    private OkHttpClient client;
    private List<DataSetChanged> listeners;


    public APIHandler(HueLightListCallBack callback) {
        this.client = new OkHttpClient();
        this.listeners = new ArrayList<>();
        this.callback = callback;
    }


    public void getLights() {
        Request request = new Request.Builder()
                .url(BASE_URL + "lights")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String data = response.body().string();
                    JsonObject jsonObject = JsonParser.parseString(data).getAsJsonObject();

                    List<Light> list = new ArrayList<>();

                    for (String key : jsonObject.keySet()) {
                        list.add(new Light(jsonObject.get(key).getAsJsonObject(), key));
                    }

                    callback.setLights(list);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void setLightColor(String id, float hueParam, float saturationParam, float brightnessParam) {

        int hue = ColorCalculator.map(0, 360, 0, 65535, hueParam);
        int saturation = ColorCalculator.map(0, 1, 0, 254, saturationParam);
        int brightness = ColorCalculator.map(0, 1, 0, 254, brightnessParam);

        String json = "{\n" +
                "    \"hue\": " + hue + ",\n" +
                "    \"on\": true,\n" +
                "    \"bri\": " + brightness + ",\n" +
                "    \"sat\": " + saturation + "\n" +
                "}";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(BASE_URL + "lights/" + id + "/state")
                .put(body)
                .build();

        Call call = client.newCall(request);


        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful())
                    getLights();
            }
        });
    }

    @Override
    public void setLightState(String id, boolean isOn) {
        String json = "{\n" +
                "    \"on\": " + isOn + ",\n" +
                "}";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(BASE_URL + "lights/" + id + "/state")
                .put(body)
                .build();

        Call call = client.newCall(request);


        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful())
                    getLights();
            }
        });
    }

    @Override
    public void refresh() {
        getLights();
    }

    @Override
    public void setBrightness(String id, int brightness) {
        String json = "{\n" +
                "    \"bri\": " + brightness + ",\n" +
                "}";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(BASE_URL + "lights/" + id + "/state")
                .put(body)
                .build();

        Call call = client.newCall(request);


        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful())
                    getLights();
            }
        });
    }

    @Override
    public void setSchedule(AlarmModel alarmModel) {

        String json = "{\n" +
                "    \"name\": \"Wake up\",\n" +
                "    \"description\": \"My wake up alarm\",\n" +
                "    \"command\": {\n" +
                "        \"address\": \" /api/newdeveloper/lights/1\",\n" +
                "        \"method\": \"POST\",\n" +
                "        \"body\": {\n" +
                "            \"on\": true\n" +
                "        }\n" +
                "    },\n" +
                "    \"timePattern\": \"W"+alarmModel.getWeekModel().getByte()+"/T"+alarmModel.getAlarmTime().getStringHour()+":"+alarmModel.getAlarmTime().getStringMinutes()+":00\"\n" +
                "}";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(BASE_URL + "schedules")
                .post(body)
                .build();

        Call call = client.newCall(request);


        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful())
                    getLights();
            }
        });
    }

    public void notifyDataSetChanged() {
        for (DataSetChanged listener : listeners) {
            listener.notifyDataSetChanged();
        }
    }

    public void addListener(DataSetChanged listener) {
        listeners.add(listener);
    }
}
