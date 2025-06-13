package com.mycompany.mavenproject1.Opcoes_Menu.MenuInicial;

import com.mycompany.mavenproject1.Classes_Principais.Zoo;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import com.mycompany.mavenproject1.ReaderClasses.CaracEspecieReader;
import com.mycompany.mavenproject1.ReaderClasses.CaractIndividualReader;
import com.mycompany.mavenproject1.ReaderClasses.EspecieReader;
import com.mycompany.mavenproject1.ReaderClasses.NomeArtisticoReader;
import com.mycompany.mavenproject1.ReaderClasses.ZooReader;

public class DadosFicheiro extends OpcaoMenu {

    private Zoo zoo;

    /**
     * Constructor of Class DadosFicheiro
     *
     * @param zoo Zoo whose information this menu will affect
     */
    public DadosFicheiro(Zoo zoo) {
        super();
        this.zoo = zoo;
    }

    /**
     * Override of executarOpcao from OpcaoMenu, tries to load the information on the files and load it into the
     * program, if unable prints an error message.
     */
    @Override
    public void executarOpcao() {
        try {
            CaracEspecieReader.readCarcEspecie();
            CaractIndividualReader.readCarcIndividual();
            NomeArtisticoReader.readNomeArtistico();
            EspecieReader.readEspecie();
            ZooReader.readZoo(zoo);
        } catch (Exception e) {
            System.out.println("Erro ao ler algum dos ficheiros");
        }
    }

}
