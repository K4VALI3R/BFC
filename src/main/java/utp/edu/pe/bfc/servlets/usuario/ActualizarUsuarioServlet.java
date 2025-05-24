package utp.edu.pe.bfc.servlets.usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.UsuarioDAO;
import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.models.enums.Estado;
import utp.edu.pe.bfc.models.enums.Tipo;

import java.io.IOException;

@WebServlet("/admin/actualizar-usuario")
public class ActualizarUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String nombreCompleto = req.getParameter("nombreCompleto");
            String email = req.getParameter("email");
            String password = req.getParameter("contrasena");
            String tipo = req.getParameter("tipo");
            String telefono = req.getParameter("telefono");
            Estado estado = Estado.valueOf(req.getParameter("estado"));

            Usuario usuario = new Usuario();
            usuario.setUsuarioId(id);
            usuario.setNombreCompleto(nombreCompleto);
            usuario.setCorreo(email);
            usuario.setContrasena(password);
            usuario.setTipo(Tipo.valueOf(tipo));
            usuario.setTelefono(telefono);
            usuario.setEstado(estado);

            UsuarioDAO usuarioDAO= new UsuarioDAO();
            usuarioDAO.actualizarUsuario(usuario);
            usuarioDAO.close();
            resp.sendRedirect("usuarios");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
