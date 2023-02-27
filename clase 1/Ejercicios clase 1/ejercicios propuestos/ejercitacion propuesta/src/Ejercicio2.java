import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        /**
         * Desarrolle un algoritmo que permita leer tres valores y almacenarlos en las variables A,
         * B y C respectivamente. El algoritmo debe imprimir cuál es el mayor y cuál es el menor.
         * Recuerde constatar que los tres valores introducidos por el teclado sean valores distintos.
         * Presente un mensaje de alerta en caso de que se detecte la introducción de valores
         * iguales.
         * */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca el primer valor:");
        double A = scanner.nextDouble();

        System.out.println("Introduzca el segundo valor:");
        double B = scanner.nextDouble();

        System.out.println("Introduzca el tercer valor:");
        double C = scanner.nextDouble();
        if( A == B || A == C || B == C ){
            System.out.println("ERROR: Los tres valores deben ser diferentes");
            /*Aplico este return como buena práctica de salir de una función si se detecta un error*/
            return;
        }
        /*Acá busco el valor máximo usando Math.max (método de la clase Math de java) entre A y B, y luego nuevamente para sacar el valor maximo entre el
        * resultante de lo anterior y C , también se podría resolver comparando usando condicionales if()
        * */
        double maximo = Math.max(Math.max(A, B), C);
        double minimo = Math.min(Math.min(A, B), C);

        System.out.println("El valor máximo es: " + maximo);
        System.out.println("El valor mínimo es: " + minimo);

    }
}
