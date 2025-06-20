package utp.edu.pe.bfc.dao;

import utp.edu.pe.bfc.models.PedidoDetalle;
import utp.edu.pe.bfc.models.Producto;
import utp.edu.pe.bfc.utils.AppConfig;
import utp.edu.pe.bfc.utils.DataAccess;

import javax.naming.NamingException;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDetalleDAO {
    private final Connection cnn;

    public PedidoDetalleDAO() throws SQLException, NamingException{
        this.cnn= DataAccess.getConnection(AppConfig.getDatasource());
    }
    public void close() throws SQLException{
        if(this.cnn !=null) DataAccess.closeConnection(this.cnn);
    }
    public void createPedidoDetalle(PedidoDetalle pedidoDetalle) throws SQLException {
        String query = "INSERT INTO pedidoDetalle(pedidoId, productoId, comboId, cantidad, subtotal) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, pedidoDetalle.getPedido().getPedidoId());

            if (pedidoDetalle.getProducto() != null) {
                ps.setInt(2, pedidoDetalle.getProducto().getProductoId());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }

            if (pedidoDetalle.getCombo() != null) {
                ps.setInt(3, pedidoDetalle.getCombo().getComboId());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }

            ps.setInt(4, pedidoDetalle.getCantidad());
            ps.setDouble(5, pedidoDetalle.getSubtotal());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al crear pedidoDetalle: " + e.getMessage(), e);
        }
    }
    public PedidoDetalle getPedidoDetalle(int pedidoDetalleId) throws SQLException{
        String query="SELECT * FROM pedidoDetalle WHERE pedidoDetalleId= ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)){
            ps.setInt(1,pedidoDetalleId);
            try(ResultSet rs = ps.executeQuery()){
                PedidoDAO pedidoDAO = new PedidoDAO();
                ProductoDAO productoDAO= new ProductoDAO();
                ComboDAO comboDAO= new ComboDAO();
                if(rs.next()){
                    PedidoDetalle pedidoDetalle = new PedidoDetalle();
                    pedidoDetalle.setPedidoDetalleId(rs.getInt("pedidoDetalleId"));
                    int pedidoId = rs.getInt("pedido");
                    int productoId = rs.getInt("producto");
                    int comboId = rs.getInt("combo");
                    pedidoDetalle.setPedido(pedidoDAO.getPedido(pedidoId));
                    pedidoDetalle.setProducto(productoDAO.getProducto(productoId));
                    pedidoDetalle.setCombo(comboDAO.getCombo(comboId));
                    pedidoDetalle.setCantidad(rs.getInt("cantidad"));
                    pedidoDetalle.setSubtotal(rs.getDouble("subtotal"));
                    return pedidoDetalle;
                }
            }
        }catch (SQLException | NamingException e) {
            throw new SQLException(e);

        }return null;
    }
    public void updatePedidoDetalle(PedidoDetalle pedidoDetalle) throws SQLException{
        String query="UPDATE pedidoDetalle SET pedido= ?,producto= ?,combo= ?,cantidad= ?, subtotal= ?";
        try(PreparedStatement ps= cnn.prepareStatement(query)){
            ps.setInt(1,pedidoDetalle.getPedido().getPedidoId());
            ps.setInt(2,pedidoDetalle.getProducto().getProductoId());
            ps.setInt(3,pedidoDetalle.getCombo().getComboId());
            ps.setInt(4,pedidoDetalle.getCantidad());
            ps.setDouble(5,pedidoDetalle.getSubtotal());
            ps.setInt(6,pedidoDetalle.getPedidoDetalleId());
            ps.executeUpdate();
        } catch (SQLException e){
            throw new SQLException(e);
        }
    }

    public void deletePedidoDetalle(int pedidoDetalleId) throws SQLException{
        String query= "DELETE FROM pedidoDetalle WHERE pedidoDetalleId = ?";
        try(PreparedStatement ps= cnn.prepareStatement(query)){
            ps.setInt(1,pedidoDetalleId);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e);
        }
    }

    public List<PedidoDetalle> getAllAPedidosDetalle(){
        List<PedidoDetalle> pedidoDetalles= new ArrayList<>();
        String query= "SELECT * FROM pedidoDetalle";
        try(PreparedStatement ps= cnn.prepareStatement(query);
            ResultSet rs= ps.executeQuery()){
            PedidoDAO pedidoDAO=new PedidoDAO();
            ProductoDAO productoDAO= new ProductoDAO();
            ComboDAO comboDAO= new ComboDAO();
            while (rs.next()){
                PedidoDetalle pedidoDetalle = new PedidoDetalle();
                pedidoDetalle.setPedidoDetalleId(rs.getInt("pedidoDetalleId"));
                pedidoDetalle.setPedido(pedidoDAO.getPedido(rs.getInt("pedidoId")));
                pedidoDetalle.setProducto(productoDAO.getProducto(rs.getInt("productoId")));
                pedidoDetalle.setCombo(comboDAO.getCombo(rs.getInt("comboId")));
                pedidoDetalle.setCantidad(rs.getInt("cantidad"));
                pedidoDetalle.setSubtotal(rs.getDouble("subtotal"));
                pedidoDetalles.add(pedidoDetalle);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }catch (NamingException e) {
            throw new RuntimeException(e);
        }
        return pedidoDetalles;
    }
    public List<PedidoDetalle> getDetallesByPedido(int pedidoId) throws SQLException {
        List<PedidoDetalle> detalles = new ArrayList<>();
        String query = "SELECT * FROM pedidoDetalle WHERE pedidoId = ?";

        try (PreparedStatement ps = cnn.prepareStatement(query)) {
            ps.setInt(1, pedidoId);

            try (ResultSet rs = ps.executeQuery()) {
                ProductoDAO productoDAO = new ProductoDAO();
                ComboDAO comboDAO = new ComboDAO();

                while (rs.next()) {
                    PedidoDetalle detalle = new PedidoDetalle();
                    detalle.setPedidoDetalleId(rs.getInt("pedidoDetalleId"));
                    detalle.setCantidad(rs.getInt("cantidad"));
                    detalle.setSubtotal(rs.getDouble("subtotal"));

                    int productoId = rs.getInt("productoId");
                    int comboId = rs.getInt("comboId");

                    // Cargar producto o combo según corresponda
                    if (productoId != 0) {
                        detalle.setProducto(productoDAO.getProducto(productoId));
                    } else if (comboId != 0) {
                        detalle.setCombo(comboDAO.getCombo(comboId));
                    }

                    detalles.add(detalle);
                }
            }
        } catch (Exception e) {
            throw new SQLException("Error al obtener detalles del pedido", e);
        }

        return detalles;
    }
}