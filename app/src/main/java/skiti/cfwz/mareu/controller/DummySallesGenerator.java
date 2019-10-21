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
            new Salle("salle rouge",1,R.drawable.ic_salle_rouge_24dp),
            new Salle("salle verte",2,R.drawable.ic_salle_verte_24dp),
            new Salle("salle bleu",3,R.drawable.ic_salle_bleu_24dp),
            new Salle("salle orange",4,R.drawable.ic_salle_orange_24dp),
            new Salle("salle jaune",5,R.drawable.ic_salle_jaune_24dp),
            new Salle("salle noir",6,R.drawable.ic_salle_noir_24dp),
            new Salle("salle blanche",7,R.drawable.ic_salle_blanche_24dp),
            new Salle("salle violette",8,R.drawable.ic_salle_violette_24dp),
            new Salle("salle grise",9,R.drawable.ic_salle_grise_24dp),
            new Salle("salle rose",10,R.drawable.ic_salle_rose_24dp)
    );


    static List<Salle> generateSalles() {
        return new ArrayList<>(DUMMY_SALLES);
    }
}