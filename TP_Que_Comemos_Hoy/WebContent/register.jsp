<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>¿Qué Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/signin.css">
	<link rel="stylesheet" href="css/estilos.css">
	
	<script type="text/javascript">
	function posicionarCursor(){
		document.getElementById("nombre").focus();
	}
	</script>
	
</head>
<body onload="posicionarCursor();">

    <div class="container">
      <form class="form-signin" action="register" method="POST">
        <h2 class="form-signin-heading">Registrarse</h2>
        
        <label for="inputText" class="sr-only">Nombre</label><h4>Nombre</h4>
        <input type="text" name="nombre" id="nombre" class="form-control" placeholder="Nombre" required>
        
        <label for="inputPassword" class="sr-only">Contraseña</label><h4>Contraseña</h4>
        <input type="password" name="contrasenia1" id="contrasenia1" class="form-control" placeholder="Contraseña" required>
        
        <label for="inputPassword" class="sr-only">Contraseña</label><h4>Confirme Contraseña</h4>
        <input type="password" name="contrasenia2" id="contrasenia2" class="form-control" placeholder="Contraseña" required>
        
        <label for="inputDate" class="sr-only">Fecha de Nacimiento</label><h4>Fecha de Nacimiento</h4>
        <input type="date" name="fechaNacimiento" id="fecha" class="form-control" placeholder="dd/mm/aaaa" required>
        
        <label class="sr-only">Altura</label><h4>Altura</h4>
        <input type="text" name="altura" id="inputAltura" class="form-control" placeholder="Altura" required>
        
        <h4>Complexión</h4>
        <label class="checkbox-inline">
        <input type="checkbox" name="complexion" id="complexionP" value="puquenia">Pequeña
        </label>
        <label class="checkbox-inline">
        <input type="checkbox" name="complexion" id="complexionM" value="mediana">Mediana
        </label>
        <label class="checkbox-inline">
        <input type="checkbox" name="complexion" id="complexionG" value="grande">Grande
        </label>
        <br>
        <br>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Registrarme</button>
        
      </form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>