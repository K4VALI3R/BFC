package utp.edu.pe.bfc.models;

public class PedidoDetalle {
    private int pedidoDetalleId;
    private Pedido pedido;
    private Producto producto;
    private Combo combo;
    private int cantidad;
    private double subtotal;

    public PedidoDetalle() {
    }

    public PedidoDetalle(Pedido pedido, Producto producto, int cantidad, Combo combo, double subtotal) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.combo = combo;
        this.subtotal = subtotal;
    }

    public PedidoDetalle(int pedidoDetalleId, Pedido pedido, Producto producto, Combo combo, int cantidad, double subtotal) {
        this.pedidoDetalleId = pedidoDetalleId;
        this.pedido = pedido;
        this.producto = producto;
        this.combo = combo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "PedidoDetalle{" +
                "pedidoDetalleId=" + pedidoDetalleId +
                ", pedido=" + pedido +
                ", producto=" + producto +
                ", combo=" + combo +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }

    public int getPedidoDetalleId() {
        return pedidoDetalleId;
    }

    public void setPedidoDetalleId(int pedidoDetalleId) {
        this.pedidoDetalleId = pedidoDetalleId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


}