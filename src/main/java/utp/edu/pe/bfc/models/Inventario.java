package utp.edu.pe.bfc.models;

public class Inventario {
    private int inventarioId;
    private int productoId;
    private Producto producto;
    private int stock;

    public Inventario() {
    }

    public Inventario(int productoId, Producto producto, int stock) {
        this.productoId = productoId;
        this.producto = producto;
        this.stock = stock;
    }

    public Inventario(int inventarioId, int productoId, Producto producto, int stock) {
        this.inventarioId = inventarioId;
        this.productoId = productoId;
        this.producto = producto;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "inventarioId=" + inventarioId +
                ", productoId=" + productoId +
                ", producto=" + producto +
                ", stock=" + stock +
                '}';
    }

    public int getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(int inventarioId) {
        this.inventarioId = inventarioId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}