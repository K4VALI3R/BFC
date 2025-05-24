package utp.edu.pe.bfc.dao;

import utp.edu.pe.bfc.models.Producto;
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

public class ProductoDAO {
    private final Connection cnn;

    public ProductoDAO() throws SQLException, NamingException {
        this.cnn = DataAccess.getConnection(AppConfig.getDatasource());
    }

    public void close() throws SQLException {
        if (this.cnn != null) DataAccess.closeConnection(this.cnn);
    }

    public void createProducto(Producto producto) throws SQLException {
        String query = "INSERT INTO producto (nombre, precio, imagen, categoria,estado) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setString(3, producto.getImagen());
            ps.setString(4, producto.getCategoria().toString());
            if (producto.getEstado() == null) {
                ps.setString(5, Estado.ACTIVE.toString());
            } else {
                ps.setString(5, producto.getEstado().toString());
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Producto getProducto(int productoId) throws SQLException {
        String query = "SELECT * FROM producto WHERE productoId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, productoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Producto producto = new Producto();
                    producto.setProductoId(rs.getInt("productoId"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setImagen(rs.getString("imagen"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                    producto.setEstado(Estado.valueOf(rs.getString("estado")));
                    return producto;
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return null;
    }

    public void updateProducto(Producto producto) throws SQLException {
        String query = "UPDATE producto SET nombre = ?, precio = ?, imagen = ?, categoria = ?, estado = ? WHERE productoId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setString(3, producto.getImagen());
            ps.setString(4, producto.getCategoria().toString());
            ps.setString(5, producto.getEstado().toString());
            ps.setInt(6, producto.getProductoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void inactiveProducto(Integer productoId) throws SQLException {
        String query = "UPDATE producto SET estado = 'INACTIVE' WHERE productoId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, productoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void activateProducto(Integer productoId) throws SQLException {
        String query = "UPDATE producto SET estado = 'ACTIVE' WHERE productoId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, productoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Producto> getAllAProductos(){
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM producto";
        try (PreparedStatement ps = cnn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setProductoId(rs.getInt("productoId"));
                producto.setNombre(rs.getString("nombre"));
                producto.setImagen(rs.getString("imagen"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                producto.setEstado(Estado.valueOf(rs.getString("estado")));
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

    public List<Producto> getActiveAProductos(){
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM producto WHERE estado = 'ACTIVE'";
        try (PreparedStatement ps = cnn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setProductoId(rs.getInt("productoId"));
                producto.setNombre(rs.getString("nombre"));
                producto.setImagen(rs.getString("imagen"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

    public List<Producto> getInactiveAProductos(){
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM producto WHERE estado = 'INACTIVE'";
        try (PreparedStatement ps = cnn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setProductoId(rs.getInt("productoId"));
                producto.setNombre(rs.getString("nombre"));
                producto.setImagen(rs.getString("imagen"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

}