package utp.edu.pe.bfc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utp.edu.pe.bfc.dao.ComboDAO;
import utp.edu.pe.bfc.dao.PedidoDAO;
import utp.edu.pe.bfc.dao.PedidoDetalleDAO;
import utp.edu.pe.bfc.dao.ProductoDAO;
import utp.edu.pe.bfc.models.Carritoo;
import utp.edu.pe.bfc.models.Pedido;
import utp.edu.pe.bfc.models.PedidoDetalle;
import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.models.enums.EstadoPedido;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/confirmar-pago")
public class ConfirmarPagoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Usuario cliente = (Usuario) session.getAttribute("usuario");
        List<Carritoo> carrito = (List<Carritoo>) session.getAttribute("carrito");
        String direccion = req.getParameter("direccion");

        if (cliente == null || carrito == null || carrito.isEmpty()) {
            resp.sendRedirect("carrito.jsp");
            return;
        }

        try {
            // Crear el pedido
            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setFecha(LocalDateTime.now());
            pedido.setDireccion(direccion);
            pedido.setEstado(EstadoPedido.IN_PROGRESS);

            double total = carrito.stream().mapToDouble(Carritoo::getSubtotal).sum();
            pedido.setMonto(total);

            Usuario admin = (Usuario) session.getAttribute("usuarioAdmin"); // opcional
            pedido.setAdmin(admin);

            PedidoDAO pedidoDAO = new PedidoDAO();
            int pedidoId = pedidoDAO.createPedidoAndReturnId(pedido);
            pedido.setPedidoId(pedidoId);

            // Guardar detalles
            PedidoDetalleDAO detalleDAO = new PedidoDetalleDAO();
            ProductoDAO productoDAO = new ProductoDAO();
            ComboDAO comboDAO = new ComboDAO();

            List<PedidoDetalle> detalles = new ArrayList<>();

            for (Carritoo item : carrito) {
                PedidoDetalle detalle = new PedidoDetalle();
                detalle.setPedido(pedido);
                detalle.setCantidad(item.getCantidad());
                detalle.setSubtotal(item.getSubtotal());


                if ("producto".equalsIgnoreCase(item.getTipo())) {
                    detalle.setProducto(productoDAO.getProducto(item.getId()));
                } else if ("combo".equalsIgnoreCase(item.getTipo())) {
                    detalle.setCombo(comboDAO.getCombo(item.getId()));
                }


                detalleDAO.createPedidoDetalle(detalle);
                detalles.add(detalle);
            }

            session.removeAttribute("carrito"); // Limpiar el carrito
            req.setAttribute("pedido", pedido);
            req.setAttribute("detalles", detalles); // deberás crear esta lista
            req.setAttribute("mensaje", "¡Tu pedido está en proceso!");
            session.setAttribute("pedido", pedido);
            session.setAttribute("detalles", detalles);
            req.getRequestDispatcher("pedido_exito.jsp").forward(req, resp); // Ir al dashboard

        } catch (Exception e) {
            req.setAttribute("message", "Error al confirmar el pedido: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}