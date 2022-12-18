package com.mycompany.mavenproject1;

import java.util.ArrayList;

public class Mavenproject1 {

    public static void main(String[] args) {
        CaractristicaIndividual panthera = new CaractristicaIndividual("Panthera", 0.5);
        CaractristicaIndividual felis = new CaractristicaIndividual("Felis", 0.5);
        CaractristicaIndividual leo = new CaractristicaIndividual("Leo", 0.5);
        CaractristicaIndividual tigris = new CaractristicaIndividual("Tigris", 0.5);
        CaractristicaIndividual leoTigris = new CaractristicaIndividual("LeoTigris", 0.5);

        ArrayList<CaractristicaIndividual> caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
        caracteristicasIndividuais.add(panthera);
        caracteristicasIndividuais.add(felis);
        caracteristicasIndividuais.add(leo);

        Zoo zoo = new Zoo(1000, 0.5);

        Especie leao = new Especie("Leão", 10, 0.8, 0.5, 0.2, caracteristicasIndividuais);
        Especie tigre = new Especie("Tigre", 10, 0.8, 0.5, 0.2, caracteristicasIndividuais);
        Especie gato = new Especie("Gato", 10, 0.8, 0.5, 0.2, caracteristicasIndividuais);
        Animal b1 = new Animal("Betinho", 1, leao);
        Animal b2 = new Animal("Betinho", 3, tigre);
        Animal b3 = new Animal("Betinho", 5, gato);

        Instalacao inst = new Instalacao(4, 0);

        zoo.addAnimal(b1);
        zoo.addAnimal(b2);
        zoo.addAnimal(b3);

        zoo.addInstalacao(2);

        zoo.getInstalacoes().get(0).addAnimal(b1, 0);
        zoo.getInstalacoes().get(0).addAnimal(b2, 1);

        NomeArtistico.addNome("Toni");
        NomeArtistico.addNome("Rui");
        NomeArtistico.addNome("João");
        NomeArtistico.addNome("Pedro");

        Menu menu = new Menu();
        menu.showMenu();

    }

}
