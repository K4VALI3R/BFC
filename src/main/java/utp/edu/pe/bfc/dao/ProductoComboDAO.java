package utp.edu.pe.bfc.dao;

import utp.edu.pe.bfc.models.PedidoDetalle;
import utp.edu.pe.bfc.models.ProductoCombo;
import utp.edu.pe.bfc.utils.AppConfig;
import utp.edu.pe.bfc.utils.DataAccess;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoComboDAO {

    private final Connection cnn;

    public ProductoComboDAO() throws SQLException, NamingException {
        this.cnn= DataAccess.getConnection(AppConfig.getDatasource());
    }
    public void close() throws SQLException{
        if(this.cnn !=null) DataAccess.closeConnection(this.cnn);
    }
    public void createProductoCombo(ProductoCombo productoCombo) throws SQLException{
        String query="INSER INTO productoCombo(producto, combo) VALUES(?,?)";
        try(PreparedStatement ps= cnn.prepareStatement(query)){
            ps.setInt(1,productoCombo.getProducto().getProductoId());
            ps.setInt(2,productoCombo.getCombo().getComboId());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e);
        }
    }
    public ProductoCombo getProductoCombo(int productoComboId) throws SQLException{
        String query="SELECT * FROM productoCombo WHERE productoComboId= ?";
        try (PreparedStatement ps = cnn.prepareStatement(query)){
            ps.setInt(1,productoComboId);
            try(ResultSet rs = ps.executeQuery()){
                ProductoDAO productoDAO= new ProductoDAO();
                ComboDAO comboDAO= new ComboDAO();
                if(rs.next()){
                    ProductoCombo productoCombo = new ProductoCombo();
                    productoCombo.setProductoComboId(rs.getInt("productoComboId"));
                    int productoId = rs.getInt("producto");
                    int comboId = rs.getInt("combo");
                    productoCombo.setProducto(productoDAO.getProducto(productoId));
                    productoCombo.setCombo(comboDAO.getCombo(comboId));

                    return productoCombo;
                }
            }
        }catch (SQLException | NamingException e) {
            throw new SQLException(e);

        }return null;
    }
    public void updateProductoCombo(ProductoCombo productoCombo) throws SQLException{
        String query="UPDATE productoCombo SET producto= ?,combo= ?";
        try(PreparedStatement ps= cnn.prepareStatement(query)){
            ps.setInt(1,productoCombo.getProducto().getProductoId());
            ps.setInt(2,productoCombo.getCombo().getComboId());
            ps.setInt(3,productoCombo.getProductoComboId());
            ps.executeUpdate();
        } catch (SQLException e){
            throw new SQLException(e);
        }
    }

    public void deleteProductoCombo(int productoComboId) throws SQLException{
        String query= "DELETE FROM productoCombo WHERE productoComboId = ?";
        try(PreparedStatement ps= cnn.prepareStatement(query)){
            ps.setInt(1,productoComboId);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new SQLException(e);
        }
    }

    public List<ProductoCombo> getAllAProductoCombos(){
        List<ProductoCombo> productoCombos= new ArrayList<>();
        String query= "SELECT * FROM productoCombo";
        try(PreparedStatement ps= cnn.prepareStatement(query);
            ResultSet rs= ps.executeQuery()){
            ProductoDAO productoDAO= new ProductoDAO();
            ComboDAO comboDAO= new ComboDAO();
            while (rs.next()){
                ProductoCombo productoCombo= new ProductoCombo();
                productoCombo.setProductoComboId(rs.getInt("pedidoDetalleId"));
                productoCombo.setProducto(productoDAO.getProducto(rs.getInt("productoId")));
                productoCombo.setCombo(comboDAO.getCombo(rs.getInt("comboId")));
                productoCombos.add(productoCombo);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }catch (NamingException e) {
            throw new RuntimeException(e);
        }
        return productoCombos;
    }

}