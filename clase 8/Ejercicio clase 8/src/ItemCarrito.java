import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ItemCarrito extends Producto {
    private int cantidad;

    public ItemCarrito(String marca, String descripcion, double precio, int cantidad) {
        super(marca, descripcion, precio);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
        public static List<String> capturarArchivoItems() throws IOException {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese la ruta del archivo con los Items: ");
            String rutaArchivo = scanner.nextLine();
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo))
                    .stream()
                    .skip(1)
                    .collect(Collectors.toList());
            for (String linea : lineas) {
                convertirLineasEnCarrito(linea);
            }
            return lineas;
        }

        public static void convertirLineasEnCarrito(String lineas) {
            String[] datosItems = lineas.split(";");
            Producto producto = new Producto(datosItems[0], datosItems[1], Double.parseDouble(datosItems[2]));
            int cantidad = Integer.parseInt(datosItems[3]);
            ItemCarrito itemCarrito = new ItemCarrito(producto.getMarca(), producto.getDescripcion(),
                    producto.getPrecio(), cantidad);
            Carrito.agregarItem(itemCarrito);
        }

    public double getSubtotal(int cantidad) {
        return this.getPrecio() * cantidad;
    }

    public static double calcularSubTotal() {
        double subtotal = 0;
        for (ItemCarrito item : Carrito.getItems()) {
            subtotal += item.getSubtotal(item.getCantidad());
        }
        return subtotal;
    }
    public static void verificarPrecios() throws Exception {
        List<ItemCarrito> items = Carrito.getItems();
        boolean hayErrores = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getPrecio() <= 0) {
                if (!hayErrores) {
                    System.out.println("*** Hay errores en el precio de los productos cargados (iguales o menores a 0) ***");
                }
                hayErrores = true;
                System.out.println("El item " + (i + 1) + " (" + items.get(i).getMarca() + " - "+ items.get(i).getDescripcion()+ ") tiene un precio de "+items.get(i).getPrecio());
            }
        }
        if (hayErrores) {
            throw new Exception("\nPor favor, corrige los errores y vuelve a ejecutar el programa.");
        }
    }
    public static void mostrarSubTotal() throws Exception {
        verificarPrecios(); // llamamos al método que verifica los precios antes de continuar
        System.out.println("\nSubtotal de la compra sin iva es de: $ " + calcularSubTotal());
    }
}


