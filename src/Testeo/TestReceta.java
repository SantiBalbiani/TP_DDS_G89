package Testeo;

import receta.Receta;
import usuario.Usuario;
import receta.Condimento;
import receta.Ingrediente;
import receta.Recetario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Session;
import org.junit.Test;
import hibernate.HibernateConf;


import java.util.HashSet;
import java.util.Iterator;
import java.awt.List;
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
	
	
	@Test
	public void testCalificarReceta() 
	{
		Receta pruebaReceta = new Receta ();			//Instancio una nueva receta
		Usuario pruebaUser1 = new Usuario ();			//Instancio un nuevo usuario
		pruebaUser1.setNombreUsuario("Pedro_PicaPiedras");		//Le agrego un nombre al usuario nuevo
		pruebaUser1.calificar(pruebaReceta, (short) 0);
		
		pruebaUser1.calificar(pruebaReceta, (short) 3);
		assertTrue((short)pruebaReceta.getCalificacion()==(short) 3);		//La calificacion fue exitosa 	(1 =< x <=5)
		
		pruebaUser1.calificar(pruebaReceta, (short) 1);
		assertTrue((short)pruebaReceta.getCalificacion()==(short) 1);		//La calificacion fue exitosa 	(1 =< x <=5)
		
		pruebaUser1.calificar(pruebaReceta, (short) 5);
		assertTrue((short)pruebaReceta.getCalificacion()==(short) 5);		//La calificacion fue exitosa 	(1 =< x <=5)
		
		pruebaUser1.calificar(pruebaReceta, (short) 0);
		assertTrue((short)pruebaReceta.getCalificacion()==(short) 0);		//La calificacion fallo 	(1 =< x <=5)
		
		pruebaUser1.calificar(pruebaReceta, (short) 8);
		assertTrue((short)pruebaReceta.getCalificacion()==(short) 8);		//La calificacion fallo 	(1 =< x <=5)
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
	
	
	/*
	@Test
	public void testBuscarReceta()
	{
		int a=0;	//flag para saber si encontro el valor buscado
		receta.Recetario recetario = new receta.Recetario ();

		
		
		// consulta BD por jerarquia1 (nombre_receta)
		
		recetario = recetario.buscarReceta ("nombre_receta", null, null, null, -2, -2, null, -2);
		Iterator<Receta> iterator = (recetario.getListaRecetas()).iterator(); 
		
		while (iterator.hasNext())
		{
			if (  ((iterator.next()).getNombreReceta()).equals("receta_buscada_por_nombre_receta")  )
				a=1;
		}
		
		if (a==1) 
		{
			assertTrue(true);
		} 
		else 
		{
			assertTrue(false);
		}
		//recetario = null;								//Elimino la instancia usuario	
		
		
		// consulta BD por jerarquia2 (usuario)
		
		a=0;
		recetario = null;
		recetario = new receta.Recetario ();
		recetario = recetario.buscarReceta (null, "unUsuario", null, null, -2, -2, null, -2);
		iterator = (recetario.getListaRecetas()).iterator(); 

		while (iterator.hasNext())
		{
			if (  ((iterator.next()).getNombreReceta()).equals("receta_buscada_por_usuario_grupo")  )
				a=1;
		}
		
		if (a==1) 
		{
			assertTrue(true);
		} 
		else 
		{
			assertTrue(false);
		}
		//recetario = null;								//Elimino la instancia usuario	

		
		// consulta BD por jerarquia3 (lo demas)
		
		a=0;
		recetario = null;
		recetario = new receta.Recetario ();
		recetario = recetario.buscarReceta (null, null, "jamonCrudo", "verano", 5, 100, "verduras", 2);
		iterator = (recetario.getListaRecetas()).iterator(); 
		
		while (iterator.hasNext())
		{
			if (  ((iterator.next()).getNombreReceta()).equals("tiranosaurioREX_GRRRR")  )
				a=1;
		}
		
		if (a==1) 
		{
			assertTrue(true);
		} 
		else 
		{
			assertTrue(false);
		}
		recetario = null;								//Elimino la instancia usuario				
		
		
	}
	*/
	
	
	
	
	
	/* 		---- Junit Test Case ----
	 * 		Codigo de condicion de Test: CreR.01
	 * 
	 * 		Testeado por: Santiago Balbiani
	 * 
	 * 	 Descripción:
	 *   El metodo setea atributos dentro del mismo objeto que contiene dentro de dicho metodo
	 *   Luego se llama a guardar usuario que persiste el objeto Usuario.
	 */
	
	@Test
	public void testcrearUnaReceta() {
		//Con esto probamos la receta y los metodos del many to many & Many to One...!!
		
		// Creo Ingrediente
		Ingrediente unIngrediente = new Ingrediente();
		unIngrediente = unIngrediente.crearIngrediente("unChori", (int) 80, (int)10);
		unIngrediente.guardarIngrediente(unIngrediente);
		
		
		// Creo Ingrediente PPAL
		Ingrediente ingredientePPAL = new Ingrediente();
		ingredientePPAL = ingredientePPAL.crearIngrediente("pasto", (int) 22, (int)33);
		ingredientePPAL.guardarIngrediente(ingredientePPAL);

		// Creo Condimento

		Condimento unCondimento = new Condimento();
		unCondimento = unCondimento.crearCondimento("ketchup", "aderezo");
		unCondimento.guardarCondimento(unCondimento);

		// Creo Receta

		Receta unaReceta = new Receta();
		short calificacion = 4;
		short sectorP = 4;

		// Agrego Condimentos

		//unaReceta.setIngredientes(unaReceta.crearListaIngrediente());
		unaReceta.agregarUnIngrediente(unIngrediente);

		//unaReceta.setListaCondimentos(unaReceta.crearListaCondimentos());
		unaReceta.agregarCondimento(unCondimento);

		unaReceta.setIngredientePrincipal(ingredientePPAL);
		unaReceta.setCalificacion(calificacion);
		unaReceta.setSectorPiramideAlimenticia(sectorP);
		unaReceta.setCalorias(500);
		unaReceta.setPreparacion("cortas la papa le pones manteca y wuala");
		unaReceta.setNombreReceta("La_PAPA_Milanesa");
		unaReceta.setDificultadReceta(5);

		
		unaReceta.guardarReceta(unaReceta);
		
		/*
		// ---------------------------------
		//Esto de aca abajo era una prueba de hardcode para Martin.....


		// Creo Ingrediente
		Ingrediente unIngrediente2 = new Ingrediente();
		unIngrediente2.crearIngrediente("estiercol", 10, 56);
		// unIngrediente.guardarIngrediente(unIngrediente);

		// Creo Condimento

		Condimento unCondimento2 = new Condimento();
		unCondimento2.crearCondimento("Noe", "aderezo");
		// unCondimento.guardarCondimento(unCondimento);

		// Creo Receta

		Receta unaReceta2 = new Receta();
		short calificacion2 = 4;
		short sectorP2 = 4;

		// Agrego Condimentos

		//unaReceta2.setListaIngredientes(unaReceta2.crearListaIngrediente());
		unaReceta2.agregarunIngrediente(unIngrediente2);
		unaReceta2.setListaCondimentos(unaReceta2.crearListaCondimentos());
		unaReceta2.agregarCondimento(unCondimento2);

		// unaReceta.setIngredientePrincipal(ingredientePrincipal);
		unaReceta2.setCalificacion(calificacion2);
		unaReceta2.setSectorPiramideAlimenticia(sectorP2);
		unaReceta2.setIngredientePrincipal(unIngrediente2);
		unaReceta2.setCalorias(250);
		unaReceta2.setPreparacion("noe se fue a la altamar");
		unaReceta2.setNombreReceta("noe_en_altamar");
		unaReceta2.setDificultadReceta(1);

		// ---------------------------------

		// Creo Ingrediente
		Ingrediente unIngrediente3 = new Ingrediente();
		unIngrediente3.crearIngrediente("lucas", 10, 56);
		// unIngrediente.guardarIngrediente(unIngrediente);

		// Creo Condimento

		Condimento unCondimento3 = new Condimento();
		unCondimento3.crearCondimento("quindimil", "aderezo");
		// unCondimento.guardarCondimento(unCondimento);

		// Creo Receta

		Receta unaReceta3 = new Receta();
		short calificacion3 = 4;
		short sectorP3 = 4;

		// Agrego Condimentos

		//unaReceta3.setListaIngredientes(unaReceta3.crearListaIngrediente());
		unaReceta3.agregarunIngrediente(unIngrediente3);
		unaReceta3.setListaCondimentos(unaReceta3.crearListaCondimentos());
		unaReceta3.agregarCondimento(unCondimento3);

		// unaReceta.setIngredientePrincipal(ingredientePrincipal);
		unaReceta3.setCalificacion(calificacion3);
		unaReceta3.setSectorPiramideAlimenticia(sectorP3);
		unaReceta3.setIngredientePrincipal(unIngrediente3);
		unaReceta3.setCalorias(100);
		unaReceta3.setPreparacion("accenture es muy linda y le gusta los cursos");
		unaReceta3.setNombreReceta("aguante ibm papa!");
		unaReceta3.setDificultadReceta(3);

		Set<Receta> listaRecetas;
		listaRecetas = new HashSet<Receta>();
		listaRecetas.add(unaReceta);
		listaRecetas.add(unaReceta2);
		listaRecetas.add(unaReceta3);
		
		
		//unaReceta.crear_receta(unIngrediente, calificacion, 4, "RecetaLoca", "hola", "como salga", "guachita", "4", sectorP);
		
		*/
	}


	
	
	@Test

	public void crearUnCondimento(){
		Condimento unCondimento = new Condimento();
		unCondimento = unCondimento.crearCondimento("mostaza", "aderezo");
		unCondimento.guardarCondimento(unCondimento);
		//System.out.println(unCondimento.getIdCondimento());
	}
	
	
	@Test
	public void crearUnIngrediente(){
		//Creo Ingrediente
		Ingrediente unIngrediente = new Ingrediente();
		unIngrediente = unIngrediente.crearIngrediente("papa", (int) 10, (int) 56);
		unIngrediente.guardarIngrediente(unIngrediente);
	}
	
}
