<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">

<!-- De esta forma se van a recibir todos los datos necesarios para la pagina -->
<%@page import="usuario.Usuario, usuario.GrupoUsuarios, receta.Receta, java.util.*" %>
<%  
	Usuario user = (Usuario) session.getAttribute("usuario");
	Set<Receta> recetas = (Set<Receta>) session.getAttribute("recetas");
	Set<GrupoUsuarios> grupos = (Set<GrupoUsuarios>) session.getAttribute("gruposDelUsuario");
%>

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
					<a href="creditos.jsp" class="navbar-brand">Que Comemos Hoy?</a>
                    <ul class="nav navbar-nav">
						<li><a href="#">Inicio</a></li>
						<li><a href="misGrupos.jsp">Mis Grupos</a></li>
						<li><a href="listadoDeRecetas.jsp">Mis Recetas</a></li>
						<li><a href="misDatos.jsp">Mis Datos</a></li>
						<li><a href="#" onclick="logout();">Cerrar Sesion</a></li>
					</ul>
				</div>
				<!-- Inicia Menu -->
				<div class="collapse navbar-collapse" id="navegacion-kd">
					<form action="Buscar" method="post" class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Buscar" name="nombreReceta">
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
			<div class="panel-heading">Recetas tuyas, <% out.println(user.getNombreUsuario()); %></div>
			<div class="panel-body">
				<!-- Buscar las recetas del usuario y poner algunas aca -->
				<% if(recetas.isEmpty()){ %>
					<p>Todavía no tienes ninguna receta!</p>
				<% } else {%>
					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<%
							int i = 0;
						
							for (Receta receta1 : recetas) {
								i++;
						%>
						<div class="panel panel-default">
						
<%
								switch (i) {
										case 1:
											out.println("<div class=\"panel-heading\" role=\"tab\" id=\"headingOne\">");
										    out.println("<h4 class=\"panel-title\">");
										    out.println("<a role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">");
										    out.println(receta1.getNombreReceta());
										    out.println("</a>");
											out.println("</h4>");
											out.println("</div>");
										    out.println("<div id=\"collapseOne\" class=\"panel-collapse collapse in\" role=\"tabpanel\" aria-labelledby=\"headingOne\">");
											break;
										case 2:
											out.println("<div class=\"panel-heading\" role=\"tab\" id=\"headingTwo\">");
											out.println("<h4 class=\"panel-title\">"); 
											out.println("<a class=\"collapsed\" role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">");
											out.println(receta1.getNombreReceta());
											out.println("</a>");
											out.println("</h4>");
											out.println("</div>");
										    out.println("<div id=\"collapseTwo\" class=\"panel-collapse collapse\" role=\"tabpanel\" aria-labelledby=\"headingTwo\">");
											break;
										case 3:
											out.println("<div class=\"panel-heading\" role=\"tab\" id=\"headingThree\">");
										    out.println("<h4 class=\"panel-title\">");
										    out.println("<a class=\"collapsed\" role=\"button\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">");
										    out.println(receta1.getNombreReceta());
										    out.println("</a>");
											out.println("</h4>");
											out.println("</div>");
										    out.println("<div id=\"collapseThree\" class=\"panel-collapse collapse\" role=\"tabpanel\" aria-labelledby=\"headingThree\">");
											break;
										default:
											out.println("<p>Todavía no tienes ninguna receta!</p>");
											break;
										}

										out.println("<div class=\"panel-body\"> Preparacion :");
										out.println(receta1.getPreparacion());
										out.println("</div>");
										out.println("</div>");
										out.println("</div>");
									}
								}
							%>
				<br />
				<br />
				<a class="btn btn-default" href="nuevaReceta.jsp" role="button" id="nuevaReceta" data-toggle="tooltip" title="Crear una nueva receta" data-placement="bottom">
					Crear receta  <span class="glyphicon glyphicon-plus"></span>
				</a>
				
				<a class="btn btn-default" href="planificar.jsp" role="button" id="verRecetas" data-toggle="tooltip" title="Ver todas las recetas disponibles" data-placement="bottom">
					Planificar  <span class="glyphicon glyphicon-th-list"></span>
				</a>
				
				<a class="btn btn-default" href="listadoDeRecetas.jsp" role="button" id="verRecetas" data-toggle="tooltip" title="Ver todas las recetas disponibles" data-placement="bottom">
					Ver todas mis recetas  <span class="glyphicon glyphicon-th-list"></span>
				</a>
				
			</div>
		</div>
	</div>
<!-- Hacer una seccion para que se puedan ver los grupos a los que pertenece el usuario -->
		<div class="panel panel-default" id="grupos">
			<div class="panel-heading">Grupos a los que perteneces</div>
			<div class="panel-body">
				<!-- Buscar los grupos a los que pertenece el usuario -->
<%-- 				<% for(GrupoUsuarios grupo : grupos) { %> --%>
				<div class="panel panel-default">
  					<div class="panel-body">
    					Grupo 1<span class="glyphicon glyphicon-menu-right" id="flechita"></span>
  					</div>
				</div>
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
	<footer>
		<!-- Aca deberia ir un logout o algo por el estilo -->
	</footer>
	
	
</body>
</html>