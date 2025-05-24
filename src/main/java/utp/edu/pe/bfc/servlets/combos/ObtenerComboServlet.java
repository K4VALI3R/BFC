package utp.edu.pe.bfc.servlets.combos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.ComboDAO;
import utp.edu.pe.bfc.dao.ProductoDAO;

import java.io.IOException;

@WebServlet("/admin/obtener-combo")
public class ObtenerComboServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int comboId = Integer.parseInt(req.getParameter("id"));
            ComboDAO comboDAO = new ComboDAO();
            req.setAttribute("combo", comboDAO.getCombo(comboId));
            comboDAO.close();
            req.getRequestDispatcher("actualizar-combo.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}