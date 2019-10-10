package skiti.cfwz.mareu.controller;

import java.util.List;

import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.model.Salle;
import skiti.cfwz.mareu.model.Time;

/**
 * Created by Skiti on 21/08/2019
 */

public class DummyMeetingApiService implements MeetingApiService {

    List<Meeting> Meetings = DummyMeetingGenerator.generateMeetings();
    List<Salle> Salles = DummySallesGenerator.generateSalles();

    @Override
    public List<Meeting> getMeetings() { return Meetings;}

    @Override
    public  void deleteMeetings(Meeting meeting){Meetings.remove(meeting);}

    @Override
    public void addMeeting(Meeting meeting) {Meetings.add(meeting);}

    @Override
    public List<Salle> getSalles() {
        return Salles;
    }

    @Override
    public List<Meeting> sortDateMeetings(List<Meeting> meetingsToSort, Time minDate, Time maxDate) {
        if (meetingsToSort!=null)
        {
        for (int i=0;i<meetingsToSort.size();i++)
            {
            //if (meetingsToSort.get(i).getTime().getHour()<minDate.getHour()||
            }
        }
        return meetingsToSort;
    }

    @Override
    public List<Meeting> sortSalleMeetings(List<Meeting> meetingsToSort,String SalleName) {
        if (meetingsToSort!=null)
        {
            for (int i=0;i<meetingsToSort.size();i++)
            {
                if (meetingsToSort.get(i).getSalle().getName()!=SalleName)
                    meetingsToSort.remove(i);
            }
        }
        return meetingsToSort;
    }


}
