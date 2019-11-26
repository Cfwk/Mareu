package skiti.cfwz.mareu.service;

import org.joda.time.LocalTime;

import java.util.List;

import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.model.Salle;

/**
 * Created by Skiti on 21/08/2019
 */

public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();
    private List<Salle> salles = DummySallesGenerator.generateSalles();
    private List<Meeting> meetingsStock = DummyMeetingGenerator.generateMeetings();
    private Boolean filter = false;

    @Override
    public List<Meeting> getMeetings() { return meetings;}

    @Override
    public  void deleteMeetings(Meeting meeting){meetings.remove(meeting);}

    @Override
    public void addMeeting(Meeting meeting) {meetings.add(meeting);}

    @Override
    public List<Salle> getSalles() {
        return salles;
    }

    @Override
    public void sortDateMeetings(LocalTime minDate, LocalTime maxDate) {
        filter=true;
            for (int i = 0; i < meetings.size(); i++) {
                if (meetings.get(i).getTime().isBefore(minDate)||meetings.get(i).getTime().isAfter(maxDate)) {
                    meetingsStock.add(meetings.get(i));
                    meetings.remove(meetings.get(i));
                    i--;}
                }
            }

    @Override
    public void sortSalleMeetings(String salleName) {
        filter=true;
            for (int i=0;i<meetings.size();i++)
            { if (!meetings.get(i).getSalle().getName().contains(salleName.toLowerCase())){
                meetingsStock.add(meetings.get(i));
                meetings.remove(meetings.get(i));
                i--; }}
    }

    @Override
    public void resetFilter() {
        if (filter) {
            meetings.addAll(meetingsStock);
            meetingsStock.removeAll(meetingsStock);
            filter = false;}
        }
    }



