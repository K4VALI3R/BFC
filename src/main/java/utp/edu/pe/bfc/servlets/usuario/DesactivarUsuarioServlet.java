package utp.edu.pe.bfc.servlets.usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.ProductoDAO;
import utp.edu.pe.bfc.dao.UsuarioDAO;

import java.io.IOException;

@WebServlet("/admin/desactivar-usuario")
public class DesactivarUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usuarioId = Integer.parseInt(req.getParameter("id"));

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.inactiveUsuario(usuarioId);
            usuarioDAO.close();
            resp.sendRedirect("usuarios");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
