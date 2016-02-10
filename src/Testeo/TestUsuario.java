package Testeo;

import usuario.CondicionesPreexistentes;
import usuario.Usuario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

		//Session session = HibernateConf.getSessionFactory().openSession();
		//session.beginTransaction();
		
		
		nuevoUsuario.setNombreUsuario("Emiliano");
		nuevoUsuario.setPassword("1234");
		nuevoUsuario.setSexo('M');
		nuevoUsuario.setFecha_nacimiento("20150313");
		nuevoUsuario.setComplexion("mediana");
		nuevoUsuario.setAltura((double)1.70);
		nuevoUsuario.setPreferencias_alimenticias("algo");
		nuevoUsuario.setDieta("ovolactovegetariana");
		nuevoUsuario.setRutina("vago");
		//nuevoUsuario.setEdad((int)15);		//proximamente borrar...
		
		nuevoUsuario.guardarUsuario(nuevoUsuario);

		
//		 session.save(nuevoUsuario);
//		 session.getTransaction().commit();
//		 System.out.println("Done");
//		 session.close();
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
	


}