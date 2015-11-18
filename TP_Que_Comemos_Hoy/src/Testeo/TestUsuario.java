package Testeo;

import usuario.Usuario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;





import java.util.Set;
 



import receta.Condimento;
import receta.Ingrediente;
import receta.Receta;

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
		 usuario.setPrefAlim("unaPrefAlim");
		 usuario.setRutina("unaRutina");
		 
		 usuario.Usuario resultado =  altaUsuario("Benja", 'M', "23/10/1986", "unaComprexion",1.67f,"unaPrefAlim", "unaCondPreexsistente","unaDieta", "unaRutina");
		 ///altaUsuario(String nombreUsuario, char sexo, String fnac, String complexion,float altura,String preferencias_alimenticias, String condPreexistentes,String dieta, String rutina )
	
		 assertEquals(usuario.getNombreUsuario(), resultado.getNombreUsuario());
		 assertEquals(usuario.getSexo(), resultado.getSexo());
		 assertEquals(usuario.getFecha_nacimiento(), resultado.getFecha_nacimiento());
		 assertEquals(usuario.getComplexion(), resultado.getComplexion());
		 //assertEquals(usuario.getAltura(), resultado.getAltura());
		 assertEquals(usuario.getCondPreexistentes(), resultado.getCondPreexistentes());
		 assertEquals(usuario.getDieta(), resultado.getDieta());
		 assertEquals(usuario.getPrefAlim(), resultado.getPrefAlim());
		 assertEquals(usuario.getRutina(), resultado.getRutina());
		 
		 usuario = null;
		 resultado = null;
	
	}
	
	//TODO RESOLVER PROBLEMA ALTA USUARIO 
	private Usuario altaUsuario(String string, char c, String string2,
			String string3, float f, String string4, String string5,
			String string6, String string7) {
		// TODO Auto-generated method stub
		return null;
	}


	@Test
	public void testCrearReceta ()
	{
		Receta unaReceta = new Receta ();
		//unaReceta.nombreReceta("vegetalesVegetarianos"); //entrada x teclado
		unaReceta.setNombreReceta("vegetalesVegetarianos");
		receta.Ingrediente unIngrediente = new receta.Ingrediente ();
		unIngrediente.setNombre("churrasco");
		
		receta.Condimento unCondimento = new receta.Condimento ();
		unCondimento.setNombre("Verbatim");
		//System.out.println(unCondimento.getNombre());	debug
		
		unaReceta.agregarIngredientePrincipal(unIngrediente);
		
		//TODO: debe haber un loop de 1 a n ingredientes y/o condimentos 
		unaReceta.setListaIngredientes(unaReceta.crearListaIngrediente());
		unaReceta.setListaCondimentos(unaReceta.crearListaCondimento());
		unaReceta.agregarIngrediente(unIngrediente);
		unaReceta.agregarCondimento(unCondimento);
		
		
		unaReceta.setPreparacion("pedro corta la ensalada como un churrasco");//entrada x teclado
		//nuevaReceta.temporadaReceta();
		unaReceta.calificar((short)5);
		unaReceta.setCalorias((short) 100);
	
		unaReceta.setListaCategorias(unaReceta.crearListaCategorias());
		unaReceta.agregarCategoria("Cerveza Quilmes");
		
		unaReceta.setDificultadReceta("Media");
		unaReceta.setTemporadaPlato("Esto es para las Pascuas - Veraneras");
		unaReceta.setSectorPiramideAlimenticia((short) 15);
		
		
		Receta unaReceta2 = new Receta ();
		unaReceta2 = unaReceta.crear_receta(unIngrediente, (short) 5 , (int) 100, unCondimento, "vegetalesVegetarianos", "pedro corta la ensalada como un churrasco", "Cerveza Quilmes", "Media", "Esto es para las Pascuas - Veraneras", (short) 15 );
	
		 assertEquals(unaReceta.getNombreReceta(), unaReceta2.getNombreReceta());
		 assertEquals(unaReceta.getCalorias(), unaReceta2.getCalorias());
		 assertEquals(unaReceta.getIngredientePrincipal(), unaReceta2.getIngredientePrincipal());
		 assertEquals(unaReceta.getCalificacion(), unaReceta2.getCalificacion());
		 assertEquals(unaReceta.getListaCategorias(), unaReceta2.getListaCategorias());
		 assertEquals(unaReceta.getListaIngredientes(), unaReceta2.getListaIngredientes());
		 assertEquals(unaReceta.getListaCondimentos(), unaReceta2.getListaCondimentos());
		 
		 assertEquals(unaReceta.getDificultadReceta(), unaReceta2.getDificultadReceta());
		 assertEquals(unaReceta.getTemporadaPlato(), unaReceta2.getTemporadaPlato());
		 assertEquals(unaReceta.getSectorPiramideAlimenticia(), unaReceta2.getSectorPiramideAlimenticia());

		 unaReceta = null;
		 unIngrediente = null;
		 unCondimento = null;
		 unaReceta2 = null;
		 
	}
	
	
	
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
		
	
}
