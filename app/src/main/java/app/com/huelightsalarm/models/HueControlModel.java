package app.com.huelightsalarm.models;

import java.util.ArrayList;

import app.com.huelightsalarm.models.data.Light;

public class HueControlModel {
    private APIHandler handler;

    public HueControlModel() {
        this.handler = new APIHandler();
    }

    public void getLamps() {
        ArrayList<Light> lamps = new ArrayList<>();

        handler.getLamps();
    }


    // This can be used if you want to do something in the ui thread
//    new Handler(Looper.getMainLooper()).post(new Runnable() {
//        @Override
//        public void run() {
//            //this runs on the UI thread
//        }
//    });

}

