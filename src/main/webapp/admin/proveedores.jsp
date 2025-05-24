<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Producto" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Estado" %>
<%@ page import="utp.edu.pe.bfc.models.Usuario" %>
<%@ page import="utp.edu.pe.bfc.models.Proveedor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores");
%>
<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
  <div class="card">
    <div class="card-body">
      <div>
        <button type="button" class="btn btn-success m-1" onclick="location.href='crear-proveedor.jsp'">Agregar proveedor</button>
      </div>
      <div class="table-responsive">
        <table class="table text-center table-responsive justify-content-center">
          <thead>
          <th>Id</th>
          <th>Empresa</th>
          <th>RUC</th>
          <th>Dirección</th>
          <th>Telefono</th>
          <th>Correo</th>
          <th>Descripción</th>
          <th>Delegado</th>
          <th>Estado</th>
          <th>Acción</th>
          </thead>
          <tbody>
          <% if (!proveedores.isEmpty()) { %>
          <tr>
              <% for (Proveedor proveedor : proveedores) { %>
            <td><%= proveedor.getProveedorId() %></td>
            <td><%= proveedor.getNombreEmpresa() %></td>
            <td><%= proveedor.getRuc() %></td>
            <td><%= proveedor.getDireccion() %></td>
            <td><%= proveedor.getTelefono() %></td>
            <td><%= proveedor.getCorreo() %></td>
            <td><%= proveedor.getDescripcion() %></td>
            <td><%= proveedor.getDelegado() %></td>
              <% if (proveedor.getEstado().equals(Estado.ACTIVE)) { %>
            <td style="color:green"><%= proveedor.getEstado().getDisplayName() %></td>
              <% } else { %>
            <td style="color:red"><%= proveedor.getEstado().getDisplayName() %></td>
              <% } %>
            <td>
              <a
                      type="button"
                      class="btn btn-primary m-1"
                      href="redireccionar-proveedor?id=<%= proveedor.getProveedorId() %>"
              >Editar</a>
              <% if (proveedor.getEstado().equals(Estado.ACTIVE)) { %>
              <a
                      type="button"
                      class="btn btn-danger m-1"
                      href="desactivar-proveedor?id=<%= proveedor.getProveedorId() %>"
              >Desactivar</a>
              <% } else { %>
              <a
                      type="button"
                      class="btn btn-success m-1"
                      href="activar-proveedor?id=<%= proveedor.getProveedorId() %>"
              >Activar</a>
              <% } %>
            </td>
          <tr>
            <% } %>
          </tr>
          <% } else { %>
          <tr>
            <td colspan="10">No se encontraron usuarios en la base de datos</td>
          </tr>
          <% } %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<jsp:include page="components/footer.jsp"/>