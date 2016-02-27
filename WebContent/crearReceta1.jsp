<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<title>Que Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
		<script type="text/javascript">
			function logout(){
	   			 if(confirm("Seguro que quieres cerrar la sesion?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
	     	{
	    	window.location="logout.jsp"; 
	     	}else{
	       return false;
	    }
	   return true;
	 }
	</script>

<style type="text/css">
    /* show the move cursor as the user moves the mouse over the panel header.*/
    #draggablePanelList .panel-heading {
        cursor: move;
    }
</style>

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
					<a href="creditos.jsp" class="navbar-brand">Que Comemos Hoy?</a>
                    <ul class="nav navbar-nav">
						<li><a href="welcome.jsp">Inicio</a></li>
						<li><a href="misGrupos.jsp">Mis Grupos</a></li>
						<li><a href="listadoDeRecetas.jsp">Mis Recetas</a></li>
						<li><a href="misDatos.jsp">Mis Datos</a></li>
						<li><a href="reportes.jsp">Reportes</a></li>
						<li><a href="#" onclick="logout();">Cerrar Sesion</a></li>								
						
					</ul>
				</div>
				<!-- Inicia Menu -->
				<div class="collapse navbar-collapse" id="navegacion-kd">
					<form action="BuscarReceta" method="post" class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Buscar Receta" name="buscar_nombreReceta">
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
				<div class="row">
					  	<div class="col-sm-8"> <h1>Qué Comemos Hoy?</h1> </div>
					  	<div class="col-sm-4"><a class="btn btn-default" href="nuevaReceta.jsp" role="button" id="nuevaReceta" data-toggle="tooltip" title="Crear una nueva receta" data-placement="bottom">
						 Agregar Receta <br> <span class="glyphicon glyphicon-plus"></span></a> </div>
				</div>
			<p> Paso 1: Personalizar Receta </p> 
			</div>
</section>

<div class="container"> 
  <div class="container">
				<div class="row">
					  	<div class="col-sm-6"> 
						  	<form role="form">
							    <div class="form-group">
							      <label for="sel2">Seleccionar Condimento (Se puede seleccionar mas de uno):</label>
							      <select multiple class="form-control" id="sel2">
							        <option>Sal</option>
							        <option>Pimienta</option>
							        <option>Oregano</option>
							        <option>Salsa</option>
							        <option>Ají</option>
							      </select>
							    </div>
							   <button type="submit" class="btn btn-default">Agregar</button>
							  </form>
						 </div>
					  	
					  	<div class="col-sm-5"> 
					  		<div class="form-group">
								<label for="inputIngredientes">Condimentos</label>
									<div class="panel panel-default" id="panelDrop">
										<div id="div1" class="panel-body" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
									</div>
							</div>
						</div>
				</div>
	</div>
</div>

</body>
</html>