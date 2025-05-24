package utp.edu.pe.bfc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utp.edu.pe.bfc.dao.UsuarioDAO;
import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.models.enums.Tipo;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "singin", urlPatterns = {"/singin"})
public class SinginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombreCompleto = req.getParameter("nombreCompleto");
        String email = req.getParameter("correo");
        String phone = req.getParameter("telefono");
        String pwd = req.getParameter("contrasena");

        try {
            Usuario usuario = new Usuario();
            usuario.setNombreCompleto(nombreCompleto);
            usuario.setCorreo(email);
            usuario.setTelefono(phone);
            usuario.setContrasena(pwd);
            usuario.setTipo(Tipo.CLIENTE);

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.createUsuario(usuario);

            HttpSession session = req.getSession();
            HashMap<Integer, Integer> carrito = new HashMap<>();
            session.setAttribute("carrito", carrito);

            usuario = usuarioDAO.obtenerUsuarioPorCorreo(email);
            session.setAttribute("usuario", usuario);
            resp.sendRedirect("index.jsp");

        } catch (Exception e) {
            String msg = "Error al registrarte";
            req.setAttribute("message", msg + ". " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}