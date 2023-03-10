import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio3 {
    /**
    3. Tome el ejercicio B de la clase 3 y que por parámetro se pueda elegir si es una
    codificación o decodificación, el valor del desplazo, y 2 archivos, uno para la entrada y
    otro para la salida. Que por pantalla solo indique si terminó o no correctamente, los
    resultados deben estar en el archivo de salida

     C:\Users\Claudio\Desktop\ArgPrograma4.0\clase 4\Ejercicios de la clase 4\Archivo de entrada Ejercicio 3.txt
     C:\Users\Claudio\Desktop\ArgPrograma4.0\clase 4\Ejercicios de la clase 4\Archivo de salida Ejercicio 3.txt
    **/
    public static void main(String[] args) throws IOException {

        String rutaPrimerArchivo;
        String rutaSegundoArchivo;
        String codificar;
        int desplazamiento = 0;
        final String abc = "abcdefghijklmnñopqrstuvwxyz ";
        String frase = "";
        String fraseEncriptada = "";
        String fraseDesencriptada = "";

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese la ruta del archivo de entrada sin dejar espacios: ");
        rutaPrimerArchivo = scanner.nextLine();
        System.out.printf("Ingrese la ruta del archivo de salida sin dejar espacios: ");
        rutaSegundoArchivo = scanner.nextLine();
        System.out.printf("¿Desea encriptar? (ingrese Y o N) Si eliges N el programa estará listo para decodificar: ");
        codificar = scanner.nextLine();
        if (codificar.equals("Y") || codificar.equals("y")) {
            System.out.printf("Ingrese el desplazamiento deseado para la codificación (no debe superar el número 27):");
            desplazamiento = Integer.parseInt(scanner.nextLine());
        } else if (codificar.equals("N") || codificar.equals("n")) {
            System.out.printf("Ingrese el desplazamiento deseado para la decodificación (no debe superar el número 27): ");
            desplazamiento = Integer.parseInt(scanner.nextLine());
        } else {
            System.out.println("Las únicas respuestas aceptadas son (Y,y ó N,n)");
        }

        for (String linea : Files.readAllLines(Paths.get(rutaPrimerArchivo))) {
            frase += linea;
        }
        for (String linea : Files.readAllLines(Paths.get(rutaSegundoArchivo))) {
            fraseEncriptada += linea;
        }

        if (codificar.equals("Y") || codificar.equals("y") && desplazamiento != 0) {
            encriptador(frase, abc, desplazamiento, fraseEncriptada, rutaSegundoArchivo);
        }
        if ((codificar.equals("N") || codificar.equals("n")) && desplazamiento != 0) {
            desencriptador(fraseEncriptada, abc, desplazamiento, rutaSegundoArchivo, fraseDesencriptada);
        }
    }
    private static void encriptador(String frase, String abc, int desplazamiento, String fraseEncriptada, String rutaSegundoArchivo) throws IOException {
        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            int posicion = abc.indexOf(caracter);
            if (posicion == -1) {
                fraseEncriptada += caracter;
            } else {
                int nuevaPosicion = posicion + desplazamiento;
                if (nuevaPosicion >= abc.length()) {
                    nuevaPosicion -= abc.length();
                } else if (nuevaPosicion < 0) {
                    nuevaPosicion += abc.length();
                }
                fraseEncriptada += abc.charAt(nuevaPosicion);
                Files.write(Paths.get(rutaSegundoArchivo), fraseEncriptada.getBytes());
            }
        }
        System.out.println("La codificación se realizó correctamente búsquela en el archivo de salida");
    }

    private static void desencriptador( String fraseEncriptada,String abc,int desplazamiento, String rutaSegundoArchivo, String fraseDesencriptada ) throws IOException {
        for (int i = 0; i < fraseEncriptada.length(); i++) {
            char caracter = fraseEncriptada.charAt(i);
            int posicion = abc.indexOf(caracter);
            if (posicion == -1) {
                fraseDesencriptada += caracter;
            } else {
                int nuevaPosicion = posicion - desplazamiento;
                if (nuevaPosicion >= abc.length()) {
                    nuevaPosicion -= abc.length();
                } else if (nuevaPosicion < 0) {
                    nuevaPosicion += abc.length();
                }
                fraseDesencriptada += abc.charAt(nuevaPosicion);
                Files.write(Paths.get(rutaSegundoArchivo), fraseDesencriptada.getBytes());
            }
        }
        System.out.println("La decodificación se realizó correctamente búsquela en el archivo de salida");
    }

}



