package Testeo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import estadisticas.Planificacion;
import hibernate.HibernateConf;
import receta.Receta;
import receta.TipoReceta;
import usuario.Usuario;

public class TestPlanificacion {

	
//	@Test
//	public void testPlanificacion() {
//		
//		Planificacion unaPlanificacion = new Planificacion();
//		
//		Usuario unUser = new Usuario();
//		
//		//++++++++++++++++++Usuario se Loguea++++++++++++++++++++++++++
//		unUser = unUser.buscarUsuarioPorNombre("HOLAMANUEL");
//		
//		Receta unaReceta = new Receta();
//		
//		
//		//+++++++++++++++++++++Receta asociada a usuario con intencion de planificar+++++++++++
//		unaReceta = (Receta)unUser.getRecetasUser().iterator().next();
//		
//		TipoReceta unTipo = new TipoReceta();
//		
//		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
//
//		Query query = sessionHIB.createQuery("FROM TipoReceta e where e.tipoReceta = :tipoReceta");
//
//		//++++++++++++++++++++El usuario decide poner la receta para desayuno++++++++++++++++++
//		query.setString("tipoReceta", "Desayuno");
//		
//		try {
//			java.util.List<?> lista;
//			
//			
//			
//			lista = query.list();
//			
//
//				unTipo = (TipoReceta)lista.get(0);
//				
//				
//		
//		}catch(Throwable theException) 	    
//		
//	{
//	     System.out.println("algo paso"); 
//	}
//		
//		
//	sessionHIB.close();
////+++++++++++++++++++++++++++Se dirige al boton crear Planificacion+++++++++++++++
//		
//		
//		sessionHIB = HibernateConf.getSessionFactory().openSession();
//		sessionHIB.beginTransaction();
//		
//		String fechaEnString = "24/02/2016";
//		
//		   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //;
// 
//			Date date = new Date();
//			try {
//				date = formatter.parse(fechaEnString);
//			} catch (ParseException e) {
//				 
//				e.printStackTrace();
//			}
//			
//			
//		
//	unaPlanificacion.setFecha(date);
//	
//	unaPlanificacion.setUsuario(unUser);
//	
//	unaPlanificacion.setReceta(unaReceta);
//	
//	unaPlanificacion.setUnTipoDeReceta(unTipo);
//	
//	sessionHIB.save(unaPlanificacion);
//	
//	sessionHIB.getTransaction().commit();
//	System.out.println("Done");
//	sessionHIB.close();
//	
//		
//		
//		// TODO Auto-generated constructor stub
//	}
//	@Test
//	public void TestPlanifXUser(){
//		
//		
//	Usuario unUser = new Usuario();
//		
//		//++++++++++++++++++Usuario se Loguea++++++++++++++++++++++++++
//		unUser = unUser.buscarUsuarioPorNombre("HOLAMANUEL");
//			
//			Session sessionHIB = HibernateConf.getSessionFactory().openSession();
//
//			Query query = sessionHIB.createQuery("FROM Planificacion p WHERE p.usuario = :usuario");
//			
//			query.setParameter("usuario", unUser);
//			
//			@SuppressWarnings("unchecked")
//			List<Planificacion> listaPlanifXUser = query.list();
//
//			sessionHIB.close();
//			
//			for (Planificacion unaPl :listaPlanifXUser){
//				
//				System.out.println(unaPl.getFecha());
//				System.out.println(unaPl.getReceta().getNombreReceta());
//				System.out.println(unaPl.getUnTipoDeReceta().getTipoReceta());
//				
//				
//				
//			
//		}
//	}
//	
 }
