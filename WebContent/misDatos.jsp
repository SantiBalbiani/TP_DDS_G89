<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">
<%@page import="usuario.Usuario, receta.Receta" %>

<%	String receta2 = "Arrozz"; %>

<head>
	<meta charset="UTF-8">
	<title>Que Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
</head>


<body>
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
                    <ul class="nav navbar-nav">
						<li><a href="welcome.jsp">Inicio</a></li>
						<li><a href="misGrupos.jsp">Mis Grupos</a></li>
						<li><a href="listadoDeRecetas.jsp">Mis Recetas</a></li>
						<li><a href="misDatos.jsp">Mis Datos</a></li>
					</ul>
				</div>
				<!-- Inicia Menu -->
				<div class="collapse navbar-collapse" id="navegacion-kd">
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

<section class="jumbotron jumbotron-kd">
		<div class="container">
			<h1>Que Comemos Hoy?</h1>
			<p>Mis Datos</p>
		</div>
	</section>

<!-- Datos de usuario -->
</head>
<body onload="posicionarCursor();">
    <div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form class="form-horizontal" method="POST" action="register">
				  <fieldset>
				    <legend>Ingrese sus Datos</legend>
				    <div class="form-group">
				      <label for="inputUsuario" class="col-lg-3 control-label">Usuario</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" name ="usuario" id="inputUsuario" placeholder="Usuario" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="inputPassword" class="col-lg-3 control-label">Contraseña</label>
				      <div class="col-lg-9">
				        <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Contraseña" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="textArea" class="col-lg-3 control-label">Fecha de Nacimiento</label>
				      <div class="col-lg-9">
				        <input class="form-control" name="fechaNacimiento" type="date" id="fecha" placeholder="dd/mm/aaaa" required>
				      </div>
				    </div>
					<div class="form-group">
				      <label for="inputAltura" class="col-lg-3 control-label">Altura</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" id="altura" name="altura" placeholder="Altura(cm)" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="col-lg-3 control-label">Sexo</label>
				      <div class="col-lg-9">
				        <div class="radio">
				          <label>
				            <input type="radio" name="optionSexo"  value="M" checked="">
				            Masculino
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" name="optionSexo" value="F">
				            Femenino
				          </label>
				        </div>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="select" class="col-lg-3 control-label">Complexion</label>
				      <div class="col-lg-9">
				        <select class="form-control" id="complexion" name="complexion">
				          <option value="P">Pequeña</option>
				          <option value="M">Mediana</option>
				          <option value="G">Grande</option>
				        </select>
				      </div>
				    </div>
				    <!-- Falta agregar las condiciones preexistentes, rutina y preferencias alimenticias -->
				    <div class="form-group">
				      <label for="select" class="col-lg-3 control-label">Dieta</label>
				      <div class="col-lg-9">
				        <select class="form-control" id="dieta" name="dieta">
				          <option value="N">Normal</option>
				          <option value="V">Vegetariano</option>
				          <option value="Veg">Vegano</option>
				          <option value="OLV">Ovolacteovegetariano</option>
				        </select>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="col-lg-3 control-label">Rutina</label>
				      <div class="col-lg-9">
				        <div class="radio">
				          <label>
				            <input type="radio" value="LEVE" name="rutina">Sedentaria con algo de ejercicio (-30 min.) [LEVE]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="NADA" name="rutina">Sedentaria con nada de ejercicio [NADA]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="MEDIANO" name="rutina">Sedentaria con ejercicio [MEDIANO]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="MEDIO_INTENSIVO" name="rutina">Activa con ejercicio adicional (+30 min.) [MEDIO-INTENSIVO]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="INTENSIVO" name="rutina">Activa con ejercicio adicional (+30 min.) [INTENSIVO]
				          </label>
				        </div>
				      </div>
				    </div>
				    
				    
				    <div class="form-group">
				      <div class="col-lg-9 col-lg-offset-3">
				        <button type="reset" class="btn btn-default">Cancelar</button>
				        <button type="submit" class="btn btn-primary">Aceptar</button>
				      </div>
				    </div>
				  </fieldset>
				</form>
			</div>
		</div>
	</div>
    
      
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<!-- Modificar Datos  -->
<a class="btn btn-default" href="#" role="button" id="modificarDatos" data-toggle="tooltip" title="Aceptar la modificacion de Datos" data-placement="bottom">
					Aceptar cambios  <span class=" glyphicon glyphicon-edit"></span>
				</a>
<br><br>
<!-- Eliminar Cuenta -->

	<a class="btn btn-default" href="#" role="button" id="eliminarCuenta" data-toggle="tooltip" title="Eliminar cuenta" data-placement="bottom">
					Eliminar Cuenta  <span class=" glyphicon glyphicon-trash"></span>
				</a>
<br><br>
<!-- Cancelar edicion -->
<a class="btn btn-default" href="welcome.jsp" role="button" id="cancelarCambios" data-toggle="tooltip" title="Cancelar" data-placement="bottom">
					Cancelar  <span class=" glyphicon glyphicon-remove"></span>
				</a>
</body>
</html>