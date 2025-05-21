package utp.edu.pe.bfc.models;

import java.time.LocalDate;

public class Ingreso {
    private int ingresoId;
    private int productoId;
    private int proveedorId;
    private int cantidad;
    private Producto producto;
    private Proveedor proveedor;
    private LocalDate fecha;

    public Ingreso() {
    }

    public Ingreso(int cantidad, Producto producto, Proveedor proveedor, LocalDate fecha) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.proveedor = proveedor;
        this.fecha = fecha;
    }

    public Ingreso(int proveedorId, int cantidad, Producto producto, Proveedor proveedor, LocalDate fecha) {
        this.proveedorId = proveedorId;
        this.cantidad = cantidad;
        this.producto = producto;
        this.proveedor = proveedor;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ingreso{" +
                "ingresoId=" + ingresoId +
                ", productoId=" + productoId +
                ", proveedorId=" + proveedorId +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                ", proveedor=" + proveedor +
                ", fecha=" + fecha +
                '}';
    }

    public int getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(int ingresoId) {
        this.ingresoId = ingresoId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}