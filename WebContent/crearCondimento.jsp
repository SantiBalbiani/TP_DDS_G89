<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>¿Qué Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
	

<script type="text/javascript">
	function comfirm_decision(){
	    if(confirm("Seguro que quieres descartar los cambios?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
	     {
 	       window.location="listadoDeRecetas.jsp"; 
	     }else{
	       return false;
	    }
	   return true;
	 }
	</script>

<!-- 	Librerias importantes para que ande bootsStrap Validator -->
	<!-- jQuery library -->
<script src="js/jquery-2.2.0.js"></script>
<script src="js/bootstrapvalidator.min.js"></script>
<script src="js/bootstrapValidator.js"></script>
<script src="js/bootstrap.min"></script>
<link rel="stylesheet" href="css/bootstrapvalidator.min.css">
 
<!-- 	Librerias importantes para que ande bootsStrap Validator -->

<!-- 	Este es el script que valida el form de registrarse!! -->
	<script>
$(document).ready(function() {
    $('#crearCondimento_form').bootstrapValidator({
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
            inputTipo: {
                validators: {
                    notEmpty: {
                        message: 'El tipo es un campo obligatorio'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'El tipo debe tener entre 4 y 30 caracteres'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'El tipo solo puede tener valores alfanumericos y guiones bajos'
                    }
                }
            },
                     
    }}
    );
});
</script>



</head>
<body>

<form class="form-horizontal" method="POST" action="ABM_CONDIMENTO" id="crearCondimento_form">
				  <fieldset>
				    <legend>Ingrese sus Datos</legend>
				    <div class="form-group">
				      <label for="inputNombre" class="col-lg-3 control-label">Nombre Ingrediente</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" name ="inputNombre" id="inputNombre" placeholder="Nombre Condimento" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="inputTipo" class="col-lg-3 control-label">Tipo Ingrediente</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" id="inputTipo" name="inputTipo" placeholder="Tipo Condimento" required>
				      </div>
				    </div>
				   
				    <input type="hidden" name="esCrearCondimento" id="esCrearCondimento" value="si">
				    
	<div class="form-group">
				      <div class="col-lg-9 col-lg-offset-3">
				        <!-- Cancelar edicion -->
<button type="button" id="evento_descartar" name="evento_descartar" class="btn btn-default" onclick="comfirm_decision()" >Descartar     <span class=" glyphicon glyphicon-remove"></span>
</button>
				       <!-- Modificar Datos  -->
<button type="submit" id="evento_aceptar" name="evento_aceptar" class="btn btn-default">Aceptar     <span class=" glyphicon glyphicon-edit"></span>
</button>
				      </div>
				    </div>
				  </fieldset>
				</form>


</body>
</html>