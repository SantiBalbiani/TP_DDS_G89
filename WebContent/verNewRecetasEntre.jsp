<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">

<%@page import="usuario.Usuario, usuario.GrupoUsuarios, receta.Receta, estadisticas.Estadisticas, java.util.*" %>

<%
List<Receta> recetasNew = (List<Receta>) session.getAttribute("listaNewEntreFechas");

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
			<h1>Que Comemos Hoy?</h1>
			<p>Ver las Recetas Creadas en el Período</p>
		</div>
</section>


<section class="main container">
<div class="panel panel-default" id="Mostrar Recetas">
	<div class="panel-heading"> Seleccionar la receta deseada para ver detalles </div>
			
			<% short noHayRecetas=0;
				for(Receta unaReceta: recetasNew){
									
									out.println("<form class=\"form-horizontal\" method=\"POST\" action=\"BuscarReceta\"><input type=\"hidden\" name=\"buscar_nombreReceta\" id=\"buscar_nombreReceta\" value="+ unaReceta.getNombreReceta() + "><button type=\"submit\" class=\"btn btn-primary btn-sm\">" + unaReceta.getNombreReceta()  + "</button>");
									out.println("<br><br>");
									out.println("</form>");
								noHayRecetas=1;
								}
				if (noHayRecetas==0)
								{
									out.println("<br><br>");
									out.println("<h4> No hay Recetas que coincidan con la búsqueda </h4>");
									out.println("<br><br>");
									out.println("<a class=\"btn btn-default\" href=\"reportes.jsp\" role=\"button\" id=\"verReporte\" data-toggle=\"tooltip\" title=\"ver Reporte\" data-placement=\"bottom\">");
									out.println(" Nueva búsqueda <br> <span class=\"glyphicon glyphicon-arrow-left\"></span></a>");
									out.println("</div>");
									
								}
			%>



			<br>
		</div>
</section>


</body>
</html>