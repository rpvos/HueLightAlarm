package app.com.huelightsalarm.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.interfaces.HueLightListCallBack;
import app.com.huelightsalarm.models.data.Light;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIHandler {
    private OkHttpClient client;
    private Gson gson;

    public APIHandler() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }


    public void getLamps(HueLightListCallBack callBack) {
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8000/api/newdeveloper/lights")
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
                }
            }
        });
    }

}