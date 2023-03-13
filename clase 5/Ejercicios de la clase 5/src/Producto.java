public class Producto {
    private String marca;
    private String descripcion;
    private double precio;


    public Producto() {
    }

    public Producto(String marca, String descripcion, double precio) {
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}




