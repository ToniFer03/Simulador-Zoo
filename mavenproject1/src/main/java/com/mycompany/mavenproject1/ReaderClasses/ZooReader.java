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

/**
 * Utility class responsible for reading and populating a {@link Zoo} object
 * from a predefined text file.
 * <p>
 * The text file must follow a specific format to represent:
 * <ul>
 *     <li>Zoo initial data (balance and escape probability)</li>
 *     <li>Animal data (name, age, species, characteristics)</li>
 *     <li>Installation data (capacity, costs, animals assigned)</li>
 * </ul>
 */
public class ZooReader {

    /**
     * File path to the Zoo configuration text file.
     */
    private static String FILENAME = "Ficheiros_Texto\\Zoo.txt";

    /**
     * Private constructor to prevent instantiation.
     */
    private ZooReader() {
    }

    /**
     * Reads the contents of the Zoo configuration file and populates the
     * given {@link Zoo} object accordingly.
     * <p>
     * The file must be structured with identifiers at the beginning of each line:
     * <ul>
     *     <li><b>id:ini</b> - Initializes the Zoo's balance and escape probability.</li>
     *     <li><b>id:tdani</b> - Declares a new animal and its characteristics.</li>
     *     <li><b>id:inst</b> - Declares a new installation and the animals assigned to it.</li>
     * </ul>
     *
     * @param zoo The {@link Zoo} instance to populate.
     * @throws IOException If there is an issue reading the file.
     */
    public static void readZoo(Zoo zoo) throws IOException {
        Zoo z = zoo;

        File file = new File(FILENAME);
        Scanner sc = new Scanner(file);

        StringTokenizer token = null;

        String ident = "";

        double saldoContabilistico = 0.0;
        double probFugir = 0.0;

        String nomeAnimal = "";
        int idade = 0;
        int idEspecie = 0;

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

                Especie e = Especie.getEspecies().get(idEspecie);
                Animal temp = new Animal(nomeAnimal, idade, e);

                int cont = Integer.parseInt(token.nextToken());

                for (int i = 0; i < cont; i++) {
                    temp.addCaracteristicaIndividuais(CaractristicaIndividual.getCaracteristicasIndividuais()
                            .get(Integer.parseInt(token.nextToken())));
                }
                z.addAnimalZoo(temp); // add the animal to the zoo

            } else if (ident.equals("id:inst")) { // if the identifier is "id:inst"
                lotacaoMaxima = Integer.parseInt(token.nextToken());
                custoTrabalhadores = Double.parseDouble(token.nextToken());
                custoLimpeza = Double.parseDouble(token.nextToken());

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
