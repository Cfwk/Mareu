package skiti.cfwz.mareu;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import skiti.cfwz.mareu.controller.DI;
import skiti.cfwz.mareu.controller.DummySallesGenerator;
import skiti.cfwz.mareu.controller.MeetingApiService;
import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.model.Salle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private MeetingApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
        service.addMeeting(new Meeting("Meeting de test1",service.getSalles().get(0),"Sujet de test1","Test1","Test1,Test2,Test3",10,10));
        service.addMeeting(new Meeting("Meeting de test2",service.getSalles().get(2),"Sujet de test2","Test2","Test4,Test5,Test6",14,45));
        service.addMeeting(new Meeting("Meeting de test3",service.getSalles().get(1),"Sujet de test3","Test3","Test7,Test8,Test9",18,0));
    }


    @Test
    public void addAndGetMeetingsWithSuccess() {
        List<Meeting> meetings = service.getMeetings();
        Meeting expectedMeeting = new Meeting("Meeting de test1",service.getSalles().get(0),"Sujet de test1","Test1","Test1,Test2,Test3",10,30);
        service.addMeeting(expectedMeeting);
        assertTrue(meetings.contains(expectedMeeting));
    }
    @Test
    public void getSallesWithSuccess() {
        List<Salle> salles = service.getSalles();
        List<Salle> expectedSalles = DummySallesGenerator.DUMMY_SALLES;
        assertThat(salles, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedSalles.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Meeting meetingToDelete = service.getMeetings().get(0);
        service.deleteMeetings(meetingToDelete);
        assertFalse(service.getMeetings().contains(meetingToDelete));
    }
    }