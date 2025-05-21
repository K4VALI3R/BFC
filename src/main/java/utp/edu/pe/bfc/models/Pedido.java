package utp.edu.pe.bfc.models;

import utp.edu.pe.bfc.models.enums.EstadoPedido;

import java.time.LocalDateTime;

public class Pedido {
    private int pedidoId;
    private Cliente cliente;
    private Admin admin;
    private LocalDateTime fecha;
    private String direccion;
    private double monto;
    private EstadoPedido tipo;

    public Pedido() {
    }

    public Pedido(Cliente cliente, Admin admin, LocalDateTime fecha, String direccion, double monto, EstadoPedido tipo) {
        this.cliente = cliente;
        this.admin = admin;
        this.fecha = fecha;
        this.direccion = direccion;
        this.monto = monto;
        this.tipo = tipo;
    }

    public Pedido(int pedidoId, Cliente cliente, Admin admin, LocalDateTime fecha, String direccion, double monto, EstadoPedido tipo) {
        this.pedidoId = pedidoId;
        this.cliente = cliente;
        this.admin = admin;
        this.fecha = fecha;
        this.direccion = direccion;
        this.monto = monto;
        this.tipo = tipo;
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
                ", tipo=" + tipo +
                '}';
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
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

    public EstadoPedido getTipo() {
        return tipo;
    }

    public void setTipo(EstadoPedido tipo) {
        this.tipo = tipo;
    }
}
