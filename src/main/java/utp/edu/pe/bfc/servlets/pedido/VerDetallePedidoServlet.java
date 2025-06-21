package utp.edu.pe.bfc.servlets.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utp.edu.pe.bfc.dao.PedidoDAO;
import utp.edu.pe.bfc.dao.PedidoDetalleDAO;
import utp.edu.pe.bfc.models.Pedido;
import utp.edu.pe.bfc.models.PedidoDetalle;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/ver-detalle-pedido")
public class VerDetallePedidoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int pedidoId = Integer.parseInt(req.getParameter("id"));

            PedidoDAO pedidoDAO = new PedidoDAO();
            Pedido pedido = pedidoDAO.getPedido(pedidoId);
            pedidoDAO.close();

            PedidoDetalleDAO detalleDAO = new PedidoDetalleDAO();
            List<PedidoDetalle> detalles = detalleDAO.getDetallesByPedido(pedidoId);
            detalleDAO.close();

            req.setAttribute("pedido", pedido);
            req.setAttribute("detalles", detalles);

            req.getRequestDispatcher("ver-detalle-pedido.jsp").forward(req, resp);
        } catch (SQLException | NamingException e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}