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

import java.io.IOException;

@WebServlet("/admin/actualizar-stock")
public class ActualizarStockServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String tipo = req.getParameter("tipo"); // producto o combo
        int id = Integer.parseInt(req.getParameter("id"));
        int cantidad = Integer.parseInt(req.getParameter("cantidad"));

        try {
            if ("producto".equals(tipo)) {
                ProductoDAO dao = new ProductoDAO();
                Producto p = dao.getProducto(id);
                int nuevoStock = p.getStock() + cantidad;
                dao.updateStock(id, nuevoStock);
                dao.close();
            } else if ("combo".equals(tipo)) {
                ComboDAO dao = new ComboDAO();
                Combo c = dao.getCombo(id);
                int nuevoStock = c.getStock() + cantidad;
                dao.updateStock(id, nuevoStock);
                dao.close();
            }

            resp.sendRedirect("inventario"); // o donde quieras volver
        } catch (Exception e) {
            req.setAttribute("message", "Error al actualizar stock: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
