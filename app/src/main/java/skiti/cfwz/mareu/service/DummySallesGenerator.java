package skiti.cfwz.mareu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import skiti.cfwz.mareu.R;
import skiti.cfwz.mareu.model.Salle;

/**
 * Created by Skiti on 11/09/2019
 */

public abstract class DummySallesGenerator {
    private static List<Salle> DUMMY_SALLES = Arrays.asList(
            new Salle("Salle rouge",1,R.drawable.ic_salle_rouge_24dp),
            new Salle("Salle verte",2,R.drawable.ic_salle_verte_24dp),
            new Salle("Salle bleu",3,R.drawable.ic_salle_bleu_24dp),
            new Salle("Salle orange",4,R.drawable.ic_salle_orange_24dp),
            new Salle("Salle jaune",5,R.drawable.ic_salle_jaune_24dp),
            new Salle("Salle noir",6,R.drawable.ic_salle_noir_24dp),
            new Salle("Salle blanche",7,R.drawable.ic_salle_blanche_24dp),
            new Salle("Salle violette",8,R.drawable.ic_salle_violette_24dp),
            new Salle("Salle grise",9,R.drawable.ic_salle_grise_24dp),
            new Salle("Salle rose",10,R.drawable.ic_salle_rose_24dp)
    );

    public static List<Salle> generateSalles() {
        return new ArrayList<>(DUMMY_SALLES);
    }
}