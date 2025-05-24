package utp.edu.pe.bfc.models;

import utp.edu.pe.bfc.models.enums.Estado;

public class Proveedor {
    private int proveedorId;
    private String nombreEmpresa;
    private String ruc;
    private String direccion;
    private String telefono;
    private String correo;
    private String descripcion;
    private String delegado;
    private Estado estado;

    public Proveedor() {
    }

    public Proveedor(String nombreEmpresa, String ruc, String direccion, String telefono, String correo, String descripcion, String delegado, Estado estado) {
        this.nombreEmpresa = nombreEmpresa;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.descripcion = descripcion;
        this.delegado = delegado;
        this.estado = estado;
    }

    public Proveedor(int proveedorId, String nombreEmpresa, String ruc, String direccion, String telefono, String correo, String descripcion, String delegado, Estado estado) {
        this.proveedorId = proveedorId;
        this.nombreEmpresa = nombreEmpresa;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.descripcion = descripcion;
        this.delegado = delegado;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "proveedorId=" + proveedorId +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", ruc='" + ruc + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", delegado='" + delegado + '\'' +
                ", estado=" + estado +
                '}';
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDelegado() {
        return delegado;
    }

    public void setDelegado(String delegado) {
        this.delegado = delegado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}