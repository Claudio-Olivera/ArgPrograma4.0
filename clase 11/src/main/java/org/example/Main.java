package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String azul = "\033[34m";
        Scanner scanner = new Scanner(System.in);
        String nombre="";
        String opcion = "";
        String morado = "\033[35m";

      
        System.out.print("Ingrese su nombre: ");
        nombre = scanner.nextLine();


        File archivoChat = new File("chat.txt");
        try {
            archivoChat.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al crear archivo de chat");
        }


        do {
            System.out.println(azul+"Seleccione una opción:");
            System.out.println("1. Escribir mensaje");
            System.out.println("2. Leer mensajes");
            System.out.println("0. Salir");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.print("Ingrese el mensaje: ");
                    String mensaje = scanner.nextLine();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String linea = nombre + " [" + dtf.format(now) + "]: " + mensaje;
                    try {
                        FileWriter escritor = new FileWriter(archivoChat, true);
                        escritor.write(linea + "\n");
                        escritor.close();
                        System.out.println("Mensaje enviado");
                    } catch (IOException e) {
                        System.out.println("Error al escribir mensaje");
                    }
                }
                case "2" -> {
                    try {
                        Scanner lector = new Scanner(archivoChat);
                        while (lector.hasNextLine()) {
                            String lineaArchivo = lector.nextLine();
                            System.out.println(morado + lineaArchivo);
                        }
                        lector.close();
                    } catch (IOException e) {
                        System.out.println("Error al leer mensajes");
                    }
                }
                case "0" -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (!opcion.equals("0"));
    }
}
