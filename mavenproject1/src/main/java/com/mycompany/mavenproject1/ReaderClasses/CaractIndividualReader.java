package com.mycompany.mavenproject1.ReaderClasses;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;

public class CaractIndividualReader {

    private CaractIndividualReader() {
    }

    public static void readCarcIndividual() throws IOException {
        // connect the file to the program
        File file = new File("mavenproject1\\src\\main\\java\\com\\mycompany\\Ficheiros Texto\\CaracIndividual.txt");

        Scanner sc = new Scanner(file);

        StringTokenizer token = null;

        // initialize the variables for object CaracteristicasEspecie
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