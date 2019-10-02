package skiti.cfwz.mareu.model;

import java.util.List;

/**
 * Created by Skiti on 21/08/2019
 */

public class Meeting {
    private String name;
    private String description;
    private String time;
    private Salle salle;
    private String sujet;
    private String creator;
    private List<String> participants;

    public Meeting(String name,String heure, Salle salle, String sujet,String creator, List<String> participants) {
        this.name = name;
        this.time = heure;
        this.salle = salle;
        this.sujet = sujet;
        this.participants = participants;
        this.creator = creator;
    }
    public String getName(){
        String toReturn = sujet + " - " + time +" - "+ creator;
        return toReturn;}

    public String getDescription(){
        String toReturn = participants.toString();
        return toReturn;}

    public void setName(String nom) { this.name = nom; }

    public void setDescription(String description) { this.description = description; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) { this.participants = participants; }

    public String getCreator() { return creator; }

    public void setCreator(String creator) { this.creator = creator;
    }
}
