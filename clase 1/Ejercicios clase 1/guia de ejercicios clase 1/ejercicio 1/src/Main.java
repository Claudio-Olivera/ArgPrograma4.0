/**
 * import necesario para el funcionamiento de Scanner
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /**
         * Se crea la variable solicitada en el punto c, cambiando este valor se cambiará el resultado,
         * dando la opción de elegir al usuario implementando scanner (no se implementa manejo de errores aún)
         */
        Scanner numero = new Scanner(System.in);
        System.out.println("Desea numeros Pares? (Ingrese true o false)");
        int numeroInicio = 5;
        int numeroFin = 14;
        boolean numeroPar = numero.nextBoolean();
        /**
         * Se crea la variable yaImprimio para mostrar por consola una única vez el mensaje
         */
        boolean yaImprimio = false;

        /**
         * Se crea el for inverso solicitado en el punto d
         */
        for(int i = numeroFin;i >= numeroInicio; i--){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }

        /**
         * Se crea el while puntos a , b , c
         */
        while(numeroInicio <= numeroFin ){
            if(numeroPar && numeroInicio % 2 == 0){
                if (!yaImprimio) {
                    System.out.println("Numeros Pares:");
                    yaImprimio = true;
                }
                System.out.println(numeroInicio);
            }else if (!numeroPar && numeroInicio % 2 != 0) {
                if (!yaImprimio) {
                    System.out.println("Numeros Impares:");
                    yaImprimio = true;
                }
                System.out.println(numeroInicio);
            }
            numeroInicio++;
        }
    }
}

