package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

public abstract class NomeArtistico {

    private static ArrayList<String> nomes = new ArrayList<>();

    // constructor
    private NomeArtistico() {
    }

    public static void addNome(String nome) {
        nomes.add(nome);
    }

    // get a random name from the list
    public static String getNome() {
        int index = (int) (Math.random() * nomes.size());
        return nomes.get(index);
    }
}
