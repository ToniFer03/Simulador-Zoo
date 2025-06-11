package com.mycompany.mavenproject1.Classes_Principais;

import java.util.ArrayList;

public class Zoo {
    // attributes
    private double saldoContabilistico;
    private double probFugir;
    private int numeroAnimais; // to keep track of what id to atribute
    private int numeroInstalacoes; // to keep track of what id to atribute
    private ArrayList<Animal> todosAnimais; // array of all animals on the zoo
    private ArrayList<Animal> animaisSemInstacao; // array of animals that are not in any instalacao
    private ArrayList<Instalacao> instalacoes;
    private ArrayList<Animal> Obituario;

    /*
     * Talvez seja necessario ter um array de instaçãoes aqui, e dentro de cada
     * instação ter um array de animais que estao la dentro. Aqui tambem podera
     * existir um array de animais para os que estao fora das instalacoes
     */

    /**
     * Constructor for the class Zoo, receives the money the Zoo has and the probability of an animal escaping the Zoo,
     * sets the total number of animals and enclosures to 0, and crates a list for all tbe Animals, Enclosures, Animals
     * without Enclosures and  the obituary of the animals who have passed away
     *
     * @param saldoContabilistico All the money the Zoo has
     * @param probFugir Probability of an Animal escaping
     */
    public Zoo(Double saldoContabilistico, double probFugir) {
        this.saldoContabilistico = saldoContabilistico;
        this.probFugir = probFugir;
        numeroAnimais = 0;
        numeroInstalacoes = 0;
        todosAnimais = new ArrayList<Animal>();
        instalacoes = new ArrayList<Instalacao>();
        animaisSemInstacao = new ArrayList<Animal>();
        Obituario = new ArrayList<Animal>();
    }

    /**
     * @return Returns all the money the zoo has
     */
    public double getSaldoContabilistico() {
        return saldoContabilistico;
    }

    /**
     * @return The probability of an animal escaping the Zoo
     */
    public double getProbFugir() {
        return probFugir;
    }

    /**
     * @return Returns the total number of animals in the Zoo
     */
    public int getNumeroAnimais() {
        return numeroAnimais;
    }

    /**
     * @return Returns a list containing all the animals that have died in the Zoo
     */
    public ArrayList<Animal> getObituario() {
        return Obituario;
    }

    /**
     * @return Returns a list containing all the animals without an enclosure
     */
    public ArrayList<Animal> getAnimaisSemInstacao() {
        return animaisSemInstacao;
    }

    /**
     * Overload of the method with the same name, receives an id and returns the animal with said ID in the list of
     * animals without enclosure
     *
     * @param id ID of the animal we want
     *
     * @return Animal with that id, or null in case there is no animal with said id
     */
    public Animal getAnimaisSemInstacao(int id) {
        for (Animal a : animaisSemInstacao) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    /**
     * @return Returns the list containing all the animals in the Zoo
     */
    public ArrayList<Animal> getTodosAnimais() {
        return todosAnimais;
    }

    /**
     * Overload of the previous method, returns a certain animal with a given ID from the list of all animals in the
     * Zoo
     *
     * @param id ID of the animal we want
     *
     * @return Returns the animal with said ID or null in case there is not an Animal with that ID
     */
    public Animal getTodosAnimais(int id) {
        for (Animal a : todosAnimais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    /**
     * @return Returns the list containing all the enclosures in the Zoo
     */
    public ArrayList<Instalacao> getInstalacoes() {
        return instalacoes;
    }

    /**
     * Overload of the previous method, returns a certain enclosure with a given ID from the list of all enclosures in
     * the Zoo
     *
     * @param id ID of the enclosure we want
     *
     * @return Returns the enclosure with said ID or null in case there is not an enclosure with that ID
     */
    public Instalacao getInstalacoes(int id) {
        for (Instalacao i : instalacoes) {
            if (i.getIdInstalacao() == id) {
                return i;
            }
        }
        return null;
    }

    /**
     * This function receives an Instalacao object and adds it to the Zoo, first gives the object and ID and then adds
     * it to the list of all enclosures in the Zoo
     *
     * @param instalacao Instalacao object to be added to the Zoo
     */
    public void addInstalacaoZoo(Instalacao instalacao) {
        addIdToInstalacao(instalacao);
        instalacoes.add(instalacao);
    }

    /**
     * This function receives an Animal object and adds it to the Zoo, first gives the object and ID and then, if the
     * list of all animals does not contain it, add it to that list and give the animal an ID.
     * Add the animal to the list of animal without enclosure as well.
     *
     * @param animal Animal object to be added to the Zoo
     */
    public void addAnimalZoo(Animal animal) {
        if (!todosAnimais.contains(animal)) {
            todosAnimais.add(animal);
            addIdToAnimal(animal);
        }

        animaisSemInstacao.add(animal);
    }

    /**
     * Removes an animal from the Zoo, first remove the animal from the list that contains all animals in the Zoo. Check
     * if the animal was in an enclosure, if not remove it from the list of animals without enclosure if it was in one,
     * else call the function to remove an animal from an enclosure.
     * After all that add the animal to the obituary of the Zoo
     *
     * @param animal Object of the animal to be removed from the Zoo
     */
    public void removeAnimal(Animal animal) {
        todosAnimais.remove(animal);
        if (animaisSemInstacao.contains(animal)) {
            animaisSemInstacao.remove(animal);
        } else {
            removeAnimalInstalacao(animal);
        }
        Obituario.add(animal);
    }

    /**
     * Function that is called when an animal escaped the Zoo, first remove the animal from the list that contains all
     * the animals in the Zoo. Check if the animal was in an enclosure and if not, remove it from the list of animals
     * without an enclosure, else call the function to remove the animal from an enclosure
     *
     * @param animal Object of the animal that escaped the Zoo
     */
    public void animalFugiu(Animal animal) {
        todosAnimais.remove(animal);
        if (animaisSemInstacao.contains(animal)) {
            animaisSemInstacao.remove(animal);
            removeAnimalTotal(animal); //TODO: Check a redundancy
        } else {
            removeAnimalInstalacao(animal);
            removeAnimalTotal(animal);
        }
    }

    //TODO: Unnecessary method
    public void removerAnimalSemInstalacao(Animal animal) {
        animaisSemInstacao.remove(animal);
    }

    /**
     * Function to be called to reduce the money the Zoo has by a certain amount that is passed by a variable
     *
     * @param money Amount of money to be taken from the zoo's current account
     */
    public void decreaseZooMoney(Double money) {
        saldoContabilistico -= money;
    }

    /**
     * Function to be called to increase the money the Zoo has by a certain amount that is passed by a variable
     *
     * @param money Amount of money to be added to the Zoo's current account
     */
    public void increaseZooMoney(Double money) {
        saldoContabilistico += money;
    }

    /**
     * Set the probability of the animals to escape the Zoo by a certain amount that is passed by a variable
     *
     * @param valor Value that is going to become the probability of an animal escaping the Zoo
     */
    public void setProbFugir(double valor) {
        probFugir = valor; //TODO: Make sure the value is between 0 and 100
    }

    /**
     * Function to set the Zoo's current account to a certain value passed by a variable
     *
     * @param valor Value to become the new Current Account of the Zoo
     */
    public void setSaldocoContabilistico(double valor) {
        saldoContabilistico = valor;
    }

    /**
     * Method toString of the class Zoo
     * @return String with every information of the Zoo
     */
    @Override
    public String toString() {
        String s = "Zoo: \n";
        s += "Saldo Contabilistico: " + saldoContabilistico + "\n";
        s += "Probabilidade de Fugir: " + probFugir + "\n";
        s += "Numero de Animais: " + numeroAnimais + "\n";
        s += "--------------------------------------------\n";
        s += "                   Animais                  \n";
        s += "--------------------------------------------\n";
        for (Animal animal : todosAnimais) {
            s += animal.basicInfo();
            s += "--------------------------------------------\n";
        }
        s += "Animais sem instalacao: \n";
        s += "[ ";
        for (Animal animal : animaisSemInstacao) {
            s += animal.getId() + " ";
        }
        s += "]\n";
        s += "--------------------------------------------\n";
        s += "                 Instalacoes                \n";
        s += "--------------------------------------------\n";

        for (Instalacao instalacao : instalacoes) {
            s += instalacao.basicInfo();
            s += "--------------------------------------------\n";
        }
        return s;
    }

    /**
     * Private method used to give an object of type animal an ID
     *
     * @param animal Animal to be given an ID
     */
    private void addIdToAnimal(Animal animal) {
        animal.setId(numeroAnimais);
        numeroAnimais++;
    }

    /**
     * Private method used to give an object of type Instalacao an ID
     *
     * @param instalacao Instalacao to be given an ID
     */
    private void addIdToInstalacao(Instalacao instalacao) {
        instalacao.setId(numeroInstalacoes);
        numeroInstalacoes++;
    }

    /**
     * Private method used to remove an animal from an enclosure, cycles by all the enclosures until it finds the animal
     * and removes it from the enclosure
     *
     * @param animal Animal to be removed from the enclosure
     */
    private void removeAnimalInstalacao(Animal animal) {
        for (Instalacao i : instalacoes) {
            if (i.getAnimais().contains(animal)) {
                i.getAnimais().remove(animal);
            }
        }
    }

    //TODO: Unnecessary method
    private void removeAnimalTotal(Animal animal) {
        todosAnimais.remove(animal);
    }
}
