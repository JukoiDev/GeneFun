package me.awli.genefun;

import java.util.HashMap;

/* That's a codon table */
public class CodonTable {
    // A lookup table mapping codons (strings of length 3) to amino acids
    private static final HashMap<String, Character> CODON_TO_AMINO_ACID = new HashMap<String, Character>() {{
        put("AAA", 'K');
        put("AAC", 'N');
        put("AAG", 'K');
        put("AAT", 'N');
        put("ACA", 'T');
        put("ACC", 'T');
        put("ACG", 'T');
        put("ACT", 'T');
        put("AGA", 'R');
        put("AGC", 'S');
        put("AGG", 'R');
        put("AGT", 'S');
        put("ATA", 'I');
        put("ATC", 'I');
        put("ATG", 'M');
        put("ATT", 'I');
        put("CAA", 'Q');
        put("CAC", 'H');
        put("CAG", 'Q');
        put("CAT", 'H');
        put("CCA", 'P');
        put("CCC", 'P');
        put("CCG", 'P');
        put("CCT", 'P');
        put("CGA", 'R');
        put("CGC", 'R');
        put("CGG", 'R');
        put("CGT", 'R');
        put("CTA", 'L');
        put("CTC", 'L');
        put("CTG", 'L');
        put("CTT", 'L');
        put("GAA", 'E');
        put("GAC", 'D');
        put("GAG", 'E');
        put("GAT", 'D');
        put("GCA", 'A');
        put("GCC", 'A');
        put("GCG", 'A');
        put("GCT", 'A');
        put("GGA", 'G');
        put("GGC", 'G');
        put("GGG", 'G');
        put("GGT", 'G');
        put("GTA", 'V');
        put("GTC", 'V');
        put("GTG", 'V');
        put("GTT", 'V');
        put("TAA", '*');
        put("TAC", 'Y');
        put("TAG", '*');
        put("TAT", 'Y');
        put("TCA", 'S');
        put("TCC", 'S');
        put("TCG", 'S');
        put("TCT", 'S');
        put("TGA", '*');
        put("TGC", 'C');
        put("TGG", 'W');
        put("TGT", 'C');
        put("TTA", 'L');
        put("TTC", 'F');
        put("TTG", 'L');
        put("TTT", 'F');
    }};

    public static char getAminoAcidForCodon(String codon) {
        return CODON_TO_AMINO_ACID.getOrDefault(codon, '?');
    }
}
