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
           <h5 class="mb-0 fw-bold">BFC PLAZA VEA BOLICHERA</h5>
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

       <a href="index.jsp" ><button class="btn btn-danger w-100 fw-bold" style="border-radius: 40px;">EMPEZAR MI PEDIDO</button></a>
     </div>


      <div style="margin-left:800px; margin-top:-450px;  height:auto;width:605px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
               <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3900.481516912248!2d-76.98923409200287!3d-12.147586108658922!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105b8152ac9162b%3A0x32694b5dc67a569c!2sAv.%20el%20Parque%20588%2C%20Lima%2015054!5e0!3m2!1ses!2spe!4v1748224212067!5m2!1ses!2spe" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade" style="width:100%; height:100%; display: block;</iframe>">
               </iframe>
      </div>


    </body>
<jsp:include page="components/footer.jsp"/>

</html>
