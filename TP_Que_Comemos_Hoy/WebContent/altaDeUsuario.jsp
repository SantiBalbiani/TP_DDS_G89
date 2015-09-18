<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>&iquest;Que Comemos Hoy? - Alta de Usuario </title>
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
      <td height="309"><!-- TemplateBeginEditable name="EditRegion1" --><form action="procesarAltaDeUsuario.jsp" method="post">
			Nombre:           
                <input type="text" name="nombre" />
           <br/>Fecha Nacimiento: 
                <input type="text" name="fechaNacimiento" />
            <br/>Contraseña:
            	<input type="password" name="pass" />
            <br/>Altura: 
                <input type="text" name="altura" />
            <br/>Sexo
                    <select name="sexo">
                      <option value="M">Masculino</option>
                      <option value="F">Femenino</option>
                      <option value="O">Otro</option>
                    </select>
         <br/>Complexi&oacute;n
                <select name="complexion">
                    <option value="P">Peque&ntilde;o</option>
                    <option value="M">Mediano</option>
                    <option value="G">Grande</option>
                  </select>
             <br/> <p><input name="Submit" type="submit" value="Registrar"></p>
                
            </form>    <!-- TemplateEndEditable --></td>
    </tr>
    <tr>
      <td bgcolor="#228B22">&nbsp;</td>
    </tr>
  </table>
</div>
</body>
</html>