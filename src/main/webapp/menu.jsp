<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<jsp:include page="components/header.jsp"/>
    <body>


    <!-- NAVBAR CON SOMBRA ARRIBA -->
    <nav id="miNav"style="
      height: 60px;
      background: white;
      box-shadow: inset 0 8px 8px -6px rgba(0,0,0,0.3);
      display: flex;
      justify-content: center;
      gap: 7rem;
      align-items: center;
      position: sticky;
      top: 285px; /* 85 header + 200 fijo-bajo-header */
      z-index: 998;
      ">
      <a href="#promos" onclick="marcaActivo(event)" style="color: black; text-decoration: none; padding-bottom: 4px; font-weight: normal;">PROMOS</a>
      <a href="#megas" onclick="marcaActivo(event)" style="color: black; text-decoration: none; padding-bottom: 4px; font-weight: normal;">MEGAS</a>
      <a href="#para2" onclick="marcaActivo(event)" style="color: black; text-decoration: none; padding-bottom: 4px; font-weight: normal;">PARA2</a>
    </nav>

    <div id="contenido" style="
      margin-top: 55px;
      padding: 1rem 2rem;
      background: #f8f9fa;
      ">

      <section id="promos" style="margin-bottom: 3rem; min-height: 500px;  background: white; padding-top: 1rem;">
        <h2 style="margin-left:322px;margin-bottom:-18px;">PROMOS</h2>

        <!-- Fila 1 -->
        <div class="row g-1 " style="width:1430px;margin-left:175px;margin-top:12px;justify-content: center;">


           <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">

              <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
              <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/13440_13440_202504241343390634.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
              <p class="fw-bold" style="margin-top:5px; text-align:center;">WINGS & KRUNCH: 18 HOTS</p>
              <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.34.90</p>
              <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
              </div>

          </div>

          <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
             <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
               <img src="img/prod1logo.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
              <p class="fw-bold" style="margin-top:5px; text-align:center;">DÚO TWISTER XL CON PAPAS</p>
              <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.38.90</p>
             <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
           </div>
          </div>

          <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
            <div style="margin-top:11.7px; height:299px;width:263px; padding:0px; border:2px solid lightgray; border-radius:3px; position: relative;">
                <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/15125_15125_202409231052201399.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                <p class="fw-bold" style="margin-top:5px; text-align:center;">MEGA 24 PIEZAS</p>
               <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .149.90</p>
               <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
              </div>
            </div>

          <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                  <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                   <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/15399_15399_202410311724111662.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                   <p class="fw-bold" style="margin-top:5px; text-align:center;">KRUNCHY DÚO</p>
                  <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.24.90</p>
                <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
              </div>
            </div>

            <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                  <div style="margin-top:11.7px; height:299px;width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                     <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/14328_14328_202505200900189186.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                    <p class="fw-bold" style="margin-top:5px; text-align:center;">KRUNCHY PARA 4</p>
                    <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .35.90</p>
                    <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
               </div>
             </div>

              <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                      <div style="margin-top:11.7px; height:299px;width:263px; padding:0px; border:2px solid lightgray; border-radius:3px; position: relative;">
                        <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/MEGA%20DELIVERY%20V4_12468_202412200859167706.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                         <p class="fw-bold" style="margin-top:5px; text-align:center;">MEGA DELIVERY - 8 PIEZAS</p>
                        <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .39.90</p>
                         <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
                        </div>
                </div>

              <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                   <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                 <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/15968_15968_202503211424266519.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                  <p class="fw-bold" style="margin-top:5px; text-align:center;">PROMO TWISTERXL + AGUA SABORIZADA</p>
                 <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.28.90</p>
                <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
               </div>
             </div>

           <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
              <div style="margin-top:11.7px; height:299px;width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
              <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/MEGA%20DELIVERY%20G_15126_202412200902009050.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
              <p class="fw-bold" style="margin-top:5px; text-align:center;">MEGA DELIVERY + GASEOSA</p>
              <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .45.90</p>
              <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
            </div>
           </div>


        </div>
      </section>



      <section id="megas" style="margin-bottom: 3rem; min-height: 500px; background: white; padding-top: 1rem;">
        <h2 style="margin-left:322px;margin-bottom:-18px;">MEGAS</h2>
  <div class="row g-1 " style="width:1430px;margin-left:175px;margin-top:12px;justify-content: center;">


             <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">

                <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/13440_13440_202504241343390634.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                <p class="fw-bold" style="margin-top:5px; text-align:center;">WINGS & KRUNCH: 18 HOTS</p>
                <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.34.90</p>
                <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
                </div>

            </div>

            <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
               <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                 <img src="img/prod1logo.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                <p class="fw-bold" style="margin-top:5px; text-align:center;">DÚO TWISTER XL CON PAPAS</p>
                <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.38.90</p>
               <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
             </div>
            </div>

            <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
              <div style="margin-top:11.7px; height:299px;width:263px; padding:0px; border:2px solid lightgray; border-radius:3px; position: relative;">
                  <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/15125_15125_202409231052201399.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                  <p class="fw-bold" style="margin-top:5px; text-align:center;">MEGA 24 PIEZAS</p>
                 <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .149.90</p>
                 <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
                </div>
              </div>

            <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                    <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                     <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/15399_15399_202410311724111662.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                     <p class="fw-bold" style="margin-top:5px; text-align:center;">KRUNCHY DÚO</p>
                    <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.24.90</p>
                  <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
                </div>
              </div>

              <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                    <div style="margin-top:11.7px; height:299px;width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                       <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/14328_14328_202505200900189186.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                      <p class="fw-bold" style="margin-top:5px; text-align:center;">KRUNCHY PARA 4</p>
                      <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .35.90</p>
                      <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
                 </div>
               </div>

                <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                        <div style="margin-top:11.7px; height:299px;width:263px; padding:0px; border:2px solid lightgray; border-radius:3px; position: relative;">
                          <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/MEGA%20DELIVERY%20V4_12468_202412200859167706.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                           <p class="fw-bold" style="margin-top:5px; text-align:center;">MEGA DELIVERY - 8 PIEZAS</p>
                          <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .39.90</p>
                           <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
                          </div>
                  </div>

                <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                     <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                   <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/15968_15968_202503211424266519.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                    <p class="fw-bold" style="margin-top:5px; text-align:center;">PROMO TWISTERXL + AGUA SABORIZADA</p>
                   <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.28.90</p>
                  <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
                 </div>
               </div>

             <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                <div style="margin-top:11.7px; height:299px;width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/MEGA%20DELIVERY%20G_15126_202412200902009050.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                <p class="fw-bold" style="margin-top:5px; text-align:center;">MEGA DELIVERY + GASEOSA</p>
                <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .45.90</p>
                <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
              </div>
             </div>


          </div>

      </section>

      <section id="para2" style="margin-bottom: 3rem; min-height: 500px; background: white; padding-top: 1rem;">
        <h2 style="margin-left:322px;margin-bottom:-18px;">PARA 2</h2>
 <div class="row g-1 " style="width:1430px;margin-left:175px;margin-top:12px;justify-content: center;">


            <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">

               <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
               <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/13440_13440_202504241343390634.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
               <p class="fw-bold" style="margin-top:5px; text-align:center;">WINGS & KRUNCH: 18 HOTS</p>
               <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.34.90</p>
               <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
               </div>

           </div>

           <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
              <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                <img src="img/prod1logo.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
               <p class="fw-bold" style="margin-top:5px; text-align:center;">DÚO TWISTER XL CON PAPAS</p>
               <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.38.90</p>
              <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
            </div>
           </div>

           <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
             <div style="margin-top:11.7px; height:299px;width:263px; padding:0px; border:2px solid lightgray; border-radius:3px; position: relative;">
                 <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/15125_15125_202409231052201399.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                 <p class="fw-bold" style="margin-top:5px; text-align:center;">MEGA 24 PIEZAS</p>
                <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .149.90</p>
                <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
               </div>
             </div>

           <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                   <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                    <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/15399_15399_202410311724111662.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                    <p class="fw-bold" style="margin-top:5px; text-align:center;">KRUNCHY DÚO</p>
                   <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.24.90</p>
                 <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
               </div>
             </div>

             <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                   <div style="margin-top:11.7px; height:299px;width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                      <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/14328_14328_202505200900189186.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                     <p class="fw-bold" style="margin-top:5px; text-align:center;">KRUNCHY PARA 4</p>
                     <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .35.90</p>
                     <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
                </div>
              </div>

               <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                       <div style="margin-top:11.7px; height:299px;width:263px; padding:0px; border:2px solid lightgray; border-radius:3px; position: relative;">
                         <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/MEGA%20DELIVERY%20V4_12468_202412200859167706.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                          <p class="fw-bold" style="margin-top:5px; text-align:center;">MEGA DELIVERY - 8 PIEZAS</p>
                         <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .39.90</p>
                          <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
                         </div>
                 </div>

               <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
                    <div style="margin-top:11.7px; height:299px; width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
                  <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/15968_15968_202503211424266519.jpg" style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
                   <p class="fw-bold" style="margin-top:5px; text-align:center;">PROMO TWISTERXL + AGUA SABORIZADA</p>
                  <p style="margin-top:65px; font-family: 'Oswald', sans-serif; text-align:center;">S/.28.90</p>
                 <button class="btn btn-danger" style="width:120px; height:56px; border-radius:40px; position:absolute; bottom:-30px; left:50%; transform:translateX(-50%);">Carrito</button>
                </div>
              </div>

            <div class="col-md-3 d-flex justify-content-center"  style="width:290px;height:350px;margin-top:25px;">
               <div style="margin-top:11.7px; height:299px;width:263px; padding:0; border:2px solid lightgray; border-radius:3px; position: relative;">
               <img src="https://cdn.tictuk.com/fbaba5c6-70cb-d548-0aa1-915f89e4a48c/ecommerce_delivery/MEGA%20DELIVERY%20G_15126_202412200902009050.jpg"  style="width:100%; height:45.8%; display: block; margin-bottom:9.92px;">
               <p class="fw-bold" style="margin-top:5px; text-align:center;">MEGA DELIVERY + GASEOSA</p>
               <p style="margin-top:65px;font-family: 'Oswald', sans-serif;text-align:center;">S/ .45.90</p>
               <button class="btn btn-danger"style="width:120px; height:56px; border-radius: 40px; position: absolute; bottom: -30px; left: 50%; transform: translateX(-50%);">Carrito</button>
             </div>
            </div>

         </div>
      </section>

    </div>
    <script>
      function marcaActivo(event) {
        event.preventDefault();
        const nav = document.getElementById('miNav');
        const links = nav.querySelectorAll('a');
        links.forEach(link => {
          link.classList.remove('activo');
          link.style.fontWeight = 'normal';
          link.style.borderBottom = 'none';
        });

        const clicked = event.currentTarget;
        clicked.classList.add('activo');
        clicked.style.fontWeight = 'bold';
        clicked.style.borderBottom = '3px solid #007bff';

        const destino = document.querySelector(clicked.getAttribute('href'));
        if (destino) {
          const offsetHeader = 306; // altura del header285+1 espacio:(286) sin salto o deliz peqeño cuando recargas F5 pero deja espacio extra.
          const offsetNav = nav.offsetHeight; // pero con 306 si hay salto o desliz cuando recargas pero no deja espacio extra.
          const totalOffset = offsetHeader + offsetNav;

          const topDestino = destino.getBoundingClientRect().top + window.scrollY;
          window.scrollTo({
            top: topDestino - totalOffset,
            behavior: 'smooth'
          });
        }
      }

    //if ('scrollRestoration' in history) {
     // history.scrollRestoration = 'manual';
     //  }

    </script>


    </body>
<jsp:include page="components/footer.jsp"/>
</html>
