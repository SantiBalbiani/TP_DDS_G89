package Testeo;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;

import hibernate.*;
import receta.Ingrediente;
import receta.Receta;
import receta.TipoReceta;
import receta.Condimento;
import usuario.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class TestBd {


	
	
	
	@Test
	public  void testReporteRecetasPorCalorias(){
		
		 int caloriasInicio = 190;
		int caloriasFin= 3000;
		 
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
 
		Criteria recetas = sessionHIB.createCriteria(Receta.class).add(Restrictions.between("calorias", caloriasInicio, caloriasFin));
	
		@SuppressWarnings("unchecked")
		List<Receta> recetasPorCalorias = recetas.list();
	
		
		try {
	 
			if(recetasPorCalorias.isEmpty()){
				
				System.out.println( " No se encontraron Resultados" );
				   System.out.println(	" INICIO: "+caloriasInicio);
				   System.out.println(	" FIN: "+caloriasFin);
			}else {
	
				 System.out.println(	" INICIO: "+caloriasInicio);
				   System.out.println(	" FIN: "+caloriasFin);
				   
				for (Receta receta: recetasPorCalorias){
					System.out.println(receta.getNombreReceta()+" Calorias "+receta.getCalorias());
				
				}
				

			}
				
	}catch(Throwable theException) 	    
		
	{
		   System.out.println(	" INICIO: "+caloriasInicio);
		   System.out.println(	" FIN: "+caloriasFin);
		System.out.println("algo paso"); 
	}
}
	
	
	

	
	
	
//	
//	@Test
//	public void altaTipos(){
//		
//		TipoReceta unTipo = new TipoReceta();
//		TipoReceta unTipo2 = new TipoReceta();
//		TipoReceta unTipo3 = new TipoReceta();
//		TipoReceta unTipo4 = new TipoReceta();
//		
//		unTipo.setTipoReceta("Desayuno");
//		unTipo2.setTipoReceta("Almuerzo");
//		unTipo3.setTipoReceta("Merienda");
//		unTipo4.setTipoReceta("Cena");
//		
//		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
//		sessionHIB.beginTransaction();
//		
//		sessionHIB.save(unTipo);
//		sessionHIB.save(unTipo2);
//		sessionHIB.save(unTipo3);
//		sessionHIB.save(unTipo4);
//		
//		sessionHIB.getTransaction().commit();
//		System.out.println("Done");
//		sessionHIB.close();
//		
//  
//		
//	}
//	
	
	
	@Test
	public void testStringToDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = "07/06/2013";

		try {

			Date date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Test
	public void buscarEntreFechas(){
		


		//Obtiene las calorias de un tipo de comida por semana o mes

			Date hoy =  new Date();
		
			Calendar calendarEnd = Calendar.getInstance();
			calendarEnd.setTime(hoy);   
			calendarEnd.set(Calendar.MILLISECOND, 999);
			calendarEnd.set(Calendar.SECOND, 59);
			calendarEnd.set(Calendar.MINUTE, 59);
			calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
		    Date fechaFin =  calendarEnd.getTime();
			
			
          //Date comienzoSemanaOmes =  fechaInicio; 
			
			
			
			Calendar calendarStart = Calendar.getInstance();
			calendarStart.setTime(hoy);   
		    calendarStart.set(Calendar.DATE, 22);
	        calendarStart.set(Calendar.MILLISECOND, 0);
	        calendarStart.set(Calendar.SECOND, 0);
	        calendarStart.set(Calendar.MINUTE, 0);
	        calendarStart.set(Calendar.HOUR_OF_DAY, 0);
		    Date comienzoSemanaOmes =  calendarStart.getTime();
			   
 
		   
	
			   
			 //  comienzoSemanaOmes = hoy;
			
			Session sessionHIB = HibernateConf.getSessionFactory().openSession();
	  
	 	//	@SuppressWarnings("unchecked")
			// List<Receta> recetaList =   sessionHIB.createQuery("from Receta e where e.fechaAlta between :start and :end").setParameter("start",comienzoSemanaOmes)
		//	.setParameter("end",hoy).list();	

			short tipoComida = 3;
	 		Criteria recetas = sessionHIB.createCriteria(Receta.class).add(Restrictions.eq("sectorPiramideAlimenticia", tipoComida)).add(Restrictions.between("fechaAlta", comienzoSemanaOmes, fechaFin));
	 		@SuppressWarnings("unchecked")
			List<Receta> recetaList = recetas.list();
	 		
			
			try {
		 
				if(recetaList.isEmpty()){
					
					System.out.println( " No se encontraron Resultados" );
					   System.out.println(	" INICIO: "+comienzoSemanaOmes);
					   System.out.println(	" FIN: "+fechaFin);
				}else {
		
					 System.out.println(	" INICIO: "+comienzoSemanaOmes);
					   System.out.println(	" FIN: "+fechaFin);
					   
					for (Receta receta: recetaList){
						System.out.println(receta.getNombreReceta()+" Dificultad "+receta.getDificultadReceta());
					
					}
					
	
				}
					
		}catch(Throwable theException) 	    
			
		{
			   System.out.println(	" INICIO: "+comienzoSemanaOmes);
			   System.out.println(	" FIN: "+fechaFin);
			System.out.println("algo paso"); 
		}
			
			
			
	 

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
