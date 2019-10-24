package skiti.cfwz.mareu.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import skiti.cfwz.mareu.R;
import skiti.cfwz.mareu.controller.DI;
import skiti.cfwz.mareu.controller.MeetingApiService;
import skiti.cfwz.mareu.model.FilterMeetingEvent;
import skiti.cfwz.mareu.model.ResetMeetingEvent;
import skiti.cfwz.mareu.model.Time;


/**
 * Created by Skiti on 21/08/2019
 */

public class ListMeetingActivity extends AppCompatActivity {
    @BindView(R.id.addMeetingButton)
    FloatingActionButton mAddButton;
    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.sort_menu)
    LinearLayout mSort_Menu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.hour_max)
    NumberPicker mHour_max;
    @BindView(R.id.hour_min)
    NumberPicker mHour_min;
    @BindView(R.id.minutes_max)
    NumberPicker mMinutes_max;
    @BindView(R.id.minutes_min)
    NumberPicker mMinutes_min;
    @BindView(R.id.salle_sort)
    EditText mSort_salles;
    @BindView(R.id.filter)
    Button mFilterButton;
    @BindView(R.id.reset)
    Button mResetButton;





    ListMeetingPagerAdapter mPagerAdapter;
    MeetingApiService mApiService= DI.getMeetingApiService();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        setNumberPicker();
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewMeetingDialog();
            }
        });
        mFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Time minTime = new Time(mHour_min.getValue(),mMinutes_min.getValue());
                Time maxTime = new Time(mHour_max.getValue(),mMinutes_max.getValue());
                if (minTime.getComparator()<maxTime.getComparator())
                mApiService.sortDateMeetings(minTime,maxTime);
                if (mSort_salles.getText().length()>1)
                mApiService.sortSalleMeetings(mSort_salles.getText().toString());
                EventBus.getDefault().post(new FilterMeetingEvent());
            }
        });
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { EventBus.getDefault().post(new ResetMeetingEvent());}
        });
        mPagerAdapter = new ListMeetingPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_sort, menu);
        return true;
    }

    private void showNewMeetingDialog() {
        FragmentManager fm = getSupportFragmentManager();
        NewMeetingDialogFragment newMeetingDialogFragment = NewMeetingDialogFragment.newInstance("New Meeting");
        newMeetingDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.Dialog_FullScreen);
        newMeetingDialogFragment.show(fm, "fragment_edit_name");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void setNumberPicker() {
        mHour_max.setMinValue(0);
        mHour_min.setMinValue(0);
        mMinutes_max.setMinValue(0);
        mMinutes_min.setMinValue(0);

        mHour_max.setMaxValue(23);
        mHour_min.setMaxValue(23);
        mMinutes_max.setMaxValue(59);
        mMinutes_min.setMaxValue(59);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter:
                if (mSort_Menu.getVisibility()==View.VISIBLE)
                mSort_Menu.setVisibility(View.GONE);
                else
                mSort_Menu.setVisibility(View.VISIBLE);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
