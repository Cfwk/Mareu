package skiti.cfwz.mareu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import skiti.cfwz.mareu.R;
import skiti.cfwz.mareu.model.Meeting;
import skiti.cfwz.mareu.model.Salle;

/**
 * Created by Skiti on 26/09/2019
 */

public abstract class DummyMeetingGenerator {
    static Salle salletest = new Salle("Salle Rouge",1,R.drawable.ic_salle_rouge_24dp);
    static List<String> participants = Arrays.asList(new String ("sdfsdf@sdf.com"), new String("jean@.com"));



    public static List<Meeting> DUMMY_MEETING = Arrays.asList(
            new Meeting("Reunion A","11:00",salletest,"Manger des crepes","Jerome",participants),
            new Meeting("Reunion B","11:00",salletest,"Manger des crepes","Jerome",participants),
            new Meeting("Reunion C","11:00",salletest,"Manger des crepes","Jerome",participants)
    );

    public static List<String> getParticipants() {
        return participants;
    }


    static List<Meeting> generateMeetings() {
        return new ArrayList<Meeting>(DUMMY_MEETING);
    }

}
