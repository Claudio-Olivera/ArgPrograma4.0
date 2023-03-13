package Ejercicio1;

import java.util.Scanner;

public class DescuentoPromocional extends Descuento {

    public DescuentoPromocional() {
    }

    public DescuentoPromocional(boolean tieneDescuento, double porcentajeDescuento, double totalSinDescuentos) {
        super(tieneDescuento, porcentajeDescuento, totalSinDescuentos);
    }

    @Override
    public double calcularDescuento() {
        totalSinDescuentos = Carrito.calcularTotal();
        return totalSinDescuentos - (totalSinDescuentos * porcentajeDescuento / 100);
    }

    public void DescuentoPromocional() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese un porcentaje de descuento promocional: ");
        porcentajeDescuento = scanner.nextDouble();
        System.out.println("El precio total con el descuento promocional del "+porcentajeDescuento+"% es de: $ "+ calcularDescuento());
    }

    public static void mostrarDescuentoPromocional() {
        DescuentoPromocional promo = new DescuentoPromocional();
        promo.DescuentoPromocional();
    }

}