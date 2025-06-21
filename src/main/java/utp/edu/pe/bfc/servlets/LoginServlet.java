package utp.edu.pe.bfc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utp.edu.pe.bfc.models.Carritoo;
import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.services.Auth;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String correo = req.getParameter("correo");
        String contrasena = req.getParameter("contrasena");
        try {
            Auth auth = new Auth();
            Usuario usuario = auth.isValidUsuario(correo, contrasena);

            if(usuario == null){
                req.setAttribute("isError", true);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("usuario", usuario);
                switch (usuario.getTipo()) {
                    case CLIENTE:
                        session.setAttribute("carrito", new ArrayList<Carritoo>());
                        session.setAttribute("usuario", usuario);
                        resp.sendRedirect("index.jsp");
                        break;

                    case ADMIN:
                        session.setAttribute("usuario", usuario);
                        resp.sendRedirect("admin/productos");
                        break;
                }
            }
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}

