import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private static List<ItemCarrito> items = new ArrayList<>();

    public Carrito() {
    }

    public static void agregarItem(ItemCarrito itemCarrito) {
        items.add(itemCarrito);
    }

    public static List<ItemCarrito> getItems() {
        return items;
    }

    public static double calcularTotal() {
        double subtotal = 0;
        for (ItemCarrito item : items) {
            subtotal += item.getPrecio() * item.getCantidad();
        }
        double iva = subtotal * 0.21; // IVA del 21%
        double total = subtotal + iva;
        return total;
    }

    public static void mostrarCarro() throws Exception {
        System.out.println("\n\n---------**** PRODUCTOS EN EL CARRITO ****---------");
        Carrito.getItems().forEach(item -> System.out.println(
                "                     *----*                     " +
                        "\nDescripcion: " + item.getDescripcion() +
                        "\nMarca: " + item.getMarca() +
                        "\nUnidades :" + item.getCantidad() +
                        "\nPrecio por unidad: $ " + item.getPrecio()));

        System.out.println(" ");
        ItemCarrito.mostrarSubTotal();
        mostrarTotal();
        }

        public static void mostrarTotal(){
        System.out.println("Total de la compra con iva 21% aplicado: $ " + calcularTotal());
        }

    public void vaciar() {
        this.items.clear();
    }
}