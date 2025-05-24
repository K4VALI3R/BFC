package utp.edu.pe.bfc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.UsuarioDAO;

import java.io.IOException;

@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("usuarioId"));

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            req.setAttribute("usuario", usuarioDAO.obtenerUsuarioPorId(id));
            usuarioDAO.close();
            req.getRequestDispatcher("perfil.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}