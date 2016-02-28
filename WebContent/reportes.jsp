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
					<a href="creditos.jsp" class="navbar-brand">Qué Comemos Hoy?</a>
                    <ul class="nav navbar-nav">
						<li><a href="welcome.jsp">Inicio</a></li>
						<li><a href="misGrupos.jsp">Mis Grupos</a></li>
						<li><a href="listadoDeRecetas.jsp">Mis Recetas</a></li>
						<li><a href="misDatos.jsp">Mis Datos</a></li>
						<li><a href="reportes.jsp">Reportes</a></li>
						<li><a href="#" onclick="logout();">Cerrar Sesión</a></li>								
						
					</ul>
				</div>
				<!-- Inicia Menu -->
				<div class="collapse navbar-collapse" id="navegacion-kd">
					<form action="ListarRecetasEncontradas" method="post" class="navbar-form navbar-right" role="search">
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
			<p>Consultar por Período</p>
			
<!-- 			 			<div class="row"> -->
<!-- <!-- 			  	<div class="col-sm-8"> <p>Estadisticas</p> </div> --> 
<!-- 			  	<div class="col-md-4"><a class="btn btn-default" href="estadisticas.jsp" role="button" id="nuevoReport" data-toggle="tooltip" title="Ver recetas" data-placement="bottom"> -->
<!-- 				 Ver Estadisticas <span class="glyphicon glyphicon-bell"></span></a> -->
<!-- 				 </div> -->
			</div>
		</div>	
	</section>
	
<!-- <section class="main container" id="Recetas consultadas">	 -->
<!-- 	<div class="panel panel-default" id="Ultimas 3"> -->
<!-- 			<div class=panel-heading>  <h3>Recetas consultadas </h3> </div> -->
<!-- 				<div class="panel-body"> -->
					
<!-- 					<form action="ReporteRecetas" method="post" class="form-group"> -->
<!-- 					<div class="row"> -->
<!-- 							 	<div class="col-sm-4"> -->
<!-- 							   		Fecha Inicial -->
<!-- 								</div> -->
<!-- 						 	  	<div class="col-sm-4"> -->
<!-- 							   		Fecha Final -->
<!-- 								</div> -->
<!-- 					</div> -->
		  			
				
<!-- 					   	<div class="row"> -->
<!-- 							 	</div> -->
<!-- 							 	<div class="col-sm-4"> -->
<!-- 							   		<input type="date" class="form-control" id="consultaReceta1" name="consultaReceta1" placeholder="Fecha inicial  (dd/mm/aaaa)" required> -->
<!-- 								</div> -->
<!-- 						 	  	<div class="col-sm-4"> -->
<!-- 							   		<input type="date" class="form-control" id="consultaReceta2" name="consultaReceta2" placeholder="Fecha final (dd/mm/aaaa)" required> -->
<!-- 								</div> -->
<!-- 								<div class="col-sm-1"><button type="submit" id="evento_aceptar" name="evento_aceptar" class="btn btn-default">Consultar</button> -->
<!-- 						 	</div> -->
						 	
<!-- 						 	<input type="hidden" name="esReporte" id="esReporte" value="EntreFechas"> -->
						 	
<!-- 						 </form> -->
<!-- 		  			</div> -->
		  		
<!-- 	</div> -->
<!-- </section> -->

<section class="main container" id="Nuevas Recetas">	
	<div class="panel panel-default" id="Nuevas Recetas">
			<div class=panel-heading>  <h3>Recetas Nuevas</h3> </div>
				<div class="panel-body">
					
					<form action="ReporteRecetas" method="post" class="form-group">
					<div class="row">
							 	<div class="col-sm-4">
							   		Fecha Inicial
								</div>
						 	  	<div class="col-sm-4">
							   		Fecha Final
								</div>
					</div>
		  			
				   	<div class="row">
							 	</div>
							 	<div class="col-sm-4">
							   		<input type="date" class="form-control" id="NewReceta1" name="newReceta1" placeholder="dd/mm/aaaa" required>
								</div>
						 	  	<div class="col-sm-4">
							   		<input type="date" class="form-control" id="newReceta2" name="newReceta2" placeholder="dd/mm/aaaa" required>
								</div>
								<div class="col-sm-1"><button type="submit" id="evento_aceptar" name="evento_aceptar" class="btn btn-default">Consultar</button>
						 	</div>
		  			
		  					<input type="hidden" name="esReporte" id="esReporte" value="newEntreFechas">
					  			
		  			</form>
		  		</div> 
	</div>
</section>

<section class="main container" id="Recetas por Calorias">	
	<div class="panel panel-default" id="Recetas por Calorias">
			<div class=panel-heading>  <h3>Recetas por Calorías</h3> </div>
				<div class="panel-body">
					<form action="ReporteRecetas" method="post" class="form-group">
					<div class="row">
							 	<div class="col-sm-4">
							   		Mín Calorías
								</div>
						 	  	<div class="col-sm-4">
							   		Máx Calorías
								</div>
					</div>
		  			
					<div class="row">
							 	</div>
							 	<div class="col-sm-4">
							   		<input type="text" class="form-control" id="MinCal" name="MinCal" placeholder="Calorias (Mín)" required>
								</div>
						 	  	<div class="col-sm-4">
							   		<input type="text" class="form-control" id="MaxCal" name="MaxCal" placeholder="Calorias (Máx)" required>
								</div>
								<div class="col-sm-1"><button type="submit" id="evento_aceptar" name="evento_aceptar" class="btn btn-default">Consultar</button>
						 	</div>
					
					<input type="hidden" name="esReporte" id="esReporte" value="entreCalorias">
					
		  			</form>
		  		</div> 
		  		
		  		
	</div>
</section>


</body>
</html>