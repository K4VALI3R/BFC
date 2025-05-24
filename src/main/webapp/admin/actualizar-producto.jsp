<%@ page import="utp.edu.pe.bfc.models.enums.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Producto producto = (Producto) request.getAttribute("producto");
  List<Categoria> categorias = Categoria.getCategorias();
%>
<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
  <div class="card">
    <div class="card-body">
      <div class="mb-6">
        <h4 class="card-title" style="font-weight: bold;">Actualizar el producto</h4>
      </div>
      <form action="actualizar-producto" method="post" enctype="multipart/form-data">
        <input type="hidden" name="productoId" value="<%= producto.getProductoId() %>">
        <input type="hidden" name="estado" value="<%= producto.getEstado() %>">
        <div class="mb-3">
          <label for="nombre" class="form-label">Ingresa el nombre</label>
          <input type="text" class="form-control" id="nombre" name="nombre"
                 aria-describedby="productName" value="<%= producto.getNombre() %>" required>
        </div>
        <div class="mb-3">
          <label for="precio" class="form-label">Ingresa el precio</label>
          <input type="number" class="form-control" id="precio" name="precio"
                 aria-describedby="productPrice" value="<%= producto.getPrecio() %>" required>
        </div>
        <div class="mb-3">
          <label for="imagen" class="form-label">Ingresa la imagen</label>
          <input type="file" class="form-control" id="imagen" name="imagen"
                 aria-describedby="productImage" required>
        </div>
        <div class="mb-3">
          <label for="categoria" class="form-label">Ingresa la categoria</label>
          <select name="categoria" id="categoria" class="form-select" required>
            <% for (Categoria categoria : categorias) { %>
            <option value="<%= categoria %>"><%= categoria.getDisplayName() %></option>
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