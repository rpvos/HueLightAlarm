package app.com.huelightsalarm.views.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import app.com.huelightsalarm.R;
import app.com.huelightsalarm.viewmodels.AlarmListViewModel;
import app.com.huelightsalarm.views.fragments.AlarmFragment;
import app.com.huelightsalarm.views.fragments.HueControlFragment;
import app.com.huelightsalarm.views.fragments.SettingsFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private AlarmListViewModel alarmViewModel;
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm, AlarmListViewModel viewModel) {
        super(fm);
        mContext = context;
        this.alarmViewModel = viewModel;
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position){
            case 0:
                return AlarmFragment.newInstance(alarmViewModel);
            case 1:
                return HueControlFragment.newInstance();
            case 2:
                return SettingsFragment.newInstance();
        }
        return AlarmFragment.newInstance(alarmViewModel);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}