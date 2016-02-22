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
	 <script src="js/jquery-1.11.0.min.js"></script>
  <script src="js/bootstrap-3.1.1.min.js"></script>
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
		//Desde aca empieza a levantar ingredientes secundarios..
		
		var spans = document.getElementById('div_ingredientes').getElementsByTagName('span'),
		  obj = {};
		console.log(obj);
		//$('inputMeIngrediento').val($.param(obj));
		var theForm = document.forms['CrearReceta'];
	     if (!theForm) {
	         theForm = document.CrearReceta;
	     }
	     
	     var ingredientesHermosos = "&";
	     for (var i = 0, l = spans.length; i < l; i++) {
			  //obj[spans[i].id] = spans[i].textContent || spans[i].innerText;
			//  addHidden(theForm, 'key-one', obj[spans[i].id]);
	    	 ingredientesHermosos = ingredientesHermosos.concat(spans[i].textContent || spans[i].innerText);
	    	 ingredientesHermosos = ingredientesHermosos.concat("&");
			}

	     //addHidden(theForm, 'ingredientesDRAGdrop', ingredientesHermosos);
	     //$('input').val()
	     //addHidden(theForm, 'key-one', obj);
	     
	     //desde aca empieza a levantar condimentos (duplico el codigo de ingredientes...)
	     var spans2 = document.getElementById('div_condimentos').getElementsByTagName('span'),
		  obj2 = {};
		console.log(obj2);
	     var condimentosHermosos = "&";
	     for (var j = 0,m = spans2.length; j < m; j++) {
	    	 condimentosHermosos = condimentosHermosos.concat(spans2[j].textContent || spans2[j].innerText);
	    	 condimentosHermosos = condimentosHermosos.concat("&");
			}
	     //addHidden(theForm, 'condimentosDRAGdrop', condimentosHermosos);
	     
	     //aca termina de levantar todos los condimentos & ingredientes y hace el submit..! :)
	     
	     if(condimentosHermosos=="&" || ingredientesHermosos=="&") // this will pop up confirmation box and if yes is clicked it call servlet else return to page
	     {
 	       confirm("Por favor seleccione ingredientes y/o condimentos");
 	      return false;
	     }else{
	    	 addHidden(theForm, 'condimentosDRAGdrop', condimentosHermosos);
	    	 addHidden(theForm, 'ingredientesDRAGdrop', ingredientesHermosos);
	    	 theForm.submit();
	    	 return true;
	    }
	
	     //theForm.submit();
	     
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
    $('#CrearReceta').bootstrapValidator({
         framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	nombreDeReceta: {
                validators: {
                    notEmpty: {
                        message: 'El nombre de la de receta es un campo obligatorio'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'El nombre de la receta debe tener entre 4 y 30 caracteres'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'El nombre solo puede tener valores alfanumericos y guiones bajos'
                    }
                }
            },
            preparacion: {
                validators: {
                    notEmpty: {
                        message: 'La preparacion es un campo obligatorio'
                    },
                    stringLength: {
                        min: 4,
                        max: 240,
                        message: 'La preparacion de la receta debe tener entre 4 y 240 caracteres'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\s]+$/,
                        message: 'La preparacion solo puede tener valores alfanumericos, guiones bajos y espacios'
                    }
                }
            },
            caloriasIngPpal: {
                validators: {
                    notEmpty: {
                        message: 'Las calorias de la receta es un campo obligatorio'
                    },
	   				 regexp: {
 					 regexp: /^[0-9]+$/,
 					 message: 'Las calorias de la receta solo puede contener números'
 				 },
 				between: {
                    min: 0,
                    max: 5000,
                    message: 'Las calorias de la receta tiene que ser entre 0 CAL  y  5000 CAL'
                }
//                     numeric: {
//                         message: 'El valor debe estar expresado en números'
//                     }
                 }
            }, 
//             peso: {
//                 validators: {
//                     notEmpty: {
//                         message: 'El peso es un campo obligatorio'
//                     },
// 	   				 regexp: {
//  					 regexp: /^[0-9]+$/,
//  					 message: 'El peso solo puede contener números'
//  				 },
//  				between: {
//                     min: 1,
//                     max: 300,
//                     message: 'El peso tiene que ser entre 1kg y  300kg'
//                 }
//                 }
//             },
            ingPrincipal: {
                validators: {
                    notEmpty: {
                        message: 'El ingrediente principal es un campo obligatorio'
                    },
                    stringLength: {
                        min: 4,
                        max: 30,
                        message: 'El ingrediente principal debe tener entre 4 y 30 caracteres'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'El ingrediente principal solo puede tener valores alfanumericos y guiones bajos'
                    }
                }
            },
//             inputMail: {
//    			 validators: {
//    				 notEmpty: {
//    					 message: 'El correo es requerido y no puede ser vacio'
//    				 },
// //    				 emailAddress: {
// //    					 message: 'El correo electronico no es valido'
// //    				 }
//    				 regexp: {
//                         regexp: /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i,
//                         message: 'No es un correo valido'
//                     }
//    			 }
//    			 },
//            fechaNacimiento: {
// 			 validators: {
// 				 notEmpty: {
// 					 message: 'La fecha de nacimiento es requerida y no puede ser vacia'
// 				 },
// 				 date: {
// 					 format: 'DD-MM-YYYY',
// 					 message: 'La fecha de nacimiento no es valida. Formato DDMMYYYY'
// 				 },
// 				 regexp: {
//                      regexp: /^[a-zA-Z0-9_-]+$/,
//                      message: 'La fecha solo puede tener valores alfanumericos y guiones bajos/altos'
//                  }
// 			 }
// 		 },
//             'size[]': {
//                 validators: {
//                     notEmpty: {
//                         message: 'The size is required'
//                     }
//                 }
//             },
            optionCategoria: {
                validators: {
                    notEmpty: {
                        message: 'La categoria es un campo obligatorio'
                    }
                }
             },
             d_sector: {
                 validators: {
                     notEmpty: {
                         message: 'El sector es un campo obligatorio'
                     }
                 }
              },
              d_dificultad: {
                  validators: {
                      notEmpty: {
                          message: 'La dificultad es un campo obligatorio'
                      }
                  }
               },
// 			rutina: {
// 			    validators: {
// 			        notEmpty: {
// 			            message: 'La rutina es un campo obligatorio'
// 			        }
// 			    }
// 			 }
//         },
        
// submitHandler: function(validator, form, submitButton) {
//     var inputUsuario = [validator.getFieldElements('firstName').val(),
//                     validator.getFieldElements('lastName').val()].join(' ');
//     alert('Hello ' + fullName);
// }
       
    }
    });
//     })
//        .on('success.field.fv', function(e, data) {
//             if (data.fv.getInvalidFields().length > 0) {    // There is invalid field
//                 data.fv.disableSubmitButtons(true);
//             }
//         });
});
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
							<input type="text" class="form-control" id="nombreDeReceta" name="nombreDeReceta" placeholder="Nombre de la receta" />
						</div>
						
						<div class="form-group">
							<label for="inputIngPrincipal">Ingrediente Principal</label> 
							<input type="text" class="form-control" id="ingPrincipal" name="ingPrincipal" placeholder="Ingrediente Principal"/>
<!-- 							<input type="number" class="form-control" id="caloriasIngPpal" name="caloriasIngPpal" placeholder="Calorias"/> -->
						</div>
						
						<div class="form-group">
							<label for="inputCaloriasTotales">Calorias Totales</label> 
							<input type="number" class="form-control" id="caloriasIngPpal" name="caloriasIngPpal" placeholder="Calorias"/>
						</div>

						<div class="form-group">
							<label for="inputIngredientes">Ingredientes</label>
								<div class="panel panel-default" id="panelDrop">
									<div id="div_ingredientes" class="panel-body" placeholder="Arrastre los ingredientes aqui" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
								</div>
						</div>
						
						<div class="panel panel-default" id="panelDrop">
							<div class="panel-body" ondrop="drop(event)" ondragover="allowDrop(event)" name="Ingredientes">
								<% 
								int i = 1;
								for(Ingrediente ing : ingredientes){
									out.println("<span id=\"ing" + i + "\" class=\"label label-default\" draggable=\"true\" ondragstart=\"drag(event)\">");
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

						<div class="form-group">
							<label for="inputPreparacion">Preparación</label><br>
							<textarea class="form-control" rows="5" id="preparacion" name="preparacion" placeholder="Por favor ingrese la preparacion de la receta.."></textarea>
						</div>
						
						<div class="form-group">
							<label for="inputCondimentos">Condimentos</label>
							<div class="panel panel-default" id="panelDrop">
									<div id="div_condimentos" class="panel-body" ondrop="drop(event)" ondragover="allowDrop(event) "></div>
								</div>
						</div>
						
						<div class="panel panel-default" id="panelDrop" >
							<div class="panel-body" ondrop="drop(event)" ondragover="allowDrop(event)" name="Condimentos">
								<% 
								i=0;
								for(Condimento condimento : condimentos){
									out.println("<span id=\"cond" + i + "\" class=\"label label-default\" draggable=\"true\" ondragstart=\"drag(event)\">");
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
<!-- 							En el futuro esto tendria que ser consultado a la BD y crearlos.... Por el momento va ok -->
								<div class="checkbox">
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
        						<select class="form-control" id="d_dificultad" name="d_dificultad">
				          			<option disabled selected> -- Elija la dificultad -- </option>
				          			<option  value="F">Fácil</option>
				          			<option  value="M">Medio</option>
				          			<option  value="D">Difícil</option>
				        		</select>
						</div>
						
						<div class="form-group">
							<label for="inputSector">Sector en la piramide alimenticia</label>
							<select class="form-control" id="d_sector" name="d_sector">
							<option disabled selected> -- Elija el sector de la piramide Alimenticia -- </option>
				          			<option  value="0">Harinas y Legumbres</option>
				          			<option  value="1">Lacteos</option>
				          			<option  value="2">Frutas y Vetetales</option>
				          			<option  value="3">Pescado, Carne y Huevo</option>
				          			<option  value="4">Sal, Azucar, Grasas y Dulces</option>
				          			<option  value="5">Aceites</option>
				        	</select>
						</div>
						
						<div class="form-group">
				      		<div class="col-lg-9 col-lg-offset-3">
				        		 <a href="listadoDeRecetas.jsp" class="btn btn-primary" role="button">Cancelar</a>
				        		<button type="button" class="btn btn-primary" onclick="submit_revisar()"  >Aceptar</button>
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