package com.mycompany.mavenproject1.ReaderClasses;

import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Classes_Principais.Especie;

import java.io.*;

/**
 * Utility class responsible for reading species data from a text file and
 * creating {@link Especie} objects.
 * <p>
 * Each line of the file is expected to contain:
 * <ul>
 *     <li>Name of the species</li>
 *     <li>Life expectancy (integer)</li>
 *     <li>Base attractiveness (double)</li>
 *     <li>Base food cost (double)</li>
 *     <li>Birth probability (double)</li>
 *     <li>Number of characteristics (integer)</li>
 *     <li>Followed by indexes of the characteristics (integers)</li>
 * </ul>
 * <p>
 * Format example:
 * <pre>
 * Leao-15-8.0-3.5-0.2-2-0-3
 * </pre>
 * Which means: a lion species with 15 years life expectancy, 8.0 base attractiveness,
 * 3.5 base food cost, 0.2 probability of birth, and 2 characteristics (indexes 0 and 3).
 */
public class EspecieReader {

    /**
     * The relative path to the file containing species data.
     */
    private static String FILENAME = "Ficheiros_Texto\\Especie.txt";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private EspecieReader() {
    }

    /**
     * Reads species data from a text file and creates {@link Especie} objects.
     * <p>
     * Each line is parsed into an {@code Especie} object. Then, based on the number of
     * characteristics specified in the line, the method fetches those characteristics
     * from the global list of {@link CaracteristicasEspecie} and adds them to the species.
     * <p>
     * Assumes that the {@code CaracteristicasEspecie.getCaracteristicasEspecie()} method
     * returns a valid static list of all characteristics that have been previously loaded.
     *
     * @throws IOException if there is a problem accessing or reading the file.
     */
    public static void readEspecie() throws IOException {
        File file = new File(FILENAME);
        Scanner sc = new Scanner(file);

        StringTokenizer token = null;

        String nomeEspecie = "";
        int esperancaVida = 0;
        Double atratividadeBase = 0.0;
        Double custoRacaobase = 0.0;
        Double probNascimento = 0.0;

        while (sc.hasNextLine()) {
            token = new StringTokenizer(sc.nextLine(), "-");

            nomeEspecie = token.nextToken();
            esperancaVida = Integer.parseInt(token.nextToken());
            atratividadeBase = Double.parseDouble(token.nextToken());
            custoRacaobase = Double.parseDouble(token.nextToken());
            probNascimento = Double.parseDouble(token.nextToken());

            Especie temp = new Especie(nomeEspecie, esperancaVida, atratividadeBase, custoRacaobase, probNascimento);

            int cont = Integer.parseInt(token.nextToken());

            for (int i = 0; i < cont; i++) {
                temp.addCaracteristicaEspecie(
                        CaracteristicasEspecie.getCaracteristicasEspecie().get(Integer.parseInt(token.nextToken())));
            }

        }

        sc.close();
    }
}
