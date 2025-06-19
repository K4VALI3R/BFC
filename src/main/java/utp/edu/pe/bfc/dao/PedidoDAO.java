package utp.edu.pe.bfc.dao;

import utp.edu.pe.bfc.models.Pedido;
import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.models.enums.Estado;
import utp.edu.pe.bfc.models.enums.EstadoPedido;
import utp.edu.pe.bfc.models.enums.Tipo;
import utp.edu.pe.bfc.utils.AppConfig;
import utp.edu.pe.bfc.utils.DataAccess;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private final Connection cnn;

    public PedidoDAO() throws SQLException, NamingException {
        this.cnn = DataAccess.getConnection(AppConfig.getDatasource());
    }

    public void close() throws SQLException {
        if (this.cnn != null) DataAccess.closeConnection(this.cnn);
    }

    public void createPedido(Pedido pedido) throws SQLException {
        String query = "INSERT INTO pedido (clienteId, adminId, fecha, direccion, monto, estado) VALUES (?, ?, ?, ?,?,?)";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, pedido.getCliente().getUsuarioId());
            ps.setInt(2, pedido.getAdmin().getUsuarioId());
            ps.setTimestamp(3, Timestamp.valueOf(pedido.getFecha()));
            ps.setString(4, pedido.getDireccion());
            ps.setDouble(5, pedido.getMonto());
            ps.setString(6, pedido.getEstado().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Pedido getPedido(int pedidoId) throws SQLException {
        String query = "SELECT * FROM pedido WHERE pedidoId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, pedidoId);
            try (ResultSet rs = ps.executeQuery()) {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                if (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setPedidoId(rs.getInt("pedidoId"));
                    int clienteId = rs.getInt("clienteId");
                    int adminId = rs.getInt("adminId");
                    pedido.setCliente(usuarioDAO.obtenerUsuarioPorId(clienteId));
                    pedido.setAdmin(usuarioDAO.obtenerUsuarioPorId(adminId));
                    pedido.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                    pedido.setDireccion(rs.getString("direccion"));
                    pedido.setMonto(rs.getDouble("monto"));
                    pedido.setEstado(EstadoPedido.valueOf(rs.getString("estado")));
                    return pedido;
                }
            }
        } catch (SQLException | NamingException e) {
            throw new SQLException(e);
        }
        return null;
    }

    public void updatePedido(Pedido pedido) throws SQLException {
        String query = "UPDATE pedido SET clienteId = ?, adminId = ?, fecha = ?, direccion = ?, monto = ?, estado = ? WHERE pedidoId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, pedido.getCliente().getUsuarioId());
            ps.setInt(2, pedido.getAdmin().getUsuarioId());
            ps.setTimestamp(3, Timestamp.valueOf(pedido.getFecha()));
            ps.setString(4, pedido.getDireccion());
            ps.setDouble(5, pedido.getMonto());
            ps.setString(6, pedido.getEstado().toString());
            ps.setInt(7, pedido.getPedidoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void deletePedido(int pedidoId) throws SQLException {
        String query = "DELETE FROM pedido WHERE pedidoId = ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, pedidoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Pedido> getAllPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM pedido";
        try (PreparedStatement ps = cnn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setPedidoId(rs.getInt("pedidoId"));
                pedido.setCliente(usuarioDAO.obtenerUsuarioPorId(rs.getInt("clienteId")));
                pedido.setAdmin(usuarioDAO.obtenerUsuarioPorId(rs.getInt("adminId")));
                pedido.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                pedido.setDireccion(rs.getString("direccion"));
                pedido.setMonto(rs.getDouble("monto"));
                pedido.setEstado(EstadoPedido.valueOf(rs.getString("estado")));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
        return pedidos;
    }

}