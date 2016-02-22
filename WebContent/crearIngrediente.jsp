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

<form class="form-horizontal" method="POST" action="ABM_INGREDIENTE" id="crearIngrediente_form">
				  <fieldset>
				    <legend>Ingrese sus Datos</legend>
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