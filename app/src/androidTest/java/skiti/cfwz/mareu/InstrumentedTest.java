package skiti.cfwz.mareu;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import skiti.cfwz.mareu.controller.DI;
import skiti.cfwz.mareu.controller.MeetingApiService;
import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.model.Time;
import skiti.cfwz.mareu.utils.DeleteViewAction;
import skiti.cfwz.mareu.view.ListMeetingActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static skiti.cfwz.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {
    // This is fixed
    private MeetingApiService mMeetingApiService=DI.getMeetingApiService();
    private Meeting meeting1 = new Meeting("Meeting de test3",mMeetingApiService.getSalles().get(1),"Sujet de test3","Test3","Test7,Test8,Test9",18,0);
    private Meeting meeting2 = new Meeting("Meeting de test1",mMeetingApiService.getSalles().get(0),"Sujet de test1","Test1","Test1,Test2,Test3",10,10);
    private Meeting meeting3 = new Meeting("Meeting de test2",mMeetingApiService.getSalles().get(2),"Sujet de test2","Test2","Test4,Test5,Test6",14,45);
    private ListMeetingActivity mActivity;


    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityRule = new ActivityTestRule(ListMeetingActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
        mMeetingApiService.addMeeting(meeting1);
        mMeetingApiService.addMeeting(meeting2);
        mMeetingApiService.addMeeting(meeting3);
    }

    /**
     * We ensure that our recyclerview is displaying at least on item
     */
    @Test
    public void myNeighboursList_shouldNotBeEmpty() {
        // First scroll to the position that needs to be matched and click on it.
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }



    /**
     * When we delete an item, the item is no more shown
     */
    @Test
    public void ListMeetings_deleteAction_shouldRemoveItem() {
        int ITEMS_COUNT = mMeetingApiService.getMeetings().size();
        // Given : We remove the element at position 2
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT-1));
    }

    @Test
    public void FilterOption_sortByDate_shouldSortItem() {
        Time minTime = new Time(10,0);
        Time maxTime = new Time(13,0);
        mMeetingApiService.sortDateMeetings(minTime,maxTime);
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .check(withItemCount(mMeetingApiService.getMeetings().size()));
        }



    @Test
    public void FilterOption_sortBySalle_shouldSortItem() {
        String salleToFilter = mMeetingApiService.getMeetings().get(0).getSalle().getName();
        mMeetingApiService.sortSalleMeetings(salleToFilter);
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .check(withItemCount(mMeetingApiService.getMeetings().size()));
    }

    @Test
    public void FilterOption_resetFilter_shouldResetList() {
        mMeetingApiService.resetFilter();
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .check(withItemCount(mMeetingApiService.getMeetings().size()));
    }


}
