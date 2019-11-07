package skiti.cfwz.mareu.model;

/**
 * Created by Skiti on 11/09/2019
 */

public class Salle {
    private String name;
    private int lieu;
    private int avatarColor;

    public Salle(String name, int lieu, int avatarColor) {
        this.name = name;
        this.lieu = lieu;
        avatarColor = avatarColor; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLieu() {
        return lieu;
    }

    public void setLieu(int lieu) {
        this.lieu = lieu;
    }

    public int getColor() {
        return avatarColor;
    }

    public void setColor(int avatarColor) { avatarColor = avatarColor; }
}
