<%@ page import="utp.edu.pe.bfc.models.enums.Categoria" %>
<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.models.enums.Tipo" %>
<%@ page import="utp.edu.pe.bfc.models.Proveedor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Proveedor proveedor = (Proveedor) request.getAttribute("proveedor");
%>
<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
  <div class="card">
    <div class="card-body">
      <div class="mb-6">
        <h4 class="card-title" style="font-weight: bold;">Registra un nuevo proveedor</h4>
      </div>
      <form action="actualizar-proveedor" method="post">
        <input type="hidden" name="id" value="<%= proveedor.getProveedorId() %>">
        <input type="hidden" name="estado" value="<%= proveedor.getEstado() %>">
        <div class="mb-3">
          <label for="nombreEmpresa" class="form-label">Ingresa el nombre de la empresa</label>
          <input type="text" class="form-control" id="nombreEmpresa" name="nombreEmpresa"
                 aria-describedby="productName" required value="<%= proveedor.getNombreEmpresa() %>">
        </div>
        <div class="mb-3">
          <label for="ruc" class="form-label">Ingresa el ruc de la empresa</label>
          <input type="text" class="form-control" id="ruc" name="ruc"
                 aria-describedby="productName" required value="<%= proveedor.getRuc() %>">
        </div>
        <div class="mb-3">
          <label for="direccion" class="form-label">Ingresa la dirección de la empresa</label>
          <input type="text" class="form-control" id="direccion" name="direccion"
                 aria-describedby="productName" required value="<%= proveedor.getDireccion() %>">
        </div>
        <div class="mb-3">
          <label for="correo" class="form-label">Ingresa el correo de contacto</label>
          <input type="email" class="form-control" id="correo" name="correo"
                 aria-describedby="productName" required value="<%= proveedor.getCorreo() %>">
        </div>
        <div class="mb-3">
          <label for="telefono" class="form-label">Ingresa un telefono de contacto</label>
          <input type="number" class="form-control" id="telefono" name="telefono"
                 aria-describedby="productName" required value="<%= proveedor.getTelefono() %>">
        </div>
        <div class="mb-3">
          <label for="descripcion" class="form-label">Ingresa una descripción</label>
          <textarea type="text" class="form-control" id="descripcion" name="descripcion"
                    aria-describedby="productName" required><%= proveedor.getDescripcion() %></textarea>
        </div>
        <div class="mb-3">
          <label for="delegado" class="form-label">Ingresa un delegado</label>
          <input type="text" class="form-control" id="delegado" name="delegado"
                 aria-describedby="productName" required value="<%= proveedor.getDelegado() %>">
        </div>
        <div style="display: flex; justify-content: space-between;">
          <button type="submit" class="btn btn-success">Registrar</button>
          <button class="btn btn-danger" onclick="history.back()">Cancelar</button>
        </div>
      </form>
    </div>
  </div>
</div>
<jsp:include page="components/footer.jsp"/>