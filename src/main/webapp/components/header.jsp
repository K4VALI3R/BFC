<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>BFC</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  <link rel="icon" type="image/png" href="img/bfclogo.png">



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

<!-- DIV FIJO BAJO EL HEADER -->
<div class="fijo-bajo-header">
  <div class="container">
    <div class="row">

      <div class="col-md-6 bg-white text-center rounded p-4">
        <p class="fs-3" style="margin-bottom:0px; margin-top:5px;font-family: 'Oswald', sans-serif;font-weight: 500;">
          <strong>¿CÓMO PREFIERES PEDIR?</strong>
        </p>
        <p class="text-secondary" style="margin-top: 0;">A domicilio o para recoger en el restaurante</p>
      </div>

      <div class="col-md-6  ">
        <div class="d-flex justify-content-center mb-3" style="gap: 10px;">
          <button class="btn btn-danger fw-bold" style="width:275px; height: 39px;border-radius: 20px;margin-left:-20px;">DELIVERY</button>
          <button class="btn btn-white fw-bold" style="width:275px; height: 39px;border-radius: 20px;border: 0.1px solid lightgray;">RECOJO EN TIENDA</button>
        </div>
        <p style="font-weight:500;font-size:16.7px;margin-left:30px;margin-top:-5px;">Escribe tu dirección</p>
        <input type="text" class="form-control " placeholder="Ingresa tu dirección" style="max-width: 540px;margin-left:29px;margin-top:-15px;">
      </div>

    </div>
  </div>
</div>


</body>
</html>
