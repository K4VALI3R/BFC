package utp.edu.pe.bfc.servlets.combos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import utp.edu.pe.bfc.dao.ComboDAO;
import utp.edu.pe.bfc.dao.ProductoDAO;
import utp.edu.pe.bfc.models.Combo;
import utp.edu.pe.bfc.models.Producto;
import utp.edu.pe.bfc.models.enums.Categoria;
import utp.edu.pe.bfc.models.enums.Estado;
import utp.edu.pe.bfc.utils.AppConfig;
import utp.edu.pe.bfc.utils.UTPBinary;

import java.io.IOException;

@MultipartConfig
@WebServlet("/admin/actualizar-combo")
public class ActualizarComboServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int comboId = Integer.parseInt(req.getParameter("id"));
            String nombre = req.getParameter("nombre");
            float precio = Float.parseFloat(req.getParameter("precio"));
            Part filePart = req.getPart("imagen");
            Categoria categoria = Categoria.valueOf(req.getParameter("categoria"));
            Estado estado = Estado.valueOf(req.getParameter("estado"));

            String imgDir = AppConfig.getImageDir();

            byte[] fileContent = filePart.getInputStream().readAllBytes();
            UTPBinary.echobin(fileContent, imgDir + "/" + nombre + ".jpg");

            Combo combo = new Combo();
            combo.setComboId(comboId);
            combo.setNombre(nombre);
            combo.setPrecio(precio);
            combo.setImagen(nombre);
            combo.setCategoria(categoria);
            combo.setEstado(estado);

            ComboDAO comboDAO = new ComboDAO();
            comboDAO.updateCombo(combo);
            comboDAO.close();
            resp.sendRedirect("combos");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
