<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">
<%@page import="usuario.Usuario, receta.Receta" %>

<%	String receta2 = "Arrozz"; %>

<head>
	<meta charset="UTF-8">
	<title>Qué Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
<style>
a:link, a:visited {
    color: blue;
 }
</style>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
	
<!-- 	<link rel="stylesheet" type="text/css"  href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"> -->
<!-- 	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script> -->
	
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

<section class="jumbotron jumbotron-kd">
		<div class="container">
			<h1>Qué Comemos Hoy?</h1>
			<p>Mis Grupos</p>
		</div>
	</section>

<section class="main container">
<div class="panel panel-default" id="administracionDeGrupos">
<div class="panel-heading"> Administrar Grupos  </div>

  <div class="container">
    <div class="accordion" id="crearGrupo">
      <div class="accordion-group">
        <div class="accordion-heading">
          <a class="accordion-toggle" data-toggle="collapse"
            data-parent="#crearGrupo" href="#collapseCrearGrupo">Crear Grupo</a>
        </div>
        <div id="collapseCrearGrupo" class="accordion-body collapse">
          <div class="accordion-inner">
            <form class="form-horizontal">
              <div class="row-fluid">
                <div class="span4">
                  <label>Nombre del grupo a crear: </label> <input class="input-medium" type="text" placeholder="">
                  <button type="submit" class="btn">Crear</button>
                </div>
              </div>
            
             </form>
            
          </div>
        </div>
       </div>
     </div>   
  </div>

  <div class="container">
    <div class="accordion" id="buscarGrupo">
      <div class="accordion-group">
        <div class="accordion-heading">
          <a class="accordion-toggle" data-toggle="collapse"
            data-parent="#searchAccordion" href="#collapseTwo">Buscar Grupo</a>
        </div>
        <div id="collapseTwo" class="accordion-body collapse">
          <div class="accordion-inner">
            <form class="form-inline">
        <label>Nombre del grupo a buscar: </label> <input class="input-medium" type="text" placeholder="">
       	<button type="submit" class="btn">Buscar</button>
    	</form>
          </div>
        </div>
       </div>
     </div>   
  </div>
  
    <div class="container">
    <div class="accordion" id="searchAccordion">
      <div class="accordion-group">
        <div class="accordion-heading">
          <a class="accordion-toggle" data-toggle="collapse"
            data-parent="#searchAccordion" href="#collapseThree">Ingresar a un Grupo</a>
        </div>
        <div id="collapseThree" class="accordion-body collapse">
          <div class="accordion-inner">
            <form class="form-inline">
        <label>Nombre del grupo al que desea ingresar: </label> <input class="input-medium" type="text" placeholder="">
       	<button type="submit" class="btn">Ingresar</button>
    	</form>
          </div>
        </div>
       </div>
     </div>   
  </div>
     
       <div class="container">
    <div class="accordion" id="searchAccordion">
      <div class="accordion-group">
        <div class="accordion-heading">
          <a class="accordion-toggle" data-toggle="collapse"
            data-parent="#searchAccordion" href="#collapse4">Salir de un Grupo</a>
        </div>
        <div id="collapse4" class="accordion-body collapse">
          <div class="accordion-inner">
            <form class="form-inline">
        <label>Nombre del grupo del que desea Salir: </label> <input class="input-medium" type="text" placeholder="">
       	<button type="submit" class="btn">Salir</button>
    	</form>
          </div>
        </div>
       </div>
     </div>   
  </div>
    
       <div class="container">
    <div class="accordion" id="searchAccordion">
      <div class="accordion-group">
        <div class="accordion-heading">
          <a class="accordion-toggle" data-toggle="collapse"
            data-parent="#searchAccordion" href="#collapse5">Eliminar Grupo</a>
        </div>
        <div id="collapse5" class="accordion-body collapse">
          <div class="accordion-inner">
            <form class="form-inline">
        <label>Nombre del grupo del grupo que desea eliminar: </label> <input class="input-medium" type="text" placeholder="">
       	<button type="submit" class="btn">Eliminar</button>
    	</form>
          </div>
        </div>
       </div>
     </div>   
  </div>
     </div>  
<!-- Aca en todo caso se cambiaran los button btn por links o botones que hagan algo,  (sus respectivas funciones) -->
   
</section>

<section class="main container">
<div class="panel panel-default" id="MostrarGrupos">
	<div class="panel-heading"> Mis Grupos </div>
	
			<!-- 	Aca hay que recorrer la tabla de grupos asociados al usuario y mostrar los nombres de los grupos -->
			<div class="panel-body"> <b><a href="infoGrupo.jsp"> Grupo "Nombre del grupo1" </a></b></div>
			<div class="panel-body"> <b><a href="infoGrupo.jsp"> Grupo "Nombre del grupo2" </a></b></div>
			<div class="panel-body"> <b><a href="infoGrupo.jsp"> Grupo "Nombre del grupo3" </a></b></div>
			<div class="panel-body"> <b><a href="infoGrupo.jsp"> Grupo "Nombre del grupo4" </a></b></div>
			<!-- Cada href deberia enviar los datos/parametros del grupo en cuestion para mostrar la pagina del grupo -->
</div>
</section>
 </body>
</html>