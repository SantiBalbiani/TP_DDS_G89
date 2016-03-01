<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">

<!-- De esta forma se van a recibir todos los datos necesarios para la pagina -->
<%@page import="usuario.Usuario, usuario.GrupoUsuarios, estadisticas.Planificacion, receta.Receta, java.util.*" %>
<%  
	Usuario user = (Usuario) session.getAttribute("usuario");
	String errorBusqueda = (String) session.getAttribute("errorBusqueda");
	String modificoUsuario = (String) session.getAttribute("modificoUsuario");
	Set<Receta> recetas = (Set<Receta>) session.getAttribute("recetas");
	Set<GrupoUsuarios> grupos = (Set<GrupoUsuarios>) session.getAttribute("gruposDelUsuario");
	
	Planificacion unaPlani = new Planificacion();
	List<Planificacion> historialPlanificacionUser = unaPlani.historialRecetasUser(user);
	
	Receta unaReceta = new Receta();
	List<Receta> recomendacionDelDia = unaReceta.recetaSegunLaHora();
	
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
			
			
			 
			 <div class="row">
			 <div class="col-sm-9"> <p><span>Inicio</span></p> </div>
			 <div class="col-sm-3"><a class="btn btn-default" href="planificar.jsp" role="button" id="nuevaReceta" data-toggle="tooltip" title="Crear una nueva receta" data-placement="bottom">
				Ver Planificación <br> <span class="glyphicon glyphicon-pencil"></span></a> </div>
			</div>
			
		</div>
	</section>


	<section class="main container">
		<div class="panel panel-default" id="Reco diaria">
			<div class="panel-heading"> <b>Recomendacion del día </b></div>
			<div class="panel-body">  
			
<!-- 			Sugerencia del día bla bla -->
			<% 
								out.print("<div class=\"btn-group\">");
								short noHayRecetas=0;	//flag de si hay recetas
								for(Receta recetaRecomendada: recomendacionDelDia){
									if (noHayRecetas>=3)
										break;	//lista hasta 3 recetas..
									out.println("<p>Te vamos a recomendar estas recetas para el horario de: "+recetaRecomendada.obtenerCategoriaSegunHora()+" !</p>");
									out.println("<form class=\"form-horizontal\" method=\"POST\" action=\"BuscarReceta\"><input type=\"hidden\" name=\"buscar_nombreReceta\" id=\"buscar_nombreReceta\" value="+ recetaRecomendada.getNombreReceta() + "><button type=\"submit\" class=\"btn btn-primary btn-sm\">" + recetaRecomendada.getNombreReceta()  + "</button>");
									out.println("<br><br>");
									out.println("</form>");
									noHayRecetas= noHayRecetas++;//al menos listo una receta
								}
								if (noHayRecetas>0)
								{
									out.println("<p>No tenemos recetas para recomendarte en nuestra base de datos en este horario..!</p>");
// 									out.println("<br><br>");
// 									out.println("<p>Haz click en el siguiente boton si quieren añadir una receta.</p>");
// 									out.println("<div class=\"col-sm-8 \"><a class=\"btn btn-default\" href=\"nuevaReceta.jsp\" role=\"button\" id=\"nuevaReceta\" data-toggle=\"tooltip\" title=\"Crear una nueva receta\" data-placement=\"bottom\">");
// 									out.println(" Agregar Receta <br> <span class=\"glyphicon glyphicon-plus\"></span></a> </div>");
// 									out.println("</div>");
								}
								out.print("</div>");
								%>
			
			
			
			
			
			</div>
			</div>		
	</section>	
	
<!-- 	<section class="main container"> -->
<!-- 		<div class="panel panel-default" id="Reco balance"> -->
<!-- 			<div class="panel-heading"><b> Recomendacion Balanceada </b></div> -->
<!-- 			<div class="panel-body"> Sugerencia balanceada del día bla bla</div> -->
<!-- 			</div>		 -->
<!-- 	</section> -->
	
	<section class="main container">
		<div class="panel panel-default" id="Tus recetas aceptadas">
			<div class="panel-heading"><b> Historial de recetas </b></div>
			<div class="panel-body"> 
				
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
					      <%
					      int i =0;
					      for (Planificacion a : historialPlanificacionUser)
					      {
					    	  out.println("<tr>"); out.println("<td>");
					    	  out.println(a.getFecha()); out.println("</td>");  out.println("<td>");
					    	  out.println(a.getReceta().getNombreReceta()); out.println("</td>"); out.println("<td>"); 
					    	  out.println(a.getUnTipoDeReceta().getTipoReceta()); out.println("</td>");
					    	  out.println("</tr>");
					    	  i=i+1;
					    	  if (i>2)
					    		  break;
					      }
					      if (i<1)
					      {
					    	  out.println("<p> Aun no tienes recetas (consumidas) en tu historial. Trata de planificar una receta.");
					    	  out.println("<br>");
					      }
					      
					      %>
					      
					      
					      
<!-- 					      <tr> -->
<!-- 					        <td>18/02/2016</td> -->
<!-- 					        <td>Mila con Papas</td> -->
<!-- 					        <td>Desayuno</td> -->
<!-- 					      </tr> -->
					     
<!-- 					      <tr> -->
<!-- 					        <td>20/02/2016</td> -->
<!-- 					        <td>Bife con fritas</td> -->
<!-- 					        <td>Cena</td> -->
<!-- 					      </tr> -->
					   
					    </tbody>
					  
					  </table>


	</div>
	</div>		
	</section>
	

	

</body>
</html>