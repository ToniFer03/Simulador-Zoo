package com.mycompany.mavenproject1.ReaderClasses;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Classes_Principais.NomeArtistico;
import com.mycompany.mavenproject1.Classes_Principais.Zoo;

public class ZooReader {

    private ZooReader() {
    }

    public static void readZoo(Zoo zoo) throws IOException {
        Zoo z = zoo;

        // connect the file to the program
        File file = new File("Ficheiros_Texto\\Zoo.txt");
        Scanner sc = new Scanner(file);

        // initialize the variables for the StringTokenizer
        StringTokenizer token = null;

        // initialize the variables for the identifier
        String ident = "";

        // initialize the variables for the object Zoo
        double saldoContabilistico = 0.0;
        double probFugir = 0.0;

        // initialize the variables for the object Animal
        String nomeAnimal = "";
        int idade = 0;
        int idEspecie = 0;

        // initialize the variables for instalações
        int lotacaoMaxima = 0;
        double custoTrabalhadores = 0;
        double custoLimpeza = 0;

        while (sc.hasNextLine()) {
            token = new StringTokenizer(sc.nextLine(), "-"); // split the line by the "-" character
            ident = token.nextToken(); // get the identifier
            if (ident.equals("id:ini")) { // if the identifier is "id:ini"
                saldoContabilistico = Double.parseDouble(token.nextToken());
                probFugir = Double.parseDouble(token.nextToken());
                z.setProbFugir(probFugir);
                z.setSaldocoContabilistico(saldoContabilistico);
            } else if (ident.equals("id:tdani")) { // if the identifier is "id:tdani"
                nomeAnimal = NomeArtistico.getNome(Integer.parseInt(token.nextToken()));
                idade = Integer.parseInt(token.nextToken());
                idEspecie = Integer.parseInt(token.nextToken());

                // get local and temporary object especie and animal
                Especie e = Especie.getEspecies().get(idEspecie);
                Animal temp = new Animal(nomeAnimal, idade, e);

                // number of caracteristicas individuais
                int cont = Integer.parseInt(token.nextToken());

                // add caracteristicas individuais
                for (int i = 0; i < cont; i++) {
                    temp.addCaracteristicaIndividuais(CaractristicaIndividual.getCaracteristicasIndividuais()
                            .get(Integer.parseInt(token.nextToken())));
                }
                z.addAnimalZoo(temp); // add the animal to the zoo

            } else if (ident.equals("id:inst")) { // if the identifier is "id:inst"
                lotacaoMaxima = Integer.parseInt(token.nextToken());
                custoTrabalhadores = Double.parseDouble(token.nextToken());
                custoLimpeza = Double.parseDouble(token.nextToken());

                // create local and temporary object instalacao
                Instalacao temp = new Instalacao(lotacaoMaxima, custoTrabalhadores, custoLimpeza);

                // number of animais
                int cont = Integer.parseInt(token.nextToken());

                // add animais
                for (int i = 0; i < cont; i++) {
                    int idAnimal = Integer.parseInt(token.nextToken());
                    temp.addAnimal(z.getTodosAnimais(idAnimal));
                    z.removerAnimalSemInstalacao(z.getTodosAnimais(idAnimal));
                }

                z.addInstalacaoZoo(temp); // add the instalacao to the zoo
            }
        }
    }
}
