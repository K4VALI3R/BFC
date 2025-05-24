package utp.edu.pe.bfc.servlets.combos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.ComboDAO;
import utp.edu.pe.bfc.dao.ProductoDAO;

import java.io.IOException;

@WebServlet("/admin/activar-combo")
public class ActivarComboServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int comboId = Integer.parseInt(req.getParameter("id"));

        try {
            ComboDAO comboDAO = new ComboDAO();
            comboDAO.activeCombo(comboId);
            comboDAO.close();
            resp.sendRedirect("combos");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}