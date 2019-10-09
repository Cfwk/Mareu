package skiti.cfwz.mareu.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import skiti.cfwz.mareu.R;

/**
 * Created by Skiti on 21/08/2019
 */

public class ListMeetingActivity extends AppCompatActivity {
    @BindView(R.id.addMeetingButton)
    public FloatingActionButton mAddButton;
    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    ListMeetingPagerAdapter mPagerAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewMeetingDialog();
            }
        });
        mPagerAdapter = new ListMeetingPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
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

}
