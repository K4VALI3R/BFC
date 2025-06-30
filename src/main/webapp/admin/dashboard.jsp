<%@ page import="java.util.Map" %>
<%@ page import="java.util.LinkedHashMap" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="components/head.jsp"/>
<jsp:include page="components/sidebar.jsp"/>

<div class="container-fluid">
  <div class="row">
    <div class="col-lg-8 d-flex align-items-strech">
      <div class="card w-100">
        <div class="card-body">
          <div class="d-sm-flex d-block align-items-center justify-content-between mb-9">
            <div class="mb-3 mb-sm-0">
              <h5 class="card-title fw-semibold">Resumen de ventas</h5>
            </div>
            <div>
              <select class="form-select" id="tipoGrafico">
                <option value="dia">Ventas por Día</option>
                <option value="semana">Ventas por Semana</option>
                <option value="mes">Ventas por Mes</option>
              </select>
              <div class="mt-4">
                <canvas id="chartDia" style="display: none;"></canvas>
                <canvas id="chartSemana" style="display: none;"></canvas>
                <canvas id="chartMes" style="display: none;"></canvas>
              </div>
            </div>
          </div>
          <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

          <div class="mb-4">
            <h5>Ventas por Día</h5>
            <canvas id="chartDia"></canvas>
          </div>
          <div class="mb-4">
            <h5>Ventas por Semana</h5>
            <canvas id="chartSemana"></canvas>
          </div>
          <div class="mb-4">
            <h5>Ventas por Mes</h5>
            <canvas id="chartMes"></canvas>
          </div>

          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-4">
      <div class="row">
        <div class="col-lg-12">
          <!-- Yearly Breakup -->
          <div class="card overflow-hidden">
            <div class="card-body p-4">
              <h5 class="card-title mb-9 fw-semibold">Resumen anual</h5>
              <div class="row align-items-center">
                <div class="col-8">
                  <h4 class="fw-semibold mb-3">S/36,358</h4>
                  <div class="d-flex align-items-center mb-3">
                          <span
                                  class="me-1 rounded-circle bg-light-success round-20 d-flex align-items-center justify-content-center">
                            <i class="ti ti-arrow-up-left text-success"></i>
                          </span>
                    <p class="text-dark me-1 fs-3 mb-0">+9%</p>
                    <p class="fs-3 mb-0">Ultimo año</p>
                  </div>
                  <div class="d-flex align-items-center">
                    <div class="me-4">
                      <span class="round-8 bg-primary rounded-circle me-2 d-inline-block"></span>
                      <span class="fs-2">2025</span>
                    </div>
                    <div>
                      <span class="round-8 bg-light-primary rounded-circle me-2 d-inline-block"></span>
                      <span class="fs-2">2025</span>
                    </div>
                  </div>
                </div>
                <div class="col-4">
                  <div class="d-flex justify-content-center">
                    <div id="breakup">



                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-12">
          <!-- Monthly Earnings -->
          <div class="card">
            <div class="card-body">
              <div class="row alig n-items-start">
                <div class="col-8">
                  <h5 class="card-title mb-9 fw-semibold"> Ganancias Mensuales </h5>
                  <h4 class="fw-semibold mb-3">S/6,820</h4>
                  <div class="d-flex align-items-center pb-1">
                          <span
                                  class="me-2 rounded-circle bg-light-danger round-20 d-flex align-items-center justify-content-center">
                            <i class="ti ti-arrow-down-right text-danger"></i>
                          </span>
                    <p class="text-dark me-1 fs-3 mb-0">+9%</p>
                    <p class="fs-3 mb-0">Ultimo año</p>
                  </div>
                </div>
                <div class="col-4">
                  <div class="d-flex justify-content-end">
                    <div
                            class="text-white bg-secondary rounded-circle p-6 d-flex align-items-center justify-content-center">
                      <i class="ti ti-currency-dollar fs-6"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div id="earning">

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="components/footer.jsp"/>