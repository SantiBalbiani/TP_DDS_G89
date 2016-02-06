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
		Iterator<Usuario> iterator = (grupo1.getGrupo()).iterator(); 
		int a=0;	//flag para saber si encontro el valor buscado
		
		while (iterator.hasNext())
		{
			String temporal =  ((iterator.next()).getNombreUsuario()  );
			if (  temporal.equals("soyUnaPrueba") || temporal.equals("eraUnaPrueba"))
				a=a+1;
		}
		
		if (a==2) 
		{
			assertTrue(true);
		} 
		else 
		{
			assertTrue(false);
		}
		
		
		//vamos a verificar que haya sacado del grupo al usuario....
		grupo1.salirGrupo(pruebaUser1);
		a=0;
		
		
		iterator = (grupo1.getGrupo()).iterator(); 
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

}
