import java.util.Scanner;

public abstract class Descuento{
    private static boolean tieneDescuento = false;
    protected static double porcentajeDescuento;
    protected static double totalSinDescuentos = 0 ;

    protected Descuento(boolean tieneDescuento, double porcentajeDescuento, double totalSinDescuentos) {
        this.tieneDescuento = tieneDescuento;
        this.porcentajeDescuento = porcentajeDescuento;
        this.totalSinDescuentos = totalSinDescuentos;
    }

    protected Descuento() {
    }

    public abstract double calcularDescuento();

    public static void aplicaDescuentos(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("¿Desea definir descuentos para esta compra? (S/N)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("N")) {
            tieneDescuento = false;
        }else if (respuesta.equalsIgnoreCase("S")){
            tieneDescuento = true;
        }
        if (tieneDescuento==true){
            DescuentoPromocional.mostrarDescuentoPromocional();
            DescuentoPorMayor.mostrarDescuentoPorMayor();
        }
    }
}