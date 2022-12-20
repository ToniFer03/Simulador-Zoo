package com.mycompany.mavenproject1;

import java.util.ArrayList;

import com.mycompany.mavenproject1.Classes_Principais.CaracteristicasEspecie;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Classes_Principais.NomeArtistico;
import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;

public class Mavenproject1 {

    public static void main(String[] args) {
        initializeNames();
        ArrayList<CaracteristicasEspecie> caracteristicasEspecie = initializeCaracteristicasEspecie();
        ArrayList<CaractristicaIndividual> caracteristicasIndividuais = initializeCaracteristicasIndividuais();
        initializeSpecies();

        Zoo zoo = initializeZoo();

        MenuPrincipal menu = new MenuPrincipal(zoo);
        menu.showMenu();
    }

    private static void initializeNames() {
        NomeArtistico.addNome("Melano");
        NomeArtistico.addNome("Mirtilo");
        NomeArtistico.addNome("Carreira");
        NomeArtistico.addNome("David");
        NomeArtistico.addNome("Alladin");
        NomeArtistico.addNome("Alvin");
        NomeArtistico.addNome("Bambi");
        NomeArtistico.addNome("Gaston");
        NomeArtistico.addNome("Hades");
        NomeArtistico.addNome("Hercules");
        NomeArtistico.addNome("Jafar");
        NomeArtistico.addNome("Kronk");
        NomeArtistico.addNome("Kuzco");
        NomeArtistico.addNome("Mufasa");
        NomeArtistico.addNome("Loki");
        NomeArtistico.addNome("Mogli");
        NomeArtistico.addNome("Mufasa");
        NomeArtistico.addNome("Nemo");
        NomeArtistico.addNome("Pumba");
        NomeArtistico.addNome("Remy");
        NomeArtistico.addNome("Scar");
        NomeArtistico.addNome("Simba");
        NomeArtistico.addNome("Tarzan");
    }

    private static ArrayList<CaracteristicasEspecie> initializeCaracteristicasEspecie() {
        ArrayList<CaracteristicasEspecie> caracteristicasEspecie = new ArrayList<CaracteristicasEspecie>();
        caracteristicasEspecie.add(new CaracteristicasEspecie("Rugir", 6.1));
        caracteristicasEspecie.add(new CaracteristicasEspecie("Nadar", 2.0));
        caracteristicasEspecie.add(new CaracteristicasEspecie("Voar", 5.5));
        caracteristicasEspecie.add(new CaracteristicasEspecie("Sprint", 4.3));
        caracteristicasEspecie.add(new CaracteristicasEspecie("Cores vivas", 7.0));
        caracteristicasEspecie.add(new CaracteristicasEspecie("Veneno", 5.0));
        caracteristicasEspecie.add(new CaracteristicasEspecie("Trapalhão", 7.8));
        caracteristicasEspecie.add(new CaracteristicasEspecie("Exotico", 7.5));

        return caracteristicasEspecie;
    }

    private static ArrayList<CaractristicaIndividual> initializeCaracteristicasIndividuais() {
        ArrayList<CaractristicaIndividual> caracteristicasIndividuais = new ArrayList<CaractristicaIndividual>();
        caracteristicasIndividuais.add(new CaractristicaIndividual("Cor especial", 6.3));
        caracteristicasIndividuais.add(new CaractristicaIndividual("Sem pelo", 2.3));
        caracteristicasIndividuais.add(new CaractristicaIndividual("Albino", 7.0));
        caracteristicasIndividuais.add(new CaractristicaIndividual("Cego", 5.1));
        caracteristicasIndividuais.add(new CaractristicaIndividual("Sem um membro", 1.5));
        caracteristicasIndividuais.add(new CaractristicaIndividual("Trissomia", 1.0));
        caracteristicasIndividuais.add(new CaractristicaIndividual("Mudo", 3.0));
        caracteristicasIndividuais.add(new CaractristicaIndividual("Anão", 8.1));
        caracteristicasIndividuais.add(new CaractristicaIndividual("Gigante", 5.1));

        return caracteristicasIndividuais;
    }

    private static void initializeSpecies() {
        Especie leao = new Especie("Leão", 10, 6.5, 0.5, 0.2);
        Especie tigre = new Especie("Tigre", 12, 7.8, 0.5, 0.2);
        Especie gato = new Especie("Gato", 11, 3.4, 0.5, 0.2);
        Especie cachorro = new Especie("Cachorro", 15, 1.8, 0.5, 0.2);
        Especie urso = new Especie("Urso", 40, 4.3, 0.5, 0.2);
        Especie panda = new Especie("Panda", 20, 10, 0.5, 0.2);
        Especie elefante = new Especie("Elefante", 70, 6.5, 0.5, 0.2);
        Especie girafa = new Especie("Girafa", 35, 7.2, 0.5, 0.2);
        Especie hipopotamo = new Especie("Hipopotamo", 22, 5.5, 0.5, 0.2);
        Especie rinoceronte = new Especie("Rinoceronte", 17, 5.3, 0.5, 0.2);
        Especie baleia = new Especie("Baleia", 50, 9.4, 0.5, 0.2);
        Especie tubarao = new Especie("Tubarão", 43, 9.6, 0.5, 0.2);
        Especie peixe = new Especie("Peixe", 6, 1.7, 0.5, 0.2);
        Especie pinguim = new Especie("Pinguim", 8, 10, 0.5, 0.2);
        Especie avestruz = new Especie("Avestruz", 13, 3.8, 0.5, 0.2);
    }

    private static Zoo initializeZoo() {
        Zoo zoo = new Zoo(1000, 0.5);

        return zoo;
    }
}
