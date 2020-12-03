package app.com.huelightsalarm.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.HueLightListCallBack;
import app.com.huelightsalarm.models.data.Light;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APIHandler {
    private final String BASE_URL = "http://10.0.2.2:8000/api/newdeveloper/";

    private OkHttpClient client;
    private List<DataSetChanged> listeners;


    public APIHandler() {
        this.client = new OkHttpClient();
        this.listeners = new ArrayList<>();
    }


    public void getLamps(HueLightListCallBack callBack) {
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
                        list.add(new Light(jsonObject.get(key).getAsJsonObject()));
                    }

                    callBack.setLights(list);
                    notifyDataSetChanged();
                }
            }
        });
    }

    public void setLightColor(int id, int hue, int saturation, int brightness) {
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
                    notifyDataSetChanged();
            }
        });
    }

    public void setLightState(int id, boolean isOn) {
        String json = "{\n" +
                "    \"on\": "+isOn+",\n" +
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
                    notifyDataSetChanged();
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
