package skiti.cfwz.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import skiti.cfwz.mareu.model.Meeting;

public abstract class DummyMeetingGenerator {
    private static List<Meeting> DUMMY_MEETING = Arrays.asList(
            );
    public static List<Meeting> generateMeetings() {
        return new ArrayList<Meeting>(DUMMY_MEETING);
    }
}
