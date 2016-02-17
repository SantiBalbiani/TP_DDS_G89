<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="es">
<!-- De esta forma se van a recibir todos los datos necesarios para la pagina -->
<%@page import="usuario.Usuario, usuario.GrupoUsuarios, receta.Receta, java.util.*" %>
<%  
	Usuario user = (Usuario) session.getAttribute("usuario");
	Set<Receta> recetas = (Set<Receta>) session.getAttribute("recetas");
	Set<GrupoUsuarios> grupos = (Set<GrupoUsuarios>) session.getAttribute("gruposDelUsuario");
%>

<head>
	<meta charset="UTF-8">
	<title>Que Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<script type="text/javascript">
	function comfirm_decision(){
	    if(confirm("Seguro que quieres descartar los cambios?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
	     {
 	       window.location="welcome.jsp"; 
	     }else{
	       return false;
	    }
	   return true;
	 }
	</script>
	
	<script type="text/javascript">
function submit_eliminar()
{
	if(confirm("Seguro que quieres eliminar el usuario?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
    {
		var theForm = document.forms['form_eliminar'];
	     if (!theForm) {
	         theForm = document.form_eliminar;
	     }
	     theForm.submit();		
// 		window.location="welcome.jsp"; 
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
<a href="creditos.jsp" class="navbar-brand">Que Comemos Hoy?</a>
                    <ul class="nav navbar-nav">
						<li><a href="welcome.jsp">Inicio</a></li>
						<li><a href="misGrupos.jsp">Mis Grupos</a></li>
						<li><a href="listadoDeRecetas.jsp">Mis Recetas</a></li>
						<li><a href="misDatos.jsp">Mis Datos</a></li>
						<li><a href="#">Cerrar Sesion</a></li>
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
			<h1>Que Comemos Hoy?</h1>
			<p>Mis Datos</p>
		</div>
	</section>

<!-- Datos de usuario -->
</head>
<body onload="posicionarCursor();">
    <div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form class="form-horizontal" method="POST" action="Actualizar_Datos">
				  <fieldset>
				    <legend>Ingrese sus Datos</legend>
				    
				    <input type="hidden" name="esEliminarUsuario" id="esEliminarUsuario" value="no">
				    
				    <div class="form-group">
				      <label for="inputUsuario" class="col-lg-3 control-label">Usuario</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" name ="usuario" id="inputUsuario" placeholder="Usuario" required value="<%  out.println(user.getNombreUsuario()); %>" readonly>
				      </div>
				    </div>
				    
				    <div class="form-group">
				      <label for="inputPassword" class="col-lg-3 control-label">Contraseña</label>
				      <div class="col-lg-9">
				        



										<div class="panel-group" id="accordion" role="tablist"
											aria-multiselectable="true">
											<div class="panel panel-default">
											
												<div class="panel-heading" role="tab" id="headingOne">
													<h4 class="panel-title">
														<a role="button" data-toggle="collapse"
															data-parent="#accordion" href="#nuevaPass"
															aria-expanded="true" aria-controls="collapseOne">
															Cambiar Contraseña..
															
															</a>
													</h4>
												</div>
												
												<div id="nuevaPass" class="panel-collapse collapse"
													role="tabpanel" aria-labelledby="headingOne">
													<div class="panel-body">
													
													<input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Nueva Contraseña">
													
													
													</div>
												</div>
												
											</div>


				      </div>
				    </div>
				    <div class="form-group">
				      <label for="textArea" class="col-lg-3 control-label">Fecha de Nacimiento</label>
				      <div class="col-lg-9">
				        <input class="form-control" name="fechaNacimiento" type="date" id="fecha" placeholder="dd/mm/aaaa" required value=<%  out.println("\""+user.getFecha_nacimiento()+"\""); %>>
<!-- 				         <input class="form-control" name="fechaNacimiento" type="date" id="fecha" placeholder="dd/mm/aaaa" required value="2012-12-12"> -->
				      </div>
				    </div>
					<div class="form-group">
				      <label for="inputAltura" class="col-lg-3 control-label">Altura</label>
				      <div class="col-lg-9">
				        <input type="text" class="form-control" id="altura" name="altura" placeholder="Altura(cm)" required value="<%  out.println(user.getAltura()); %>">
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="col-lg-3 control-label">Sexo</label>
				      <div class="col-lg-9">
				        <div class="radio">
				          <label>
				            <input type="radio" name="optionSexo"  value="M" <% if ((user.getSexo()) =='M') { out.println("checked"); } %> >
				            Masculino
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" name="optionSexo" value="F" <% if ((user.getSexo()) =='F') { out.println("checked"); } %> >
				            Femenino
				          </label>
				        </div>
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="select" class="col-lg-3 control-label">Complexion</label>
				      <div class="col-lg-9">
				        <select class="form-control" id="complexion" name="complexion" >
				          <option value="P" <% if ((user.getComplexion()).equals("P")) { out.println("selected=\"selected\""); } %> >Pequeña</option>
				          <option value="M" <% if ((user.getComplexion()).equals("M")) { out.println("selected=\"selected\""); } %> >Mediana</option>
				          <option value="G" <% if ((user.getComplexion()).equals("G")) { out.println("selected=\"selected\""); } %> >Grande</option>
				        </select>
				      </div>
				    </div>
				    <!-- Falta agregar las condiciones preexistentes, rutina y preferencias alimenticias -->
				    <div class="form-group">
				      <label for="select" class="col-lg-3 control-label">Dieta</label>
				      <div class="col-lg-9">
				        <select class="form-control" id="dieta" name="dieta">
				          <option value="N" <% if ((user.getDieta()).equals("N")) { out.println("selected=\"selected\""); } %> >Normal</option>
				          <option value="V" <% if ((user.getDieta()).equals("V")) { out.println("selected=\"selected\""); } %> >Vegetariano</option>
				          <option value="VEG" <% if ((user.getDieta()).equals("VEG")) { out.println("selected=\"selected\""); } %> >Vegano</option>
				          <option value="OLV" <% if ((user.getDieta()).equals("OLV")) { out.println("selected=\"selected\""); } %> >Ovolacteovegetariano</option>
				        </select>
				      </div>
				    </div>
				    <div class="form-group">
				      <label class="col-lg-3 control-label">Rutina</label>
				      <div class="col-lg-9">
				        <div class="radio">
				          <label>
				            <input type="radio" value="LEVE" name="rutina" <% if ((user.getRutina()).equals("LEVE")) { out.println("checked"); } %> >Sedentaria con algo de ejercicio (-30 min.) [LEVE]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="NADA" name="rutina" <% if ((user.getRutina()).equals("NADA")) { out.println("checked"); } %> >Sedentaria con nada de ejercicio [NADA]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="MEDIANO" name="rutina" <% if ((user.getRutina()).equals("MEDIANO")) { out.println("checked"); } %> >Sedentaria con ejercicio [MEDIANO]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="MEDIO_INTENSIVO" name="rutina" <% if ((user.getRutina()).equals("MEDIO_INTENSIVO")) { out.println("checked"); } %> >Activa con ejercicio adicional (+30 min.) [MEDIO-INTENSIVO]
				          </label>
				        </div>
				        <div class="radio">
				          <label>
				            <input type="radio" value="INTENSIVO" name="rutina" <% if ((user.getRutina()).equals("INTENSIVO")) { out.println("checked"); } %> >Activa con ejercicio adicional (+30 min.) [INTENSIVO]
				          </label>
				        </div>
				      </div>
				    </div>
				     
				    
				    <div class="form-group">
<!-- 				    <div class="row"> -->
				      <div class="col-lg-9 col-md-3 col-lg-offset-3">

<!-- Modificar Datos  -->
<button type="submit" id="evento_aceptar" name="evento_aceptar" class="btn btn-default">Aceptar cambios     <span class=" glyphicon glyphicon-edit"></span>
</button>

<!-- </div> -->
<!-- <div class="col-lg-9 col-md-4 col-lg-offset-4"> -->
<br><br>
<!-- Cancelar edicion -->
<button type="button" id="evento_descartar" name="evento_descartar" class="btn btn-default" onclick="comfirm_decision()" >Descartar cambios     <span class=" glyphicon glyphicon-remove"></span>
</button>

<!-- </div> -->
<!-- </div> -->
<br><br>
				      </div>
				    </div>
				  </fieldset>
				</form>
<form id="form_eliminar" name="form_eliminar" method="POST" action="Actualizar_Datos">

<!-- Eliminar Cuenta -->
<button type="submit" id="evento_eliminar" name="evento_eliminar" class="btn btn-default" onclick="submit_eliminar()">Eliminar Cuenta     <span class=" glyphicon glyphicon-trash"></span>
</button>
<input type="hidden" name="esEliminarUsuario" id="esEliminarUsuario" value="si">

</form>


			

			</div>
		</div>
	</div>
    
      
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>


</body>
</html>