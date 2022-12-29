package com.mycompany.mavenproject1.ReaderClasses;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.mycompany.mavenproject1.Classes_Principais.Animal;
import com.mycompany.mavenproject1.Classes_Principais.CaractristicaIndividual;
import com.mycompany.mavenproject1.Classes_Principais.Especie;
import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Classes_Principais.Zoo;

public class ZooReader {

    private ZooReader() {
    }

    public static void readZoo(Zoo zoo) throws IOException {
        Zoo z = zoo;

        // connect the file to the program
        File file = new File("mavenproject1\\src\\main\\java\\com\\mycompany\\Ficheiros Texto\\Zoo.txt");

        Scanner sc = new Scanner(file);

        StringTokenizer token = null;

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
        int custoTrabalhadores = 0;
        int custoLimpeza = 0;

        while (sc.hasNextLine()) {
            token = new StringTokenizer(sc.nextLine(), "-");
            ident = token.nextToken();
            if (ident.equals("id:ini")) {
                saldoContabilistico = Double.parseDouble(token.nextToken());
                probFugir = Double.parseDouble(token.nextToken());
                z.setProbFugir(probFugir);
                z.setSaldocoContabilistico(saldoContabilistico);
            } else if (ident.equals("id:tdani")) {
                nomeAnimal = token.nextToken();
                idade = Integer.parseInt(token.nextToken());
                idEspecie = Integer.parseInt(token.nextToken());
                Especie e = Especie.getEspecies().get(idEspecie);

                Animal temp = new Animal(nomeAnimal, idade, e);

                int cont = Integer.parseInt(token.nextToken());
                for (int i = 0; i < cont; i++) {
                    temp.addCaracteristicaIndividuais(CaractristicaIndividual.getCaracteristicasIndividuais()
                            .get(Integer.parseInt(token.nextToken())));
                }
                z.addAnimalZoo(temp);

            } else if (ident.equals("id:inst")) {
                lotacaoMaxima = Integer.parseInt(token.nextToken());
                custoTrabalhadores = Integer.parseInt(token.nextToken());
                custoLimpeza = Integer.parseInt(token.nextToken());

                Instalacao temp = new Instalacao(lotacaoMaxima, custoTrabalhadores, custoLimpeza);

                int cont = Integer.parseInt(token.nextToken());
                for (int i = 0; i < cont; i++) {
                    int idAnimal = Integer.parseInt(token.nextToken());
                    temp.addAnimal(z.getTodosAnimais(idAnimal));
                    z.removerAnimalSemInstalacao(z.getTodosAnimais(idAnimal));
                }

                z.addInstalacaoZoo(temp);
            }
        }
    }
}
