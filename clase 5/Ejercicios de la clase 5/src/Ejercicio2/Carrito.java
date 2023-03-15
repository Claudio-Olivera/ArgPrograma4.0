package Ejercicio2;

import java.util.ArrayList;
public class Carrito {

    private ArrayList<Producto> productos;

    public Carrito(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public double precio() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecioTotal();
        }
        return total;
    }
}