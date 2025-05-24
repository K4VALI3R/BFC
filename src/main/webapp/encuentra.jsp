<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<jsp:include page="components/header.jsp"/>
    <body>





    <div style="width: 360px;margin-top:140px;margin-left:330px;text-align:center;">
       <h5 class="mb-0 fw-bold">BFC TIENDA FISICA</h5>
     </div>

     <div class="card shadow p-3" style="width: 360px; border-radius: 12px;margin-top:40px;margin-left:330px;">


       <div class="d-flex align-items-start mb-2">
         <span class="badge bg-danger me-2" style="border-radius: 50%;">1</span>
         <div>
           <h5 class="mb-0 fw-bold">KFC PLAZA VEA BOLICHERA</h5>
         </div>
       </div>

       <p class="mb-1 text-muted">Av. el Parque 588, Lima 15054, Perú</p>

       <div class="d-flex align-items-center mb-1">
         <i class="bi bi-telephone-fill text-danger me-2"></i>
         <a href="#" class="text-decoration-none">(01) 505 0505</a>
       </div>
       <div class="d-flex align-items-center mb-2">
         <i class="bi bi-geo-alt-fill text-danger me-2"></i>
         <a href="#" class="text-decoration-none">Indicaciones</a>
       </div>

       <p class="fw-bold text-success mb-1">● Abierto – Cierra a las 10:00 p.m.</p>

       <ul class="list-unstyled mb-3">
         <li class="d-flex justify-content-between">
           <span>✔ Delivery</span>
           <span>Cierra 10:00 p.m.</span>
         </li>
         <li class="d-flex justify-content-between">
           <span>✔ Recogo en tienda</span>
           <span>Cierra 10:00 p.m.</span>
         </li>
         <li class="d-flex justify-content-between">
           <span>✔ En tienda</span>
           <span>Cierra 10:00 p.m.</span>
         </li>
       </ul>

       <a href="principal.jsp" ><button class="btn btn-danger w-100 fw-bold" style="border-radius: 40px;">EMPEZAR MI PEDIDO</button></a>
     </div>


      <div style="margin-left:800px; margin-top:-450px;  height:650px;width:663px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
               <img src="img/mapa.png" style="width:100%; height:100%; display: block; ">
            </div>


    </body>
<jsp:include page="components/footer.jsp"/>

</html>
