package utp.edu.pe.bfc.servlets.productos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.ProductoDAO;
import utp.edu.pe.bfc.models.Producto;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/admin/productos")
public class ProductosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Inicializas el acceso a base de datos
            ProductoDAO productoDAO = new ProductoDAO();
            // Inicializas la lista de productos y la recuperas de la base de datos
            List<Producto> productos = productoDAO.getAllAProductos();
            // Cerramos la conexión a la base de datos
            productoDAO.close();
            // Defines el parámetro que vas a enviar al JSP
            req.setAttribute("productos", productos);
            // Redireccionas al usuario al JSP
            req.getRequestDispatcher("productos.jsp").forward(req, resp);
        } catch (SQLException | NamingException e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}