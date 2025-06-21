package utp.edu.pe.bfc.servlets.pedido;

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
import java.util.List;


@WebServlet("/confirmar-pedido")
    public class ConfirmarPedidoServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            HttpSession session = req.getSession(false);
            if (session == null || session.getAttribute("usuario") == null) {
                resp.sendRedirect("login.jsp");
                return;
            }

            Usuario usuario = (Usuario) session.getAttribute("usuario");
            List<Carritoo> carrito = (List<Carritoo>) session.getAttribute("carrito");

            if (carrito == null || carrito.isEmpty()) {
                req.setAttribute("message", "Carrito vacío");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }

            try {
                // 1. Crear el pedido principal
                Pedido pedido = new Pedido();
                pedido.setCliente(usuario); // asegúrate de que cliente venga de tipo Usuario
                pedido.setDireccion(req.getParameter("direccion")); // deberías tener un input para esto
                pedido.setEstado(EstadoPedido.IN_PROGRESS);

                PedidoDAO pedidoDAO = new PedidoDAO();
                int pedidoId = pedidoDAO.createPedidoAndReturnId(pedido); // retorna el ID del pedido generado
                pedido.setPedidoId(pedidoId);

                // 2. Insertar detalles del pedido
                PedidoDetalleDAO pedidoDetalleDAO = new PedidoDetalleDAO();
                ProductoDAO productoDAO = new ProductoDAO();
                ComboDAO comboDAO = new ComboDAO();

                for (Carritoo item : carrito) {
                    PedidoDetalle detalle = new PedidoDetalle();
                    detalle.setPedido(pedido);
                    detalle.setCantidad(item.getCantidad());
                    detalle.setSubtotal(item.getSubtotal());


                    if (item.getTipo().equals("producto")) {
                        detalle.setProducto(productoDAO.getProducto(item.getId()));
                    } else {
                        detalle.setCombo(comboDAO.getCombo(item.getId()));
                    }

                    pedidoDetalleDAO.createPedidoDetalle(detalle);
                }

                pedidoDetalleDAO.close();
                pedidoDAO.close();

                // 3. Limpiar el carrito
                session.removeAttribute("carrito");

                resp.sendRedirect("pedido-confirmado.jsp");

            } catch (Exception e) {
                req.setAttribute("message", "Error al confirmar pedido: " + e.getMessage());
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }
    }

