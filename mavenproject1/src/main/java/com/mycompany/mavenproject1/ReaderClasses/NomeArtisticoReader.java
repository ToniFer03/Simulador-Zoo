package com.mycompany.mavenproject1.ReaderClasses;

import java.io.*;
import java.util.Scanner;

import com.mycompany.mavenproject1.Classes_Principais.NomeArtistico;

public class NomeArtisticoReader {
    private NomeArtisticoReader() {
    }

    public static void readNomeArtistico() throws IOException {
        // connect the file to the program
        File file = new File("mavenproject1\\src\\main\\java\\com\\mycompany\\Ficheiros Texto\\NomeArtistico.txt");

        Scanner sc = new Scanner(file);

        // initialize the variables for object CaracteristicasEspecie
        String nome = "";

        while (sc.hasNextLine()) {

            nome = sc.nextLine();

            NomeArtistico.addNome(nome);
        }

        sc.close();
    }
}
