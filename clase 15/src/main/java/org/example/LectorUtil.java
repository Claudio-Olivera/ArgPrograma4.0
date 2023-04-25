package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class LectorUtil {
    private static String filePath = "C:\\Users\\luist\\Desktop\\Clase15\\src\\main\\java\\org\\example\\productos.csv";


    public static void inicio() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<Oferta> ofertas = lines.stream()
                .skip(1)
                .map(Oferta::Csv)
                .collect(Collectors.toList());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(ofertas);
        System.out.println(json);
    }}


