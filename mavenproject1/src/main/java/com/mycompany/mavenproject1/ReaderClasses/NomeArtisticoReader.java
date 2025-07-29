package com.mycompany.mavenproject1.ReaderClasses;

import java.io.*;
import java.util.Scanner;

import com.mycompany.mavenproject1.Classes_Principais.NomeArtistico;

/**
 * Utility class responsible for reading artistic names from a text file
 * and storing them using the {@link NomeArtistico} class.
 * <p>
 * Each line in the file represents a single artistic name.
 * <p>
 * Example file content:
 * <pre>
 * Tigre Real
 * Pantera Negra
 * Leão Dourado
 * </pre>
 * This class is non-instantiable and provides a static method to perform the read operation.
 */
public class NomeArtisticoReader {

    /**
     * The relative path to the text file containing artistic names.
     */
    private static String FILENAME = "mavenproject1\\Ficheiros_Texto\\NomeArtistico.txt";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private NomeArtisticoReader() {
    }

    /**
     * Reads artistic names from a text file and stores them using
     * {@link NomeArtistico#addNome(String)}.
     * <p>
     * Each line of the file should contain one artistic name.
     * <p>
     * Assumes that {@code NomeArtistico.addNome()} method handles internal storage.
     *
     * @throws IOException if there is a problem reading the file.
     */
    public static void readNomeArtistico() throws IOException {
        File file = new File(FILENAME);
        Scanner sc = new Scanner(file);

        String nome = "";

        while (sc.hasNextLine()) {
            nome = sc.nextLine();
            NomeArtistico.addNome(nome);
        }

        sc.close();
    }
}
