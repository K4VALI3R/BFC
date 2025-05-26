<%@ page import="utp.edu.pe.bfc.models.Usuario" %>
<%@ page import="utp.edu.pe.bfc.dao.ProductoDAO" %>
<%@ page import="utp.edu.pe.bfc.models.Producto" %>
<%@ page import="java.util.List" %>
<%@ page import="utp.edu.pe.bfc.dao.ComboDAO" %>
<%@ page import="utp.edu.pe.bfc.models.Combo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  HttpSession session1 = request.getSession(false);
  Usuario usuario = (Usuario) session1.getAttribute("usuario");

  ProductoDAO productoDAO = new ProductoDAO();
  List<Producto> productos = productoDAO.getActiveAProductos();
  productoDAO.close();

  ComboDAO comboDAO = new ComboDAO();
  List<Combo> combos = comboDAO.getActiveACombos();
  comboDAO.close();
%>
<!DOCTYPE html>
<html>

<jsp:include page="components/header.jsp"/>

<header class="bg-white border-bottom shadow-sm" style="margin-top: -3px; margin-bottom: 0px;">
  <div class="container d-flex justify-content-between align-items-center lol">
    <h1 class=" text-danger fw-bold" style="margin-left:-205px;font-size:65px;transform: scaleX(1.3);">BFC</h1>

    <nav class="d-flex gap-3" style="margin-left:-628px;margin-top:16px;">
      <a href="encuentra.jsp" class="text-dark text-decoration-none fw-bold"style="font-size:18.5px;">ENCUENTRA TU KFC</a>
      <a href="menu.jsp" class="text-dark text-decoration-none fw-bold"style="font-size:18.5px;">VER MENÚ</a>
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




<div style="margin-top:28.5px;">
  <img src="img/banner.jpeg" style="width: 100%; height: 100%; margin-top:-9px;">

</div>


<div class="container" style="margin-top:21px;">
  <div class="row">
    <h1>Productos</h1>
    <!-- Columna 1 -->
    <% for (Producto producto : productos) { %>
    <div style="margin-left:60px; margin-right:-42px; margin-top:11.5px; width:261px; padding:0; border:1px solid lightgray; border-radius:3px; position: relative;">
      <img src="image?img=<%= producto.getNombre() %>.jpg" style="width:100%; height:50.4%; display: block; margin-bottom:9.92px;">
      <p class="fw-bold" style="margin-bottom:50px; text-align:center;"><%= producto.getNombre() %></p>
      <p class="mb-3 text-center">S/<%= producto.getPrecio() %></p>
      <button class="btn btn-danger"style="width:120px; height:60px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Agregar</button>
    </div>
    <% } %>
  </div>
  <div class="row" style="margin-top:21px;">
    <h1>Combos</h1>
    <!-- Columna 1 -->
    <% for (Combo combo : combos) { %>
    <div style="margin-left:60px; margin-right:-42px; margin-top:11.5px; width:261px; padding:0; border:1px solid lightgray; border-radius:3px; position: relative;">

      <img src="image?img=<%= combo.getNombre() %>.jpg" style="width:100%; height:50.4%; display: block; margin-bottom:9.92px;">
      <p class="fw-bold" style="margin-bottom:50px; text-align:center;"><%= combo.getNombre() %></p>
      <p class="mb-3 text-center">S/<%= combo.getPrecio() %></p>
      <button class="btn btn-danger"style="width:120px; height:60px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Agregar</button>
    </div>
    <% } %>
  </div>









</body>

    <jsp:include page="components/footer.jsp"/>

</html>