package io.github.lberaldi.microservices.math;

public class SimpleMath {

    public double sum(double numberOne, double numberTwo) {
        return (numberOne) + (numberTwo);
    }

    public double sub(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }


    public double mult(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    public double div(double numberOne, double numberTwo) {
        return numberOne / numberTwo;
    }

    public double media(double numberOne, double numberTwo) {
        return numberOne + numberTwo / 2;
    }

    public double raiz(double numberOne) {
        return Math.sqrt(numberOne);
    }

}
