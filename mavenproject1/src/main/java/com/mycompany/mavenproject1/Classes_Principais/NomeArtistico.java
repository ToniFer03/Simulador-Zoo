package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

public abstract class NomeArtistico {

    private static ArrayList<String> nomes = new ArrayList<>();

    /**
     * Private constructor, not meant to be instantiated
     */
    private NomeArtistico() {
    }

    /**
     * Add a name to the list of every artistic name ever given
     *
     * @param nome name to be added
     */
    public static void addNome(String nome) {
        nomes.add(nome);
    }

    /**
     * Get a random name from the artistic names list
     *
     * @return name to be given to an animal
     */
    public static String getNome() {
        int index = (int) (Math.random() * nomes.size());
        return nomes.get(index);
    }

    /**
     * Get a certain name from the list
     *
     * @param index index of the name on the list
     *
     * @return name
     */
    public static String getNome(int index) {
        return nomes.get(index);
    }
}
