package utp.edu.pe.bfc.servlets.proveedor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utp.edu.pe.bfc.dao.ProveedorDAO;
import utp.edu.pe.bfc.dao.UsuarioDAO;
import utp.edu.pe.bfc.models.Proveedor;
import utp.edu.pe.bfc.models.Usuario;
import utp.edu.pe.bfc.models.enums.Estado;
import utp.edu.pe.bfc.models.enums.Tipo;

import java.io.IOException;

@WebServlet("/admin/crear-proveedor")
public class CrearProveedorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nombreEmpresa = req.getParameter("nombreEmpresa");
            String ruc = req.getParameter("ruc");
            String direccion = req.getParameter("direccion");
            String telefono = req.getParameter("telefono");
            String correo = req.getParameter("correo");
            String descripcion = req.getParameter("descripcion");
            String delegado = req.getParameter("delegado");

            Proveedor proveedor = new Proveedor();
            proveedor.setNombreEmpresa(nombreEmpresa);
            proveedor.setRuc(ruc);
            proveedor.setDireccion(direccion);
            proveedor.setTelefono(telefono);
            proveedor.setCorreo(correo);
            proveedor.setDescripcion(descripcion);
            proveedor.setDelegado(delegado);
            proveedor.setEstado(Estado.ACTIVE);

            ProveedorDAO proveedorDAO = new ProveedorDAO();
            proveedorDAO.createProveedor(proveedor);
            proveedorDAO.close();

            resp.sendRedirect("proveedores");
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}