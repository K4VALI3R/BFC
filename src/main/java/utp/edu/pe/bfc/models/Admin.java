package utp.edu.pe.bfc.models;

import utp.edu.pe.bfc.models.enums.Tipo;

public class Admin {
    private int adminId;
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private Tipo tipo;

    public Admin() {
    }

    public Admin(String nombreCompleto, String correo, String contrasena, Tipo tipo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public Admin(int adminId, String nombreCompleto, String correo, String contrasena, Tipo tipo) {
        this.adminId = adminId;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
