
public class Main {

    public static void main(String[] args) throws Exception {
        ItemCarrito.capturarArchivoItems();
        try {
        Carrito.mostrarCarro();
        Descuento.aplicaDescuentos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/**
 * Ingresar la ruta siguiendo el formato de la ruta de ejemplo, la misma corresponde a la ubicación del archivo Productos.csv en su computadora:
    C:\Users\Claudio\Desktop\ArgPrograma4.0\clase 8\Ejercicio clase 8\src\Productos.csv
 */
