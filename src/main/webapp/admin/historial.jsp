<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Producto" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Estado" %>
<%@ page import="utp.edu.pe.bfc.models.Pedido" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
%>
<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
  <div class="card">
    <div class="card-body">
      <div class="table-responsive">
        <table class="table text-center table-responsive justify-content-center align-items-center">
          <thead>
          <th>Id</th>
          <th>Cliente</th>
          <th>Fecha</th>
          <th>Dirección</th>
          <th>Monto</th>
          <th>Estado</th>
          <th>Detalle</th>
          </thead>
          <tbody>
          <% if (!pedidos.isEmpty()) { %>
          <% for (Pedido pedido : pedidos) { %>
          <tr>

            <td><%= pedido.getPedidoId() %></td>
            <td><%= pedido.getCliente().getNombreCompleto() %></td>
            <td><%= pedido.getFecha() %></td>
            <td><%= pedido.getDireccion() %></td>
            <td>S/<%= pedido.getMonto() %></td>
            <td> <%= pedido.getEstado().getDisplayName() %> </td>
            <td> <a href="ver-detalle-pedido?id=<%= pedido.getPedidoId() %>"> Ver detalle </a> </td>
            <% } %>
          </tr>
          <% } else { %>
          <tr>
            <td colspan="6">No se encontraron pedidos en la base de datos</td>
          </tr>
          <% } %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<jsp:include page="components/footer.jsp"/>