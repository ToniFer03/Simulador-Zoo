package com.mycompany.mavenproject1;

import java.io.IOException;

import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Menus.MenuInicial;
import com.mycompany.mavenproject1.Menus.MenuPrincipal;
import com.mycompany.mavenproject1.ReaderClasses.CaracEspecieReader;
import com.mycompany.mavenproject1.ReaderClasses.CaractIndividualReader;
import com.mycompany.mavenproject1.ReaderClasses.EspecieReader;
import com.mycompany.mavenproject1.ReaderClasses.NomeArtisticoReader;
import com.mycompany.mavenproject1.ReaderClasses.ZooReader;

public class Mavenproject1 {

    public static void main(String[] args) {

        try {
            CaracEspecieReader.readCarcEspecie();
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }

        try {
            CaractIndividualReader.readCarcIndividual();
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }

        try {
            NomeArtisticoReader.readNomeArtistico();
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }

        try {
            EspecieReader.readEspecie();
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }

        Zoo zoo = initializeZoo();

        try {
            ZooReader.readZoo(zoo);
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }

        MenuInicial menuInicial = new MenuInicial(zoo);
        menuInicial.showMenu();

        MenuPrincipal menu = new MenuPrincipal(zoo);
        menu.showMenu();

    }

    private static Zoo initializeZoo() {
        Zoo zoo = new Zoo(1000.0, 0.0);

        return zoo;
    }
}
