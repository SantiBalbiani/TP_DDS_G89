<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="usuario.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>&iquest;Que Comemos Hoy? - Bienvenida</title>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" --><!-- TemplateEndEditable -->
<style type="text/css">
<!--
body {
	background-color: #90C58F;
}
-->
</style></head>

<body>
<div align="center">
  <table width="642" height="548" border="1">
    <tr>
      <th height="196" bgcolor="#228B22" scope="col"><img src="logogral.jpg" width="416" height="192" /></th>
    </tr>
    <tr>
      <td height="309"><!-- TemplateBeginEditable name="EditRegion1" -->
      <% 

String nombreUsuario = (String)request.getParameter("nombre");
String fechaNac = (String)request.getParameter("fechaNacimiento");
String altura = (String)request.getParameter("altura");
String sexo = (String)request.getParameter("sexo");
String complexion = (String)request.getParameter("complexion");


Usuario nuevoUsuario = new Usuario();


nuevoUsuario.setNombreUsuario(nombreUsuario);


out.print("Bienvenido "+nombreUsuario+"!! ");
out.print("<br/>");


%>
<form action="inicio.jsp" method="post">
<p><input name="comenzar" type="submit" value="comenzar"></p>
</form>
<!-- TemplateEndEditable --></td>
    </tr>
    <tr>
      <td bgcolor="#228B22">&nbsp;</td>
    </tr>
  </table>
</div>
</body>
</html>