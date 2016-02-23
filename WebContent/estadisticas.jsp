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
						<li><a href="estadisticas.jsp">Estadisticas</a></li>
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
			  	<div class="col-md-4"><a class="btn btn-default" href="crearIngredientes.jsp" role="button" id="nuevaReceta" data-toggle="tooltip" title="Crear una nueva receta" data-placement="bottom">
				 Agregar Receta <br> <span class="glyphicon glyphicon-plus"></span></a>
				 </div>
			</div>
			
			<div class="row">
<!-- 			  	<div class="col-sm-8"> <p>Estadisticas</p> </div> -->
			  	<div class="col-md-4"><a class="btn btn-default" href="reportes.jsp" role="button" id="nuevoReport" data-toggle="tooltip" title="Ver recetas" data-placement="bottom">
				 Ver Reportes Adicionales <span class="glyphicon glyphicon-bell"></span></a>
				 </div>
			</div>
		</div>	
</section>


<section class="main container">
<div class="panel panel-default" id="MostrarGrupos">
	<div class="panel-heading"> <h3> Estadísticas Semanales </h3> </div>
	<div class="panel-body">
		
		<div class="panel panel-default" id="Segun Genero">
		<div class=panel-heading>   <center> <h3> Según Género </h3> </center> </div>
		<div class="panel-body">
		<div class="row">
			  
			 <div class="col-sm-5"> <center> <h4><u> Masculino </u></h4> </center>
			 <ul>
			 	<li><p>Empanada</p></li>
			 	<li><p>Empanada</p></li>
			 	<li><p>Empanada</p></li>
			 </ul>
			 </div>
			  
			 <div class="col-sm-5"> <center> <h4><u> Femenino </u></h4> </center>
			  <ul>
			 	<li><p>Pizza</p></li>
			 	<li><p>Pizza</p></li>
			 	<li><p>Pizza</p></li>
			 </ul>
			 </div>
		</div>
		</div>
		</div>
	
		<br><br>
		
		<div class="panel panel-default" id="Segun Dificultad">
		<div class=panel-heading>   <center> <h3> Según Nivel de Dificultad </h3> </center> </div>
		<div class="panel-body">
		<div class="row">
			  
			 <div class="col-sm-5"> <center> <h4><u>Fácil</u></h4> </center>
			 <ul>
				<center><p>NombreReceta</p></center>
				<center><p>NombreReceta</p></center>
				<center><p>NombreReceta</p></center>
			 </ul>
			 </div>
			 
			 <div class="col-sm-5"> <center> <h4><u>Media</u></h4> </center>
			 <ul>
			 	<center><p>NombreReceta</p></center>
				<center><p>NombreReceta</p></center>
				<center><p>NombreReceta</p></center>
			 </ul>
			 </div>
			 
			 			 
			 <div class="col-sm-5"> <center> <h4><u>Difícil</u></h4> </center>
			 <ul>
			 	<center><p>NombreReceta</p></center>
				<center><p>NombreReceta</p></center>
				<center><p>NombreReceta</p></center>
			  </ul>
			 </div>
			  
			 <div class="col-sm-5"> <center> <h4><u>Muy difícil</u></h4> </center>
			  <ul>
			 	<center><p>NombreReceta</p></center>
				<center><p>NombreReceta</p></center>
				<center><p>NombreReceta</p></center>
			 </ul>
			 </div>
		</div>
		</div>
		</div>
		
		<div class="panel panel-default" id="Ultimas 3">
			<div class=panel-heading>   <center> <h3>Ultimas 3 recetas más consultadas </h3> </center> </div>
				<div class="panel-body">
					<div class="row">
						  <ul>
						 	<li><p>Nombre de receta 1</p></li>
						 	<li><p>Nombre de receta 2</p></li>
						 	<li><p>Nombre de receta 3</p></li>
						 </ul>
					</div>
				</div>
			</div>
	</div>
</div>
</section>


</body>
</html>