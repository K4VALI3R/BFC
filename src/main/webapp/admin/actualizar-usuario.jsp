<%@ page import="utp.edu.pe.bfc.models.enums.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Tipo" %>
<%@ page import="utp.edu.pe.bfc.models.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Tipo> tipos = Tipo.getTipos();
  Usuario usuario = (Usuario) request.getAttribute("usuario");
%>
<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
  <div class="card">
    <div class="card-body">
      <div class="mb-6">
        <h4 class="card-title" style="font-weight: bold;">Actualiza el usuario</h4>
      </div>
      <form action="actualizar-usuario" method="post">
        <input type="hidden" name="id" value="<%= usuario.getUsuarioId() %>">
        <input type="hidden" name="estado" value="<%= usuario.getEstado() %>">
        <div class="mb-3">
          <label for="nombreCompleto" class="form-label">Ingresa el nombre</label>
          <input type="text" class="form-control" id="nombreCompleto" name="nombreCompleto"
                 aria-describedby="productName" value="<%= usuario.getNombreCompleto() %>" required>
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">Ingresa el correo</label>
          <input type="email" class="form-control" id="email" name="email"
                 aria-describedby="productName" value="<%= usuario.getCorreo() %>" required>
        </div>
        <div class="mb-3">
          <label for="contrasena" class="form-label">Ingresa la contraseña</label>
          <input type="password" class="form-control" id="contrasena" name="contrasena"
                 aria-describedby="productName" required>
        </div>
        <div class="mb-3">
          <label for="telefono" class="form-label">Ingresa el telefono</label>
          <input type="number" class="form-control" id="telefono" name="telefono"
                 aria-describedby="productPrice" value="<%= usuario.getTelefono() %>" required>
        </div>
        <div class="mb-3">
          <label for="tipo" class="form-label">Selecciona el tipo de usuario</label>
          <select name="tipo" id="tipo" class="form-select" required>
            <% for (Tipo tipo : tipos) { %>
            <option value="<%= tipo %>"><%= tipo.getDisplayName() %></option>
            <% } %>
          </select>
        </div>
        <div style="display: flex; justify-content: space-between;">
          <button type="submit" class="btn btn-warning">Actualizar</button>
          <button class="btn btn-danger" onclick="history.back()">Cancelar</button>
        </div>
      </form>
    </div>
  </div>
</div>
<jsp:include page="components/footer.jsp"/>