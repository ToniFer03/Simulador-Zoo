package com.mycompany.mavenproject1.ReaderClasses;

import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;

import java.io.*;

public class CaracEspecieReader {

    private CaracEspecieReader() {
    }

    public static void readCarcEspecie() throws IOException {
        // connect the file to the program
        File file = new File("mavenproject1\\src\\main\\java\\com\\mycompany\\Ficheiros Texto\\CaracEspecies.txt");

        Scanner sc = new Scanner(file);

        StringTokenizer token = null;

        // initialize the variables for object CaracteristicasEspecie
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
