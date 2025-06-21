<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Pedido" %>
<%@ page import="utp.edu.pe.bfc.models.PedidoDetalle" %>

<%
  Pedido pedido = (Pedido) request.getAttribute("pedido");
  List<PedidoDetalle> detalles = (List<PedidoDetalle>) request.getAttribute("detalles");
  String mensaje = (String) request.getAttribute("mensaje");
%>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>BFC</title>
  <title>Comprobante</title>
  <link rel="icon" type="image/png" href="img/bfclogo.png">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  <link rel="stylesheet" href="ruta/a/bootstrap.css"> <!-- opcional -->
  <style>
    .voucher {
      border: 1px solid #ccc;
      padding: 25px;
      margin-top: 50px;
      max-width: 600px;
      margin-left: auto;
      margin-right: auto;
      background: #f9f9f9;
    }
    .voucher h3 {
      margin-bottom: 20px;
    }
    .voucher table {
      width: 100%;
    }
  </style>
</head>
<style>
  body {
    padding-top: 230px; /* header (85px) + sección fija (~145px) */
  }
  header {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    z-index: 1000;
    background: white;
  }
  .fijo-bajo-header {
    position: fixed;

    top: 82px;
    left: 0;
    right: 0;
    z-index: 999;
    background: white;
    padding: 20px 0;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    height:203px;

  }
</style>
</head>

<body>

<!-- HEADER -->
<header class="bg-white border-bottom shadow-sm" style="height:83px;">
  <div class="container d-flex justify-content-between align-items-center">
    <a href="index.jsp" class="text-danger fw-bold text-decoration-none" style="margin-left:-205px;margin-top:-10px;font-size:65px;transform: scaleX(1.3);">
      BFC
    </a>

    <nav class="d-flex gap-3" style="margin-left:-628px;">
      <a href="encuentra.jsp" class="text-dark text-decoration-none fw-bold" style="font-size:18.5px;">ENCUENTRA TU KFC</a>
      <a href="menu.jsp" class="text-dark text-decoration-none fw-bold" style="font-size:18.5px;">VER MENÚ</a>
      <a href="#sobre-nosotros" class="text-dark text-decoration-none fw-bold" style="font-size:18.5px;">NOSOTROS</a>
    </nav>
    <% if (session.getAttribute("usuario") == null) { %>
    <button type="submit" class="btn btn-primary" onclick="location.href='login.jsp'">Iniciar sesión</button>
    <% } else { %>
    <a type="submit" class="btn btn-danger" href="logout">Cerrar sesión</a>
    <% } %>

  </div>
</header>
<body>



<div class="voucher">
  <h3 class="text-center"><%= mensaje %></h3>
  <p><strong>Cliente:</strong> <%= pedido.getCliente().getNombreCompleto() %></p>
  <p><strong>Fecha:</strong> <%= pedido.getFecha() %></p>
  <p><strong>Dirección:</strong> <%= pedido.getDireccion() %></p>
  <p><strong>Estado:</strong> <%= pedido.getEstado() %></p>

  <table class="table table-bordered mt-4">
    <thead>
    <tr>
      <th>Tipo</th>
      <th>Nombre</th>
      <th>Cantidad</th>
      <th>Subtotal</th>
    </tr>
    </thead>
    <tbody>
    <% for (PedidoDetalle det : detalles) { %>
    <tr>
      <td><%= det.getProducto() != null ? "Producto" : "Combo" %></td>
      <td><%= det.getProducto() != null ? det.getProducto().getNombre() : det.getCombo().getNombre() %></td>
      <td><%= det.getCantidad() %></td>
      <td>S/ <%= det.getSubtotal() %></td>
    </tr>
    <% } %>
    </tbody>
  </table>

  <h4 class="text-end">Total: <strong>S/ <%= pedido.getMonto() %></strong></h4>

  <div class="text-center mt-3">
    <a href="index.jsp" class="btn btn-success">Volver al inicio</a>
  </div>
</div>

<jsp:include page="components/footer.jsp"/>

</body>
</html>