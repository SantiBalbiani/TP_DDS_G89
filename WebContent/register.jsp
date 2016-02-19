
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>¿Qué Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
	
	<script type="text/javascript">
	function posicionarCursor(){
		document.getElementById("usuario").focus();
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
    $('#registrarse_form').bootstrapValidator({
         framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	inputUsuario: {
                validators: {
                    notEmpty: {
                        message: 'El nombre de usuario es un campo obligatorio'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'El nombre de usuario debe tener entre 6 y 30 caracteres'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'El nombre solo puede tener valores alfanumericos y guiones bajos'
                    }
                }
            },
            altura: {
                validators: {
                    notEmpty: {
                        message: 'La altura es un campo obligatorio'
                    },
	   				 regexp: {
 					 regexp: /^[0-9]+$/,
 					 message: 'La altura solo puede contener números'
 				 },
 				between: {
                    min: 0,
                    max: 250,
                    message: 'La altura tiene que ser entre 0 cm  y  250 cm'
                }
//                     numeric: {
//                         message: 'El valor debe estar expresado en números'
//                     }
                 }
            }, 
            inputPassword: {
                validators: {
                    notEmpty: {
                        message: 'La contraseña es un campo obligatorio'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'La contraseña debe tener entre 6 y 30 caracteres'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'La contraseña solo puede tener valores alfanumericos y guiones bajos'
                    }
                }
            },
            
           fechaNacimiento: {
			 validators: {
				 notEmpty: {
					 message: 'La fecha de nacimiento es requerida y no puede ser vacia'
				 },
// 				 between: {
// 	                    min: 1011900,
// 	                    max: 31123000,
// 	                },
 				 date: {
 					 format: 'DDMMYYYY',
 					 message: 'La fecha de nacimiento no es valida. Formato DDMMYYYY'
 				 },
				 regexp: {
                     regexp: /^[a-zA-Z0-9_-]+$/,
                     message: 'La fecha solo puede tener valores alfanumericos, guiones bajos/altos y barras'
                 }
			 }
		 },
//             'size[]': {
//                 validators: {
//                     notEmpty: {
//                         message: 'The size is required'
//                     }
//                 }
//             },
            optionSexo: {
                validators: {
                    notEmpty: {
                        message: 'El sexo es un campo obligatorio'
                    }
                }
             },
             inputMail: {
    			 validators: {
    				 notEmpty: {
    					 message: 'El correo es requerido y no puede ser vacio'
    				 },
//     				 emailAddress: {
//     					 message: 'El correo electronico no es valido'
//     				 }
    				 regexp: {
                         regexp: /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i,
                         message: 'No es un correo valido'
                     }
    			 }
    		 },
             dieta: {
                 validators: {
                     notEmpty: {
                         message: 'La dieta es un campo obligatorio'
                     }
                 }
              },
              complexion: {
                  validators: {
                      notEmpty: {
                          message: 'La complexion es un campo obligatorio'
                      }
                  }
               },
			rutina: {
			    validators: {
			        notEmpty: {
			            message: 'La rutina es un campo obligatorio'
			        }
			    }
			 }
//         },
        
// submitHandler: function(validator, form, submitButton) {
//     var inputUsuario = [validator.getFieldElements('firstName').val(),
//                     validator.getFieldElements('lastName').val()].join(' ');
//     alert('Hello ' + fullName);
// }
       
    }
    });
});
</script>
	
</head>
<body onload="posicionarCursor();">
    <div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form class="form-horizontal" method="POST" action="register" id="registrarse_form">
				  <fieldset>
				    <legend>Ingrese sus Datos</legend>
				    <div class="form-group">
				      <label for="inputUsuario" class="col-lg-3 control-label">Usuario</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" name ="inputUsuario" id="inputUsuario" placeholder="Usuario" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="inputPassword" class="col-lg-3 control-label">Contraseña</label>
				      <div class="col-lg-9">
				        <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Contraseña" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="inputMail" class="col-lg-3 control-label">E-mail</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" id="inputMail" name="inputMail" placeholder="E-mail" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="textArea" class="col-lg-3 control-label">Fecha de Nacimiento</label>
				      <div class="col-lg-9">
				        <input class="form-control" name="fechaNacimiento" type="date" id="fechaNacimiento" placeholder="dd/mm/aaaa" required>
				      </div>
				    </div>
					<div class="form-group">
				      <label for="inputAltura" class="col-lg-3 control-label">Altura</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" id="altura" name="altura" placeholder="Altura(cm)" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="col-lg-3 control-label">Género</label>
				      <div class="col-lg-9">
				        <div class="radio">
				          <label>
				            <input type="radio" name="optionSexo"  value="M">
				            Masculino
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" name="optionSexo" value="F">
				            Femenino
				          </label>
				        </div>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="select" class="col-lg-3 control-label">Complexión</label>
				      <div class="col-lg-9">
				        <select class="form-control" id="complexion" name="complexion">
				          <option disabled selected> -- Elija una opcion -- </option>
				          <option value="P">Pequeña</option>
				          <option value="M">Mediana</option>
				          <option value="G">Grande</option>
				        </select>
				      </div>
				    </div>
				    <!-- Falta agregar las condiciones preexistentes, rutina y preferencias alimenticias -->
				    <div class="form-group">
				      <label for="select" class="col-lg-3 control-label">Dieta</label>
				      <div class="col-lg-9">
				        <select class="form-control" id="dieta" name="dieta">
				          <option disabled selected> -- Elija una opcion -- </option>
				          <option value="N">Normal</option>
				          <option value="V">Vegetariano</option>
				          <option value="VEG">Vegano</option>
				          <option value="OLV">Ovolacteovegetariano</option>
				        </select>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="col-lg-3 control-label">Rutina</label>
				      <div class="col-lg-9">
				        <div class="radio">
				          <label>
				            <input type="radio" value="LEVE" name="rutina">Sedentaria con algo de ejercicio (-30 min.) [LEVE]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="NADA" name="rutina">Sedentaria con nada de ejercicio [NADA]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="MEDIANO" name="rutina">Sedentaria con ejercicio [MEDIANO]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="MEDIO_INTENSIVO" name="rutina">Activa sin ejercicio adicional (+30 min.) [MEDIO-INTENSIVO]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="INTENSIVO" name="rutina">Activa con ejercicio adicional (+30 min.) [INTENSIVO]
				          </label>
				        </div>
				      </div>
				    </div>
				    
				    
				    <div class="form-group">
				      <div class="col-lg-9 col-lg-offset-3">
				        <button type="reset" class="btn btn-default">Cancelar</button>
				        <button type="submit" class="btn btn-primary">Aceptar</button>
				      </div>
				    </div>
				  </fieldset>
				</form>
			</div>
		</div>
	</div>
    
<!--       Las comento porque actualice las librerias y me tiraba error... por favor revisar que no rompi nada!! -->
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> -->
<!--     <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script> -->
</body>
</html>