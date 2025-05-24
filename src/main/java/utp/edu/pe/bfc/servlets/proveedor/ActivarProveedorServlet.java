package utp.edu.pe.bfc.servlets.proveedor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.ProveedorDAO;
import utp.edu.pe.bfc.dao.UsuarioDAO;

import java.io.IOException;

@WebServlet("/admin/activar-proveedor")
public class ActivarProveedorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int proveedorId = Integer.parseInt(req.getParameter("id"));

        try {
            ProveedorDAO proveedorDAO = new ProveedorDAO();
            proveedorDAO.activeProveedor(proveedorId);
            proveedorDAO.close();
            resp.sendRedirect("proveedores");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
