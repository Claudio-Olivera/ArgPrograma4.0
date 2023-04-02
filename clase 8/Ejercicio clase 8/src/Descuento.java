import java.util.Scanner;

public abstract class Descuento {
    private static boolean tieneDescuento = false;
    protected static double porcentajeDescuento;
    protected static double totalSinDescuentos = 0;

    protected Descuento(boolean tieneDescuento, double porcentajeDescuento, double totalSinDescuentos) {
        this.tieneDescuento = tieneDescuento;
        this.porcentajeDescuento = porcentajeDescuento;
        this.totalSinDescuentos = totalSinDescuentos;
    }

    protected Descuento() {
    }

    public abstract double calcularDescuento() throws Exception;

    public static void aplicaDescuentos() {
        try {
            if (ItemCarrito.calcularSubTotal() == 0) {
                throw new Exception("No se pueden aplicar descuentos si no hay precios cargados");
            }
            Scanner scanner = new Scanner(System.in);
            System.out.printf("¿Desea definir descuentos para esta compra? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("N")) {
                tieneDescuento = false;
            } else {
                tieneDescuento = true;
            }
            if (tieneDescuento) {
                DescuentoPorMayor.mostrarDescuentoPorMayor();
                DescuentoPromocionalSinLimite.mostrarDescuentoPromocionalSinLimite();
                DescuentoPorcentajeConTope.mostrarDescuentoConTope();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}