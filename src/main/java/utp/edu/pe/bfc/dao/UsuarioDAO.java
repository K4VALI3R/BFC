package utp.edu.pe.bfc.dao;

import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.models.enums.Estado;
import utp.edu.pe.bfc.models.enums.Tipo;
import utp.edu.pe.bfc.services.Auth;
import utp.edu.pe.bfc.utils.AppConfig;
import utp.edu.pe.bfc.utils.DataAccess;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final Connection cnn;

    public UsuarioDAO() throws SQLException, NamingException {
        this.cnn = DataAccess.getConnection(AppConfig.getDatasource());
    }

    public void close() throws SQLException {
        if (cnn != null) {
            DataAccess.closeConnection(cnn);
        }
    }

    public void createUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nombreCompleto, correo, contrasena, tipo, telefono, direccion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setString(1, usuario.getNombreCompleto());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, Auth.md5(usuario.getContrasena()));
            ps.setString(4, usuario.getTipo().name());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getDireccion());
            ps.setString(7, usuario.getEstado().toString());
            ps.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario obtenerUsuarioPorId(int usuarioId) throws SQLException {
        String query = "SELECT * FROM usuario WHERE usuarioId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("usuarioId"),
                            rs.getString("nombreCompleto"),
                            rs.getString("correo"),
                            rs.getString("contrasena"),
                            Tipo.valueOf(rs.getString("tipo")),
                            rs.getString("telefono"),
                            rs.getString("direccion"),
                            Estado.valueOf(rs.getString("estado"))
                    );
                }
            }
        }
        return null;
    }

    public Usuario obtenerUsuarioPorCorreo(String correo) throws SQLException {
        String query = "SELECT * FROM usuario WHERE correo = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setString(1, correo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("usuarioId"),
                            rs.getString("nombreCompleto"),
                            rs.getString("correo"),
                            rs.getString("contrasena"),
                            Tipo.valueOf(rs.getString("tipo")),
                            rs.getString("telefono"),
                            rs.getString("direccion"),
                            Estado.valueOf(rs.getString("estado"))
                    );
                }
            }
        }
        return null;
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET nombreCompleto = ?, correo = ?, contrasena = ?, tipo = ?, telefono = ?, direccion = ?, estado = ? WHERE usuarioId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setString(1, usuario.getNombreCompleto());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, Auth.md5(usuario.getContrasena()));
            ps.setString(4, usuario.getTipo().name());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getDireccion());
            ps.setString(7, usuario.getEstado().toString());
            ps.setInt(8, usuario.getUsuarioId());
            ps.executeUpdate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void inactiveUsuario(int usuarioId) throws SQLException {
        String query = "UPDATE usuario SET estado = 'INACTIVE' WHERE usuarioId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, usuarioId);
            ps.executeUpdate();
        }
    }

    public void activeUsuario(int usuarioId) throws SQLException {
        String query = "UPDATE usuario SET estado = 'ACTIVE' WHERE usuarioId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, usuarioId);
            ps.executeUpdate();
        }
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (PreparedStatement ps = cnn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                usuarios.add(
                        new Usuario(
                                rs.getInt("usuarioId"),
                                rs.getString("nombreCompleto"),
                                rs.getString("correo"),
                                rs.getString("contrasena"),
                                Tipo.valueOf(rs.getString("tipo")),
                                rs.getString("telefono"),
                                rs.getString("direccion"),
                                Estado.valueOf(rs.getString("estado"))
                        )
                );
            }
        }
        return usuarios;
    }
}