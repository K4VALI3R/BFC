package utp.edu.pe.bfc.servlets.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.PedidoDAO;
import utp.edu.pe.bfc.models.Pedido;
import utp.edu.pe.bfc.models.PedidoDetalle;

import java.io.IOException;

@WebServlet("/admin/redireccionar-pedido")
public class RedireccionarPedidoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idStr = req.getParameter("id");
            if (idStr == null || idStr.isEmpty()) {
                throw new IllegalArgumentException("ID de pedido no proporcionado");
            }
            int id = Integer.parseInt(idStr);

            PedidoDAO pedidoDao = new PedidoDAO();
            req.setAttribute("pedido", pedidoDao.getPedido(id));
            pedidoDao.close();
            req.getRequestDispatcher("actualizar-pedido.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}