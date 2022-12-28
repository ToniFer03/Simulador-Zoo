package com.mycompany.mavenproject1.Opcoes_Menu.MenuDigitarDados;

import com.mycompany.mavenproject1.Classes_Principais.Instalacao;
import com.mycompany.mavenproject1.Menus.MenuDigitarDados;
import com.mycompany.mavenproject1.Menus.OpcaoMenu;
import java.util.Scanner;

public class DigitarInstalacoes extends OpcaoMenu {

    private MenuDigitarDados menu;

    public DigitarInstalacoes(MenuDigitarDados menu) {
        super();
        this.menu = menu;
    }

    @Override
    public void executarOpcao() {
        createInstalacao();
        menu.showMenu();
    }

    private void createInstalacao() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a lotação da instação: ");
        int lotacao = sc.nextInt();
        System.out.print("Digite o custo de trabalhadores da instação: ");
        int custoTrabalhadores = sc.nextInt();
        System.out.print("Digite o custo de limpeza da instação: ");
        int custoLimpeza = sc.nextInt();
        Instalacao instalacao = new Instalacao(lotacao, custoTrabalhadores, custoLimpeza);
        menu.getZoo().addInstalacaoZoo(instalacao);
    }
}
