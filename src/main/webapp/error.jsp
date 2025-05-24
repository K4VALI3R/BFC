
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String message = (String) request.getAttribute("message"); %>
<html>
<head>
    <title>Error</title>
    <link rel="icon" type="image/png" href="img/bfclogo.png">

</head>
<body>
<h1 style="color: red; ">Error</h1>
<p><%= message %></p>
</body>
</html>
