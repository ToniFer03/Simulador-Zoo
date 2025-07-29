package com.mycompany.mavenproject1.ReaderClasses;

import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;

import java.io.*;

/**
 * Utility class responsible for reading species characteristics
 * from a text file and creating {@link CaracteristicasEspecie} objects.
 * <p>
 * The expected file format is one characteristic per line in the format:
 * <pre>
 * NomeCaracteristica-ValorNumerico
 * </pre>
 * Example:
 * <pre>
 * AlturaMedia-1.75
 * </pre>
 * This class cannot be instantiated.
 */
public class CaracEspecieReader {

    /**
     * The relative path to the file containing species characteristics.
     */
    private static String FILENAME = "Ficheiros_Texto\\CaracEspecies.txt";

    /**
     * Private constructor to prevent instantiation.
     */
    private CaracEspecieReader() {
    }

    /**
     * Reads species characteristics from the text file and creates
     * {@link CaracteristicasEspecie} objects.
     * <p>
     * Each line in the file should contain a name and a numeric value,
     * separated by a hyphen ('-'). For example:
     * <pre>
     * Tamanho-2.4
     * Peso-3.5
     * </pre>
     * <p>
     * This method will throw a {@link NumberFormatException} if the value
     * cannot be parsed as a {@code Double}
     *
     * @throws IOException if an error occurs while reading the file.
     */
    public static void readCarcEspecie() throws IOException {
        File file = new File(FILENAME);
        Scanner sc = new Scanner(file);

        StringTokenizer token = null;

        String nome = "";
        Double valor = 0.0;

        while (sc.hasNextLine()) {
            token = new StringTokenizer(sc.nextLine(), "-");

            nome = token.nextToken();
            valor = Double.parseDouble(token.nextToken());


            CaracteristicasEspecie ce = new CaracteristicasEspecie(nome, valor);
        }

        sc.close();
    }

}
