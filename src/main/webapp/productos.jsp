<%@ page import="utp.edu.pe.bfc.models.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Categoria" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>

<!DOCTYPE html>
<html lang="es">
<jsp:include page="components/header.jsp"/>
<body class="bg-light">

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="text-danger">Lista de Productos</h2>
        <a href="crear-producto.jsp" class="btn btn-primary">Crear Producto</a>
    </div>

    <% if (productos != null && !productos.isEmpty()) { %>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Categoría</th>
                <th>Imagen</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <% for (Producto product : productos) { %>
            <tr>
                <td><%= product.getProductoId() %></td>
                <td><%= product.getNombre() %></td>
                <td>S/ <%= product.getPrecio() %></td>
                <td><%= product.getCategoria().getDisplayName() %></td>
                <td><img src="image?img=<%= product.getImagen() %>" width="100" height="100" style="border-radius: 999px"/></td>
                <td>
                    <div class="d-flex gap-2">
                        <a href="redireccionar-producto?productoId=<%= product.getProductoId() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="borrar-producto?productoId=<%= product.getProductoId() %>" class="btn btn-danger btn-sm">Eliminar</a>
                    </div>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <% } else { %>
    <div class="alert alert-warning text-center" role="alert">
        No hay productos disponibles.
    </div>
    <% } %>
</div>

<jsp:include page="components/footer.jsp"/>
</body>
</html>