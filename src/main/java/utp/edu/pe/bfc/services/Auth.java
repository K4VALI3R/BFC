package utp.edu.pe.bfc.services;

import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.models.enums.Tipo;
import utp.edu.pe.bfc.utils.AppConfig;
import utp.edu.pe.bfc.utils.DataAccess;

import javax.naming.NamingException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {
    public void close() throws SQLException {
    }

    public static String md5(String data) throws IOException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            return byteArrayToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new IOException(e);
        }
    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public Usuario isValidUsuario(String email, String password) throws SQLException, IOException {
        String query = "SELECT * FROM usuario WHERE correo = ? AND contrasena = ?";
        Usuario usuario = new Usuario();
        try (Connection cnn = DataAccess.getConnection(AppConfig.getDatasource());
             PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, md5(password));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario.setUsuarioId(rs.getInt("usuarioId"));
                    usuario.setNombreCompleto(rs.getString("nombreCompleto"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setTipo(Tipo.valueOf(rs.getString("tipo")));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setDireccion(rs.getString("direccion"));
                } else {
                    throw new SQLException("No se pudo encontrar el usuario en la base de datos.");
                }
            }
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}