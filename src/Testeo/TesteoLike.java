package Testeo;

import java.util.List;


import org.junit.Test;

import receta.Receta;

public class TesteoLike {

	@Test
	public void testLike(){
		
		Receta unaReceta = new Receta();
		
		List<Receta> resultado;
		
		resultado = unaReceta.buscarRecetasPorNombre("SAL");
		
		for (Receta rec : resultado){
			
			System.out.println(rec.getNombreReceta());
			
		}
		
		
		
	}
	
}
