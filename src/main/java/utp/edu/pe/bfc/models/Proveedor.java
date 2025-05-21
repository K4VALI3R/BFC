package utp.edu.pe.bfc.models;

public class Proveedor {
    private int proveedorId;
    private String nombreCompleto;
    private String ruc;
    private String direccion;
    private String telefono;
    private String correo;
    private String personaContacto;

    public Proveedor() {
    }

    public Proveedor(String nombreCompleto, String ruc, String direccion, String telefono, String correo, String personaContacto) {
        this.nombreCompleto = nombreCompleto;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.personaContacto = personaContacto;
    }

    public Proveedor(int proveedorId, String nombreCompleto, String ruc, String direccion, String telefono, String correo, String personaContacto) {
        this.proveedorId = proveedorId;
        this.nombreCompleto = nombreCompleto;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.personaContacto = personaContacto;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "proveedorId=" + proveedorId +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", ruc='" + ruc + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", personaContacto='" + personaContacto + '\'' +
                '}';
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }
}