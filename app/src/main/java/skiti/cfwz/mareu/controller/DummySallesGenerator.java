package skiti.cfwz.mareu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import skiti.cfwz.mareu.R;
import skiti.cfwz.mareu.model.Salle;

/**
 * Created by Skiti on 11/09/2019
 */

public abstract class DummySallesGenerator {

    public static List<Salle> DUMMY_SALLES = Arrays.asList(
            new Salle("Salle Rouge",1,R.drawable.ic_salle_rouge_24dp),
            new Salle("Salle Verte",2,R.drawable.ic_salle_verte_24dp),
            new Salle("Salle Bleu",3,R.drawable.ic_salle_bleu_24dp),
            new Salle("Salle Orange",4,R.drawable.ic_salle_orange_24dp),
            new Salle("Salle Jaune",5,R.drawable.ic_salle_jaune_24dp),
            new Salle("Salle Noir",6,R.drawable.ic_salle_noir_24dp),
            new Salle("Salle Blanche",7,R.drawable.ic_salle_blanche_24dp),
            new Salle("Salle Violette",8,R.drawable.ic_salle_violette_24dp),
            new Salle("Salle Grise",9,R.drawable.ic_salle_grise_24dp),
            new Salle("Salle Rose",10,R.drawable.ic_salle_rose_24dp)
    );


    static List<Salle> generateSalles() {
        return new ArrayList<>(DUMMY_SALLES);
    }
}