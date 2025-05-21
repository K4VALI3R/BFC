package utp.edu.pe.bfc.models;

import utp.edu.pe.bfc.models.enums.Categoria;

public class Combo {
    private int comboId;
    private String nombre;
    private String imagen;
    private double precio;
    private Categoria categoria;

    public Combo() {
    }

    public Combo(String nombre, String imagen, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Combo(int comboId, String nombre, String imagen, double precio, Categoria categoria) {
        this.comboId = comboId;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "comboId=" + comboId +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                '}';
    }

    public int getComboId() {
        return comboId;
    }

    public void setComboId(int comboId) {
        this.comboId = comboId;
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
