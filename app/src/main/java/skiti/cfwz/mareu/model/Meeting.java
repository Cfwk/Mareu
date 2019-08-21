package skiti.cfwz.mareu.model;

import android.provider.ContactsContract;

import java.sql.Time;
import java.util.List;

/**
 * Created by Skiti on 21/08/2019
 */

public class Meeting {
    private Time heure;
    private String lieu;
    private String sujet;
    private List<ContactsContract.CommonDataKinds.Email> participants;

    public Meeting(Time heure, String lieu, String sujet, List<ContactsContract.CommonDataKinds.Email> participants) {
        this.heure = heure;
        this.lieu = lieu;
        this.sujet = sujet;
        this.participants = participants;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public List<ContactsContract.CommonDataKinds.Email> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ContactsContract.CommonDataKinds.Email> participants) {
        this.participants = participants;
    }



}
