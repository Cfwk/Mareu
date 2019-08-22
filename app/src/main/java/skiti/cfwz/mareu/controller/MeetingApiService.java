package skiti.cfwz.mareu.controller;

import java.util.List;

import skiti.cfwz.mareu.model.Meeting;

/**
 * Created by Skiti on 21/08/2019
 */

public interface MeetingApiService {

    List<Meeting> getMeetings();

    void deleteMeetings(Meeting meeting);

    void addMeeting(Meeting meeting);
}
