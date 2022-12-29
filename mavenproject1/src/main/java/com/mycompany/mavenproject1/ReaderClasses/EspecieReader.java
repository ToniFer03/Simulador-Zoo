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

        String ident = "";

        // initialize the variables for the object Especie
        String nomeEspecie = "";
        int esperancaVida = 0;
        Double atratividadeBase = 0.0;
        Double custoRacaobase = 0.0;
        Double probNascimento = 0.0;
        ArrayList<CaracteristicasEspecie> ce = new ArrayList<CaracteristicasEspecie>();

        String nomeCarac = "";
        Double valorCarac = 0.0;

        while (sc.hasNextLine()) {
            token = new StringTokenizer(sc.nextLine(), "-");
            ident = token.nextToken();
            if (ident.equals("id:esp")) {
                nomeEspecie = token.nextToken();
                esperancaVida = Integer.parseInt(token.nextToken());
                atratividadeBase = Double.parseDouble(token.nextToken());
                custoRacaobase = Double.parseDouble(token.nextToken());
                probNascimento = Double.parseDouble(token.nextToken());
            } else if (ident.equals("id:ce")) {
                nomeCarac = token.nextToken();
                valorCarac = Double.parseDouble(token.nextToken());
                CaracteristicasEspecie c = new CaracteristicasEspecie(nomeCarac, valorCarac);
                ce.add(c);
            } else if (ident.equals("id:fim")) {
                // cria a especie caso seja detetato que chegou ao fim
                Especie e = new Especie(nomeEspecie, esperancaVida, atratividadeBase, custoRacaobase, probNascimento);

                for (CaracteristicasEspecie caracteristicasEspecie : ce) {
                    e.addCaracteristicaEspecie(caracteristicasEspecie);
                }
                ce.clear();
            }
        }

        sc.close();
    }
}
