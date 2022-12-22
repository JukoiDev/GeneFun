package me.awli.genefun;

public final class Example {
    public static void main(String[] args) {
        GeneSequence firstGene = new GeneSequence("ATGCATGCATGC");
        System.out.println("Sequence of the first genome: " + firstGene.getSequence());

        GeneSequence secondGene = new GeneSequence("GTCACGGCTCGGAGC");
        System.out.println("Sequence of the second genome: " + secondGene.getSequence());

        secondGene.addAnnotation(0, "Example annotation");
        System.out.println("Annotation of the second gene: " + secondGene.getAnnotation(0));

        // Introduce a mutation with a probability of 0.1
        firstGene.introduceMutation(0.1);
        System.out.println("Sequence of the first genome after mutation: " + firstGene.getSequence());

        // Insert another gene into the first gene
        GeneSequence insertedGene = new GeneSequence("CGTA");
        firstGene.insert(1, insertedGene);
        System.out.println("Sequence of the first genome after inserting a new gene: " + firstGene.getSequence());

        // Calculate the similarity between the second gene and the first gene
        double similarity = secondGene.calculateSimilarity(firstGene);
        System.out.println("Similarity between the second gene and the first one: " + similarity);

        // Create a chromosome
        Chromosome group = new Chromosome();
        group.addGene(firstGene);
        group.addGene(secondGene);
        group.addGene(insertedGene);
        System.out.println("Genomes in chromosomes: " + group.getGenes().size());

        // Log out the amino acids
        System.out.println("Amino acids produced by first genome: " + firstGene.getAminoAcidSequence());
        System.out.println("Amino acids produced by second genome: " + secondGene.getAminoAcidSequence());

        // Final message
        System.out.println("And remember that this pseudo library is not even usefull. It's a waste of time!");
    }
}
