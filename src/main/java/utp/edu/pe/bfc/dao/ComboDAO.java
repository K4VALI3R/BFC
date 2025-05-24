package utp.edu.pe.bfc.dao;

import utp.edu.pe.bfc.models.Combo;
import utp.edu.pe.bfc.models.enums.Categoria;
import utp.edu.pe.bfc.models.enums.Estado;
import utp.edu.pe.bfc.utils.AppConfig;
import utp.edu.pe.bfc.utils.DataAccess;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComboDAO {
    private final Connection cnn;

    public ComboDAO() throws SQLException, NamingException {
        this.cnn = DataAccess.getConnection(AppConfig.getDatasource());
    }

    public void close() throws SQLException {
        if (this.cnn != null) DataAccess.closeConnection(this.cnn);
    }

    public void createCombo(Combo combo) throws SQLException {
        String query = "INSERT INTO combo (nombre, imagen, precio, categoria) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setString(1, combo.getNombre());
            ps.setString(2, combo.getImagen());
            ps.setDouble(3, combo.getPrecio());
            ps.setString(4, combo.getCategoria().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Combo getCombo(int comboId) throws SQLException {
        String query = "SELECT * FROM combo WHERE comboId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, comboId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Combo combo = new Combo();
                    combo.setComboId(rs.getInt("comboId"));
                    combo.setNombre(rs.getString("nombre"));
                    combo.setImagen(rs.getString("imagen"));
                    combo.setPrecio(rs.getDouble("precio"));
                    combo.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                    combo.setEstado(Estado.valueOf(rs.getString("estado")));
                    return combo;
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return null;
    }

    public void updateCombo(Combo combo) throws SQLException {
        String query = "UPDATE combo SET nombre = ?, imagen = ?, precio = ?, categoria = ?, estado = ? WHERE comboId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setString(1, combo.getNombre());
            ps.setString(2, combo.getImagen());
            ps.setDouble(3, combo.getPrecio());
            ps.setString(4, combo.getCategoria().toString());
            ps.setString(5, combo.getEstado().toString());
            ps.setInt(6, combo.getComboId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void deleteCombo(int comboId) throws SQLException {
        String query = "DELETE FROM combo WHERE comboId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, comboId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Combo> getAllACombos(){
        List<Combo> combos = new ArrayList<>();
        String query = "SELECT * FROM combo";
        try (PreparedStatement ps = cnn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Combo combo = new Combo();
                combo.setComboId(rs.getInt("comboId"));
                combo.setNombre(rs.getString("nombre"));
                combo.setImagen(rs.getString("imagen"));
                combo.setPrecio(rs.getDouble("precio"));
                combo.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                combo.setEstado(Estado.valueOf(rs.getString("estado")));
                combos.add(combo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return combos;
    }

    public List<Combo> getActiveACombos(){
        List<Combo> combos = new ArrayList<>();
        String query = "SELECT * FROM combo WHERE estado = 'ACTIVE'";
        try (PreparedStatement ps = cnn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Combo combo = new Combo();
                combo.setComboId(rs.getInt("comboId"));
                combo.setNombre(rs.getString("nombre"));
                combo.setImagen(rs.getString("imagen"));
                combo.setPrecio(rs.getDouble("precio"));
                combo.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                combo.setEstado(Estado.valueOf(rs.getString("estado")));
                combos.add(combo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return combos;
    }

    public void inactiveCombo(int id) throws SQLException {
        String query = "UPDATE combo SET estado = 'INACTIVE' WHERE comboId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void activeCombo(int id) throws SQLException {
        String query = "UPDATE combo SET estado = 'ACTIVE' WHERE comboId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}