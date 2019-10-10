package skiti.cfwz.mareu.controller;

import java.util.List;

import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.model.Salle;
import skiti.cfwz.mareu.model.Time;

/**
 * Created by Skiti on 21/08/2019
 */

public interface MeetingApiService {

    List<Meeting> getMeetings();

    void deleteMeetings(Meeting meeting);

    void addMeeting(Meeting meeting);

    List<Salle> getSalles();

    List<Meeting>sortDateMeetings(List<Meeting> meetingsToSort, Time minDate, Time maxDate);

    List<Meeting>sortSalleMeetings(List<Meeting> meetingsToSort,String SalleName);
}
