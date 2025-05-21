package utp.edu.pe.bfc.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccess {

    public enum TipoDA {DATASOURCE, CLASS_FORNAME};

    public static Connection getConnection(String cnx) throws SQLException, NamingException {
        Connection conn = null;
        TipoDA tipoDA = TipoDA.CLASS_FORNAME;   // DEFAULT METHOD
        try {
            if (tipoDA == TipoDA.DATASOURCE) {
                conn = ((DataSource) InitialContext.doLookup(cnx)).getConnection();
            } else {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Updated to MySQL driver
                conn = DriverManager.getConnection(cnx);
            }
        } catch (NamingException e) {
            throw new NamingException(e.getExplanation());
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static Connection getConnection(TipoDA tipoDA, String cnx) throws SQLException, NamingException {
        Connection conn = null;
        try {
            if (tipoDA == TipoDA.DATASOURCE) {
                conn = ((DataSource) InitialContext.doLookup(cnx)).getConnection();
            } else {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Updated to MySQL driver
                conn = DriverManager.getConnection(cnx);
            }
        } catch (NamingException e) {
            throw new NamingException(e.getExplanation());
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static ResultSet querySQL(Connection conn, String sql) throws SQLException {
        ResultSet rst = null;
        try {
            rst = conn.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return rst;
    }

    public static void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}