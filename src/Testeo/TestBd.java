package Testeo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import hibernate.*;
import receta.Ingrediente;
import receta.Receta;
import receta.TipoReceta;
import receta.Condimento;
import usuario.Usuario;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class TestBd {

	
	
	@Test
	public void altaTipos(){
		
		TipoReceta unTipo = new TipoReceta();
		TipoReceta unTipo2 = new TipoReceta();
		TipoReceta unTipo3 = new TipoReceta();
		TipoReceta unTipo4 = new TipoReceta();
		
		unTipo.setTipoReceta("Desayuno");
		unTipo2.setTipoReceta("Almuerzo");
		unTipo3.setTipoReceta("Merienda");
		unTipo4.setTipoReceta("Cena");
		
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		sessionHIB.beginTransaction();
		
		sessionHIB.save(unTipo);
		sessionHIB.save(unTipo2);
		sessionHIB.save(unTipo3);
		sessionHIB.save(unTipo4);
		
		sessionHIB.getTransaction().commit();
		System.out.println("Done");
		sessionHIB.close();
		
		
		

		
	}
	
	/*
	@Test
	public void consultarMisRecetas(){
		
		Usuario user = new Usuario();
		
		user = user.buscarUsuarioPorNombre("HOLAMANUEL");
		
		Set<Receta> misRecetas = new HashSet<Receta>(0);
		
		misRecetas = user.getRecetasUser();
		
		for (Receta unaReceta : misRecetas){
			System.out.println(unaReceta.getNombreReceta());
			}
		
	}
	*/
	/*
	@Test
	public void recetasPorUsuario(){
		
		Usuario usuario = new Usuario();
		
		usuario = usuario.buscarUsuarioPorNombre("Santiago");
		
		Set<Receta> recetas = usuario.getRecetasUser();
		
		for(Receta r : recetas){
			System.out.println(r.getNombreReceta());
		}
		
	}
	*/
	
//	
//	@Test	
//	public void buscarRecetaInexistente(){
//		
//		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
//
//		Query query = sessionHIB.createQuery("FROM Receta e where e.nombreReceta = :nombre");
//
//		query.setString("nombre", "tartotatita");
//		
//		try {
//			java.util.List<?> lista;
//			
//			
//			
//			lista = query.list();
//			
//
//				Receta nombreReceta1 = (Receta)lista.get(0);
//				Receta nombreReceta2 = (Receta)lista.get(0);
//				Receta nombreReceta3 = (Receta)lista.get(0);
//					
//					System.out.println(nombreReceta1.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
//					System.out.println(nombreReceta2.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
//					System.out.println(nombreReceta3.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
//				
//		}catch(Throwable theException) 	    
//			
//		{
//		     System.out.println("algo paso"); 
//		}
//			
//	
//		
//	
//		
//	}
	
//	@Test	
//	public void buscarReceta(){
//		
//		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
//
//		Query query = sessionHIB.createQuery("FROM Receta e where e.nombreReceta = :nombre");
//
//		query.setString("nombre", "TARTA");
//		
//		java.util.List<?> lista = query.list();
//		
//	Receta nombreReceta1 = (Receta)lista.get(0);
//	Receta nombreReceta2 = (Receta)lista.get(0);
//	Receta nombreReceta3 = (Receta)lista.get(0);
//		
//		System.out.println(nombreReceta1.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
//		System.out.println(nombreReceta2.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
//		System.out.println(nombreReceta3.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
//				
//		
//	}
//	
//	@Test	
//	public void buscarRecetaPorNombre(){
//		
//		Receta unaReceta = new Receta();
//		
//		unaReceta = unaReceta.buscarRecetaPorNombre("tarta");
//		
//		Assert.assertEquals("tarta", unaReceta.getNombreReceta());
//		
//		
//	}
//	
//	
//	@Test
//	public void traerTodosLosIngredientes(){
//		Ingrediente unIngrediente = new Ingrediente();
//		
//		List<Ingrediente> todosLosIng = unIngrediente.obtenerTodoslosIngredientes();
//		
//		
//		
//		for (Ingrediente ing : todosLosIng){
//			System.out.println(ing.getNombre());
//		}
//		System.out.println(todosLosIng.size());
//	}
//
//	@Test
//	public void traerTodosLosCondimentoss(){
//		Condimento unCondimento = new Condimento();
//		
//		List<Condimento> todosLosCond = unCondimento.obtenerTodoslosCondimentos();
//		
//		
//		
//		for (Condimento cond : todosLosCond){
//			System.out.println(cond.getNombre());
//		}
//		System.out.println(todosLosCond.size());
//	}
//	


}
