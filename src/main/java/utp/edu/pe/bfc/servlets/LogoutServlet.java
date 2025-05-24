package utp.edu.pe.bfc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utp.edu.pe.bfc.models.Usuario;

import java.io.IOException;

@WebServlet(name = "logout", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            resp.sendRedirect("index.jsp");
        } else {
            String usertype = usuario.getTipo().toString();
            try {
                session.invalidate();

                if ("ADMIN".equals(usertype)) {
                    resp.sendRedirect("./index.jsp");
                } else {
                    resp.sendRedirect("index.jsp");
                }

            } catch (Exception e) {
                req.setAttribute("message", e.getMessage());
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }
    }
}