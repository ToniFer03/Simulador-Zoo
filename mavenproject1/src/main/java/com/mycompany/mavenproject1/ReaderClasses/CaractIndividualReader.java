package com.mycompany.mavenproject1.ReaderClasses;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;

/**
 * Utility class responsible for reading individual characteristics
 * from a text file and creating {@link CaractristicaIndividual} objects.
 * <p>
 * The expected file format contains lines where each line consists of a name
 * and a numeric value separated by a hyphen ('-'), for example:
 * <pre>
 * Forca-7.2
 * Velocidade-5.1
 * </pre>
 * <p>
 * This class is non-instantiable and provides a static method to perform the reading.
 */
public class CaractIndividualReader {

    /**
     * The relative path to the file containing individual characteristics.
     */
    private static String FILENAME = "Ficheiros_Texto\\CaracIndividual.txt";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private CaractIndividualReader() {
    }

    /**
     * Reads individual characteristics from a text file and creates
     * {@link CaractristicaIndividual} objects.
     * <p>
     * Each line of the file must contain two values: the name of the characteristic
     * and its corresponding numeric value, separated by a hyphen ('-').
     * <p>
     * Example line format:
     * <pre>
     * Energia-9.3
     * </pre>
     * <p>
     * The method assumes that the {@code CaractristicaIndividual} constructor
     * stores each created instance internally (e.g., in a static list).
     *
     * @throws IOException if an I/O error occurs when reading the file.
     */
    public static void readCarcIndividual() throws IOException {
        File file = new File(FILENAME);
        Scanner sc = new Scanner(file);

        StringTokenizer token = null;

        String nome = "";
        Double valor = 0.0;

        while (sc.hasNextLine()) {
            token = new StringTokenizer(sc.nextLine(), "-");

            nome = token.nextToken();
            valor = Double.parseDouble(token.nextToken());

            CaractristicaIndividual ci = new CaractristicaIndividual(nome, valor);
        }

        sc.close();
    }
}