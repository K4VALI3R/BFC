<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Pedido" %>
<%@ page import="utp.edu.pe.bfc.models.PedidoDetalle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Pedido pedido = (Pedido) request.getAttribute("pedido");
    List<PedidoDetalle> detalles = (List<PedidoDetalle>) request.getAttribute("detalles");
%>

<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid mt-4">
    <div class="card">
        <div class="card-body">
            <h4 class="mb-3">Detalle del pedido N° <%= pedido.getPedidoId() %></h4>

            <p><strong>Cliente:</strong> <%= pedido.getCliente().getNombreCompleto() %></p>
            <p><strong>Fecha:</strong> <%= pedido.getFecha() %></p>
            <p><strong>Dirección:</strong> <%= pedido.getDireccion() %></p>
            <p><strong>Monto Total:</strong> S/ <%= pedido.getMonto() %></p>

            <div class="table-responsive mt-4">
                <table class="table table-striped text-center">
                    <thead class="table-dark">
                    <tr>
                        <th>Tipo</th>
                        <th>Nombre</th>
                        <th>Precio</th>

                        <th>Cantidad</th>
                        <th>Subtotal</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (PedidoDetalle d : detalles) { %>
                    <tr>
                        <td>
                            <% if (d.getProducto() != null) { %> Producto <% } else { %> Combo <% } %>
                        </td>
                        <td>
                            <% if (d.getProducto() != null) { %>
                            <%= d.getProducto().getNombre() %>
                            <% } else { %>
                            <%= d.getCombo().getNombre() %>
                            <% } %>
                        </td>

                        <td>
                            <% if (d.getProducto() != null) { %>
                            S/<%= d.getProducto().getPrecio() %>
                            <% } else { %>
                            S/<%= d.getCombo().getPrecio() %>
                            <% } %>
                        </td>
                        <td><%= d.getCantidad() %></td>
                        <td>S/<%= d.getSubtotal() %></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>

            <a href="javascript:history.back()" class="btn btn-primary mt-3">Volver</a>
        </div>
    </div>
</div>

<jsp:include page="components/footer.jsp"/>