<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">


<!-- De esta forma se van a recibir todos los datos necesarios para la pagina -->
<%@page import="usuario.Usuario, receta.Receta, java.util.*" %>
<%  

	String usuario1 = request.getParameter("usuario");
	String datos [] = request.getParameterValues("datos");
	Receta receta = new Receta();
	receta = (Receta) request.getAttribute("receta_ejemplo");
	Set<Receta> recetas = (Set<Receta>) session.getAttribute("recetas"); 
	Boolean datosRecibidos = false;
	if(recetas.isEmpty()){
		datosRecibidos = true;
	}
	Usuario unUsuario = new Usuario();
	unUsuario = unUsuario.buscarUsuarioPorNombre(usuario1);
	
	
	Set<Receta> recetasDeUsaurio =unUsuario.getRecetasUser();
	Iterator<Receta>  itRecetas  = recetasDeUsaurio.iterator();
	while (itRecetas.hasNext()) {
	       
		  Receta recetaDeUsario = (Receta) itRecetas.next();
	 	System.out.println(recetaDeUsario.getNombreReceta()); 
	  }
	//Agregar un array en donde vienen los datos restantes, los grupos, las primeras 3 recetas del usuario
	//Las recomendaciones tambien vienen en el array y se muestran las primeras 3/4 de las que esten en la tabla de recestas
%>

<head>
	<meta charset="UTF-8">
	<title>Qué Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
		<script type="text/javascript">
	function logout(){
	    if(confirm("Seguro que quieres cerrar la sesión?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
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
					<a href="creditos.jsp" class="navbar-brand">Qué Comemos Hoy?</a>
                    <ul class="nav navbar-nav">
						<li><a href="welcome.jsp">Inicio</a></li>
						<li><a href="misGrupos.jsp">Mis Grupos</a></li>
						<li><a href="listadoDeRecetas.jsp">Mis Recetas</a></li>
						<li><a href="misDatos.jsp">Mis Datos</a></li>
						<li><a href="#" onclick="logout();">Cerrar Sesión</a></li>
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
	
	<section class="jumbotron jumbotron-kd">
		<div class="container">
			<h1>Qué Comemos Hoy?</h1>
			<p>Mis Recetas</p>
		</div>
	</section>
	

<section class="main container">
<div class="panel panel-default" id="MostrarGrupos">
	<div class="panel-heading"> Seleccionar la receta deseada para ver detalles </div>
	
			
			<div class="panel-body"> <b><a href="verReceta.jsp"> Receta "nombre de receta 1" </a></b></div>
		
			<div class="panel-body"> <b><a href="verReceta.jsp"> Receta "nombre de receta 2" </a></b></div>
			
			<div class="panel-body"> <b><a href="verReceta.jsp"> Receta "nombre de receta 3" </a></b></div>
			
			<br>
		</div>
</section>

<!-- <section class="main container">
<div class="panel panel-default" id="MostrarGrupos">
	<div class="panel-heading"> Seleccionar la receta deseada para ver detalles </div>
	<br>
			<a href="verReceta.jsp" class="btn btn-primary btn-sm2 pull-left">Ver detalles</a>
	  		<div class="panel-body" style="text-indent: 1cm;" > Receta "Nombre de Receta 1"</div>
	  		<br>
			<a href="verReceta.jsp" class="btn btn-primary btn-sm2 pull-left">Ver detalles</a>
	  		<div class="panel-body" style="text-indent: 1cm;" > Receta "Nombre de Receta 2"</div>
	  		<br>
			<a href="verReceta.jsp" class="btn btn-primary btn-sm2 pull-left">Ver detalles</a>
	  		<div class="panel-body" style="text-indent: 1cm;" > Receta "Nombre de Receta 3"</div>
			
</div>
</section> -->
				
</body>
</html>