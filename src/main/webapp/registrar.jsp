<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
      <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>BFC</title>
        <link rel="icon" type="image/png" href="img/bfclogo.png">


    <style>
        .registro-container {
            max-width: 600px;
            margin: 60px auto;
            padding: 40px;
            background-color: white;
            border-radius: 20px;
            box-shadow: 0 0 15px rgba(255, 0, 0, 0.2);
            border-top: 8px solid #c00000;
        }
        .btn-rojo {
            background-color: #c00000;
            color: white;
        }
        .btn-rojo:hover {
            background-color: #a00000;
        }
        h2 {
            color: #c00000;
            text-align: center;
            margin-bottom: 30px;
            font-weight: bold;
        }
    </style>
</head>

<body>

<div class="container registro-container">
    <h2>REGÍSTRATE</h2>
    <form action="Registrar" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="pri_nombre" placeholder="Primer Nombre">
            <label>Primer Nombre</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="seg_nombre" placeholder="Segundo Nombre">
            <label>Segundo Nombre</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="pat_apellido" placeholder="Apellido Paterno">
            <label>Apellido Paterno</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="mat_apellido" placeholder="Apellido Materno">
            <label>Apellido Materno</label>
        </div>

        <div class="form-floating mb-3">
            <input type="number" class="form-control" name="edad" placeholder="Edad">
            <label>Edad</label>
        </div>

        <div class="form-floating mb-3">
            <input type="tel" class="form-control" name="numeroTelefono" placeholder="Teléfono">
            <label>Teléfono</label>
        </div>

        <div class="form-floating mb-3">
            <input type="email" class="form-control" name="correo" placeholder="Correo Electrónico">
            <label>Correo</label>
        </div>

        <div class="form-floating mb-3">
            <input type="password" class="form-control" name="contrasena" placeholder="Contraseña">
            <label>Contraseña</label>
        </div>

        <div class="form-floating mb-4">
            <input type="password" class="form-control" name="confirmar" placeholder="Confirmar Contraseña">
            <label>Confirmar Contraseña</label>
        </div>

        <div class="d-grid gap-2">
            <input type="submit" value="Registrarse" class="btn btn-rojo btn-lg">
        </div>
    </form>

    <div class="text-center mt-4">
        <form action="login.jsp">
            <input type="submit" value="Ya tengo cuenta" class="btn btn-outline-danger">
        </form>
    </div>

    <%
        String msg = request.getParameter("msg");
        if ("ok".equals(msg)) {
    %>
        <div class="alert alert-success text-center mt-4">
            ¡Registrado exitosamente! Redirigiendo a login...
        </div>
        <script>
            setTimeout(() => {
                window.location.replace("login.jsp");
            }, 3000);
        </script>
    <% } else if ("error".equals(msg)) { %>
        <div class="alert alert-danger text-center mt-4">
            Las contraseñas no coinciden.
        </div>
    <% } %>
</div>

</body>
</html>
