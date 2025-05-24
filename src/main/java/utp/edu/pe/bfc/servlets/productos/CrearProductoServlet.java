package utp.edu.pe.bfc.servlets.productos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import utp.edu.pe.bfc.dao.ProductoDAO;
import utp.edu.pe.bfc.models.Producto;
import utp.edu.pe.bfc.models.enums.Categoria;
import utp.edu.pe.bfc.utils.AppConfig;
import utp.edu.pe.bfc.utils.UTPBinary;

import java.io.IOException;

@MultipartConfig
@WebServlet("/admin/crear-producto")
public class CrearProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nombre = req.getParameter("nombre");
            float precio = Float.parseFloat(req.getParameter("precio"));
            Part filePart = req.getPart("imagen");
            Categoria categoria = Categoria.valueOf(req.getParameter("categoria"));

            String imgDir = AppConfig.getImageDir();

            byte[] fileContent = filePart.getInputStream().readAllBytes();
            UTPBinary.echobin(fileContent, imgDir+"/"+ nombre + ".jpg");

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setImagen(nombre);
            producto.setCategoria(categoria);

            ProductoDAO productoDAO = new ProductoDAO();
            productoDAO.createProducto(producto);
            productoDAO.close();
            resp.sendRedirect("productos");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
