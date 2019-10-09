package skiti.cfwz.mareu.model;

/**
 * Created by Skiti on 21/08/2019
 */

public class Meeting {
    private String name;
    private String description;
    private Time time;
    private Salle salle;
    private String sujet;
    private String creator;
    private String participants;

    public Meeting(String name, Salle salle, String sujet,String creator, String participants,int Hour,int Minute) {
        this.name = name;
        this.salle = salle;
        this.sujet = sujet;
        this.participants = participants;
        this.creator = creator;
        this.time.setHour(Hour);
        this.time.setMinute(Minute);
    }
    public String getName(){
        String toReturn = sujet + " - " + time +" - "+ creator;
        return toReturn;}

    public String getDescription(){
        String toReturn = participants.toString();
        return toReturn;}

    public void setName(String nom) { this.name = nom; }

    public void setDescription(String description) { this.description = description; }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) { this.participants = participants; }

    public String getCreator() { return creator; }

    public void setCreator(String creator) { this.creator = creator;
    }
}
