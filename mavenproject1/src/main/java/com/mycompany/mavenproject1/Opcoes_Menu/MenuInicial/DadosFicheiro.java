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

    public DadosFicheiro(Zoo zoo) {
        super();
        this.zoo = zoo;
    }

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
