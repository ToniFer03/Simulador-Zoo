package com.mycompany.mavenproject1.Classes_Aux;

public abstract class ComplexMath {

    /**
     * Constructor for the class, private because there is no need to create an instance of this class
     */
    private ComplexMath() {
        // private constructor
    }


    /**
     * Method meant to calculate a constant to be multiplied to the attractiveness on an animal bases on its age. The
     * younger the animal the bigger the bonus it gets but, if the animal manages to live more than the life
     * expectancy of its species the bonus begins to increase as well.
     *
     * @param idade The animal's age
     * @param esperancaVida The animal species life expectancy
     *
     * @return the bonus to be applied
     */
    public static double calculateAtracBasedAge(int idade, int esperancaVida) {
        double result;
        double aux = (double) idade / (double) esperancaVida * 100;

        result = (1.432 * Math.pow(10, -6)) * Math.pow(aux, 3);
        result += (-1.534 * Math.pow(10, -4)) * Math.pow(aux, 2);
        result += (-0.017 * aux);
        result += 1.99;

        return result;
    }


    /*
     * The following function calculates the probability of an animal dying based on
     * its current age in relations to the life expectancy of its species
     */

    /**
     * Method meant to calculate the probability of an animal dying based on its current age in relation to the life
     * expectancy of its species.
     *
     * @param idade animal's age
     * @param esperancaVida animal species life expectancy
     *
     * @return probability of the animal dying
     */
    public static double calculateProbabilityDeath(int idade, int esperancaVida) {
        double result;
        double aux = (double) idade / (double) esperancaVida * 100;

        result = (-1.031 * Math.pow(10, -7)) * Math.pow(aux, 3);
        result += (5.1108 * Math.pow(10, -5)) * Math.pow(aux, 2);
        result += (5.504 * Math.pow(10, -4) * aux);
        result += -0.013;

        return result;
    }
}
