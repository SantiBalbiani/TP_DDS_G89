<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <link rel="icon" href="">
    <title>Que Comemos Hoy?</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/signin.css">
    <link rel="stylesheet" href="css/estilos.css">
<!--     <script src="js/jquery.js"></script> -->
    <script src="js/bootstrap.min.js"></script>
    
    
    <!-- 	Librerias importantes para que ande bootsStrap Validator -->
	<!-- jQuery library -->
<script src="js/jquery-2.2.0.js"></script>
<script src="js/bootstrapvalidator.min.js"></script>
<script src="js/bootstrapValidator.js"></script>
<!-- <script src="js/bootstrap.min"></script> -->
<link rel="stylesheet" href="css/bootstrapvalidator.min.css">
 
<!-- 	Librerias importantes para que ande bootsStrap Validator -->

<!-- 	Este es el script que valida el form de registrarse!! -->
	<script>
$(document).ready(function() {
    $('#login_form').bootstrapValidator({
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
            }
        }
            
        });
});
</script>
     <script type="text/javascript">
    function posicionarCursor(){
		document.getElementById("usuario").focus();
	}
    </script>
    
  </head>

  <body onload="posicionarCursor();">


<%  if (request.getParameter("r") != null) {
if (request.getParameter("r").equals("1")) {
	 out.println("<div class=\"alert alert-success fade in\">");
	    out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
	     out.println("<strong>Success!</strong> El usuario se creo correctamente. Por favor ingrese sus datos.");
	   out.println("</div>");
	 	//  session.setAttribute("modificoUsuario", "no");	//reseteo el flag
}
}%>

<%  if (request.getParameter("u") != null) {
if (request.getParameter("u").equals("1")) {
	 out.println("<div class=\"alert alert-danger  fade in\">");
	    out.println("<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>");
	     out.println("<strong>Danger!</strong> Usuario y/o contraseña invalidos. Por favor ingrese sus datos.");
	   out.println("</div>");
	 	//  session.setAttribute("modificoUsuario", "no");	//reseteo el flag
}
}%>



    <div class="container">
    <div class="col-md-4 col-md-offset-4">
      <form class="form-horizontal" action="login" method="POST" id="login_form">      
				    <h2 class="form-signin-heading" style="text-align: center;" >Iniciar Sesion</h2>
				    <br>
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
      
         <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
      
      
      
      </form>
        </div>
    </div>
    
  </body>
</html>
