package utp.edu.pe.bfc.models;

public class Cliente {
    private int clienteId;
    private String nombreCompleto;
    private String numeroTelefono;
    private String correo;
    private String contrasena;

    public Cliente() {
    }

    public Cliente(String nombreCompleto, String numeroTelefono, String correo, String contrasena) {
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Cliente(int clienteId, String nombreCompleto, String numeroTelefono, String correo, String contrasena) {
        this.clienteId = clienteId;
        this.nombreCompleto = nombreCompleto;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteId=" + clienteId +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
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
}
