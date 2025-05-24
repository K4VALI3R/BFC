package utp.edu.pe.bfc.servlets.proveedor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.ProveedorDAO;

import java.io.IOException;

@WebServlet("/admin/redireccionar-proveedor")
public class RedireccionarProveedorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            ProveedorDAO proveedorDAO = new ProveedorDAO();
            req.setAttribute("proveedor", proveedorDAO.getProveedor(id));
            proveedorDAO.close();
            req.getRequestDispatcher("actualizar-proveedor.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}