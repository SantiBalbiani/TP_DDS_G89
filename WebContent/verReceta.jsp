<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">
<%@page import="usuario.Usuario, receta.Receta, receta.Ingrediente, receta.Condimento, receta.TipoReceta" %>

<%
Receta receta = (Receta) session.getAttribute("recetaEncontrada");	
String creoReceta = (String) session.getAttribute("creoReceta");

String errorBusqueda = (String) session.getAttribute("errorBusqueda");
String calificoOK = (String) session.getAttribute("calificoOK");
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
	
	<!-- 	Codigo en JQuery para las estrellas -->
		<script>
// 	var logID = 'log',
//   log = $('<div id="'+logID+'"></div>');
// $('body').append(log);
//   $('[type*="radio"]').change(function () {
//     var me = $(this);
//     log.html(me.attr('value'));
//   });
	</script> 
	
		<!-- 	Estrellita, estrellita, dime quien es la mas bonita.. -->
	<style>
<%--      <%@ include file="style.css"%> --%>
@charset "UTF-8";
.star-cb-group {
  /* remove inline-block whitespace */
  font-size: 0;
  /* flip the order so we can use the + and ~ combinators */
  unicode-bidi: bidi-override;
  direction: rtl;
  /* the hidden clearer */
}
.star-cb-group * {
  font-size: 1rem;
}
.star-cb-group > input {
  display: none;
}
.star-cb-group > input + label {
  /* only enough room for the star */
  display: inline-block;
  overflow: hidden;
  text-indent: 9999px;
  width: 1em;
  white-space: nowrap;
  cursor: pointer;
}
.star-cb-group > input + label:before {
  display: inline-block;
  text-indent: -9999px;
  content: "☆";
  color: #888;
}
.star-cb-group > input:checked ~ label:before, .star-cb-group > input + label:hover ~ label:before, .star-cb-group > input + label:hover:before {
  content: "★";
  color: #e52;
  text-shadow: 0 0 1px #333;
}
.star-cb-group > .star-cb-clear + label {
  text-indent: -9999px;
  width: .5em;
  margin-left: -.5em;
}
.star-cb-group > .star-cb-clear + label:before {
  width: .5em;
}
.star-cb-group:hover > input + label:before {
  content: "☆";
  color: #888;
  text-shadow: none;
}
.star-cb-group:hover > input + label:hover ~ label:before, .star-cb-group:hover > input + label:hover:before {
  content: "★";
  color: #e52;
  text-shadow: 0 0 1px #333;
}

:root {
  font-size: 2em;
  font-family: Helvetica, arial, sans-serif;
}

body {
  background: #333;
  color: #888;
}

fieldset {
  border: 0;
  background: #222;
  width: 5em;
  border-radius: 1px;
  padding: 1em 1.5em 0.9em;
  margin: 1em auto;
}

#log {
  margin: 1em auto;
  width: 5em;
  text-align: center;
  background: transparent;
}

h1 {
  text-align: center;
}


</style>
	
	
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
					<form action="ListarRecetasEncontradas" method="post" class="navbar-form navbar-right" role="search">
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
  				<% if (errorBusqueda.equals("yes")) {
					out.println("<div class=\"alert alert-info fade in\">");
			    	out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
			    	out.println("<strong>Info!</strong> No se encontro la receta. Intente nuevamente.");
			    	out.println("</div>");
		        	session.setAttribute("errorBusqueda", "no");	//reseteo el flag
				}%>
				<% if (calificoOK.equals("yes")) {
 				 out.println("<div class=\"alert alert-success fade in\">");
    out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
     out.println("<strong>Success!</strong> Se califico correctamente la receta.");
   out.println("</div>");
 	  session.setAttribute("calificoOK", "no");	//reseteo el flag
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
  <div class="panel-heading"> 
   <div class="row">
                   <div class="col-sm-6" style="height:20px"> Informacion de la receta </div> 
                 
        
                 
                 </div>
<!--    <div>  -->
               <div class="col-sm-3" style="height:25px"> 
  <form id="form_calificar" name="form_calificar" method="POST" action="BM_RECETA" style="height:10px">
<!--   <fieldset> -->
    <span class="star-cb-group">

      <input type="radio" id="rating-5" name="rating" value="5" onclick="this.form.submit();" <% if (receta.getCalificacion()==5) out.println("checked=\"checked\""); %> /><label for="rating-5">5</label>
      <input type="radio" id="rating-4" name="rating" value="4" onclick="this.form.submit();" <% if (receta.getCalificacion()==4) out.println("checked=\"checked\""); %> /><label for="rating-4">4</label>
      <input type="radio" id="rating-3" name="rating" value="3" onclick="this.form.submit();" <% if (receta.getCalificacion()==3) out.println("checked=\"checked\""); %>/><label for="rating-3">3</label>
      <input type="radio" id="rating-2" name="rating" value="2" onclick="this.form.submit();" <% if (receta.getCalificacion()==2) out.println("checked=\"checked\""); %>/><label for="rating-2">2</label>
      <input type="radio" id="rating-1" name="rating" value="1" onclick="this.form.submit();" <% if (receta.getCalificacion()==1) out.println("checked=\"checked\""); %>/><label for="rating-1">1</label>
      <input type="radio" id="rating-0" name="rating" value="0" class="star-cb-clear" 		  <% if (receta.getCalificacion()>5 || receta.getCalificacion()<1) out.println("checked=\"checked\""); %> /><label for="rating-0">0</label>
    </span>
<!--     <button type="button" id="calificar_receta" name="calificar_receta" class="btn btn-default" ">     <span class=" glyphicon glyphicon-trash"></span> -->
<!-- </button> -->
<input type="hidden" name="BM_RECETA" id="BM_RECETA" value="calificar">
<input type="hidden" name="receta_calificar" id="receta_calificar" value=<% out.println("\""+receta.getNombreReceta()+"\"");%>>
<!--   </fieldset> -->
</form>
<!--    </div> -->
  
      </div>
       </div>
   <div class="panel-body"> 

   <br>

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