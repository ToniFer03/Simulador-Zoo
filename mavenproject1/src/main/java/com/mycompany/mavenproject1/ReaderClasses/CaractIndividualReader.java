package com.mycompany.mavenproject1.ReaderClasses;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;

public class CaractIndividualReader {

    private static String FILENAME = "Ficheiros_Texto\\CaracIndividual.txt";

    private CaractIndividualReader() {
    }

    public static void readCarcIndividual() throws IOException {
        // connect the file to the program
        File file = new File(FILENAME);
        Scanner sc = new Scanner(file);

        // initialize the variables for the StringTokenizer
        StringTokenizer token = null;

        // initialize the variables for object CaracteristicasEspecie
        String nome = "";
        Double valor = 0.0;

        while (sc.hasNextLine()) {
            token = new StringTokenizer(sc.nextLine(), "-"); // split the line by the "-" character

            nome = token.nextToken();
            valor = Double.parseDouble(token.nextToken());

            // creates an object (uses the fact that every object created is stored in the
            // arraylist)
            CaractristicaIndividual ci = new CaractristicaIndividual(nome, valor);
        }

        // close the scanner
        sc.close();
    }
}