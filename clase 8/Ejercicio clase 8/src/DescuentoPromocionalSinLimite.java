import java.util.Scanner;

public class DescuentoPromocionalSinLimite extends Descuento {

    public DescuentoPromocionalSinLimite() {
    }

    public DescuentoPromocionalSinLimite(boolean tieneDescuento, double porcentajeDescuento, double totalSinDescuentos) {
        super(tieneDescuento, porcentajeDescuento, totalSinDescuentos);
    }

    public static void setPorcentajeDescuento(int i) {
        porcentajeDescuento = i;
    }

    public double calcularDescuento() throws Exception {
        totalSinDescuentos = Carrito.calcularTotal();
        double descuento = totalSinDescuentos - (totalSinDescuentos * porcentajeDescuento / 100);
        if (descuento <= 0) {
            throw new Exception("El descuento no puede ser mayor o igual al precio total del carrito");
        }
        return descuento;
    }

    public void DescuentoPromocional() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese un porcentaje de descuento promocional (Sin límite): ");
        porcentajeDescuento = scanner.nextDouble();
        try {
            System.out.println("El precio total con el descuento promocional del " + obtenerDescuentoPromocional() + "% es de: $ " + calcularDescuento());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            DescuentoPromocional();
        }
    }


    public static void mostrarDescuentoPromocionalSinLimite() throws Exception {
        DescuentoPromocionalSinLimite promo = new DescuentoPromocionalSinLimite();
        promo.DescuentoPromocional();
    }
    public double obtenerDescuentoPromocional() {
        return porcentajeDescuento;
    }
}