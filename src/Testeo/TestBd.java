package Testeo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import hibernate.*;
import receta.Ingrediente;
import receta.Receta;
import receta.Condimento;
import usuario.Usuario;

import java.util.List;
import java.util.Set;
public class TestBd {

	
	@Test
	public void recetasPorUsuario(){
		
		Usuario usuario = new Usuario();
		
		usuario = usuario.buscarUsuarioPorNombre("Santiago");
		
		Set<Receta> recetas = usuario.getRecetasUser();
		
		for(Receta r : recetas){
			System.out.println(r.getNombreReceta());
		}
		
	}
	
	@Test	
	public void buscarRecetaInexistente(){
		
		Session session = HibernateConf.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Receta e where e.nombreReceta = :nombre");

		query.setString("nombre", "tartotatita");
		
		try {
			java.util.List<?> lista;
			
			
			
			lista = query.list();
			

				Receta nombreReceta1 = (Receta)lista.get(0);
				Receta nombreReceta2 = (Receta)lista.get(0);
				Receta nombreReceta3 = (Receta)lista.get(0);
					
					System.out.println(nombreReceta1.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
					System.out.println(nombreReceta2.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
					System.out.println(nombreReceta3.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
				
		}catch(Throwable theException) 	    
			
		{
		     System.out.println("algo paso"); 
		}
			
	
		
	
		
	}
	
	@Test	
	public void buscarReceta(){
		
		Session session = HibernateConf.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Receta e where e.nombreReceta = :nombre");

		query.setString("nombre", "TARTA");
		
		java.util.List<?> lista = query.list();
		
	Receta nombreReceta1 = (Receta)lista.get(0);
	Receta nombreReceta2 = (Receta)lista.get(0);
	Receta nombreReceta3 = (Receta)lista.get(0);
		
		System.out.println(nombreReceta1.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
		System.out.println(nombreReceta2.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
		System.out.println(nombreReceta3.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
				
		
	}
	
	@Test	
	public void buscarRecetaPorNombre(){
		
		Receta unaReceta = new Receta();
		
		unaReceta = unaReceta.buscarRecetaPorNombre("tarta");
		
		Assert.assertEquals("tarta", unaReceta.getNombreReceta());
		
		
	}
	
	
	@Test
	public void traerTodosLosIngredientes(){
		Ingrediente unIngrediente = new Ingrediente();
		
		List<Ingrediente> todosLosIng = unIngrediente.obtenerTodoslosIngredientes();
		
		
		
		for (Ingrediente ing : todosLosIng){
			System.out.println(ing.getNombre());
		}
		System.out.println(todosLosIng.size());
	}

	@Test
	public void traerTodosLosCondimentoss(){
		Condimento unCondimento = new Condimento();
		
		List<Condimento> todosLosCond = unCondimento.obtenerTodoslosCondimentos();
		
		
		
		for (Condimento cond : todosLosCond){
			System.out.println(cond.getNombre());
		}
		System.out.println(todosLosCond.size());
	}

}
