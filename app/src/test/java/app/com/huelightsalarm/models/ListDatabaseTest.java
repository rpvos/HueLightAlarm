package app.com.huelightsalarm.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import junit.framework.TestCase;

import org.mockito.Mockito;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import app.com.huelightsalarm.models.data.AlarmModel;
import app.com.huelightsalarm.models.data.TimeModel;
import app.com.huelightsalarm.models.data.WeekModel;
import app.com.huelightsalarm.viewmodels.AlarmViewModel;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

public class ListDatabaseTest extends TestCase {

    private ListDataBaseTest listDatabase;

    public void setUp() throws Exception {
        super.setUp();
        SharedPreferences sharedPreferences = Mockito.mock(SharedPreferences.class);
        final Context context = Mockito.mock(Context.class);
        Mockito.when(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPreferences);

        List<AlarmViewModel> alarms = new ArrayList<>();
        alarms.add(new AlarmViewModel(new AlarmModel(new TimeModel(12, 40), false, new WeekModel())));

        Mockito.when(sharedPreferences.getString("Alarms", null)).thenReturn(new Gson().toJson(alarms));

        this.listDatabase = new ListDataBaseTest(sharedPreferences);
    }

    public void testLoadList() {
        List<AlarmViewModel> alarms = new ArrayList<>();
        listDatabase.setListPointer(alarms);

        listDatabase.loadList();

        assert(listDatabase.alarms.size() == 1);
    }

    public static class ListDataBaseTest extends ListDatabase{

        private List<AlarmViewModel> alarms;

        public ListDataBaseTest(SharedPreferences sharedPreferences) {
            super(sharedPreferences);
        }

        @Override
        public void setListPointer(List<AlarmViewModel> alarmArrayList) {
            super.setListPointer(alarmArrayList);
            this.alarms = alarmArrayList;
        }
    }
}