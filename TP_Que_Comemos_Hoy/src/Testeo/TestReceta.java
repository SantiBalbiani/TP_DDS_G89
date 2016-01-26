package Testeo;

import receta.Receta;
import usuario.Usuario;
import receta.Condimento;
import receta.Ingrediente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;





import java.util.Set;


public class TestReceta {
	//E.G.S.
	/* 		---- Junit Test Case ----
	 * 		Codigo de condicion de Test: CalR.01
	 * 
	 * 		Puntua a la receta del 1-5
	 * 
	 * 
	 *   El metodo calificar recibe unaReceta y unaCalificacion, valida los datos de entrada
	 *   y luego califica la receta con la calificacion dada.
	 */
	
	/*
	@Test
	public void testCalificarReceta() 
	{
		Receta pruebaReceta = new Receta ();			//Instancio una nueva receta
		Usuario pruebaUser1 = new Usuario ();			//Instancio un nuevo usuario
		pruebaUser1.setNombreUsuario("Pedro_PicaPiedras");		//Le agrego un nombre al usuario nuevo
		pruebaUser1.calificar(pruebaReceta, (short) 0);
		assertTrue(pruebaUser1.calificar(pruebaReceta, (short) 3));		//La calificacion fue exitosa 	(1 =< x <=5)
		assertTrue(pruebaUser1.calificar(pruebaReceta, (short) 1));		//La calificacion fue exitosa 	(1 =< x <=5)
		assertTrue(pruebaUser1.calificar(pruebaReceta, (short) 5));		//La calificacion fue exitosa 	(1 =< x <=5)
		assertFalse(pruebaUser1.calificar(pruebaReceta, (short) 0));		//La calificacion fallo 	(1 =< x <=5)
		assertFalse(pruebaUser1.calificar(pruebaReceta, (short) 8));		//La calificacion fallo 	(1 =< x <=5)
		//Agregar pruebas "banana" le mando cualquier cosa y falla...
		//Agregar pruebas por falla
		pruebaReceta = null;							//Elimino la instancia receta
		pruebaUser1 = null;								//Elimino la instancia usuario		
	}
	*/
	/*
	@Test
	public void testRecetario() 
	{
		Receta pruebaReceta = new Receta ();			//Instancio una nueva receta
		pruebaReceta.setNombreReceta("tiranosaurioREX_GRRRR");
		receta.Recetario recetario = new receta.Recetario ();
		recetario.crearRecetario() ;
		recetario.agregarReceta(pruebaReceta);
		
		assertTrue((recetario.getListaRecetas()).contains(pruebaReceta));
		
		recetario.eliminarReceta(pruebaReceta);
		assertFalse((recetario.getListaRecetas()).contains(pruebaReceta));

		
		pruebaReceta = null;							//Elimino la instancia receta
		recetario = null;								//Elimino la instancia usuario	
	}
	*/
	
	
	@Test
	public void crearUnIngrediente(){
		//Creo Ingrediente
		Ingrediente unIngrediente = new Ingrediente();
		unIngrediente.crearIngrediente("papa", 10, 56);
		unIngrediente.guardarIngrediente(unIngrediente);
	}
	
	
//	@Test
//	public void crearUnCondimento(){
//		Condimento unCondimento = new Condimento();
//		unCondimento.crearCondimento("mostaza", "aderezo");
//		unCondimento.guardarCondimento(unCondimento);
//	}
	
	
//	
//	@Test
//	/* 		---- Junit Test Case ----
//	 * 		Codigo de condicion de Test: CreR.01
//	 * 
//	 * 		Testeado por: Santiago Balbiani
//	 * 
//	 * 	 Descripción:
//	 *   El metodo setea atributos dentro del mismo objeto que contiene dentro de dicho metodo
//	 *   Luego se llama a guardar usuario que persiste el objeto Usuario.
//	 */
//	public void crearUnaReceta(){
//		
//		//Creo Ingrediente
//		Ingrediente unIngrediente = new Ingrediente();
//		unIngrediente.crearIngrediente("papa", 10, 56);
//		unIngrediente.guardarIngrediente(unIngrediente);
//		
//		//Creo Condimento
//		
//		Condimento unCondimento = new Condimento();
//		unCondimento.crearCondimento("mostaza", "aderezo");
//		unCondimento.guardarCondimento(unCondimento);
//		
//		
//		//Creo Receta
//		
//		Receta unaReceta = new Receta ();
//		short calificacion = 4;
//		short sectorP = 4;
//		
//		// Agrego Condimentos
//		
//		unaReceta.agregarIngrediente(unIngrediente);
//		unaReceta.agregarCondimento(unCondimento);
//		
//		
//		
//		
//		unaReceta.crear_receta(unIngrediente, calificacion, 4, "RecetaLoca", "hola", "como salga", "guachita", "4", sectorP);
//		
//	
//		//System.out.println(unCondimento.getNombre());
//		
//	}

	
}
