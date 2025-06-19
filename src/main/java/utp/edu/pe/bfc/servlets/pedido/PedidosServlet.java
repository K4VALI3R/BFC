package utp.edu.pe.bfc.servlets.pedido;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.PedidoDAO;
import utp.edu.pe.bfc.models.Pedido;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/pedidos")
public class PedidosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PedidoDAO pedidoDAO = new PedidoDAO();

            req.setAttribute("pedidos", pedidoDAO.getAllPedidos());
            pedidoDAO.close();

            req.getRequestDispatcher("pedidos.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}