package utp.edu.pe.bfc.models;

import utp.edu.pe.bfc.models.enums.EstadoPedido;

import java.time.LocalDateTime;

public class Pedido {
    private int pedidoId;
    private Usuario cliente;
    private Usuario admin;
    private LocalDateTime fecha;
    private String direccion;
    private double monto;
    private EstadoPedido estado;

    public Pedido() {
    }

    public Pedido(Usuario cliente, Usuario admin, LocalDateTime fecha, String direccion, double monto, EstadoPedido tipo) {
        this.cliente = cliente;
        this.admin = admin;
        this.fecha = fecha;
        this.direccion = direccion;
        this.monto = monto;
        this.estado = tipo;
    }

    public Pedido(int pedidoId, Usuario cliente, Usuario admin, LocalDateTime fecha, String direccion, double monto, EstadoPedido tipo) {
        this.pedidoId = pedidoId;
        this.cliente = cliente;
        this.admin = admin;
        this.fecha = fecha;
        this.direccion = direccion;
        this.monto = monto;
        this.estado = tipo;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "pedidoId=" + pedidoId +
                ", cliente=" + cliente +
                ", admin=" + admin +
                ", fecha=" + fecha +
                ", direccion='" + direccion + '\'' +
                ", monto=" + monto +
                ", tipo=" + estado +
                '}';
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getAdmin() {
        return admin;
    }

    public void setAdmin(Usuario admin) {
        this.admin = admin;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}