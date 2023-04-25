package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Attribute;

public class ExpresionesRegulares {
    private static int count = 0;

    public static void expresionRegular(String texto,String expresion  ){
        count++;
        System.out.print("Texto " + count +":");
        String red = "\033[31m";
        String reset = "\033[0m";
        String azul = "\033[34m";


        Pattern patron = Pattern.compile(expresion);

        Matcher matcher = patron.matcher(texto);

        if (matcher.find()) {
            String nombre = matcher.group(1);
            int edad = Integer.parseInt(matcher.group(2));
            String email = matcher.group(3);
            System.out.println(azul+"Nombre: " + nombre+" Edad: " + edad+" Email: " + email+reset);
           }
            else {
            System.out.println(red + "El texto "+texto+" no cumple las condiciones" + reset);
        }

        }
    }

