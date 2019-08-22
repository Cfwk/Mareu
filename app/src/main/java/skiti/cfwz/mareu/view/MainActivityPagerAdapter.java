package skiti.cfwz.mareu.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Skiti on 22/08/2019
 */

public class MainActivityPagerAdapter extends FragmentPagerAdapter {

        public MainActivityPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * getItem is called to instantiate the fragment for the given page.
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
                return MeetingFragment.newInstance();
        }


        /**
         * get the number of pages
         * @return
         */
        @Override
        public int getCount() {
            return 2;
        }
    }

