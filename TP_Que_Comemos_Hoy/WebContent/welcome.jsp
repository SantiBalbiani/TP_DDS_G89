<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Que Comemos Hoy?</title>
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
  <header>
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegacion-kd">
            <span class="sr-only"> Desplegar / Ocultar Menu</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="#" class="navbar-brand">Que Comemos Hoy?</a>
        </div>
      <!-- Inicia Menu -->
      <div class="collapse navbar-collapse" id="navegacion-kd">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Inicio</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">
              Recetas <span class="caret"></span>
            </a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="#">Desayuno</a></li>
              <li><a href="#">Almuerzo</a></li>
              <li><a href="#">Merienda</a></li>
              <li><a href="#">Cena</a></li>
              <li class="divider"></li>
              <li><a href="#">Todas</a></li>
            </ul>
          </li>
          <li><a href="#">Grupos</a></li>
          <li><a href="#">Configuracion</a></li>
        </ul> 

        <form action="" class="navbar-form navbar-right" role="search">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Buscar"> 
          </div>
          <button type="submit" class="btn btn-default">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </form>     
      </div>
      

      </div>
    </nav>
  </header>

  <!-- Jumbotron -->

  <section class="jumbotron jumbotron-kd">
    <div class="container">
      <h1>Que Comemos Hoy?</h1>
      <p>Recetas sugeridas para una alimentación saludable</p>
    </div>
  </section>

  <section class="main container"></section>

  <footer></footer>

  <script src="js/jquery.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>