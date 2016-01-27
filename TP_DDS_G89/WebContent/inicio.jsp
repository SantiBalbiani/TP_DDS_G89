<%@ page language="java" contentType="text/html; charset=iso-8859-1"
	pageEncoding="ISO-8859-1" import="usuario.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />

	<title>&iquest;Tablero de Operaciones</title>
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

	<style type="text/css">
	body {
		background-color: #90C58F;
	}
	</style>

	<style>
	#div1 {
		width:530px;
		height:220px;
		padding:10px;
		border:10px solid #FFFFFF;
		background-image: url(cocinaFeliz.png);
	}
	.Estilo1 {
		font-family: 'Glyphicons Halflings';
		font-weight: bold;
	}
	</style>
	<script>
	function allowDrop(ev) {
    	ev.preventDefault();
	}

	function drag(ev) {
    	ev.dataTransfer.setData("text", ev.target.id);
	}

	function drop(ev) {
    	ev.preventDefault();
    	var data = ev.dataTransfer.getData("text");
    	ev.target.appendChild(document.getElementById(data));
	}
	</script>
</head>

<body>
	<div align="center">
		<table width="642" height="574" border="1">
			<tr>
				<th height="196" colspan="2" bgcolor="#228B22" scope="col"><img
					src="logogral.jpg" width="416"
					height="192" /></th>
			</tr>
			<tr>
				<td width="244" height="34"><a href="index.jsp"><img
						src="home.png" width="64" height="48" /></a></td>
				<td width="382">&nbsp;</td>
			</tr>
			<tr>
				<td height="309" colspan="2">
					<!-- InstanceBeginEditable name="EditRegion1" -->

					
					
					<a href="crearReceta.jsp" class="btn btn-primary btn-lg">Crear Receta</a>


					
					
					<button type="button" class="btn btn-default btn-lg">Crear Grupo</button>
					
					
					
					
					
					
					
					

  
  
  
  
  
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script
						src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="js/bootstrap.min.js"></script>
</p>
			  </body>

</html>