package com.mycompany.mavenproject1;

//Referente a opção de menu "Adquirir animal com características genéticas"
public class AdqAnimalCaracGen extends OpcaoMenu {

    // constructor
    public AdqAnimalCaracGen(Menu parentMenu) {
        super(parentMenu);
    }

    // function that executes the action of this option
    @Override
    public void executarOpcao() {
        showText();
        voltarMenu();
    }

    private void showText() {
        System.out.println("\n");
        System.out.println("Selecione a característica genética que deseja adquirir:");
        for (int i = 0; i < CaractristicaIndividual.getCaracteristicasIndividuais().size(); i++) {
            System.out.println("[" + i + "] - "
                    + CaractristicaIndividual.getCaracteristicasIndividuais().get(i).getCaracteristicas());
        }
    }

}
