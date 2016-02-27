<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">
<%@page import="usuario.Usuario, receta.Receta, receta.Ingrediente, receta.Condimento, receta.TipoReceta" %>

<%
Receta receta = (Receta) session.getAttribute("recetaEncontrada");	
String creoReceta = (String) session.getAttribute("creoReceta");
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
						<li><a href="reportes.jsp">Reportes</a></li>
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
				<% if (creoReceta.equals("yes")) {
 				 out.println("<div class=\"alert alert-success fade in\">");
    out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
     out.println("<strong>Success!</strong> La receta se creo correctamente.");
   out.println("</div>");
 	  session.setAttribute("creoReceta", "no");	//reseteo el flag
 				}
  				
  				%>
			</div>
		</nav>
		
<section class="jumbotron jumbotron-kd">
		<div class="container">
			<h1>Que Comemos Hoy?</h1>
			
			
			<form class="form-horizontal" method="POST" action="eliminarReceta" id="eliminarReceta_form">
              
                <div class="row">
                 <div class="col-sm-6"> <p> <% out.println(receta.getNombreReceta()); %> </p> </div>
                  
<!--                   <div class="col-sm-3"> -->
<!--                   	<button type="submit" id="evento_modificar" name="evento_modificar" class="btn btn-default" >Modificar Receta <span class="glyphicon glyphicon-edit"> </span></button> -->
<!--                   </div> -->
<!--                   <input type="hidden" name="esModificar" id="esModificar" value="modificar"> -->
<!--                   <div class="col-sm-3"> -->
<!--                   	<button type="submit" id="evento_eliminar" name="evento_eliminar" class="btn btn-default" >Eliminar Receta <span class="glyphicon glyphicon-remove"> </span></button> -->
<!--                   </div> -->
<!--                   <input type="hidden" name="esEliminar" id="esEliminar" value="eliminar"> -->
            
                </div>
              
            
             </form>
			
			
			
<!-- 			<form action="eliminarReceta" method="post" class="navbar-form navbar-right"> -->
<!-- 					<div class="col-sm-4"><a class="btn btn-default" href="crearIngredientes.jsp" role="button" id="nuevaReceta" data-toggle="tooltip" title="Crear una nueva receta" data-placement="bottom"> -->
<!-- 				 Agregar Receta <br> <span class="glyphicon glyphicon-plus"></span></a> </div> -->
<!-- 						</button> -->
<!-- 					</form> -->
		</div>
	</section>	


<section class="main container">
<div class="panel panel-default"> 
  <div class="panel-heading"> Informacion de la receta  </div>
   <div class="panel-body"> 
 	     <p> Nombre de la receta: <% out.println(receta.getNombreReceta());%> <p>
  
		 <p> Preparacion: <% out.println(receta.getPreparacion());%> <p> 
		 
<%-- 		 <p> Ingrediente Principal:  <% out.println(receta.getIngPrincipal());%> <p>  --%>
		 		  
		 <p> Calorias: <% out.println(receta.getCalorias());%> <p> 

<%-- 		 <p> Dificultad: <% out.println(receta.getDificultad());%> <p>  --%>
		 
<%-- 		 <p> Sector alimenticio: <% out.println(receta.getSector());%> <p>  --%>
     <p> IngredientePrincipal: <% out.println(receta.getIngredientePrincipal().getNombre());%> <p> 
    <br>
     <p> Ingredientes Secundarios: </p>
     <% 
     
								int i = 1;
								for(Ingrediente ing : receta.getIngredientes()){
									out.println("<span id=\"drag" + i + "\" class=\"label label-default\" draggable=\"true\" ondragstart=\"drag(event)\">");
									out.println(ing.getNombre());
									out.println("</span>");
									out.println("<br>");
									i++;
								}
								%>
								<br>
								<p> Condimentos Adicionales: </p>
								 <% 
     
								int j = 1;
								for(Condimento cond: receta.getListaCondimentos()){
									out.println("<span id=\"drag" + j + "\" class=\"label label-default\" draggable=\"true\" ondragstart=\"drag(event)\">");
									out.println(cond.getNombre());
									out.println("</span>");
									out.println("<br>");
									j++;
								}
								%>
     <br>
     <p> Categorias de la receta </p>
     <% 
     
								int k = 1;
								for(TipoReceta cat : receta.getListaCategorias()){
									out.println(cat.getTipoReceta());
									out.println("<br>");
									k++;
								}
								%>
								<br>
  </div>
</div>
</section>



</body>
</html>