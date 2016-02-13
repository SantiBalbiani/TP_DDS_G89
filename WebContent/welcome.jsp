<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">

<!-- De esta forma se van a recibir todos los datos necesarios para la pagina -->
<%@page import="usuario.Usuario, receta.Receta, java.util.*" %>
<%  String usuario1 = request.getParameter("usuario");
	String datos [] = request.getParameterValues("datos");
	Receta receta = new Receta();
	receta = (Receta) request.getAttribute("receta_ejemplo");
	Set<Receta> recetas = (Set<Receta>) session.getAttribute("recetas"); 
	Boolean datosRecibidos = false;
	if(recetas.isEmpty()){
		datosRecibidos = true;
	}
	//Agregar un array en donde vienen los datos restantes, los grupos, las primeras 3 recetas del usuario
	//Las recomendaciones tambien vienen en el array y se muestran las primeras 3/4 de las que esten en la tabla de recestas
%>

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
						<li><a href="#">Inicio</a></li>
						<li><a href="misGrupos.jsp">Mis Grupos</a></li>
						<li><a href="listadoDeRecetas.jsp">Mis Recetas</a></li>
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

	<!-- Jumbotron -->

	<section class="jumbotron jumbotron-kd">
		<div class="container">
			<h1>Que Comemos Hoy?</h1>
			<p>Recetas sugeridas para una alimentación saludable</p>
		</div>
	</section>

	<section class="main container">
<!-- Crear las 2 columnas para mostrar los datos -->
<!-- Hacer una seccion para que se puedan ver las recetas del usuario -->
	<div id="columna1">
		<div class="panel panel-default" id="recetasPropias">
			<!-- Asi se muestran lo que se recibe del servlet -->
			<div class="panel-heading">Recetas tuyas, <%=usuario1%></div>
			<div class="panel-body">
				<!-- Buscar las recetas del usuario y poner algunas aca -->
				<% if(datosRecibidos){ %>
					<p>Todavía no tienes ninguna receta!</p>
				<% } else {%>
					<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
						<% int i = 0; 
						String collapse1 = "collapseOne";
						String heading1 = "headingOne";
						String collapse2 = "collapseTwo";
						String heading2 = "headingTwo";
						String collapse3 = "collapseThree";
						String heading3 = "headingThree";
						
						for(Receta receta1 : recetas) { 
							i++;
						%>
						<div class="panel panel-default">
						
<!--     						<div class="panel-heading" role="tab" id="headingOne"> -->
<!--       							<h4 class="panel-title"> -->
<!--         							<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> -->

          								<% switch(i){
          								case 1: out.println("<div class=\"panel-heading\" role=\"tab\" id=\"" + heading1 + "\"");
          										out.println("<h4 class=\"panel-title\"");
          										out.println("<a role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#" + collapse1 + "\" aria-expanded=\"true\" aria-controls=\"" + collapse1 +"\">");  
          										out.println(receta1.getNombreReceta()); 
          										out.println("</a>");
          										out.println("</h4>");
  												out.println("</div>");
  												out.println("<div id=\""+ collapse1 + "\" class=\"panel-collapse collapse in\" role=\"tabpanel\" aria-labelledby=" + heading1 + ">");
          										break;
          								case 2: out.println("<div class=\"panel-heading\" role=\"tab\" id=\"" + heading2 + "\"");
  												out.println("<h4 class=\"panel-title\"");
          										out.println("<a role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#" + collapse2 + "\" aria-expanded=\"false\" aria-controls=\"" + collapse2 +"\">");  
  												out.println(receta1.getNombreReceta()); 
  												out.println("</a>");
  												out.println("</h4>");
  												out.println("</div>");
  												out.println("<div id=\""+ collapse2 + "\" class=\"panel-collapse collapse in\" role=\"tabpanel\" aria-labelledby=" + heading2 + ">");
          										break;
          								case 3: out.println("<div class=\"panel-heading\" role=\"tab\" id=\"" + heading3 + "\"");
												out.println("<h4 class=\"panel-title\"");
          										out.println("<a role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#" + collapse3 + "\" aria-expanded=\"false\" aria-controls=\"" + collapse3 +"\">");  
  												out.println(receta1.getNombreReceta()); 
  												out.println("</a>");
  												out.println("</h4>");
  												out.println("</div>");
  												out.println("<div id=\""+ collapse3 + "\" class=\"panel-collapse collapse in\" role=\"tabpanel\" aria-labelledby=" + heading3 + ">");
          										break;
          								default:
          										out.println("<p>Todavía no tienes ninguna receta!</p>");
          										break;
          								}
          								%>
          								
<!--       							</h4> -->
<!--     						</div> -->
<!--     						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne"> -->
<!--       						<div class="panel-body"> -->
      								<%  out.println("<div class=\"panel-body\"> Preparacion :");
      									out.println(receta1.getPreparacion()); 
      									out.println("</div>");
      									out.println("</div>");
      								%>
<!--       						</div> -->
<!--     						</div> -->
  						</div>
  						<% } %>
				<% } %>
				<br />
				<br />
				<a class="btn btn-default" href="nuevaReceta.jsp" role="button" id="nuevaReceta" data-toggle="tooltip" title="Crear una nueva receta" data-placement="left">
					Crear receta  <span class="glyphicon glyphicon-plus"></span>
				</a>
				
				<a class="btn btn-default" href="listadoDeRecetas.jsp" role="button" id="verRecetas" data-toggle="tooltip" title="Ver todas las recetas disponibles" data-placement="right">
					Ver todas mis recetas  <span class="glyphicon glyphicon-plus"></span>
				</a>
				
			</div>
		</div>
<!-- Hacer una seccion para que se puedan ver los grupos a los que pertenece el usuario -->
		<div class="panel panel-default" id="grupos">
			<div class="panel-heading">Grupos a los que perteneces</div>
			<div class="panel-body">
				<!-- Buscar los grupos a los que pertenece el usuario -->
			</div>
		</div>
	</div>
	</div>
<!-- Hacer una seccion para que se puedan ver las recetas recomendadas (en forma de columna a la derecha) -->
	<div id="columna2">
		<div class="panel panel-default" id="recomendaciones">
			<div class="panel-heading">Recomendaciones</div>
			<div class="panel-body">
				<!-- Obtener las recomendaciones -->
			</div>
		</div>
	</div>
	</section>
	<footer></footer>
	
	
</body>
</html>