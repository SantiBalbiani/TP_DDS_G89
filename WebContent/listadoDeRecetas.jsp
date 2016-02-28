<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">


<!-- De esta forma se van a recibir todos los datos necesarios para la pagina -->
<%@page import="usuario.Usuario, receta.Receta, java.util.*, receta.Condimento, receta.Ingrediente" %>
<%  

	Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
	
	Set<Receta> misRecetas = new HashSet<Receta>(0);
	
	misRecetas = usuarioActual.getRecetasUser();
	
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
</header>
	
	<section class="jumbotron jumbotron-kd">
			<div class="container">
		<div class="row">
			  	<div class="col-sm-8"> <h1>Qué Comemos Hoy?</h1> </div>
			  	<div class="col-sm-4"><a class="btn btn-default" href="crearIngredientes.jsp" role="button" id="nuevaReceta" data-toggle="tooltip" title="Crear una nueva receta" data-placement="bottom">
				 Agregar Receta <br> <span class="glyphicon glyphicon-plus"></span></a> </div>
			</div>
			
			 <p>Mis recetas</p> 
		</div>	
	</section>
	

<section class="main container">
<div class="panel panel-default" id="MostrarRecetas">
	<div class="panel-heading"> Seleccionar la receta deseada para ver detalles </div>
	
						<div class="panel panel-default" id="panelDrop">
							<div class="panel-body" ondrop="drop(event)" ondragover="allowDrop(event)" name="Ingredientes">
								<% 
								out.print("<div class=\"btn-group\">");
								short noHayRecetas=0;	//flag de si hay recetas
								for(Receta unaReceta: misRecetas){
									
									out.println("<form class=\"form-horizontal\" method=\"POST\" action=\"BuscarReceta\"><input type=\"hidden\" name=\"buscar_nombreReceta\" id=\"buscar_nombreReceta\" value="+ unaReceta.getNombreReceta() + "><button type=\"submit\" class=\"btn btn-primary btn-sm\">" + unaReceta.getNombreReceta()  + "</button>");
									out.println("<br><br>");
									out.println("</form>");
									noHayRecetas=1;//al menos listo una receta
								}
								if (noHayRecetas==0)
								{
									out.println("<p>Todavía no tienes ninguna receta!</p>");
									out.println("<br><br>");
									out.println("<p>Haz click en el siguiente boton si quieren añadir una receta.</p>");
									out.println("<div class=\"col-sm-8 \"><a class=\"btn btn-default\" href=\"nuevaReceta.jsp\" role=\"button\" id=\"nuevaReceta\" data-toggle=\"tooltip\" title=\"Crear una nueva receta\" data-placement=\"bottom\">");
									out.println(" Agregar Receta <br> <span class=\"glyphicon glyphicon-plus\"></span></a> </div>");
									out.println("</div>");
								}
								out.print("</div>");
								%>
							</div>
						</div>


						
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