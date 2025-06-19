package utp.edu.pe.bfc.servlets.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utp.edu.pe.bfc.dao.PedidoDAO;
import utp.edu.pe.bfc.dao.UsuarioDAO;
import utp.edu.pe.bfc.models.Pedido;
import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.models.enums.EstadoPedido;

import java.io.IOException;
import java.rmi.ServerException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@MultipartConfig
@WebServlet("/admin/crear-pedido")
public class CrearPedidoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> usuarios = usuarioDAO.getAllUsuarios();
            req.setAttribute("usuarios", usuarios);
            req.getRequestDispatcher("/admin/crear-pedido.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int usuarioId = Integer.parseInt(req.getParameter("usuarioid"));
            String fechaStr = req.getParameter("fecha");
            if (fechaStr == null || fechaStr.isEmpty()) {
                throw new IllegalArgumentException("La fecha es obligatoria");
            }

            LocalDateTime fecha = LocalDateTime.parse(fechaStr);
            String direccion = req.getParameter("direccion");
            float precio = Float.parseFloat(req.getParameter("precio"));
            EstadoPedido estado = EstadoPedido.valueOf(req.getParameter("estado"));

            Usuario usuario = new UsuarioDAO().obtenerUsuarioPorId(usuarioId);

            Pedido pedido = new Pedido();
            pedido.setCliente(usuario);
            pedido.setFecha(fecha);
            pedido.setDireccion(direccion);
            pedido.setMonto(precio);
            pedido.setEstado(estado);

            HttpSession session = req.getSession();
            Usuario admin = (Usuario) session.getAttribute("usuario");
            pedido.setAdmin(admin);
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.createPedido(pedido);
            pedidoDAO.close();

            resp.sendRedirect("pedidos"); // ✅ redirige a lista de pedidos

        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
