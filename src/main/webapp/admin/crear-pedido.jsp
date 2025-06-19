<%@ page import="utp.edu.pe.bfc.models.enums.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Tipo" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Estado" %>
<%@ page import="utp.edu.pe.bfc.models.enums.EstadoPedido" %>
<%@ page import="utp.edu.pe.bfc.models.Pedido" %>
<%@ page import="utp.edu.pe.bfc.models.Usuario" %>
<%@ page import="utp.edu.pe.bfc.dao.UsuarioDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  UsuarioDAO usuarioDAO = new UsuarioDAO();
  List<EstadoPedido> estados= EstadoPedido.getEstados();
  List<Usuario> usuarios = usuarioDAO.getAllUsuarios();
%>
<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
  <div class="card">
    <div class="card-body">
      <div class="mb-6">
        <h4 class="card-title" style="font-weight: bold;">Registra un nuevo pedido</h4>
      </div>
      <form action="crear-pedido" method="post" enctype="multipart/form-data">
        <div class="mb-3">
        <label for="usuarioid" class="form-label">Selecciona el cliente</label>
        <select class="form-select" id="usuarioid" name="usuarioid" required>
          <option value="" disabled selected>Selecciona un cliente</option>
          <% if (usuarios != null && !usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) { %>
          <option value="<%= usuario.getUsuarioId() %>"><%= usuario.getNombreCompleto() %></option>
          <% }
          } else { %>
          <option disabled>No hay usuarios registrados</option>
          <% } %>
        </select>
      </div>
        <div class="mb-3">
          <label for="fecha" class="form-label">Ingresa la fecha</label>
          <input type="datetime-local" class="form-control" id="fecha" name="fecha"
                 aria-describedby="productName" required>
        </div>
        <div class="mb-3">
          <label for="direccion" class="form-label">Ingresa la dirección</label>
          <input type="text" class="form-control" id="direccion" name="direccion"
                 aria-describedby="productName" required>
        </div>
        <div class="mb-3">
          <label for="precio" class="form-label">Ingresa el monto</label>
          <input type="number" class="form-control" id="precio" name="precio"
                 aria-describedby="productPrice" required>
        </div>
        <div class="mb-3">
          <label for="estado" class="form-label">Ingresa el estado</label>
          <select name="estado" id="estado" class="form-select">
            <% for (EstadoPedido estado : estados) { %>
            <option value="<%= estado %>"><%= estado.getDisplayName() %></option>
            <% } %>
          </select>
        </div>

        <div style="display: flex; justify-content: space-between;">
          <button type="submit" class="btn btn-success">Registrar</button>
          <button class="btn btn-danger" onclick="history.back()">Cancelar</button>
        </div>
      </form>
    </div>
  </div>
</div>
<jsp:include page="components/footer.jsp"/>
