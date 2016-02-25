<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">

<!-- De esta forma se van a recibir todos los datos necesarios para la pagina -->
<%@page import="usuario.Usuario, usuario.GrupoUsuarios, receta.Receta, java.util.*" %>
<%  
	Usuario user = (Usuario) session.getAttribute("usuario");
	String errorBusqueda = (String) session.getAttribute("errorBusqueda");
	String modificoUsuario = (String) session.getAttribute("modificoUsuario");
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
					<a href="creditos.jsp" class="navbar-brand">Qué Comemos Hoy?</a>
                    <ul class="nav navbar-nav">
						<li><a href="#">Inicio</a></li>
						<li><a href="misGrupos.jsp">Mis Grupos</a></li>
						<li><a href="listadoDeRecetas.jsp">Mis Recetas</a></li>
						<li><a href="misDatos.jsp">Mis Datos</a></li>
						<li><a href="estadisticas.jsp">Estadisticas</a></li>
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
				
				<% if (errorBusqueda.equals("yes")) {
					out.println("<div class=\"alert alert-info fade in\">");
			    	out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
			    	out.println("<strong>Info!</strong> No se encontro la receta. Intente nuevamente.");
			    	out.println("</div>");
		        	session.setAttribute("errorBusqueda", "no");	//reseteo el flag
				}%>
				<% if (modificoUsuario.equals("yes")) {
 				 out.println("<div class=\"alert alert-success fade in\">");
    out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
     out.println("<strong>Success!</strong> El usuario se modifico correctamente.");
   out.println("</div>");
 	  session.setAttribute("modificoUsuario", "no");	//reseteo el flag
 				}
  				
  				%>
				
			</div>
		</nav>
	</header>
	
	<section class="jumbotron jumbotron-kd">
		<div class="container">
			
			<div class="row">
			  	<div class="col-sm-8"> <h1>Qué Comemos Hoy?</h1> </div>
			  	<div class="col-sm-4"><a class="btn btn-default" href="crearIngredientes.jsp" role="button" id="nuevaReceta" data-toggle="tooltip" title="Crear una nueva receta" data-placement="bottom">
				 Agregar Receta <br> <span class="glyphicon glyphicon-plus"></span></a> </div>
			</div>
			
			 <p><span>Inicio</span></p>
			 
			 <div class="row">
			 <div class="col-sm-8"><a class="btn btn-default" href="planificar.jsp" role="button" id="planificar" data-toggle="tooltip" title="Crear una nueva receta" data-placement="bottom">
				Planificar <br> <span class="glyphicon glyphicon-pencil"></span></a> </div>
			</div>
			
		</div>
	</section>


	<section class="main container">
		<div class="panel panel-default" id="Reco diaria">
			<div class="panel-heading"> <b>Recomendacion del día </b></div>
			<div class="panel-body">  Sugerencia del día bla bla</div>
			</div>		
	</section>	
	
	<section class="main container">
		<div class="panel panel-default" id="Reco balance">
			<div class="panel-heading"><b> Recomendacion Balanceada </b></div>
			<div class="panel-body"> Sugerencia balanceada del día bla bla</div>
			</div>		
	</section>
	
	<section class="main container">
		<div class="panel panel-default" id="Tus recetas aceptadas">
			<div class="panel-heading"><b> Historial de recetas </b></div>
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
										    out.println("</a>");											out.println("</div>");
										    out.println("<div id=\"collapseOne\" class=\"panel-collapse collapse\" role=\"tabpanel\" aria-labelledby=\"headingOne\">");
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
	</div>
	</div>
	</div>
	</div>		
	</section>
	

	

</body>
</html>