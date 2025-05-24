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
      <a href="" class="text-dark text-decoration-none fw-bold"style="font-size:18.5px;">ENCUENTRA TU KFC</a>
      <a href="" class="text-dark text-decoration-none fw-bold"style="font-size:18.5px;">VER MENÚ</a>
      <a href="" class="text-dark text-decoration-none fw-bold" style="font-size:18.5px;">NOSOTROS</a>
    </nav>

    <% if (session.getAttribute("usuario") == null) { %>
    <button type="submit" class="btn btn-primary" onclick="location.href='login.jsp'">Iniciar sesión</button>
    <% } else { %>
    <a type="submit" class="btn btn-danger" href="logout">Cerrar sesión</a>
    <% } %>
  </div>
</header>

<body>

<div class="container" style="margin-top:25px;">
  <div class="row">

    <div class="col-md-6 bg-white text-center border-danger rounded p-4">
      <p class="fs-3" style="margin-bottom:0px; margin-top:25px;font-family: 'Oswald', sans-serif;font-weight: 500;"> <strong>¿CÓMO PREFIERES PEDIR?</strong></p>
      <p class="text-secondary" style="margin-top: 0;" >A domicilio o para recoger en el restaurante</p>
    </div>

    <div class="col-md-6 text-center " style="margin-top:-2px" >

      <div class="d-flex justify-content-center mb-3 " style="gap: 10px;margin-top:-2px;">
        <button class="btn btn-danger fw-bold" style="width:275px; height: 40.2px;border-radius: 20px;margin-left:-34px">DELIVERY</button>
        <button class="btn btn-white fw-bold"  style="width:275px; height: 40.2px;border-radius: 20px ;border: 0.1px solid lightgray;">RECOJO EN TIENDA</button>
      </div>
      <p style="width:153px ;font-weight:500;margin-left:17px;margin-top:-5px;font-size:16.7px;" >Escribe tu dirección</p>
      <input type="text" class="form-control" placeholder="Ingresa tu dirección" style=" margin-left:20px ;margin-top:-15px; max-width: 540px;">
    </div>

  </div>
</div>

<div style="margin-top:28.5px;">
  <img src="img/banner.jpeg" style="width: 100%; height: 100%; margin-top:-9px;">

</div>

<p class="fw-bold" style="margin-top:37px; margin-left:352.5px; font-size:25px;" >OFERTA POR TIEMPO LIMITADO</p>

<div class="container" style="margin-top:21px;">
  <div class="row">
    <h1>Productos</h1>
    <!-- Columna 1 -->
    <% for (Producto producto : productos) { %>
    <div style="margin-left:60px; margin-right:-42px; margin-top:11.5px; width:261px; padding:0; border:1px solid lightgray; border-radius:3px; position: relative;">
      <img src="image/<%= producto.getNombre() %>" style="width:100%; height:50.4%; display: block; margin-bottom:9.92px;">
      <p class="fw-bold" style="margin-bottom:50px; text-align:center;"><%= producto.getNombre() %></p>
      <p class="mb-3 text-center">S/<%= producto.getPrecio() %></p>
      <button class="btn btn-danger"style="width:120px; height:60px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
    </div>
    <% } %>
  </div>
  <div class="row" style="margin-top:21px;">
    <h1>Combos</h1>
    <!-- Columna 1 -->
    <% for (Combo combo : combos) { %>
    <div style="margin-left:60px; margin-right:-42px; margin-top:11.5px; width:261px; padding:0; border:1px solid lightgray; border-radius:3px; position: relative;">
      <img src="image/<%= combo.getNombre() %>" style="width:100%; height:50.4%; display: block; margin-bottom:9.92px;">
      <p class="fw-bold" style="margin-bottom:50px; text-align:center;"><%= combo.getNombre() %></p>
      <p class="mb-3 text-center">S/<%= combo.getPrecio() %></p>
      <button class="btn btn-danger"style="width:120px; height:60px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
    </div>
    <% } %>
  </div>


  <p class="fw-bold" style="margin-left:50px;margin-top:70px;font-size:25px;" >EXPLORA NUESTRO MENÚ</p>






  </body>
</html>