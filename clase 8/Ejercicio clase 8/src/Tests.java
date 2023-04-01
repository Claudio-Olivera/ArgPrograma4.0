import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private Carrito carrito;
    @BeforeEach
    public void setUp() {
        carrito = new Carrito();
    }
    @AfterEach
    public void limpiarCarrito() {
        carrito.vaciar();
    }

    /**
     * Este test verifica que el total calculado por el método calcularTotal() sea cero cuando el carrito está vacío.
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
        ItemCarrito item1 = new ItemCarrito("Levis", "Jean", 10.0, 2);
        ItemCarrito item2 = new ItemCarrito("Lacoste", "Camisa", 5.0, 3);
        carrito.agregarItem(item1);
        carrito.agregarItem(item2);
        double subtotal = 10.0 * 2 + 5.0 * 3;
        double iva = subtotal * 0.21; // Calculamos el IVA del 21%
        double totalEsperado = subtotal + iva; // Sumamos el subtotal más el IVA para obtener el total esperado
        assertEquals(totalEsperado, carrito.calcularTotal(), 0);
    }

    /**
     * Este test verifica si la cantidad de items es menor a 100 arroja el mensaje: "Compra mínima de 100 unidades para aplicar el descuento por mayor".
     * El propósito de este test es comprobar que al llamar al método mostrarDescuentoPorMayor() de la clase DescuentoPorMayor, se imprima el mensaje correspondiente en la salida estándar
     * si la cantidad total de unidades en el carrito es menor a 100. Para lograr esto, el test agrega dos items al carrito con una cantidad de 20 unidades cada uno.
     * Luego, redirige la salida estándar a un objeto ByteArrayOutputStream para capturarla.
     * Finalmente, convierte la salida en una cadena y la compara con el resultado esperado utilizando el método assertEquals(). Si el mensaje impreso en la salida estándar coincide con el mensaje esperado, el test se considera exitoso.
     */
    @Test
    public void testMostrarDescuentoPorMayorMenosDe100Unidades() {
        // Agregamos productos al carrito para hacer la prueba
        ItemCarrito item1 = new ItemCarrito("Levis", "Jean", 10.0, 20);
        ItemCarrito item2 = new ItemCarrito("Levis", "Jean", 10.0, 20);

        // Capturamos la salida de la consola
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Verificamos que se imprima el mensaje de compra mínima
        DescuentoPorMayor.mostrarDescuentoPorMayor();
        String resultadoEsperado = "Compra mínima de 100 unidades para aplicar el descuento por mayor (descuento Fijo)";
        assertEquals(resultadoEsperado, outContent.toString().trim());
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

        // Aquí el resultado esperado es igual a 6352.5, porque se aplica el iva, además de que el descuento es el resultado de totalSinDescuentos - (totalSinDescuentos * 0.25)
        double resultadoEsperado = 6352.5;
        assertEquals(resultadoEsperado, descuento, 0);
    }

    /**
     * Este test está probando que el monto de descuento calculado por el objeto DescuentoPorcentajeConTope es correcto.
     *
     * El IVA fue calculado anteriormente para obtener 14278 (60*180)+(50*20) = 11,800 * 0.21 = 2,478
     * Entonces, el precio total con IVA incluido es: 11,800 + 2,478 = 14,278
     * Tener en cuenta que al valor de 14278 se le resta 5711.2 (correspondiente al 40% de 14278), y para obtener
     * el descuento: 14278 - 5711.2 = 8566.8
     * El precio a pagar por el cliente, luego de aplicar IVA y un descuento del 40% es de 8566.8
     */
    @Test
    public void testCalcularDescuento() {
    Carrito carrito = new Carrito();
    carrito.agregarItem(new ItemCarrito("Levis", "Jean", 50, 20));
    carrito.agregarItem(new ItemCarrito("Nike", "Zapatillas", 60, 180));

    DescuentoPorcentajeConTope descuento = new DescuentoPorcentajeConTope(true, 40, carrito.calcularTotal());

    double descuentoCalculado = descuento.calcularDescuento();
    double totalConIvaSinDescuentos = carrito.calcularTotal();

    double precioConIvaSinDescuentos = totalConIvaSinDescuentos - descuentoCalculado;

    double precioConDescuentoAplicado =  totalConIvaSinDescuentos - precioConIvaSinDescuentos ;

    Assertions.assertEquals(8566.8, precioConDescuentoAplicado, 0);
}

    /**
     * Este test simplemente comprueba que el mensaje que arroja si la compra es menor a 200 unidades es correcto
     */
    @Test
    public void testMostrarDescuentoConTope() {
        final String resultadoEsperado = "Compra minima de 200 unidades para acceder al descuento";

        // Redirigimos la salida estándar a un objeto ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Creamos un Carrito y agregamos productos
        Carrito carrito = new Carrito();
        // Le paso menos de 200 productos (cantidad = 60)
        ItemCarrito item1 = new ItemCarrito("Levis", "Jean", 10.0, 50);
        ItemCarrito item2 = new ItemCarrito("Adidas", "Zapatillas", 50.0, 10);
        carrito.agregarItem(item1);
        carrito.agregarItem(item2);

        // Verificamos que se imprima el mensaje de descuento con tope
        DescuentoPorcentajeConTope.mostrarDescuentoConTope();
        assertEquals(resultadoEsperado, outContent.toString().trim());
    }

    /**
     * Este test comprueba que el método calcularDescuento() de la clase DescuentoPromocionalSinLimite funciona correctamente
     *
     * El IVA fue calculado anteriormente para obtener 14278 (60*180)+(50*20) = 11,800 * 0.21 = 2,478
     * Entonces, el precio total con IVA incluido es: 11,800 + 2,478 = 14,278
     * Tener en cuenta que al valor de 14278 se le resta 7139 (correspondiente al 50% de 14278), y para obtener
     * el descuento: 14278 - 7139 = 7139
     * El precio final a pagar por el cliente, luego de aplicar IVA y un descuento del 50% es de 7139
     *
     */
    @Test
    public void testCalcularDescuentoSinLimite() {
        Carrito carrito = new Carrito();
        carrito.agregarItem(new ItemCarrito("Levis", "Jean", 50, 20));
        carrito.agregarItem(new ItemCarrito("Nike", "Zapatillas", 60, 180));

        DescuentoPromocionalSinLimite descuento = new DescuentoPromocionalSinLimite(true, 50, carrito.calcularTotal());

        double descuentoCalculado = descuento.calcularDescuento();
        double totalConIvaSinDescuentos = carrito.calcularTotal();

        double precioConIvaSinDescuentos = totalConIvaSinDescuentos - descuentoCalculado;

        double precioConDescuentoAplicado =  totalConIvaSinDescuentos - precioConIvaSinDescuentos ;

        Assertions.assertEquals(7139, precioConDescuentoAplicado, 0);
    }

    /**
     * Tener en cuenta que este test, fue creado para cumplir con el objetivo del trabajo de hacer dos test por clase.
     *
     * Este test comprueba que el valor de retorno del método obtenerDescuentoPromocional() de la clase DescuentoPromocionalSinLimite sea igual al resultado esperado.
     */
    @Test
    public void testObtenerDescuentoPromocional() {
        //creo un objeto de esa clase con un porcentajeDescuento de 30
        DescuentoPromocionalSinLimite descuento = new DescuentoPromocionalSinLimite(true, 30, 100);
        //creo una variable resultadoEsperado con un valor de 30 para hacer la comparación.
        double resultadoEsperado = 30;
        double resultadoObtenido = descuento.obtenerDescuentoPromocional();
        assertEquals(resultadoEsperado, resultadoObtenido, 0);
    }
}



