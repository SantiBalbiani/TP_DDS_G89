package Testeo;

import usuario.CondicionesPreexistentes;
import usuario.Usuario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
 





import receta.Condimento;
import receta.Ingrediente;
import receta.Receta;

public class TestUsuario {


	/* 		---- Junit Test Case ----
	 * 		Codigo de condicion de Test: CarP.01
	 * 
	 * 		Testeado por: Santiago Balbiani
	 * 
	 * 	 Descripci�n:
	 *   El metodo setea atributos dentro del mismo objeto que contiene dentro de dicho metodo
	 *   Luego se llama a guardar usuario que persiste el objeto Usuario.
	 */
	@Test
	public void testAltaDeUsuario()
	{
		Usuario nuevoUsuario = new Usuario();
		
		//(String nombreUsuario, char sexo, String fnac, String complexion,double altura,String preferencias_alimenticias, Set<Integer> condPreexistentes,String dieta, String rutina, String password ) {
		
		CondicionesPreexistentes condPreexis = new CondicionesPreexistentes();
		condPreexis.getIndiceCondicionesDelUsuario().add(1); //generico
		
		nuevoUsuario.altaUsuario("Santiago", 'M', 25,"20150313", "mediana", 1.70, " ", condPreexis, " ", " ", "1234");
		
		nuevoUsuario.guardarUsuario(nuevoUsuario);
	}
	
	
	


}