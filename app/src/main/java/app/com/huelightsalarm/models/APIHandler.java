package app.com.huelightsalarm.models;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

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


    public void getLamps() {
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8000/api/newdeveloper/lights")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                if (response.isSuccessful()) {
                    String data = response.body().string();
                    Log.d("Response successful", data);
                    //todo return data
                }

            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
        });


    }
}
