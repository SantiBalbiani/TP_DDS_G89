
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
	
</head>
<body onload="posicionarCursor();">
    <div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form class="form-horizontal" action="register" method="POST" >
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
				      <label for="textArea" class="col-lg-3 control-label">Fecha de Nacimiento</label>
				      <div class="col-lg-9">
				        <input class="form-control" name="fechaNacimiento" type="date" id="fecha" placeholder="dd/mm/aaaa" required>
				      </div>
				    </div>
					<div class="form-group">
				      <label for="inputAltura" class="col-lg-3 control-label">Altura</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" id="inputAltura" name="inputAltura" placeholder="Altura(cm)" required>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="col-lg-3 control-label">Sexo</label>
				      <div class="col-lg-9">
				        <div class="radio">
				          <label>
				            <input type="radio" name="optionMasc" id="optionMasc" value="optionMasc" checked="">
				            Masculino
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" name="optionFem" id="optionFem" value="optionFem">
				            Femenino
				          </label>
				        </div>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="select" class="col-lg-3 control-label">Complexion</label>
				      <div class="col-lg-9">
				        <select class="form-control" id="select">
				          <option value="">Pequeña</option>
				          <option value="">Mediana</option>
				          <option value="">Grande</option>
				        </select>
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
    
      
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>