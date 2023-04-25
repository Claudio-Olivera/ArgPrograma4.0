package org.example;

class Oferta {
    public Producto producto;
    public Descuento descuento;
    public String fechaDesde;
    public String fechaHasta;

    public static Oferta Csv(String csv) {
        String[] partes = csv.split(",");
        Oferta oferta = new Oferta();
        oferta.producto = new Producto();
        oferta.producto.nombre = partes[0];
        oferta.producto.peso = new Object[]{Integer.parseInt(partes[1]), "kg"};
        oferta.producto.precio = Integer.parseInt(partes[2]);
        oferta.descuento = new Descuento();
        oferta.descuento.tipo = partes[3];
        oferta.descuento.cantidad = Double.parseDouble(partes[4]);
        oferta.descuento.tope = Integer.parseInt(partes[5]);
        oferta.fechaDesde = partes[6];
        oferta.fechaHasta = partes[7];
        return oferta;
    }
}