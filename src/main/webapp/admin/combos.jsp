<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Producto" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Estado" %>
<%@ page import="utp.edu.pe.bfc.models.Combo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Combo> combos = (List<Combo>) request.getAttribute("combos");
%>
<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
    <div class="card">
        <div class="card-body">
            <div>
                <button type="button" class="btn btn-success m-1" onclick="location.href='crear-combo.jsp'">Agregar combo</button>
            </div>
            <div class="table-responsive">
                <table class="table text-center table-responsive justify-content-center align-items-center">
                    <thead>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Imagen</th>
                    <th>Categoria</th>
                    <th>Estado</th>
                    <th>Acción</th>
                    </thead>
                    <tbody>
                    <% if (!combos.isEmpty()) { %>
                    <tr>
                        <% for (Combo combo : combos) { %>
                        <td><%= combo.getComboId() %></td>
                        <td><%= combo.getNombre() %></td>
                        <td><%= combo.getPrecio() %></td>
                        <td><img src="image?img=<%= combo.getImagen() %>" width="50" height="50" style="border-radius: 999px"/></td>
                        <td><%= combo.getCategoria().getDisplayName() %></td>
                        <% if (combo.getEstado().equals(Estado.ACTIVE)) { %>
                        <td style="color:green"><%= combo.getEstado().getDisplayName() %></td>
                        <% } else { %>
                        <td style="color:red"><%= combo.getEstado().getDisplayName() %></td>
                        <% } %>
                        <td>
                            <a
                                    type="button"
                                    class="btn btn-primary m-1"
                                    href="obtener-combo?id=<%= combo.getComboId() %>"
                            >Editar</a>
                            <% if (combo.getEstado().equals(Estado.ACTIVE)) { %>
                            <a
                                    type="button"
                                    class="btn btn-danger m-1"
                                    href="desactivar-combo?id=<%= combo.getComboId() %>"
                            >Desactivar</a>
                            <% } else { %>
                            <a
                                    type="button"
                                    class="btn btn-success m-1"
                                    href="activar-combo?id=<%= combo.getComboId() %>"
                            >Activar</a>
                            <% } %>
                        </td>
                        <% } %>
                    </tr>
                    <% } else { %>
                    <tr>
                        <td colspan="6">No se encontraron productos en la base de datos</td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<jsp:include page="components/footer.jsp"/>