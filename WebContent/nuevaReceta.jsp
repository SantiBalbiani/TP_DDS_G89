<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">

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
	<header>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navegacion-kd">
						<span class="sr-only"> Desplegar / Ocultar Menu</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a href="#" class="navbar-brand">Que Comemos Hoy?</a>
					<ul class="nav navbar-nav">
						<!-- Agregar la session para que quede guardado el usuario -->
						<li><a href="welcome.jsp">Inicio</a></li>
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
	</header>

	
	<section class="main container">
	<br><br>
		<div class="panel panel-default">
			<div class="panel panel-heading">Nueva receta!</div>
			<div class="panel-body">
				<div class="col-xs-8 col-md-offset-2">
					<form action="" method="post">
						<div class="form-group">
							<label for="inputNombreReceta">Nombre de la receta</label> 
							<input type="text" class="form-control" id="nombreDeReceta" />
						</div>

						<!-- Encontrar la forma de agregar ingredientes y condimentos -->
						<div class="form-group">
							<label for="inputIngredientes">Ingredientes</label>
							<ul class="list-group">
								<li class="input-group">
  									<input type="text" class="form-control" placeholder="Ingrediente" id="ingrediente">
  									<input type="number" class="form-control" placeholder="Calorias" id="calorias">
								</li>
								<br />
								<li class="input-group">
  									<input type="text" class="form-control" placeholder="Ingrediente" id="ingrediente">
  									<input type="number" class="form-control" placeholder="Calorias" id="calorias">
								</li>
								<br	/>
								<li class="input-group">
  									<input type="text" class="form-control" placeholder="Ingrediente" id="ingrediente">
  									<input type="number" class="form-control" placeholder="Calorias" id="calorias">
								</li>
							</ul>
						</div>

						<div class="form-inline">
							<label for="inputPreparacion">Preparación</label><br>
							<textarea class="form-control" rows="5" id="preparacion"></textarea>
						</div>
						
						<div class="form-group">
							<label for="inputCondimentos">Condimentos</label>
							<ul class="list-group">
								<li class="input-group">
									<input type="text" class="form-control" placeholder="Condimento" id="condimento">
								</li>
								<li class="input-group">
									<input type="text" class="form-control" placeholder="Condimento" id="condimento">
								</li>
								<li class="input-group">
									<input type="text" class="form-control" placeholder="Condimento" id="condimento">
								</li>
							</ul>
						</div>
						
						<div class="form-group">
							<label for="inputCategorias">Categorias</label>
						</div>
						
						<!-- Van a ser checkboxes -->
						<div class="form-group">
							<label for="inputDificultad" class="control-label" >Nivel de Dificultad</label>
        						<select class="form-control" id="dificultad">
				          			<option value="F">Fácil</option>
				          			<option value="M">Medio</option>
				          			<option value="D">Difícil</option>
				        		</select>
						</div>
						
						<div class="form-group">
							<label for="inputSector">Sector en la piramide alimenticia</label>
						</div>
						
						<div class="form-group">
				      		<div class="col-lg-9 col-lg-offset-3">
				        		<button type="reset" class="btn btn-default">Cancelar</button>
				        		<button type="submit" class="btn btn-primary">Aceptar</button>
				      		</div>
				    	</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
	
</body>
</html>