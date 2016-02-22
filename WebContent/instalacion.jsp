<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="usuario.Usuario, receta.Receta, java.util.*, receta.Condimento, receta.Ingrediente, Testeo.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%	TestBd instalacion = new TestBd();
	instalacion.altaTipos();
	
	TestReceta ingredientesYcondimentos = new TestReceta();
	
	ingredientesYcondimentos.crearUnCondimento();
	ingredientesYcondimentos.crearUnIngrediente();

	
	

%>

</body>
</html>