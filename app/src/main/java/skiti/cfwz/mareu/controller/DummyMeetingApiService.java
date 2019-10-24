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
    List<Meeting> MeetingsStock = DummyMeetingGenerator.generateMeetings();
    Boolean Filter = false;

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
    public void sortDateMeetings(Time minDate, Time maxDate) {
        Filter=true;
            for (int i = 0; i < Meetings.size(); i++) {
                if (Meetings.get(i).getTime().getComparator()<minDate.getComparator()||Meetings.get(i).getTime().getComparator()>maxDate.getComparator()) {
                    MeetingsStock.add(Meetings.get(i));
                    Meetings.remove(Meetings.get(i));
                    i=0;}
                }
            }

    @Override
    public void sortSalleMeetings(String SalleName) {
        Filter=true;
            for (int i=0;i<Meetings.size();i++)
            { if (!Meetings.get(i).getSalle().getName().contains(SalleName.toLowerCase())){
                MeetingsStock.add(Meetings.get(i));
                Meetings.remove(Meetings.get(i));
                i=0; }}
    }

    @Override
    public void resetFilter() {
        if (Filter) {
            Meetings.addAll(MeetingsStock);
            MeetingsStock.removeAll(MeetingsStock);
            Filter = false;}
        }
    }



