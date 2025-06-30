package utp.edu.pe.bfc.servlets;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import utp.edu.pe.bfc.dao.ComboDAO;
import utp.edu.pe.bfc.dao.ProductoDAO;
import utp.edu.pe.bfc.models.Combo;
import utp.edu.pe.bfc.models.Producto;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/inventario")
public class InventarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            ProductoDAO productoDAO = new ProductoDAO();
            ComboDAO comboDAO = new ComboDAO();

            List<Producto> productos = productoDAO.getAllAProductos();
            List<Combo> combos = comboDAO.getAllACombos();

            productoDAO.close();
            comboDAO.close();

            req.setAttribute("productos", productos);
            req.setAttribute("combos", combos);

            req.getRequestDispatcher("inventario.jsp").forward(req, resp);
        } catch (SQLException | NamingException e) {
            req.setAttribute("message", "Error al cargar inventario: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
