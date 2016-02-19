package Testeo;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import receta.Receta;
import usuario.Usuario;

public class TestGrupo {

	@Test
	public void test_grupo1() 
	{
		//Pruebo el test_grupo....
		
		Usuario pruebaUser1 = new Usuario ();			//Instancio un nuevo usuario
		pruebaUser1.setNombreUsuario("soyUnaPrueba");
		
		Usuario pruebaUser2 = new Usuario ();			//Instancio un nuevo usuario
		pruebaUser2.setNombreUsuario("eraUnaPrueba");
		
		usuario.GrupoUsuarios grupo1 = new usuario.GrupoUsuarios ();
		grupo1.darAltaGrupo(pruebaUser1, "grupo1");
		assertTrue("grupo1".equals(grupo1.getNombreDeGrupo()));
		
		grupo1.ingresarGrupo(pruebaUser2);
		Iterator<Usuario> iterator = (grupo1.getGrupoDeUsuarios()).iterator(); 
		int a=0;	//flag para saber si encontro el valor buscado
		
//		while (iterator.hasNext())
//		{
//			String temporal =  ((iterator.next()).getNombreUsuario()  );
//			if (  temporal.equals("soyUnaPrueba") )
//				a=a+1;
//			if (  temporal.equals("eraUnaPrueba") )
//				a=a+1;
//		}
//		
//		if (a>=1) 
//		{
//			assertTrue(true);
//		} 
//		else 
//		{
//			assertTrue(false);
//		}
		
		
		//vamos a verificar que haya sacado del grupo al usuario....
		grupo1.salirGrupo(pruebaUser1);
		a=0;
		
		
		iterator = (grupo1.getGrupoDeUsuarios()).iterator(); 
		while (iterator.hasNext())
		{
		  String temporal =  ((iterator.next()).getNombreUsuario()  );
			if (  temporal.equals("eraUnaPrueba"));
				a=a+1;
		}
		
		if (a==1) 
		{
			assertTrue(true);
		} 
		else 
		{
			assertTrue(false);
		}
		
		grupo1 = null;
		pruebaUser1 = null;
		pruebaUser2 = null;
	}
	
	@Test
	public void testMANYtoMANYuserGRUPO()
	{
		Usuario nuevoUsuario = new Usuario();
		
		//(String nombreUsuario, char sexo, String fnac, String complexion,double altura,String preferencias_alimenticias, Set<Integer> condPreexistentes,String dieta, String rutina, String password ) {
		
		//CondicionesPreexistentes condPreexis = new CondicionesPreexistentes();
		//condPreexis.getIndiceCondicionesDelUsuario().add(1); //generico
		
		//nuevoUsuario.altaUsuario("Santiago", 'M', 25,"20150313", "mediana", 1.70, " ", condPreexis, " ", " ", "1234");

		//Session session = HibernateConf.getSessionFactory().openSession();
		//session.beginTransaction();
		
		//TODO: enrealidad hay que buscar el IDUSUARIO porque sino rompe... en mi bd es el user 140
		nuevoUsuario.setIdUsuario(140);
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

		Usuario pruebaUser2 = new Usuario ();			//Instancio un nuevo usuario
		pruebaUser2.setNombreUsuario("eraUnaPrueba");
		
		usuario.GrupoUsuarios grupo1 = new usuario.GrupoUsuarios ();
		grupo1.darAltaGrupo(nuevoUsuario, "grupo1");
				
		//grupo1.ingresarGrupo(pruebaUser2);
		
		nuevoUsuario.getUserGrupo().add(grupo1);
		//pruebaUser2.getUserGrupo().add(grupo1);
		
		//nuevoUsuario.guardarUsuario(nuevoUsuario);
		grupo1.guardarGrupo(grupo1);
		
		

		
//		 session.save(nuevoUsuario);
//		 session.getTransaction().commit();
//		 System.out.println("Done");
//		 session.close();
		//nuevoUsuario.guardarUsuario(nuevoUsuario);
	}
	

}
