package utp.edu.pe.bfc.models;

public class ProductoCombo {
    private int productoComboId;
    private Producto producto;
    private Combo combo;

    public ProductoCombo() {
    }

    public ProductoCombo(Producto producto, Combo combo) {
        this.producto = producto;
        this.combo = combo;
    }

    public ProductoCombo(int productoComboId, Producto producto, Combo combo) {
        this.productoComboId = productoComboId;
        this.producto = producto;
        this.combo = combo;
    }

    @Override
    public String toString() {
        return "ProductoCombo{" +
                "productoComboId=" + productoComboId +
                ", producto=" + producto +
                ", combo=" + combo +
                '}';
    }

    public int getProductoComboId() {
        return productoComboId;
    }

    public void setProductoComboId(int productoComboId) {
        this.productoComboId = productoComboId;
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
}