package Testeo;

import usuario.CondicionesPreexistentes;
import usuario.Usuario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import hibernate.HibernateConf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
 





import receta.Condimento;
import receta.Ingrediente;
import receta.Receta;

public class TestUsuario {


	@Test
	public void testMANYtoMANYuserRECETA()
	{
		Usuario nuevoUsuario = new Usuario();
		
		//(String nombreUsuario, char sexo, String fnac, String complexion,double altura,String preferencias_alimenticias, Set<Integer> condPreexistentes,String dieta, String rutina, String password ) {
		
		//CondicionesPreexistentes condPreexis = new CondicionesPreexistentes();
		//condPreexis.getIndiceCondicionesDelUsuario().add(1); //generico
		
		//nuevoUsuario.altaUsuario("Santiago", 'M', 25,"20150313", "mediana", 1.70, " ", condPreexis, " ", " ", "1234");

		//Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		//sessionHIB.beginTransaction();
		
		
		nuevoUsuario.setNombreUsuario("Santiago");
		nuevoUsuario.setPassword("123456");
		nuevoUsuario.setSexo('M');
		nuevoUsuario.setFecha_nacimiento("20150313");
		nuevoUsuario.setComplexion("mediana");
		nuevoUsuario.setAltura((double)1.70);
		nuevoUsuario.setPreferencias_alimenticias("algo");
		nuevoUsuario.setDieta("ovolactovegetariana");
		nuevoUsuario.setRutina("vago");
		//nuevoUsuario.setEdad((int)15);		//proximamente borrar...

		Receta unaReceta = new Receta();
		// Creo Ingrediente
		Ingrediente unIngrediente = new Ingrediente();
		unIngrediente = unIngrediente.crearIngrediente("unChori", (int) 80, (int)10);
		//unIngrediente.guardarIngrediente(unIngrediente);
		 
		//Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		//sessionHIB.beginTransaction();

		//sessionHIB.save(unIngrediente);
 
		
		
		
		
		
		// Creo Ingrediente PPAL
		Ingrediente ingredientePPAL = new Ingrediente();
		ingredientePPAL = ingredientePPAL.crearIngrediente("pasto", (int) 22, (int)33);
		//ingredientePPAL.guardarIngrediente(ingredientePPAL);
		
		//sessionHIB.save(ingredientePPAL);
		
		// Creo Condimento

		Condimento unCondimento = new Condimento();
		unCondimento = unCondimento.crearCondimento("ketchup", "aderezo");
		//unCondimento.guardarCondimento(unCondimento);
		//sessionHIB.save(unCondimento);
		//sessionHIB.getTransaction().commit();
		//sessionHIB.close();                	   
		
		// Creo Receta
		// Creo Receta

		Receta unaReceta2 = new Receta();
		short calificacion = 4;
		short sectorP = 4;

		// Agrego Condimentos
		unaReceta2.agregarUnIngrediente(unIngrediente);
		unaReceta2.agregarCondimento(unCondimento);
		unaReceta2.setIngredientePrincipal(ingredientePPAL);
		unaReceta2.setCalificacion(calificacion);
		unaReceta2.setSectorPiramideAlimenticia(sectorP);
		
		unaReceta2.setCalorias(500);
		unaReceta2.setPreparacion("Se hace como venga");
		unaReceta2.setNombreReceta("tarta");
		unaReceta2.setDificultadReceta(5);
		nuevoUsuario.getRecetasUser().add(unaReceta2);
		
		//unaReceta.guardarReceta(unaReceta);
		
		
		
		nuevoUsuario.guardarUsuario(nuevoUsuario);

		
//		 sessionHIB.save(nuevoUsuario);
//		 sessionHIB.getTransaction().commit();
//		 System.out.println("Done");
//		 sessionHIB.close();
		//nuevoUsuario.guardarUsuario(nuevoUsuario);
	}
	
	
	@Test
	public void testBuscarUsuario(){
		
			
			Session sessionHIB = HibernateConf.getSessionFactory().openSession();
			
			Query query = sessionHIB.createQuery("FROM Usuario e where e.nombreUsuario = :nombreUsuario");
			
			query.setString("nombreUsuario", "Emiliano");
			
			java.util.List<?> lista = query.list();
			
			Usuario usuarioBuscado = (Usuario)lista.get(0);
			
			System.out.println(usuarioBuscado.getPassword());
	}
	
	/* 		---- Junit Test Case ----
	 * 		Codigo de condicion de Test: CarP.01
	 * 
	 * 		Testeado por: Chespy
	 * 
	 * 	 Descripciï¿½n:
	 *   El metodo setea atributos dentro del mismo objeto que contiene dentro de dicho metodo
	 *   Luego se llama a guardar usuario que persiste el objeto Usuario.
	 */
	@Test
	public void testAltaDeUsuario()
	{
		Usuario nuevoUsuario = new Usuario();
		
		//(String nombreUsuario, char sexo, String fnac, String complexion,double altura,String preferencias_alimenticias, Set<Integer> condPreexistentes,String dieta, String rutina, String password ) {
		
		//CondicionesPreexistentes condPreexis = new CondicionesPreexistentes();
		//condPreexis.getIndiceCondicionesDelUsuario().add(1); //generico
		
		//nuevoUsuario.altaUsuario("Santiago", 'M', 25,"20150313", "mediana", 1.70, " ", condPreexis, " ", " ", "1234");

		//Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		//sessionHIB.beginTransaction();
		
		
		nuevoUsuario.setNombreUsuario("Santiago");
		nuevoUsuario.setPassword("123456");
		nuevoUsuario.setSexo('M');
		nuevoUsuario.setFecha_nacimiento("20150313");
		nuevoUsuario.setComplexion("mediana");
		nuevoUsuario.setAltura((double)1.70);
		nuevoUsuario.setPreferencias_alimenticias("algo");
		nuevoUsuario.setDieta("ovolactovegetariana");
		nuevoUsuario.setRutina("vago");
		//nuevoUsuario.setEdad((int)15);		//proximamente borrar...
		
		nuevoUsuario.guardarUsuario(nuevoUsuario);

		
//		 sessionHIB.save(nuevoUsuario);
//		 sessionHIB.getTransaction().commit();
//		 System.out.println("Done");
//		 sessionHIB.close();
		//nuevoUsuario.guardarUsuario(nuevoUsuario);
	}
	
	@Test
	public void probarObtenerFecha ()
	{
		Usuario nuevoUsuario = new Usuario();
		int prueba = nuevoUsuario.calcularEdad("2014-02-10");
		System.out.println("La edad del tipo es de: "+prueba +" años");	    
		
		//De "2014-02-09" a "2016-02-09"... la funcion devuelve 2
		//De "2014-02-09" a "2016-02-10"... la funcion devuelve 1
	}
	
	@Test
	public void modificarUsuario ()
	{
		//sessionHIB.getTransaction().begin();
		Usuario unUsuario = new Usuario();
		unUsuario.setNombreUsuario("Emiliano");
		unUsuario.setPassword("1234");
		unUsuario.setSexo('M');
		unUsuario.setFecha_nacimiento("20150313");
		unUsuario.setComplexion("mediana");
		unUsuario.setAltura((double)1.70);
		unUsuario.setPreferencias_alimenticias("algo");
		unUsuario.setDieta("ovolactovegetariana");
		unUsuario.setRutina("vago");
		
		unUsuario.guardarUsuario(unUsuario);
		
		//Le hago update al nombre
		unUsuario.setNombreUsuario("Antonio");
		unUsuario.setPassword("se_cambio");
		unUsuario.setFecha_nacimiento("20160413");
		unUsuario.setSexo('F');
		unUsuario.setComplexion("alta");
		unUsuario.setAltura((double)1.22);
		unUsuario.setDieta("vegetariano");
		unUsuario.setRutina("intenso");
		unUsuario.setComplexion("complicada");
		
		unUsuario.modificarUsuario(unUsuario);
	}

	@Test
	public void eliminarUsuario ()
	{
		//busco un usuario por nombre
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		Query query = sessionHIB.createQuery("FROM Usuario e where e.nombreUsuario = :nombreUsuario");
		query.setString("nombreUsuario", "Emiliano");
		java.util.List<?> lista = query.list();
		Usuario usuarioBuscado = (Usuario)lista.get(0);
		System.out.println("el id de usuario es: "+usuarioBuscado.getIdUsuario());
		
		
		//borro el usuario encontrado
		usuarioBuscado.eliminarUsuario(usuarioBuscado);
		System.out.println("se borro ok");
		
	}
}