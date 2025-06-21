package utp.edu.pe.bfc.models;

public class Carritoo {

    private String tipo; // "producto" o "combo"
    private int id;
    private String nombre;
    private float precio;
    private int cantidad;

    public Carritoo(String tipo, int id, String nombre, float precio,int cantidad) {
        this.tipo = tipo;
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public float getSubtotal() {
        return this.precio * this.cantidad;
    }
}
