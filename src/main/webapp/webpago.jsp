<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utp.edu.pe.bfc.models.Usuario" %>
<%@ page import="utp.edu.pe.bfc.models.Carritoo" %>
<%@ page import="java.util.List" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    List<Carritoo> carrito = (List<Carritoo>) session.getAttribute("carrito");
    float total = 0;
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Pago</title>
    <style>
        .detalle {
            margin-top: 60px;
            padding: 20px;
        }
        .table th, .table td {
            text-align: center;
        }
        .qr-img {
            width: 200px;
            margin: 20px 0;
        }
    </style>
</head>
<body>

<jsp:include page="components/header.jsp"/>

<main class="container detalle">
    <h2 class="text-center">Resumen del Pedido</h2>

    <% if (usuario != null) { %>
    <p><strong>Cliente:</strong> <%= usuario.getNombreCompleto() %></p>
    <% } %>

    <% if (carrito == null || carrito.isEmpty()) { %>
    <p>Tu carrito está vacío.</p>
    <% } else { %>
    <table class="table table-bordered">
        <thead class="table-light">
        <tr>
            <th>Tipo</th>
            <th>Nombre</th>
            <th>Precio unitario</th>
            <th>Cantidad</th>
            <th>Subtotal</th>
        </tr>
        </thead>
        <tbody>
        <% for (Carritoo item : carrito) {
            float subtotal = item.getSubtotal();
            total += subtotal;
        %>
        <tr>
            <td><%= item.getTipo() %></td>
            <td><%= item.getNombre() %></td>
            <td>S/ <%= item.getPrecio() %></td>
            <td><%= item.getCantidad() %></td>
            <td>S/ <%= subtotal %></td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <h4 class="text-end">Total a pagar: <strong>S/ <%= total %></strong></h4>

    <form method="post" action="confirmar-pago">
        <div class="mb-3">
            <label for="direccion">Dirección de entrega</label>
            <input type="text" class="form-control" id="direccion" name="direccion" required>
        </div>

        <div class="text-center mt-4">
            <p>Escanea el siguiente código QR desde tu app Yape:</p>
            <img class="qr-img" src="https://i.imgur.com/3W0GJ5f.png" alt="Yape QR">
            <p><strong>Número Yape:</strong> 976114667</p>
            <p>Envía tu comprobante por WhatsApp para confirmar tu pedido 📲</p>
        </div>

        <div class="text-center mt-3">
            <button type="submit" class="btn btn-success">Confirmar Pedido</button>
            <a href="carrito.jsp" class="btn btn-secondary">Volver al carrito</a>
        </div>
    </form>
    <% } %>
</main>

<jsp:include page="components/footer.jsp"/>

</body>
</html>

