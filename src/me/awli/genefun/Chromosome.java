package me.awli.genefun;

import java.util.ArrayList;
import java.util.List;

/* Class that holds a collection of genes */
public class Chromosome {
    private List<GeneSequence> genes;

    public Chromosome() {
        this.genes = new ArrayList<>();
    }

    public void addGene(GeneSequence gene) {
        genes.add(gene);
    }

    public List<GeneSequence> getGenes() {
        return genes;
    }
}