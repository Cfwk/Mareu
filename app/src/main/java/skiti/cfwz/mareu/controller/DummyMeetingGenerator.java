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
    public static List<Meeting> DUMMY_MEETING = Arrays.asList(
            new Meeting("Reunion A",salletest,"Manger des crepes","Jerome","SDFSDFSsdfsdfsdfsdfsdfsfdggsdfgdsfgdfgsdfgfDFSDFS"),
            new Meeting("Reunion B",salletest,"Manger des crepes","Jerome","SDFSDFSsdfsdfsdfsdfsdfsfdggsdfgdsfgdfgsdfgfDFSDFS"),
            new Meeting("Reunion C",salletest,"Manger des crepes","Jerome","SDFSDFSsdfsdfsdfsdfsdfsfdggsdfgdsfgdfgsdfgfDFSDFS")
    );
    static List<Meeting> generateMeetings() {
        return new ArrayList<Meeting>(DUMMY_MEETING);
    }
}
