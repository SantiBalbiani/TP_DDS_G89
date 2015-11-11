package Testeo;

import usuario.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestUsuario {

	// click derecho sobre metodo, refactor >> rename  
	//  assertEquals(val1,val2); compara valores. 
	
	//code snippet 
	  /*
		@Test
	    public void testConcatenate() {
	        MyUnit myUnit = new MyUnit();  //crea objeto

	        String result = myUnit.concatenate("one", "two");

	        assertEquals("onetwo", result);

	    }
	*/

	@Test
	
	public void testAltaDeUsuario(){
	
	
		 usuario.Usuario usuario = new usuario.Usuario();
	
		 usuario.setNombreUsuario("Benja");
		 usuario.setSexo('M');
		 usuario.setFecha_nacimiento("23/10/1986");
		 usuario.setComplexion("unaComprexion");
		 usuario.setAltura(1.67f);
		 usuario.setCondPreexistentes("unaCondPreexsistente");
		 usuario.setDieta("unaDieta");
		 usuario.setPrefAlim("prefAlim");
		 usuario.setRutina("unaRutina");
		 usuario.setPrefAlim("unaPrefAlim");
		 
		 Usuario resultado =  usuario.altaUsuario('M', "23/10/1986", "unaComprexion",1.67f,"unaPrefAlim", "unaCondPreexsistente","unaDieta", "unaRutina");
	
	
	
		 assertEquals(usuario, resultado);
	
	
	}
	
	
}
