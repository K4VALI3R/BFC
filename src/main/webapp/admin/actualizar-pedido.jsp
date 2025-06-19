<%@ page import="utp.edu.pe.bfc.models.enums.EstadoPedido" %>
<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Pedido" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Tipo" %>
<%@ page import="utp.edu.pe.bfc.models.Usuario" %>
<%@ page import="utp.edu.pe.bfc.dao.UsuarioDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    List<Usuario> usuarios = usuarioDAO.getAllUsuarios();
    List<EstadoPedido> estados = EstadoPedido.getEstados();
    Pedido pedido = (Pedido) request.getAttribute("pedido");
%>

<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
    <div class="card">
        <div class="card-body">
            <div class="mb-6">
                <h4 class="card-title" style="font-weight: bold;">Actualiza el pedido</h4>
            </div>
            <form action="actualizar-pedido" method="post">
                <input type="hidden" name="id" value="<%= pedido.getPedidoId() %>">

                <!-- Cliente -->
                <div class="mb-3">
                    <label for="usuarioid" class="form-label">Selecciona el cliente</label>
                    <select class="form-select" id="usuarioid" name="usuarioid" required>
                        <option value="" disabled>Selecciona un cliente</option>
                        <% if (usuarios != null && !usuarios.isEmpty()) {
                            for (Usuario usuario : usuarios) { %>
                        <option value="<%= usuario.getUsuarioId() %>"
                                <%= (pedido.getCliente() != null && usuario.getUsuarioId() == pedido.getCliente().getUsuarioId()) ? "selected" : "" %>>
                            <%= usuario.getNombreCompleto() %>
                        </option>
                        <% }
                        } else { %>
                        <option disabled>No hay usuarios registrados</option>
                        <% } %>
                    </select>
                </div>

                <!-- Fecha -->
                <div class="mb-3">
                    <label for="fecha" class="form-label">Ingresa la fecha</label>
                    <input type="datetime-local" class="form-control" id="fecha" name="fecha"
                           value="<%= pedido.getFecha().toString().replace(' ', 'T').substring(0, 16) %>" required>
                </div>

                <!-- Dirección -->
                <div class="mb-3">
                    <label for="direccion" class="form-label">Ingresa la dirección</label>
                    <input type="text" class="form-control" id="direccion" name="direccion"
                           value="<%= pedido.getDireccion() %>" required>
                </div>

                <!-- Precio -->
                <div class="mb-3">
                    <label for="precio" class="form-label">Ingresa el monto</label>
                    <input type="number" class="form-control" id="precio" name="precio"
                           value="<%= pedido.getMonto() %>" required>
                </div>

                <!-- Estado -->
                <div class="mb-3">
                    <label for="estado" class="form-label">Selecciona el estado</label>
                    <select name="estado" id="estado" class="form-select" required>
                        <% for (EstadoPedido estado : estados) { %>
                        <option value="<%= estado.name() %>"
                                <%= estado == pedido.getEstado() ? "selected" : "" %>>
                            <%= estado.getDisplayName() %>
                        </option>
                        <% } %>
                    </select>
                </div>

                <!-- Botones -->
                <div style="display: flex; justify-content: space-between;">
                    <button type="submit" class="btn btn-warning">Actualizar</button>
                    <button class="btn btn-danger" onclick="history.back()">Cancelar</button>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="components/footer.jsp"/>
