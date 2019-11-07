package skiti.cfwz.mareu.controller;

import java.util.List;

import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.model.Salle;
import skiti.cfwz.mareu.model.Time;

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
    public void sortDateMeetings(Time minDate, Time maxDate) {
        filter=true;
            for (int i = 0; i < meetings.size(); i++) {
                if (meetings.get(i).getTime().getComparator()<minDate.getComparator()||meetings.get(i).getTime().getComparator()>maxDate.getComparator()) {
                    meetingsStock.add(meetings.get(i));
                    meetings.remove(meetings.get(i));
                    i=0;}
                }
            }

    @Override
    public void sortSalleMeetings(String salleName) {
        filter=true;
            for (int i=0;i<meetings.size();i++)
            { if (!meetings.get(i).getSalle().getName().contains(salleName.toLowerCase())){
                meetingsStock.add(meetings.get(i));
                meetings.remove(meetings.get(i));
                i=0; }}
    }

    @Override
    public void resetFilter() {
        if (filter) {
            meetings.addAll(meetingsStock);
            meetingsStock.removeAll(meetingsStock);
            filter = false;}
        }
    }



