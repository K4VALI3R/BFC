<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Producto" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Estado" %>
<%@ page import="utp.edu.pe.bfc.models.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
%>
<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
  <div class="card">
    <div class="card-body">
      <div>
        <button type="button" class="btn btn-success m-1" onclick="location.href='crear-usuario.jsp'">Agregar usuario</button>
      </div>
      <div class="table-responsive">
        <table class="table text-center table-responsive justify-content-center">
          <thead>
          <th>Id</th>
          <th>Nombre</th>
          <th>Telefono</th>
          <th>Correo</th>
          <th>Tipo</th>
          <th>Estado</th>
          <th>Acción</th>
          </thead>
          <tbody>
          <% if (!usuarios.isEmpty()) { %>
          <tr>
              <% for (Usuario usuario : usuarios) { %>
            <td><%= usuario.getUsuarioId() %></td>
            <td><%= usuario.getNombreCompleto() %></td>
            <td><%= usuario.getTelefono() %></td>
            <td><%= usuario.getCorreo() %></td>
            <td><%= usuario.getTipo().getDisplayName() %></td>
              <% if (usuario.getEstado().equals(Estado.ACTIVE)) { %>
            <td style="color:green"><%= usuario.getEstado().getDisplayName() %></td>
              <% } else { %>
            <td style="color:red"><%= usuario.getEstado().getDisplayName() %></td>
              <% } %>
            <td>
              <a
                      type="button"
                      class="btn btn-primary m-1"
                      href="redireccionar-usuario?id=<%= usuario.getUsuarioId() %>"
              >Editar</a>
              <% if (usuario.getEstado().equals(Estado.ACTIVE)) { %>
              <a
                      type="button"
                      class="btn btn-danger m-1"
                      href="desactivar-usuario?id=<%= usuario.getUsuarioId() %>"
              >Desactivar</a>
              <% } else { %>
              <a
                      type="button"
                      class="btn btn-success m-1"
                      href="activar-usuario?id=<%= usuario.getUsuarioId() %>"
              >Activar</a>
              <% } %>
            </td>
          <tr>
            <% } %>
          </tr>
          <% } else { %>
          <tr>
            <td colspan="6">No se encontraron usuarios en la base de datos</td>
          </tr>
          <% } %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<jsp:include page="components/footer.jsp"/>