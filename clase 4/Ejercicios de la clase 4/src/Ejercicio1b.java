import java.util.Arrays;
import java.util.Scanner;

/**
 1. Tomando los Ejercicios de la clase anterior
 a. haga un main, donde por parámetro ponga 3 números y una letra que
 represente ascendente o descendente y los muestre ordenados por tal criterio
 b. haga lo mismo, pero solicitando los parámetros de a uno por consola
 c. lo mismo, pero usando los parámetros si hay alguno (como en a) y haciendo (b)
 si no detecta ninguno. Vea si con una función puede evitar repetir código.
 */

public class Ejercicio1b {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la orden (a o d): ");
        String orden = scanner.next();

        System.out.print("Ingrese los números separados por comas: ");
        String numerosString = scanner.next();
        String[] numeros = numerosString.split(",");
        int[] arrnumeros = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            arrnumeros[i] = Integer.parseInt(numeros[i]);
        }

        Arrays.sort(arrnumeros);

        if (orden.equals("d")) {
            int[] numerosDescendentes = new int[arrnumeros.length];
            for (int i = 0; i < arrnumeros.length; i++) {
                numerosDescendentes[i] = arrnumeros[arrnumeros.length - 1 - i];
            }
            System.out.println("Numeros descendentes: " + Arrays.toString(numerosDescendentes));
        }
        else if (orden.equals("a")) {
            System.out.println("Numeros ascendentes: " + Arrays.toString(arrnumeros));
        }
        else {
            System.out.println("La orden ingresada no es válida. Debe ser 'a' o 'd'.");
        }
    }
}