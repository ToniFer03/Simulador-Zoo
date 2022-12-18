package com.mycompany.mavenproject1;

//this class is not meant to be instantiated
public abstract class ComplexMath {

    private ComplexMath() {
        // private constructor
    }

    /*
     * The following function calculates a constant to be multiplied to the
     * atractiveness of an animal based on its relative age, the younger the animal
     * the bigger the bonus, but if an animal manages to live more than its based
     * age its atractiveness starts to increase again
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
}
