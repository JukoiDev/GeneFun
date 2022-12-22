package me.awli.genefun;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* Class that holds a gene sequence*/
public class GeneSequence {
    private String sequence;
    private static final Random RANDOM = new Random();

    private Map<Integer, String> annotations;

    public GeneSequence(String sequence) {
        this.sequence = sequence;
        this.annotations = new HashMap<>();
    }

    public String getAminoAcidSequence() {
        StringBuilder aminoAcidSequence = new StringBuilder();

        for (int i = 0; i + 2 < sequence.length(); i += 3) {
            String codon = sequence.substring(i, i + 3);

            aminoAcidSequence.append(CodonTable.getAminoAcidForCodon(codon));
        }

        return aminoAcidSequence.toString();
    }

    public void introduceMutation(double mutationProbability) {
        StringBuilder mutatedSequence = new StringBuilder();

        for (int i = 0; i < sequence.length(); i++) {
            char base = sequence.charAt(i);
            double randomProbability = RANDOM.nextDouble();
            if (randomProbability < mutationProbability) {
                // Introduce a mutation by replacing the base with a random base
                base = getRandomBase();
            }
            mutatedSequence.append(base);
        }

        this.sequence = mutatedSequence.toString();
    }

    public void insert(int index, GeneSequence geneToInsert) {
        StringBuilder modifiedSequence = new StringBuilder(sequence);
        modifiedSequence.insert(index, geneToInsert.getSequence());
        this.sequence = modifiedSequence.toString();
    }

    public double calculateSimilarity(GeneSequence otherGene) {
        // Calculate the length of the shorter gene
        int shorterLength = Math.min(sequence.length(), otherGene.getSequence().length());

        // Count the number of matching bases
        int matchingBases = 0;
        for (int i = 0; i < shorterLength; i++) {
            if (sequence.charAt(i) == otherGene.getSequence().charAt(i)) {
                matchingBases++;
            }
        }

        // Calculate the similarity as the ratio of matching bases to the length of the shorter gene
        return (double) matchingBases / shorterLength;
    }

    private char getRandomBase() {
        // Generate a random base (A, C, G, or T)
        int randomIndex = RANDOM.nextInt(4);
        return "ACGT".charAt(randomIndex);
    }

    public void addAnnotation(int index, String annotation) {
        annotations.put(index, annotation);
    }

    public String getAnnotation(int index) {
        return annotations.get(index);
    }

    public String getSequence() {
        return sequence;
    }
}