package me.awli.genefun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GeneSequenceFile {

    public static GeneSequence loadFromFastaFile(String filePath) throws IOException {
        StringBuilder sequence = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        while (line != null) {
            if (!line.startsWith(">")) {
                // This line is part of the sequence, so append it to the StringBuilder
                sequence.append(line);
            }
            line = reader.readLine();
        }
        reader.close();

        return new GeneSequence(sequence.toString());
    }

    public static GeneSequence loadFromGenBankFile(String filePath) throws IOException {
        StringBuilder sequence = new StringBuilder();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        while (line != null) {
            if (line.startsWith("ORIGIN")) {
                // The following lines contain the sequence
                line = reader.readLine();
                while (line != null && !line.startsWith("//")) {
                    // Remove any numbers or whitespace from the line
                    line = line.replaceAll("[\\d\\s]", "");
                    // Append the remaining characters (which should be the sequence bases) to the StringBuilder
                    sequence.append(line);
                    line = reader.readLine();
                }
                break;
            }
            line = reader.readLine();
        }
        reader.close();

        return new GeneSequence(sequence.toString());
    }
}