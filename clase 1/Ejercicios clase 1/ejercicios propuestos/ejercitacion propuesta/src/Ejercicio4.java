import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca la longitud del primer cateto:");
        double primerCateto = scanner.nextDouble();

        System.out.println("Introduzca la longitud del segundo cateto:");
        double segundoCateto = scanner.nextDouble();
        /*
        Esto calcula la hipotenusa, la raíz cuadrada es aplicada usando Math.sqrt, Math.pow() para la potenciación
        * */
        double hipotenusa = Math.sqrt( Math.pow(primerCateto,2) + (Math.pow(segundoCateto,2)));
        System.out.printf("La hipotenusa del triángulo rectángulo es: %.2f%n", hipotenusa);
    }
}
