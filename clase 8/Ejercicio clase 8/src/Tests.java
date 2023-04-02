
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {

    /**
     * Este test verifica si el método verificarPrecios() lanza una excepción cuando hay items con precios menores o iguales a cero en el carrito.
     */
    @Test
    public void testVerificarPrecios() {
        // Agregar items con precios menores o iguales a cero al carrito
        Carrito.agregarItem(new ItemCarrito("Nike", "Zapatillas", 0.0, 50));
        Carrito.agregarItem(new ItemCarrito("Nike", "Zapatillas azules", -150, 50));

        // Verificar si el método verificarPrecios() lanza una excepción
        assertThrows(Exception.class, () -> ItemCarrito.verificarPrecios());
    }

    /**
     * Este test verifica si el método calcularDescuento() lanza una exepción cuando se intenta hacer un descuento del 100% sobre el valor de los productos.
     */
    @Test
    public void testCalcularDescuento() {
            // Agregar item al carrito con un precio de 100, al cual intentaremos hacerle un descuento de 100%, lo cual debería arrojar un error.
            Carrito.agregarItem(new ItemCarrito("Nike", "Zapatillas", 100, 1));
            Carrito.agregarItem(new ItemCarrito("Lacoste", "Remera", 200, 1));
            // Crear una instancia de la clase que contiene el método calcularDescuento()
            DescuentoPromocionalSinLimite descuento = new DescuentoPromocionalSinLimite();

            // Establecer un porcentaje de descuento mayor o igual 100%
            descuento.setPorcentajeDescuento(100);

            // Verificar si el método calcularDescuento() lanza una excepción
            assertThrows(Exception.class, () -> descuento.calcularDescuento());
        }

    }


