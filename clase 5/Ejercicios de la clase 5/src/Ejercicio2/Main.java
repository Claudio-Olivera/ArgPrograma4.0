package Ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2. En un programa main, lea de un archivo, por ejemplo separado por Tabs o comas, una
 *         lista de items, arme los objetos correspondientes y con el método de carrito “precio”,
 *         retorne el resultado. Por ejemplo:
 *         cant precioUnitario producto
 *         1 40 jabón en polvo
 *         3 10 esponjas
 *         2 100 chocolates
 *         carrito.precio() == 270
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String rutaArchivoIngresada;

        if (args.length >= 1) {
            rutaArchivoIngresada = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Ingrese la ruta del archivo sin dejar espacios: ");
            rutaArchivoIngresada = scanner.nextLine();
        }

        ArrayList<Producto> productos = new ArrayList<>();

        Scanner scanner = new Scanner(new File(rutaArchivoIngresada));
        scanner.nextLine(); // Salto la primera línea porque ahi se encuentra el encabezado
        while (scanner.hasNextLine()) {
            String[] datos = scanner.nextLine().split(",");
            int cantidad = Integer.parseInt(datos[0].trim());
            double precioUnitario = Double.parseDouble(datos[1].trim());
            String producto = datos[2].trim();
            productos.add(new Producto(cantidad, precioUnitario, producto));
        }
        scanner.close();

        Carrito carrito = new Carrito(productos);
        System.out.println("El precio total es: " + carrito.precio());
    }
}

/**
 *
 * cantidad,precio,producto
 * 1,40,Jabón en Polvo
 * 3,10,Esponjas
 * 2,100,Chocolates
 *
 * java Ejercicio2.Main "C:\Users\Claudio\Desktop\ArgPrograma4.0\clase 5\Ejercicios de la clase 5\src\Ejercicio2\ProductosLista-Ejercicio2.txt"
 *
 *
 */