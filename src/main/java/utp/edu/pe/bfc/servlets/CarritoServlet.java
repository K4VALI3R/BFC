package utp.edu.pe.bfc.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import utp.edu.pe.bfc.dao.ComboDAO;
import utp.edu.pe.bfc.dao.ProductoDAO;
import utp.edu.pe.bfc.models.Carritoo;
import utp.edu.pe.bfc.models.Combo;
import utp.edu.pe.bfc.models.Producto;
import utp.edu.pe.bfc.models.Usuario;


import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utp.edu.pe.bfc.models.enums.Tipo;

import javax.naming.NamingException;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario.getTipo() != Tipo.CLIENTE) {
            resp.sendRedirect("login.jsp");
            return;
        }

        List<Carritoo> carrito = (List<Carritoo>) session.getAttribute("carrito");
        if (carrito == null) carrito = new ArrayList<>();

        String accion = req.getParameter("accion");
        String tipo = req.getParameter("tipo"); // "producto" o "combo"
        int id = Integer.parseInt(req.getParameter("id"));

        if ("eliminar".equals(accion)) {
            // Elimina todo el ítem (no solo reduce la cantidad)
            carrito.removeIf(item -> item.getId() == id && item.getTipo().equals(tipo));
        } else {
            boolean encontrado = false;
            for (Carritoo item : carrito) {
                if (item.getId() == id && item.getTipo().equals(tipo)) {
                    item.setCantidad(item.getCantidad() + 1);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                if ("producto".equals(tipo)) {
                    Producto prod = null;
                    try {
                        prod = new ProductoDAO().getProducto(id);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (NamingException e) {
                        throw new RuntimeException(e);
                    }
                    carrito.add(new Carritoo("producto", id, prod.getNombre(), (float) prod.getPrecio(), 1));
                } else {
                    Combo comb = null;
                    try {
                        comb = new ComboDAO().getCombo(id);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (NamingException e) {
                        throw new RuntimeException(e);
                    }
                    carrito.add(new Carritoo("combo", id, comb.getNombre(), (float) comb.getPrecio(), 1));
                }
            }
        }

        session.setAttribute("carrito", carrito);
        resp.sendRedirect("carrito.jsp");
    }
}


