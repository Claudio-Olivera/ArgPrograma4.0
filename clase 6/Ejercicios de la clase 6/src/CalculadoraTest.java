import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Implemente una clase “Calculadora” que tenga cuatro métodos, uno por cada operación
 * aritmética básica (suma, resta, multiplicación y división), respetando las siguientes firmas:
 * ● double sumar(double unNumero, double otroNumero);
 * ● double restar(double unNumero, double otroNumero);
 * ● double multiplicar(double unNumero, double otroNumero);
 * ● double dividir(double unNumero, double otroNumero);
 * Luego de haber implementado la Calculadora, realice los siguientes casos de prueba:
 * 1. El resultado de multiplicar 80 por 3 da 240
 * 2. El resultado de sumar 150 y 180, dividido por 3, da 110
 * 3. El resultado de restar 90 y 50, multiplicado por 15, no da 605.
 * 4. El resultado de sumar 70 y 40, multiplicado por 25, no da 2700.
 *
 */
public class CalculadoraTest {
    private Calculadora calculadora;
    @BeforeEach
    //De esta forma usando @BeforeEach creo una nueva instancia de la clase para cada @Test que realizo.
    public void setUp() {
        calculadora = new Calculadora();
    }
    @Test
    public void testOne() {
        //En los @Test, uso la instancia que creé usando @BeforeEach
        double resultado = calculadora.multiplicar(80, 3);
        Assert.assertEquals(240, resultado, 0);
    }

    @Test
    public void testTwo() {
        double resultado = calculadora.dividir(calculadora.sumar(150, 180), 3);
        Assert.assertEquals(110, resultado, 0);
    }

    @Test
    public void testThree() {
        double resultado = calculadora.multiplicar(calculadora.restar(90, 50), 15);
        Assert.assertNotEquals(605, resultado, 0);
    }

    @Test
    public void testFour() {
        double resultado = calculadora.multiplicar(calculadora.sumar(70, 40), 25);
        Assert.assertNotEquals(2700, resultado, 0);
    }
}