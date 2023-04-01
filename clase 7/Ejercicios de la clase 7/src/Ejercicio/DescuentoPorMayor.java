package Ejercicio;

public class DescuentoPorMayor extends Descuento {

    public DescuentoPorMayor() {
    }

    public DescuentoPorMayor(boolean tieneDescuento, double porcentajeDescuento, double totalSinDescuentos) {
        super(tieneDescuento, porcentajeDescuento, totalSinDescuentos);
    }

    @Override
    public double calcularDescuento() {
       totalSinDescuentos = Carrito.calcularTotal();
        return totalSinDescuentos - (totalSinDescuentos * 0.25);
    }

    public void DescuentoMayorista() {
        System.out.println("El precio total con un descuento al por mayor del 25% (descuento Fijo) es de: $ " + calcularDescuento());
    }

    public static void mostrarDescuentoPorMayor() {
        final int[] contador = {0};
        Carrito.getItems().forEach(item -> {
            contador[0] += item.getCantidad();
        });

        if (contador[0] < 100) {
            System.out.println("Compra mínima de 100 unidades para aplicar el descuento por mayor (descuento Fijo)");
        } else {
            System.out.println("La cantidad de productos es: " + contador[0] +" accedes a un descuento al por mayor(descuento Fijo)");
            DescuentoPorMayor porMayor = new DescuentoPorMayor();
            porMayor.DescuentoMayorista();
        }
    }
}





