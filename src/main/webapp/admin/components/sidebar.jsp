<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="sidebar-nav scroll-sidebar" data-simplebar="">
  <ul id="sidebarnav">
    <li class="nav-small-cap">
      <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
      <span class="hide-menu">Home</span>
    </li>
    <li class="sidebar-item">
      <a class="sidebar-link" href="dashboard.jsp" aria-expanded="false">
                <span>
                  <i class="ti ti-layout-dashboard"></i>
                </span>
        <span class="hide-menu">Inicio</span>
      </a>
    </li>
    <li class="nav-small-cap">
      <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
      <span class="hide-menu">Menu</span>
    </li>
    <li class="sidebar-item">
      <a class="sidebar-link" href="productos" aria-expanded="false">
                <span>
                  <i class="ti ti-article"></i>
                </span>
        <span class="hide-menu">Productos</span>
      </a>
    </li>
    <li class="sidebar-item">
      <a class="sidebar-link" href="combos" aria-expanded="false">
                <span>
                  <i class="ti ti-alert-circle"></i>
                </span>
        <span class="hide-menu">Combos</span>
      </a>
    </li>
    <li class="nav-small-cap">
      <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
      <span class="hide-menu">Gestionar</span>
    </li>
    <li class="sidebar-item">
      <a class="sidebar-link" href="pedidos" aria-expanded="false">
                <span>
                  <i class="ti ti-login"></i>
                </span>
        <span class="hide-menu">Pedidos</span>
      </a>
    </li>

    <li class="sidebar-item">
      <a class="sidebar-link" href="usuarios" aria-expanded="false">
                <span>
                  <i class="ti ti-user-circle"></i>
                </span>
        <span class="hide-menu">Usuarios</span>
      </a>
    </li>

    <li class="sidebar-item">
      <a class="sidebar-link" href="proveedores" aria-expanded="false">
                <span>
                  <i class="ti ti-user"></i>
                </span>
        <span class="hide-menu">Proveedores</span>
      </a>
    </li>
    <li class="nav-small-cap">
      <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
      <span class="hide-menu">Historial</span>
    </li>
    <li class="sidebar-item">
      <a class="sidebar-link" href="historial" aria-expanded="false">
                <span>
                  <i class="ti ti-mood-happy"></i>
                </span>
        <span class="hide-menu">Pedidos</span>
      </a>
    </li>
  </ul>
</nav>
<!-- End Sidebar navigation -->
</div>
<!-- End Sidebar scroll-->
</aside>
<!--  Sidebar End -->
<!--  Main wrapper -->
<div class="body-wrapper">
  <!--  Header Start -->
  <header class="app-header">
    <nav class="navbar navbar-expand-lg navbar-light">
      <ul class="navbar-nav">
        <li class="nav-item d-block d-xl-none">
          <a class="nav-link sidebartoggler nav-icon-hover" id="headerCollapse" href="javascript:void(0)">
            <i class="ti ti-menu-2"></i>
          </a>
        </li>
      </ul>
      <div class="navbar-collapse justify-content-end px-0" id="navbarNav">
        <ul class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
          <li class="nav-item dropdown">
            <a class="nav-link nav-icon-hover" href="javascript:void(0)" id="drop2" data-bs-toggle="dropdown"
               aria-expanded="false">
              <img src="assets/images/profile/user-1.jpg" alt="" width="35" height="35" class="rounded-circle">
            </a>
            <div class="dropdown-menu dropdown-menu-end dropdown-menu-animate-up" aria-labelledby="drop2">
              <div class="message-body">
                <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                  <i class="ti ti-user fs-6"></i>
                  <p class="mb-0 fs-3">My Profile</p>
                </a>
                <a href="../logout" class="btn btn-outline-primary mx-3 mt-2 d-block">Logout</a>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!--  Header End -->
