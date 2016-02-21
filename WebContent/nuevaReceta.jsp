<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<%@page import="receta.Condimento"%>
<%@ page import="java.util.*,receta.Receta, receta.Ingrediente, usuario.Usuario" %>
<%

 	//List<Ingrediente> ingredientes = (List<Ingrediente>)session.getAttribute("todosLosIngredientes");
Ingrediente unIng = new Ingrediente();
List<Ingrediente> ingredientes = unIng.obtenerTodoslosIngredientes();
	//List<Condimento> condimentos = (List<Condimento>)session.getAttribute("todosLosCondimentos");
Condimento unCond = new Condimento();	
List<Condimento> condimentos = unCond.obtenerTodoslosCondimentos(); 
%>
<head>
	<meta charset="UTF-8">
	<title>Que Comemos Hoy?</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
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
	<script type="text/javascript">
	function submit_revisar(){
		
// 	    if(confirm("Seguro que quieres descartar los cambios?")) // this will pop up confirmation box and if yes is clicked it call servlet else return to page
// 	     {
//  	       window.location="welcome.jsp"; 
// 	     }else{
// 	       return false;
// 	    }
// 	   return true;

		var spans = document.getElementById('div_ingredientes').getElementsByTagName('span'),
		  obj = {};

		

		console.log(obj);
		
		//$('inputMeIngrediento').val($.param(obj));
		
		var theForm = document.forms['CrearReceta'];
	     if (!theForm) {
	         theForm = document.CrearReceta;
	     }
	     
	     for (var i = 0, l = spans.length; i < l; i++) {
			  obj[spans[i].id] = spans[i].textContent || spans[i].innerText;
			  addHidden(theForm, 'key-one', obj[spans[i].id]);
			}

	     //$('input').val()
	     //addHidden(theForm, 'key-one', obj);
	     
	     theForm.submit();
	 }
	</script>
	
	<script type="text/javascript">
	function addHidden(theForm, key, value) {
	    // Create a hidden input element, and append it to the form:
	    var input = document.createElement('input');
	    input.type = 'hidden';
	    input.name = key;'name-as-seen-at-the-server';
	    input.value = value;
	    theForm.appendChild(input);
	}
	</script>
	
</head>

<body>
	<header>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navegacion-kd">
						<span class="sr-only"> Desplegar / Ocultar Menu</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
						<!-- Agregar la session para que quede guardado el usuario -->
					<a href="creditos.jsp" class="navbar-brand">Que Comemos Hoy?</a>
                    <ul class="nav navbar-nav">
						<li><a href="welcome.jsp">Inicio</a></li>
						<li><a href="misGrupos.jsp">Mis Grupos</a></li>
						<li><a href="listadoDeRecetas.jsp">Mis Recetas</a></li>
						<li><a href="misDatos.jsp">Mis Datos</a></li>
						<li><a href="estadisticas.jsp">Estadisticas</a></li>
						<li><a href="#" onclick="logout();">Cerrar Sesion</a></li>
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
	</header>

	
	<section class="main container">
	<br><br>
		<div class="panel panel-default">
			<div class="panel panel-heading">Nueva receta!</div>
			<div class="panel-body">
				<div class="col-xs-8 col-md-offset-2">
					<form action="CrearReceta" method="post" id="CrearReceta">
						<div class="form-group">
							<label for="inputNombreReceta">Nombre de la receta</label> 
							<input type="text" class="form-control" id="nombreDeReceta" name="nombreDeReceta"/>
						</div>
						
						<div class="form-group">
							<label for="inputIngPrincipal">Ingrediente Principal</label> 
							<input type="text" class="form-control" id="ingPrincipal" name="ingPrincipal"/>
							<input type="number" class="form-control" id="caloriasIngPpal" name="caloriasIngPpal" placeholder="Calorias"/>
						</div>

						<div class="form-group">
							<label for="inputIngredientes">Ingredientes</label>
								<div class="panel panel-default" id="panelDrop">
									<div id="div_ingredientes" class="panel-body" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
								</div>
						</div>
						
						<div class="panel panel-default" id="panelDrop">
							<div class="panel-body" ondrop="drop(event)" ondragover="allowDrop(event)" name="Ingredientes">
								<% 
								int i = 1;
								for(Ingrediente ing : ingredientes){
									out.println("<span id=\"drag" + i + "\" class=\"label label-default\" draggable=\"true\" ondragstart=\"drag(event)\">");
									out.println(ing.getNombre());
									out.println("</span>");
									i++;
								}
								%>
<!-- 								<span id="drag1" class="label label-default" draggable="true" ondragstart="drag(event)">Default</span> -->
<!-- 								<span id="drag2" class="label label-default" draggable="true" ondragstart="drag(event)">Default</span> -->
<!-- 								<span id="drag3" class="label label-default" draggable="true" ondragstart="drag(event)">Default</span> -->
							</div>
						</div>

						<div class="form-inline">
							<label for="inputPreparacion">Preparación</label><br>
							<textarea class="form-control" rows="5" id="preparacion" name="preparacion"></textarea>
						</div>
						
						<div class="form-group">
							<label for="inputCondimentos">Condimentos</label>
							<div class="panel panel-default" id="panelDrop">
									<div id="div1" class="panel-body" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
								</div>
						</div>
						
						<div class="panel panel-default" id="panelDrop" >
							<div class="panel-body" ondrop="drop(event)" ondragover="allowDrop(event)" name="Condimentos">
								<% 
								
								for(Condimento condimento : condimentos){
									out.println("<span id=\"drag" + i + "\" class=\"label label-default\" draggable=\"true\" ondragstart=\"drag(event)\">");
									out.println(condimento.getNombre());
									out.println("</span>");
									i++;
								}
								%>
<!-- 								<span id="drag4" class="label label-default" draggable="true" ondragstart="drag(event)">Default1</span> -->
<!-- 								<span id="drag5" class="label label-default" draggable="true" ondragstart="drag(event)">Default2</span> -->
<!-- 								<span id="drag6" class="label label-default" draggable="true" ondragstart="drag(event)">Default3</span> -->
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputCategorias">Categorias</label>
								<div>
				          			<label>
				            			<input type="checkbox" name="optionCategoria"  value="Desayuno" />
				            			Desayuno
				          			</label>
				          			<label>
				            			<input type="checkbox" name="optionCategoria" value="Almuerzo" />
				            			Almuerzo
				          			</label>
				          			<label>
				            			<input type="checkbox" name="optionCategoria" value="Merienda" />
				            			Merienda
				          			</label>
				          			<label>
				            			<input type="checkbox" name="optionCategoria" value="Cena" />
				            			Cena
				          			</label>
				          		</div>
				      	</div>
						
						<div class="form-group">
							<label for="inputDificultad" class="control-label" >Nivel de Dificultad</label>
        						<select class="form-control" id="dificultad" name="dificultad">
				          			<option value="F">Fácil</option>
				          			<option value="M">Medio</option>
				          			<option value="D">Difícil</option>
				        		</select>
						</div>
						
						<div class="form-group">
							<label for="inputSector">Sector en la piramide alimenticia</label>
							<select class="form-control" id="sector" name="sector">
				          			<option value="0">Harinas y Legumbres</option>
				          			<option value="1">Lacteos</option>
				          			<option value="2">Frutas y Vetetales</option>
				          			<option value="3">Pescado, Carne y Huevo</option>
				          			<option value="4">Sal, Azucar, Grasas y Dulces</option>
				          			<option value="5">Aceites</option>
				        	</select>
						</div>
						
						<div class="form-group">
				      		<div class="col-lg-9 col-lg-offset-3">
				        		<button type="reset" class="btn btn-default">Cancelar</button>
				        		<button type="button" class="btn btn-primary" onclick="submit_revisar()">Aceptar</button>
				      		</div>
				    	</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
	
</body>
</html>