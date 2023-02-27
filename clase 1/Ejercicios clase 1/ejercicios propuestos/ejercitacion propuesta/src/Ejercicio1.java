import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        /**
         * 1. Desarrolle un algoritmo que permita leer dos valores distintos, determinar cuál de los
         dos valores es el mayor y escribirlo.
         */
        System.out.println ("Por favor introduzca un número:");

        Scanner scanner = new Scanner(System.in);
        double primerNumero = scanner.nextDouble();
        System.out.println ("Por favor introduzca otro número para realizar la comparación:");
        double segundoNumero = scanner.nextDouble();

        if (primerNumero > segundoNumero) {
            System.out.printf("%.2f es mayor que %.2f%n", primerNumero, segundoNumero);
        } else if (segundoNumero > primerNumero) {
            System.out.printf("%.2f es mayor que %.2f%n", segundoNumero, primerNumero);
        } else {
            System.out.println("Los números son iguales");
        }
        /*
        *  Lista con algunos de los operadores de formato más comunes en Java:
        *  La "n" es el salto de línea.
            %d: para imprimir números enteros con signo.
            %u: para imprimir números enteros sin signo.
            %f: para imprimir números de punto flotante.
            %e o %E:para imprimir números de punto flotante en notación científica (exponencial).
            %s: para imprimir cadenas de caracteres.
            %c: para imprimir caracteres individuales.
            * */
        /* VARIANTE: en caso de usar operador ternario, pero para este ejemplo considero mejor usar if():
        String resultado = (primerNumero > segundoNumero) ? (primerNumero+" es mayor que "+segundoNumero) : ((segundoNumero > primerNumero) ? (segundoNumero+ " es mayor que "+primerNumero) : "Los números son iguales");
        System.out.println(resultado);
        */

    }
}