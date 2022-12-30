package com.mycompany.mavenproject1.ReaderClasses;

import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;

import java.io.*;

public class CaracEspecieReader {

    // private constructor to avoid object creation
    private CaracEspecieReader() {
    }

    public static void readCarcEspecie() throws IOException {
        // connect the file to the program
        File file = new File("Ficheiros_Texto\\CaracEspecies.txt");
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
            CaracteristicasEspecie ce = new CaracteristicasEspecie(nome, valor);
        }

        // close the scanner
        sc.close();
    }

}
