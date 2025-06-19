package utp.edu.pe.bfc.servlets.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utp.edu.pe.bfc.dao.PedidoDAO;
import utp.edu.pe.bfc.dao.UsuarioDAO;
import utp.edu.pe.bfc.models.Pedido;
import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.models.enums.EstadoPedido;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/admin/actualizar-pedido")
public class ActualizarPedidoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            int usuarioId = Integer.parseInt(req.getParameter("usuarioid"));


            String fechaStr = req.getParameter("fecha");
            if (fechaStr == null || fechaStr.isEmpty()) {
                throw new IllegalArgumentException("La fecha es obligatoria");
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatter);

            String direccion = req.getParameter("direccion");
            float precio = Float.parseFloat(req.getParameter("precio"));
            EstadoPedido estado = EstadoPedido.valueOf(req.getParameter("estado"));

            Usuario usuario = new UsuarioDAO().obtenerUsuarioPorId(usuarioId);

            Pedido pedido = new Pedido();
            pedido.setPedidoId(id);
            pedido.setCliente(usuario);
            pedido.setFecha(fecha);
            pedido.setDireccion(direccion);
            pedido.setMonto(precio);
            pedido.setEstado(estado);
            HttpSession session = req.getSession();
            Usuario admin = (Usuario) session.getAttribute("usuario");
            if (admin != null) {
                pedido.setAdmin(admin);
            }
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.updatePedido(pedido);
            pedidoDAO.close();

            resp.sendRedirect("pedidos");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
