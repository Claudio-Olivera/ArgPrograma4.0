import java.util.Scanner;

public class DescuentoPorcentajeConTope extends Descuento {

    public DescuentoPorcentajeConTope(){
    }

    public DescuentoPorcentajeConTope(boolean tieneDescuento, double porcentajeDescuento, double totalSinDescuentos) {
        super(tieneDescuento, porcentajeDescuento, totalSinDescuentos);
    }
    @Override
    public double calcularDescuento() {
        totalSinDescuentos = Carrito.calcularTotal();
        return totalSinDescuentos - (totalSinDescuentos * porcentajeDescuento / 100);
    }

    public void DescPorcentajeConTope() {
        System.out.print("Ingrese un porcentaje de descuento no superior al 40%: ");
        Scanner scanner1 = new Scanner(System.in);
        porcentajeDescuento = scanner1.nextDouble();
        if(porcentajeDescuento <= 40) {
            System.out.println("El precio total con el descuento de " + porcentajeDescuento + "% es de: $ " + calcularDescuento());
        }
        else{
            System.out.println("No puedes superar el 40 % de descuento, Ingresa otro numero");
            DescPorcentajeConTope();
        }
    }

    public static void mostrarDescuentoConTope() {
        final int[] contador = {0};
        Carrito.getItems().forEach(item -> {
            contador[0] += item.getCantidad();
        });

        if (contador[0] < 200) {
            System.out.println("Necesitas una compra minima de 200 unidades para acceder al descuento (con tope, no mayor a 40%)");
        } else {
            System.out.println("La cantidad de productos es: " + contador[0] +" accedes a un descuento, no mayor del 40%");
            DescuentoPorcentajeConTope descTope = new DescuentoPorcentajeConTope();
            descTope.DescPorcentajeConTope();
        }
    }
}
