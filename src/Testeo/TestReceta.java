package Testeo;

import receta.Receta;
import usuario.Usuario;
import receta.Condimento;
import receta.Ingrediente;
import receta.Recetario;
import receta.TipoReceta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Query;
import org.junit.Test;

import hibernate.HibernateConf;

import java.util.Iterator;
import java.awt.List;



public class TestReceta {

	
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
	 * 		Codigo de condicion de Test: BusR.01
	 * 
	 * 		Testeado por: Santiago Balbiani
	 * 
	 * 	 Descripci�n:
	 *   Obtiene las primeras 3 recetas
	 *   
	 */
	
//	@Test	
//	public void buscarReceta(){
//		
//		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
//
//		Query query = sessionHIB.createQuery("FROM Receta e where e.nombreReceta = :nombre");
//
//		query.setString("nombre", "tarta");
//		
//		java.util.List<?> lista = query.list();
//		
//	Receta nombreReceta1 = (Receta)lista.get(0);
//	Receta nombreReceta2 = (Receta)lista.get(0);
//	Receta nombreReceta3 = (Receta)lista.get(0);
//		
//		System.out.println(nombreReceta1.getNombreReceta()+"acaa");
//		System.out.println(nombreReceta2.getNombreReceta()+"acaa");
//		System.out.println(nombreReceta3.getNombreReceta()+"acaa");
//				
//		
//	}
	
	
	/* 		---- Junit Test Case ----
	 * 		Codigo de condicion de Test: ConR.01
	 * 
	 * 		Testeado por: Santiago Balbiani
	 * 
	 * 	 Descripci�n:
	 *   Obtiene las primeras 3 recetas
	 *   
	 */
	/*
	@Test	
	public void consultarLas3PrimerasRecetas(){
		
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();

		Query query = sessionHIB.createQuery("FROM Receta");

		query.setFirstResult(3);
		
		java.util.List<?> lista = query.list();
		
		
		
		Receta nombreReceta = (Receta)lista.get(0);
		
		System.out.println(nombreReceta.getNombreReceta()+"acaa");
		System.out.println(nombreReceta.getNombreReceta()+"acaa");
		System.out.println(nombreReceta.getNombreReceta()+"acaa");
				
		
	} */
	
	/* 		---- Junit Test Case ----
	 * 		Codigo de condicion de Test: CreR.01
	 * 
	 * 		Testeado por: Santiago Balbiani
	 * 
	 * 	 Descripci�n:
	 *   El metodo setea atributos dentro del mismo objeto que contiene dentro de dicho metodo
	 *   Luego se llama a guardar usuario que persiste el objeto Usuario.
	 */
	
	@Test
	public void testcrearUnaReceta() {
		//Con esto probamos la receta y los metodos del many to many & Many to One...!!
		
		// Creo Ingrediente
		Ingrediente unIngrediente = new Ingrediente();
		unIngrediente = unIngrediente.crearIngrediente("Arroz", (int) 80, (int)10);
		//unIngrediente.guardarIngrediente(unIngrediente);
		 
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		sessionHIB.beginTransaction();

		sessionHIB.save(unIngrediente);
 
		
		
		
		
		
		// Creo Ingrediente PPAL
		Ingrediente ingredientePPAL = new Ingrediente();
		ingredientePPAL = ingredientePPAL.crearIngrediente("Pollo", (int) 22, (int)33);
		ingredientePPAL.guardarIngrediente(ingredientePPAL);
		
		sessionHIB.save(ingredientePPAL);
		
		// Creo Condimento

		Condimento unCondimento = new Condimento();
		unCondimento = unCondimento.crearCondimento("ketchup", "aderezo");
		//unCondimento.guardarCondimento(unCondimento);
		sessionHIB.save(unCondimento);
		sessionHIB.getTransaction().commit();
		sessionHIB.close();                	   
		
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
		unaReceta.setPreparacion("Se cocinan los ingredientes por separado y luego se mezclan");
		unaReceta.setNombreReceta("Arroz con pollo");
		unaReceta.setDificultadReceta(5);

		
		//unaReceta.guardarReceta(unaReceta);
		
		/*
		Receta unaReceta2 = new Receta();
		unaReceta2 = unaReceta2.crear_receta(ingredientePPAL, (short)1, 2, "tarta", "googlealo", "ComidaLight", 2, "verano", (short)2);
		
		unaReceta2.guardarReceta(unaReceta2);                                              
		*/
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
		unCondimento = unCondimento.crearCondimento("Mostaza", "aderezo");
		unCondimento.guardarCondimento(unCondimento);
		//System.out.println(unCondimento.getIdCondimento());
	}
	
	
	@Test
	public void crearUnIngrediente(){
		//Creo Ingrediente
		Ingrediente unIngrediente = new Ingrediente();
		unIngrediente = unIngrediente.crearIngrediente("Papa", (int) 10, (int) 56);
		unIngrediente.guardarIngrediente(unIngrediente);
	}
	
	
	
//	@Test
//	public void testDeTiposReceta() {
//		//Con esto probamos la receta y los metodos del many to many & Many to One...!!
//		
//		// Creo Ingrediente
//		Ingrediente unIngrediente = new Ingrediente();
//		unIngrediente = unIngrediente.crearIngrediente("Arroz", (int) 80, (int)10);
//		//unIngrediente.guardarIngrediente(unIngrediente);
//		 
//		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
//		sessionHIB.beginTransaction();
//
//		sessionHIB.save(unIngrediente);
// 
//		
//		
//		
//		
//		
//		// Creo Ingrediente PPAL
//		Ingrediente ingredientePPAL = new Ingrediente();
//		ingredientePPAL = ingredientePPAL.crearIngrediente("Pollo", (int) 22, (int)33);
//		ingredientePPAL.guardarIngrediente(ingredientePPAL);
//		
//		sessionHIB.save(ingredientePPAL);
//		
//		// Creo Condimento
//
//		Condimento unCondimento = new Condimento();
//		unCondimento = unCondimento.crearCondimento("ketchup", "aderezo");
//		//unCondimento.guardarCondimento(unCondimento);
//		sessionHIB.save(unCondimento);
//		sessionHIB.getTransaction().commit();
//		sessionHIB.close();                	   
//		
//		// Creo Receta
//
//		Receta unaReceta = new Receta();
//		short calificacion = 4;
//		short sectorP = 4;
//
//		// Agrego Condimentos
//
//		//unaReceta.setIngredientes(unaReceta.crearListaIngrediente());
//		unaReceta.agregarUnIngrediente(unIngrediente);
//
//		//unaReceta.setListaCondimentos(unaReceta.crearListaCondimentos());
//		unaReceta.agregarCondimento(unCondimento);
//		unaReceta.setIngredientePrincipal(ingredientePPAL);
//		unaReceta.setCalificacion(calificacion);
//		unaReceta.setSectorPiramideAlimenticia(sectorP);
//		unaReceta.setCalorias(500);
//		unaReceta.setPreparacion("Se cocinan los ingredientes por separado y luego se mezclan");
//		unaReceta.setNombreReceta("Arroz con pollo");
//		unaReceta.setDificultadReceta(5);
//
//		TipoReceta esDesayuno = new TipoReceta();
//		esDesayuno = esDesayuno.buscarTipoRecetaPorNombre("Desayuno");
//		TipoReceta esMeriendo = new TipoReceta();
//		esMeriendo = esMeriendo.buscarTipoRecetaPorNombre("Merienda");
//		Set<TipoReceta> lasCategorias = new HashSet<TipoReceta>(0);
//		lasCategorias.add(esDesayuno);
//		lasCategorias.add(esMeriendo);
//		
//		unaReceta.setListaCategorias(lasCategorias);
//		
//		unaReceta.guardarReceta(unaReceta);
//		
//		
//	}

	
}
