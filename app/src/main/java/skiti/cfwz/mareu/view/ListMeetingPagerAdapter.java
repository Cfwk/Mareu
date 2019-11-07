package skiti.cfwz.mareu.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Skiti on 26/09/2019
 */

public class ListMeetingPagerAdapter extends FragmentPagerAdapter {

    public ListMeetingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
            return MeetingFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 1;
    }
}