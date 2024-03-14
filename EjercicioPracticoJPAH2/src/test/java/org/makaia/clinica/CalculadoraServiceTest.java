package org.makaia.clinica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.makaia.clinica.services.CalculadoraService;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraServiceTest {
    // importar las dependencias (cual es la clase que usted va testear)
    private CalculadoraService calculadoraService;

    // No tienen constructor
    @BeforeEach
    public void construir(){
        this.calculadoraService = new CalculadoraService();
    }

    //EMPIEZO A GENERAR LOS CASOS.
    @Test
    public void sumarNumerosNegativos() {
        //arrange
        int numero1 = -2;
        int numero2 = -3;
        //Act
        int resultado = this.calculadoraService.sumar(numero1, numero2);
        //Assert
        // primer parametro lo que usted espera
        // segundo parametro lo que retorno el metodo que usted testeando.
        assertEquals(-5, resultado);
    }

    @Test
    public void sumarPrimerNumeroEnZero() {
        //arrange
        int numero1 = 0;
        int numero2 = -3;
        //Act
        int resultado = this.calculadoraService.sumar(numero1, numero2);
        //Assert
        // primer parametro lo que usted espera
        // segundo parametro lo que retorno el metodo que usted testeando.
        assertEquals(0, resultado);
    }

    @Test
    public void sumarNumerosZeros() {
        //arrange
        int numero1 = 0;
        int numero2 = 0;
        //Act
        int resultado = this.calculadoraService.sumar(numero1, numero2);
        //Assert
        // primer parametro lo que usted espera
        // segundo parametro lo que retorno el metodo que usted testeando.
        assertEquals(0, resultado);
    }


    @Test
    public void sumarNumerosNullos() {
        //arrange
        int numero1 = 6;
        int numero2 = 4;
        //Act
        int resultado = this.calculadoraService.sumar(numero1, numero2);
        //Assert
        // primer parametro lo que usted espera
        // segundo parametro lo que retorno el metodo que usted testeando.
        assertTrue(resultado==10);
    }

    @Test
    public void dividirConNumeroZero(){
        //arrange
        int numero1 = 5;
        int numero2 = 0;
        //  act- assert
        Exception e = assertThrows(ArithmeticException.class, () ->  this.calculadoraService.dividir(numero1, numero2));
        assertEquals("Division by zero is not allowed", e.getMessage());
    }
}
