<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Carritoo" %>
<%
  List<Carritoo> carrito = (List<Carritoo>) session.getAttribute("carrito");
  float total = 0;
%>
<!DOCTYPE html>
<html lang="es">

<body>

<jsp:include page="components/header.jsp"/>

<div class="container text-center" style="margin-top:60px;">
  <h1 class="p-3">Detalles del Carrito</h1>
</div>

<% if (carrito == null || carrito.isEmpty()) { %>
<div class="container mt-3">
  <p>Tu carrito está vacío.</p>
</div>
<% } else { %>
<div class="container mt-5">
  <table class="table">
    <thead class="table-light">
    <tr>
      <th>Nombre</th>
      <th class="text-center">Precio unitario</th>
      <th class="text-center">Cantidad</th>
      <th class="text-center">Subtotal</th>
      <th class="text-center">Acciones</th>
    </tr>
    </thead>
    <tbody>
    <% for (Carritoo item : carrito) {
      float subtotal = item.getSubtotal();
      total += subtotal;
    %>
    <tr>
      <td><%= item.getNombre() %></td>
      <td class="text-center">S/ <%= item.getPrecio() %></td>
      <td class="text-center"><%= item.getCantidad() %></td>
      <td class="text-center">S/ <%= subtotal %></td>
      <td class="text-center">
        <form method="post" action="carrito" style="display:inline;">
          <input type="hidden" name="accion" value="eliminar">
          <input type="hidden" name="id" value="<%= item.getId() %>">
          <input type="hidden" name="tipo" value="<%= item.getTipo() %>">
          <button class="btn btn-danger btn-sm"
                  onclick="return confirm('¿Eliminar ese producto del carrito?\nSi aceptas, borrarás su producto y cantidad')">
            Eliminar
          </button>
        </form>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>

  <div class="mt-4">
    <h3 style="margin-left:940px;margin-top:40px;">Total: S/ <%= total %></h3>
    <form action="webpago.jsp" method="get">
      <button class="btn btn-success mt-2" style="margin-left:940px;">Proceder pago</button>
    </form>
  </div>
</div>
<% } %>

<jsp:include page="components/footer.jsp"/>

</body>
</html>
