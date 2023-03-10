import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
/**Ejercicio 2
 * Haga una main donde por parámetro envíe la ruta de un archivo. Ese archivo debe
 * contener números. El programa debe escribir por consola la suma de esos números
 * a. Al programa anterior agreguele un parámetro para que la operación pueda ser
 * suma o multiplicación.
 * */
public class Ejercicio2 {
    public static void main(String[] argumentos) throws IOException {
        String rutaArchivoIngresada;
        String operador;

        if (argumentos.length >= 2) {
            rutaArchivoIngresada = argumentos[0];
            /**
             * NOTA IMPORTANTE: No entiendo porque "operador" toma el valor de "Ejercicio1a.class", por ello me vi obligado a colocar la condicional en la línea 38,
             * para que funcionara cuando utilizo el programa por consola.
             * Una posibilidad, es que al hacer el build se esté generando un error. Esto claramente no ocurre si uso scanner para pasar el valor.
             */
            operador = argumentos[1];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Ingrese la ruta del archivo sin dejar espacios: ");
            rutaArchivoIngresada = scanner.nextLine();
            System.out.printf("Ingrese el operador (+ o *): ");
            operador = scanner.nextLine();
        }

        int resultadoSuma = 0;
        int resultadoMultiplicacion = 1;
        for (String linea: Files.readAllLines(Paths.get(rutaArchivoIngresada))){
            if (operador.equals("+")){
                resultadoSuma += Integer.parseInt(linea);

            }else if(operador.equals("Ejercicio1a.class") || operador.equals("*")){
                resultadoMultiplicacion *= Integer.parseInt(linea);
            }
        }
        if(resultadoSuma == 0){
            System.out.println("El resultado de la multiplicación de los números en el archivo es: " + resultadoMultiplicacion);
        }else{
            System.out.println("El resultado de la suma de los números en el archivo es: " + resultadoSuma);
            }
        }
    }

/**
 * C:\\Users\\Claudio\\Desktop\\ArgPrograma4.0\\clase 4\\Ejercicios de la clase 4\\Archivo de numeros para Ejercicio 2.txt
 * C:\Users\Claudio\Desktop\ArgPrograma4.0\clase 4\Ejercicios de la clase 4\Archivo de numeros para Ejercicio 2.txt
 * */

