<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String message = (String) request.getAttribute("message"); %>

<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
  <div class="card">
    <div class="card-body">
      <h5 class="card-title fw-semibold mb-4">Error</h5>
      <p class="mb-0"><%= message %></p>
    </div>
  </div>
</div>

<jsp:include page="components/footer.jsp"/>