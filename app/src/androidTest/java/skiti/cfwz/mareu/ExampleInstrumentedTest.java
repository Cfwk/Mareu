package skiti.cfwz.mareu;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import skiti.cfwz.mareu.controller.DI;
import skiti.cfwz.mareu.controller.MeetingApiService;
import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.utils.DeleteViewAction;
import skiti.cfwz.mareu.view.ListMeetingActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static skiti.cfwz.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("skiti.cfwz.mareu", appContext.getPackageName());
    }

    // This is fixed
    private static int ITEMS_COUNT = 12;
    private MeetingApiService mMeetingApiService;
    private List<Meeting> Meetings;

    private ListMeetingActivity mActivity;


    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityRule = new ActivityTestRule(ListMeetingActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
        mMeetingApiService = DI.getNewInstanceApiService();
        Meetings = mMeetingApiService.getMeetings();
        mMeetingApiService.addMeeting(new Meeting("Meeting de test1",mMeetingApiService.getSalles().get(0),"Sujet de test1","Test1","Test1,Test2,Test3",10,10));
        mMeetingApiService.addMeeting(new Meeting("Meeting de test2",mMeetingApiService.getSalles().get(2),"Sujet de test2","Test2","Test4,Test5,Test6",14,45));
        mMeetingApiService.addMeeting(new Meeting("Meeting de test3",mMeetingApiService.getSalles().get(1),"Sujet de test3","Test3","Test7,Test8,Test9",18,0));
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
        // Given : We remove the element at position 2
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT));
        // When perform a click on a delete icon
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
        // Then : the number of element is 11
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .check(withItemCount(ITEMS_COUNT-1));
    }


    @Test
    public void LisMeetingsItemName_shouldHaveTheGoodMeetingName() {
        onView(allOf(withId(R.id.list_meeting), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(allOf(withId(R.id.nameHeader), isDisplayed()))
                .check(matches(isDisplayed()));


    }

    @Test
    public void ProfileNeighbourActivity_shouldShowTheNeighbourNameOfNeighbourHeaderName() {

        onView(allOf(withId(R.id.list_neighbours), isDisplayed()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(allOf(withId(R.id.nameHeader), isDisplayed()))
                .check(matches(withText(Neighbours.get(1).getName())));

    }
}
