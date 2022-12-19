package com.mycompany.mavenproject1;

import java.util.ArrayList;

public class Mavenproject1 {

    public static void main(String[] args) {
        CaracteristicasEspecie pantheral = new CaracteristicasEspecie("Panthera", 0.5);
        CaracteristicasEspecie felisl = new CaracteristicasEspecie("Felis", 0.5);
        CaracteristicasEspecie leol = new CaracteristicasEspecie("Leo", 0.5);
        CaractristicaIndividual panthera = new CaractristicaIndividual("Panthera", 0.5);
        CaractristicaIndividual felis = new CaractristicaIndividual("Felis", 0.5);
        CaractristicaIndividual leo = new CaractristicaIndividual("Leo", 0.5);
        CaractristicaIndividual tigris = new CaractristicaIndividual("Tigris", 0.5);
        CaractristicaIndividual leoTigris = new CaractristicaIndividual("LeoTigris", 0.5);

        ArrayList<CaracteristicasEspecie> caracteristicasEspecie = new ArrayList<CaracteristicasEspecie>();
        caracteristicasEspecie.add(pantheral);
        caracteristicasEspecie.add(felisl);
        caracteristicasEspecie.add(leol);

        ArrayList<CaractristicaIndividual> caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
        caracteristicasIndividuais.add(panthera);
        caracteristicasIndividuais.add(felis);
        caracteristicasIndividuais.add(leo);

        Zoo zoo = new Zoo(1000, 0.5);

        Especie leao = new Especie("Leão", 10, 0.8, 0.5, 0.2, caracteristicasEspecie);
        Especie tigre = new Especie("Tigre", 10, 0.8, 0.5, 0.2, caracteristicasEspecie);
        Especie gato = new Especie("Gato", 10, 0.8, 0.5, 0.2, caracteristicasEspecie);
        Animal b1 = new Animal("Betinho", 1, leao);
        Animal b2 = new Animal("Betinho", 3, tigre);

        NomeArtistico.addNome("Toni");
        NomeArtistico.addNome("Rui");
        NomeArtistico.addNome("João");
        NomeArtistico.addNome("Pedro");

        Menu menu = new Menu(zoo);
        menu.showMenu();
    }

}
