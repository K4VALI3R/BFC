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
                    int cantidadActual = item.getCantidad();
                    int stockDisponible = 0;

                    try {
                        if ("producto".equals(tipo)) {
                            Producto prod = new ProductoDAO().getProducto(id);
                            stockDisponible = prod.getStock();
                        } else {
                            Combo combo = new ComboDAO().getCombo(id);
                            stockDisponible = combo.getStock();
                        }
                    } catch (SQLException | NamingException e) {
                        throw new RuntimeException(e);
                    }

                    if (cantidadActual < stockDisponible) {
                        item.setCantidad(cantidadActual + 1);
                    }
                    // Si ya no hay stock disponible, no se aumenta
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                try {
                    if ("producto".equals(tipo)) {
                        Producto prod = new ProductoDAO().getProducto(id);
                        if (prod.getStock() > 0) {
                            carrito.add(new Carritoo("producto", id, prod.getNombre(), (float) prod.getPrecio(), 1));
                        }
                    } else {
                        Combo combo = new ComboDAO().getCombo(id);
                        if (combo.getStock() > 0) {
                            carrito.add(new Carritoo("combo", id, combo.getNombre(), (float) combo.getPrecio(), 1));
                        }
                    }
                } catch (SQLException | NamingException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        session.setAttribute("carrito", carrito);
        resp.sendRedirect("carrito.jsp");
    }
}


