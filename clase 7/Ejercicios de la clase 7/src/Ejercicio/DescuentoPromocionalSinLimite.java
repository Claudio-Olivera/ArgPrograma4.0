package Ejercicio;

import java.util.Scanner;

public class DescuentoPromocionalSinLimite extends Descuento {

    public DescuentoPromocionalSinLimite() {
    }

    public DescuentoPromocionalSinLimite(boolean tieneDescuento, double porcentajeDescuento, double totalSinDescuentos) {
        super(tieneDescuento, porcentajeDescuento, totalSinDescuentos);
    }

    @Override
    public double calcularDescuento() {
        totalSinDescuentos = Carrito.calcularTotal();
        return totalSinDescuentos - (totalSinDescuentos * porcentajeDescuento / 100);
    }

    public void DescuentoPromocional() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese un porcentaje de descuento promocional (Sin límite): ");
        porcentajeDescuento = scanner.nextDouble();
        System.out.println("El precio total con el descuento promocional del "+porcentajeDescuento+"% es de: $ "+ calcularDescuento());
    }

    public static void mostrarDescuentoPromocionalSinLimite() {
        DescuentoPromocionalSinLimite promo = new DescuentoPromocionalSinLimite();
        promo.DescuentoPromocional();
    }

}