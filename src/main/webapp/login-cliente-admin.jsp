<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">

<jsp:include page="components/header.jsp"/>

<body class="d-flex justify-content-center align-items-center vh-100 bg-light">


<div class="login-contenedor bg-white p-4 rounded shadow">
    <h2 class="text-center mb-4 text-danger fw-bold">Iniciar Sesi&oacute;n</h2>


    <form action="LoginServlet" method="post" autocomplete="on">

        <div class="mb-3">
            <label for="correo" class="llabel">Correo:</label>
            <input type="text" name="correo" id="correo" class="form-control" required autocomplete="on">
        </div>

        <div class="mb-5">
            <label for="contrasena" class="llabel">Contrase&ntilde;a:</label>
            <input type="password" name="contrasena" id="contrasena" class="form-control" required autocomplete="new-password">
        </div>

        <button type="submit" class="btn btn-danger w-100 ">Ingresar</button>


    </form>

    <form action="registrar.jsp" class="mt-4">
        <button type="submit" class="btn btn-success w-100">Registrar</button>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>

<!-- Limpia campos al cargar -->
<script>
    window.onload = function () {
        document.getElementById("correo").value = "";
        document.getElementById("contrasena").value = "";
    };
</script>





<jsp:include page="components/footer.jsp"/>

</body>
</html>
