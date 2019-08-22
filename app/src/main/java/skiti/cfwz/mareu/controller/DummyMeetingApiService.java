package skiti.cfwz.mareu.controller;

import java.util.List;

import skiti.cfwz.mareu.model.Meeting;

/**
 * Created by Skiti on 21/08/2019
 */

public class DummyMeetingApiService implements MeetingApiService {

    List<Meeting> Meetings;

    @Override
    public List<Meeting> getMeetings() {return Meetings;}

    @Override
    public  void deleteMeetings(Meeting meeting){Meetings.remove(meeting);}

    @Override
    public void addMeeting(Meeting meeting) {Meetings.add(meeting);}

}
