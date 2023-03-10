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
public class Ejercicio1c {
    public static void main(String[] args) {

        String orden;
        int[] numeros;

        if (args.length == 2) {
            orden = args[0];
            numeros = parsearNumeros(args[1]);
        } else {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese la orden (a o d): ");
            orden = scanner.next();

            System.out.print("Ingrese los números separados por comas: ");
            String numerosString = scanner.next();
            numeros = parsearNumeros(numerosString);
        }

        String resultado = ordenarNumeros(orden, numeros);
        System.out.println(resultado);
    }

    public static int[] parsearNumeros(String numerosString) {
        String[] numeros = numerosString.split(",");
        int[] arrnumeros = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            arrnumeros[i] = Integer.parseInt(numeros[i]);
        }
        return arrnumeros;
    }

    public static String ordenarNumeros(String orden, int[] numeros) {
        Arrays.sort(numeros);

        if (orden.equals("d")) {
            int[] numerosDescendentes = new int[numeros.length];
            for (int i = 0; i < numeros.length; i++) {
                numerosDescendentes[i] = numeros[numeros.length - 1 - i];
            }
            return "Numeros descendentes: " + Arrays.toString(numerosDescendentes);
        } else if (orden.equals("a")) {
            return "Numeros ascendentes: " + Arrays.toString(numeros);
        } else {
            return "La orden ingresada no es válida. Debe ser 'a' o 'd'.";
        }
    }
}
