package org.makaia.clinica.services;

public class CalculadoraService {
    public int sumar(int a, int b) {
        if (a == 0){
            return 0;
        }
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public double dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
}
