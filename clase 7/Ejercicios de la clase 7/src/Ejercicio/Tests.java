package Ejercicio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Tests {
    private Carrito carrito;
    @BeforeEach
    public void setUp() { carrito= new Carrito();}
    @AfterEach
    public void limpiarCarrito() {
        carrito.vaciar();
    }

    /**
     *  Este test verifica que el total calculado por el método calcularTotal() sea cero cuando el carrito está vacío.
     */
    @Test
    public void testCalcularTotalVacio() {
        assertEquals(0, carrito.calcularTotal(), 0);
    }

    /**
     * Este test crea un objeto Carrito, agrega dos items al carrito y luego verifica que el total calculado por el método calcularTotal() sea igual al total esperado.
     */
    @Test
    public void testCalcularTotal() {
        ItemCarrito item1 = new ItemCarrito("Levis","Jean",10.0, 2);
        ItemCarrito item2 = new ItemCarrito("Lacoste","Camisa", 5.0, 3);
        carrito.agregarItem(item1);
        carrito.agregarItem(item2);
        double subtotal = 10.0 * 2 + 5.0 * 3;
        double iva = subtotal * 0.21; // Calculamos el IVA del 21%
        double totalEsperado = subtotal + iva; // Sumamos el subtotal más el IVA para obtener el total esperado
        assertEquals(totalEsperado, carrito.calcularTotal(), 0);
    }

    /**
     Este test verifica si la cantidad de items es menor a 100 arroja el mensaje: "Compra mínima de 100 unidades para aplicar el descuento por mayor".
     El propósito de este test es comprobar que al llamar al método mostrarDescuentoPorMayor() de la clase DescuentoPorMayor, se imprima el mensaje correspondiente en la salida estándar
     si la cantidad total de unidades en el carrito es menor a 100. Para lograr esto, el test agrega dos items al carrito con una cantidad de 20 unidades cada uno.
     Luego, redirige la salida estándar a un objeto ByteArrayOutputStream para capturarla.
     Finalmente, convierte la salida en una cadena y la compara con el resultado esperado utilizando el método assertEquals(). Si el mensaje impreso en la salida estándar coincide con el mensaje esperado, el test se considera exitoso.
     */
    @Test
    public void testMostrarDescuentoPorMayorMenosDe100Unidades() {
        // Agregamos productos al carrito para hacer la prueba
        ItemCarrito item1 = new ItemCarrito("Levis","Jean",10.0, 20);
        ItemCarrito item2 = new ItemCarrito("Levis","Jean",10.0, 20);

        // Capturamos la salida de la consola
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Verificamos que se imprima el mensaje de compra mínima
        DescuentoPorMayor.mostrarDescuentoPorMayor();
        String resultadoEsperado = "Compra mínima de 100 unidades para aplicar el descuento por mayor";
        assertEquals(resultadoEsperado,outContent.toString().trim());
    }


    /**
     * Este test comprueba que el resultado esperado sea igual al descuento calculado.
     */
    @Test
    public void testCalcularDescuentoPorMayor() {
        // Creamos el carrito
        Carrito carrito = new Carrito();

        // Agregamos productos al carrito para hacer la prueba
        ItemCarrito item1 = new ItemCarrito("Levis", "Jean", 20.0, 50);
        ItemCarrito item2 = new ItemCarrito("Nike", "Zapatillas", 100.0, 60);
        carrito.agregarItem(item1);
        carrito.agregarItem(item2);

        // Creamos un objeto de la clase DescuentoPorMayor y llamamos al método calcularDescuento()
        DescuentoPorMayor porMayor = new DescuentoPorMayor();
        double descuento = porMayor.calcularDescuento();

        // Aqui el resultado esperado es igual a 6352.5, porque se aplica el iva, además de que el descuento es el resultado de totalSinDescuentos - (totalSinDescuentos * 0.25)
        double resultadoEsperado = 6352.5;
        assertEquals(resultadoEsperado, descuento, 0);
    }




}



