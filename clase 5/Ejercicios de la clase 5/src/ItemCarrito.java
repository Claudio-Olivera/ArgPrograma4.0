import java.util.Scanner;

public class ItemCarrito extends Producto {
    private int cantidad;
    static boolean seguirComprando = true;

    public ItemCarrito(String marca, String descripcion, double precio, int cantidad) {
        super(marca, descripcion, precio);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public static void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        while (seguirComprando) {
            System.out.print("Ingrese la marca del producto: ");
            String marca = scanner.nextLine();

            System.out.print("Ingrese la descripción del producto: ");
            String descripcion = scanner.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();

            Producto producto = new Producto(marca, descripcion, precio);

            System.out.print("Ingrese la cantidad de productos: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Producto agregado con éxito al carrito: " + producto.getDescripcion());

            ItemCarrito itemCarrito = new ItemCarrito(marca, descripcion, precio, cantidad);

            Carrito.agregarItem(itemCarrito);

            System.out.print("¿Desea agregar otro producto? (S/N): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("N")) {
                seguirComprando = false;
            }
        }
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

    public static void mostrarSubTotal() {
        System.out.println("\nSubtotal de la compra sin iva es de: $ " + calcularSubTotal());
    }


}

