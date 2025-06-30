<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Producto" %>
<%@ page import="utp.edu.pe.bfc.models.Combo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    List<Combo> combos = (List<Combo>) request.getAttribute("combos");
%>

<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
    <%
        boolean hayAlertas = false;

        for (Producto p : productos) {
            if (p.getStock() <= 10) {
                hayAlertas = true;
                break;
            }
        }
        if (!hayAlertas) {
            for (Combo c : combos) {
                if (c.getStock() <= 10) {
                    hayAlertas = true;
                    break;
                }
            }
        }
    %>

    <% if (hayAlertas) { %>
    <div class="alert alert-danger d-flex align-items-center mt-4" role="alert" style="border-radius: 8px;">
        <i class="bi bi-exclamation-triangle-fill me-2 fs-5"></i>
        <div>
            <strong>¡Atención!</strong> Hay productos o combos con stock bajo (≤ 10) o agotados.
            Revisa el inventario para reabastecerlos.
        </div>
    </div>
    <% } %>
    <h4 class="mb-4">Inventario de Productos</h4>
    <div class="table-responsive mb-5">
        <table class="table text-center">
            <thead class="table-dark">
            <tr>
                <th>Imagen</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Categoría</th>
                <th>Stock</th>
                <th>Agregar Stock</th>
            </tr>
            </thead>


            <tbody>
            <% for (Producto producto : productos) {
                int stock = producto.getStock();
                String rowStyle = "";
                if (stock == 0) {
                    rowStyle = "background-color: #343a40; color: white;"; // negro oscuro
                } else if (stock <= 10) {
                    rowStyle = "background-color: #f8d7da;"; // rojo claro
                }
            %>
            <tr style="<%= rowStyle %>">
                <td>
                    <img src="image?img=<%= producto.getImagen() %>"
                         width="60" height="60"
                         style="border-radius: 999px;">
                </td>
                <td><%= producto.getNombre() %></td>
                <td>S/<%= producto.getPrecio() %></td>
                <td><%= producto.getCategoria().getDisplayName() %></td>
                <td><%= producto.getStock() %></td>
                <td>
                    <form method="post" action="actualizar-stock" class="d-flex justify-content-center">
                        <input type="hidden" name="tipo" value="producto">
                        <input type="hidden" name="id" value="<%= producto.getProductoId() %>">
                        <input type="number" name="cantidad" min="1" class="form-control form-control-sm me-2" style="width: 70px;" required>
                        <button type="submit" class="btn btn-success btn-sm">+</button>
                    </form>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>

    <h4 class="mb-4">Inventario de Combos</h4>
    <div class="table-responsive">
        <table class="table text-center">
            <thead class="table-dark">
            <tr>
                <th>Imagen</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Categoría</th>
                <th>Stock</th>
                <th>Agregar Stock</th>
            </tr>
            </thead>


            <tbody>
            <% for (Combo combo : combos) {
                int stock = combo.getStock();
                String rowStyle = "";
                if (stock == 0) {
                    rowStyle = "background-color: #343a40; color: white;";
                } else if (stock <= 10) {
                    rowStyle = "background-color: #f8d7da;";
                }
            %>
            <tr style="<%= rowStyle %>">
                <td>
                    <img src="image?img=<%= combo.getImagen() %>"
                         width="60" height="60"
                         style="border-radius: 999px;">
                </td>
                <td><%= combo.getNombre() %></td>
                <td>S/<%= combo.getPrecio() %></td>
                <td><%= combo.getCategoria().getDisplayName() %></td>
                <td><%= combo.getStock() %></td>
                <td>
                    <form method="post" action="actualizar-stock" class="d-flex justify-content-center">
                        <input type="hidden" name="tipo" value="combo">
                        <input type="hidden" name="id" value="<%= combo.getComboId() %>">
                        <input type="number" name="cantidad" min="1" class="form-control form-control-sm me-2" style="width: 70px;" required>
                        <button type="submit" class="btn btn-success btn-sm">+</button>
                    </form>
                </td>
            </tr>
            <% } %>


            </tbody>
        </table>
    </div>
</div>

<jsp:include page="components/footer.jsp"/>