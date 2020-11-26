package app.com.huelightsalarm.views.activities;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.models.OnAddingAlarm;
import app.com.huelightsalarm.views.fragments.AddAlarmFragment;
import app.com.huelightsalarm.models.AlarmCardModel;
import app.com.huelightsalarm.views.adapters.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements OnAddingAlarm {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(view -> {
//                final Dialog fbDialogue = new Dialog(MainActivity.this, android.R.style.Widget);
//                //fbDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
//                fbDialogue.setContentView(R.layout.fragment_addalarm_popup);
//                fbDialogue.setCancelable(true);
//                fbDialogue.show();
            FragmentManager fm = getSupportFragmentManager();
            AddAlarmFragment addAlarmFragment = AddAlarmFragment.newInstance(this);
            addAlarmFragment.show(fm, null);
        });
    }

    @Override
    public void addAlarm(AlarmCardModel newAlarm) {
        //todo add new alarm

    }
}