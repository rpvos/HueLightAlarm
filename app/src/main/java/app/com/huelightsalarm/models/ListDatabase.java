package app.com.huelightsalarm.models;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.interfaces.DataSetChanged;
import app.com.huelightsalarm.interfaces.Database;
import app.com.huelightsalarm.viewmodels.AlarmViewModel;

public class ListDatabase implements Database, DataSetChanged {

    private static final String SAVE_KEY = "Alarms";
    private SharedPreferences sharedPreferences;
    private List<AlarmViewModel> listPointer;

    public ListDatabase(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void saveList(List<AlarmViewModel> alarms) {
        String json = new Gson().toJson(new ArrayList<>(alarms));
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(SAVE_KEY, json);
        editor.apply();
    }

    @Override
    public void loadList() {
        List<AlarmViewModel> arrayItems;
        String serializedObject = sharedPreferences.getString(SAVE_KEY, null);
        if (serializedObject != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<AlarmViewModel>>(){}.getType();
            arrayItems = gson.fromJson(serializedObject, type);

            if(arrayItems != null){
                this.listPointer.clear();
                this.listPointer.addAll(arrayItems);
            }
        }

    }

    @Override
    public void setListPointer(ArrayList<AlarmViewModel> alarmArrayList) {
        this.listPointer = alarmArrayList;
    }

    @Override
    public void notifyDataSetChanged() {
        this.saveList(this.listPointer);
    }
}
