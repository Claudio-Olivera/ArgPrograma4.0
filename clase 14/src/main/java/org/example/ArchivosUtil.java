package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ArchivosUtil extends ExpresionesRegulares {
    private static  final String ARCHIVO_EXPRESIONES= "C:\\Users\\luist\\Desktop\\Clase14\\src\\main\\java\\org\\example\\texto.txt";


    public static void obtenerCorreosElectronicos() throws IOException {

        for (String linea : Files.readAllLines(Paths.get(ARCHIVO_EXPRESIONES))) {
            String[] partes = linea.split(";");
            expresionRegular(partes[0],"Nombre: (\\w+ \\w+), Edad: (\\d+), Email: (\\S+)");
            }
        }

    }


