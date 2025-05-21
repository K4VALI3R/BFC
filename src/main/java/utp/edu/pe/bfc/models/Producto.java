package utp.edu.pe.bfc.models;

import utp.edu.pe.bfc.models.enums.Categoria;

public class Producto {
    private int productoId;
    private String nombre;
    private String imagen;
    private double precio;
    private Categoria categoria;

    public Producto() {
    }

    public Producto(String nombre, String imagen, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(int productoId, String nombre, String imagen, double precio, Categoria categoria) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "productoId=" + productoId +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                '}';
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}