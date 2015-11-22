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
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    function posicionarCursor(){
		document.getElementById("usuario").focus();
	}
    </script>
    
  </head>

  <body onload="posicionarCursor();">

    <div class="container">
      <form class="form-signin" action="login" method="POST">
        <h2 class="form-signin-heading">Iniciar Sesion</h2>
        <label for="inputText" class="sr-only">Usuario</label>
        <input type="text" id="inputText" class="form-control" placeholder="Usuario" name="usuario" required>
        <label for="inputPassword" class="sr-only">Contraseña</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" name="contrasenia" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Recordarme
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
      </form>
    </div>
    
  </body>
</html>
