<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<title>Qué Comemos Hoy?</title>
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
	<script src="js/jquery-2.2.0.js"></script>
	<script src="js/bootstrapvalidator.min.js"></script>
	<script src="js/bootstrapValidator.js"></script>
	<script src="js/bootstrap.min"></script>
	<link rel="stylesheet" href="css/bootstrapvalidator.min.css">

		<script>
$(document).ready(function() {
    $('#crearIngrediente_form').bootstrapValidator({
         framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	inputNombre: {
                validators: {
                    notEmpty: {
                        message: 'El nombre es un campo obligatorio'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'El nombre debe tener entre 4 y 30 caracteres'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'El nombre solo puede tener valores alfanumericos y guiones bajos'
                    }
                }
            },
            inputCalorias: {
                validators: {
                    notEmpty: {
                        message: 'Las calorias es un campo obligatorio'
                    },
	   				 regexp: {
 					 regexp: /^[0-9]+$/,
 					 message: 'Las calorias solo puede contener números'
 				 },
 				between: {
                    min: 0,
                    max: 2000,
                    message: 'Las calorias tiene que ser entre 0 CAL  y  2000 CAL'
                }
//                     numeric: {
//                         message: 'El valor debe estar expresado en números'
//                     }
                 }
            }, 
            inputPorcion: {
                validators: {
                    notEmpty: {
                        message: 'La porcion es un campo obligatorio'
                    },
	   				 regexp: {
 					 regexp: /^[0-9]+$/,
 					 message: 'La porcion solo puede contener números'
 				 },
 				between: {
                    min: 0,
                    max: 50,
                    message: 'La porcion tiene que ser entre 0 y 50'
                }
                }
            }
           
    }}
    );
});
</script>


	
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
						<li><a href="estadisticas.jsp">Estadísticas</a></li>
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
			</div>
		</nav>

<section class="jumbotron jumbotron-kd">
		<div class="container">
			<h1>Qué Comemos Hoy?</h1>
			<p>Crear Ingredientes</p>
		</div>
</section>


<section class="main container">

<div class="panel-body">
			<div class="panel panel-default" id="Ultimas 3">
				<div class=panel-heading>  <h3>Agregar Ingrediente</h3> </div>
				<div class="panel-body" id="1">		
				
					<form class="form-horizontal" method="POST" action="ABM_INGREDIENTE" id="crearIngrediente_form">
				  <fieldset>
				      <div class="form-group">
				      <label for="inputNombre" class="col-lg-3 control-label">Nombre Ingrediente</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" name ="inputNombre" id="inputNombre" placeholder="Nombre Ingrediente" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="inputCalorias" class="col-lg-3 control-label">Calorias</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" id="inputCalorias" name="inputCalorias" placeholder="Calorias" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="inputPorcion" class="col-lg-3 control-label">Porcion</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" id="inputPorcion" name="inputPorcion" placeholder="Porcion" required>
				      </div>
				    </div>
				   
				    <input type="hidden" name="esCrearIngrediente" id="esCrearIngrediente" value="si">
				    
					<div class="form-group">
				      <div class="col-lg-9 col-lg-offset-3">
				        <!-- Cancelar edicion -->
					<button type="button" id="evento_descartar" name="evento_descartar" class="btn btn-default" onclick="comfirm_decision()" >Descartar     	<span class=" glyphicon glyphicon-remove"></span>
					</button>
				       <!-- Modificar Datos  -->
						<button type="submit" id="evento_aceptar" name="evento_aceptar" class="btn btn-default">Aceptar     <span class=" glyphicon glyphicon-edit"></span>
					</button>
				      </div>
				    </div>
				  </fieldset>
				</form>
																
		  		
				
				</div>
		 	</div>
</div>
</section>

</body>
</html>