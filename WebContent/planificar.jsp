<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<title>Qué Comemos Hoy?</title>
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
						<li><a href="estadisticas.jsp">Estadísticas</a></li>
						<li><a href="#" onclick="logout();">Cerrar Sesión</a></li>
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
			<h1>Qué Comemos Hoy?</h1>
			<p>Planificar Comidas Diarias </p>
		</div>
</section>


<section class="main container">

<div class="panel-body">
			<div class="panel panel-default" id="Ultimas 3">
				<div class=panel-heading>  <h3>Planificación</h3> </div>
				<div class="panel-body" id="1">		
					<form action="PlanificarComidas" method="post" class="form-group">
<!-- 						<div class="row"> -->
<!-- 							 	<div class="col-sm-4"> -->
<!-- 							   		Fecha -->
<!-- 								</div> -->
<!-- 						</div> -->
		  			
				
					   	<div class="row">
							 	</div>
							 	<div class="col-sm-3">
							   		<input type="date" class="form-control" id="planFecha" name="planFecha" placeholder="Fecha" required>
								</div>
						 	  <div class="col-sm-3">
							   		<input type="text" class="form-control" id="planNombre" name="planNombre" placeholder="Nombre De Receta" required>
								</div>
								<div class="col-sm-3">
									<select class="form-control" id="tipo" name="tipo">
				          				  <option disabled selected> -- Elija una opcion -- </option>
								          <option value="D">Desayuno</option>
								          <option value="A">Almuerzo</option>
								          <option value="M">Merienda</option>
								          <option value="C">Cena</option>
				       				 </select>
								</div>
								<div class="col-sm-1">
									<button type="submit" id="eventoPlanificar" name="eventoPlanificar" class="btn btn-default">Planificar</button>
						 		</div>
						 		
						 		<input type="hidden" name="esPlanificacion" id="esPlanificacion" value="planificacion">
						 	
						</form>
																
		  			</div>
		 		</div>
</div>


<div class="panel body" id="2">
		  			
		  			 <table class="table table-bordered">
					    <thead>
					      <tr>
					        <th>Fecha</th>
					        <th>Receta</th>
					        <th>Categoria</th>
					      </tr>
					    </thead>


<!-- 	Acá en el body hay que hacer lo mismo de mostrar recetas de las tablas, -->
<!-- 	 mostrar los planes agendados en tabla de forma recursiva uno debajo del otro   -->
					   
					   
					    <tbody>
					      
					      <tr>
					        <td>18/02/2016</td>
					        <td>Mila con Papas</td>
					        <td>Desayuno</td>
					      </tr>
					     
					      <tr>
					        <td>20/02/2016</td>
					        <td>Bife con fritas</td>
					        <td>Cena</td>
					      </tr>
					   
					    </tbody>
					  
					  </table>
</div>

</section>









</body>
</html>