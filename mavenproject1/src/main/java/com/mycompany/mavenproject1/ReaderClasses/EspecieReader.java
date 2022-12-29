package com.mycompany.mavenproject1.ReaderClasses;

import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Classes_Principais.Especie;

import java.util.ArrayList;
import java.io.*;

public class EspecieReader {
    private EspecieReader() {
    }

    public static void readEspecie() throws IOException {
        // connect the file to the program
        File file = new File("mavenproject1\\src\\main\\java\\com\\mycompany\\Ficheiros Texto\\Especie.txt");

        Scanner sc = new Scanner(file);

        StringTokenizer token = null;

        // initialize the variables for the object Especie
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
