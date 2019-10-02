package skiti.cfwz.mareu.model;

/**
 * Created by Skiti on 11/09/2019
 */

public class Salle {
    private String Name;
    private int Lieu;
    private int AvatarColor;

    public Salle(String name, int lieu, int avatarColor) {
        Name = name;
        Lieu = lieu;
        AvatarColor = avatarColor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getLieu() {
        return Lieu;
    }

    public void setLieu(int lieu) {
        Lieu = lieu;
    }

    public int getColor() {
        return AvatarColor;
    }

    public void setColor(int avatarColor) { AvatarColor = avatarColor;
    }
}
