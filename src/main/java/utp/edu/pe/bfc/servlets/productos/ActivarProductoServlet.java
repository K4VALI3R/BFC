package utp.edu.pe.bfc.servlets.productos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.ProductoDAO;

import java.io.IOException;

@WebServlet("/admin/activar-producto")
public class ActivarProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productoId = Integer.parseInt(req.getParameter("id"));

        try {
            ProductoDAO productoDAO = new ProductoDAO();
            productoDAO.activateProducto(productoId);
            productoDAO.close();
            resp.sendRedirect("productos");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}