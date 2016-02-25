package Testeo;

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

	
	@Test
	public void TestPlanificacion() {
		
		Planificacion unaPlanificacion = new Planificacion();
		
		Usuario unUser = new Usuario();
		
		//++++++++++++++++++Usuario se Loguea++++++++++++++++++++++++++
		unUser = unUser.buscarUsuarioPorNombre("HOLAMANUEL");
		
		Receta unaReceta = new Receta();
		
		
		//+++++++++++++++++++++Receta asociada a usuario con intencion de planificar+++++++++++
		unaReceta = (Receta)unUser.getRecetasUser().iterator().next();
		
		TipoReceta unTipo = new TipoReceta();
		
		Session session = HibernateConf.getSessionFactory().openSession();

		Query query = session.createQuery("FROM TipoReceta e where e.tipoReceta = :tipoReceta");

		//++++++++++++++++++++El usuario decide poner la receta para desayuno++++++++++++++++++
		query.setString("tipoReceta", "Desayuno");
		
		try {
			java.util.List<?> lista;
			
			
			
			lista = query.list();
			

				unTipo = (TipoReceta)lista.get(0);
				
				
		
		}catch(Throwable theException) 	    
		
	{
	     System.out.println("algo paso"); 
	}
		
		
	session.close();
//+++++++++++++++++++++++++++Se dirige al boton crear Planificacion+++++++++++++++
		
		
		session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();
		
		
		
	unaPlanificacion.setFecha("24/02/2016");
	
	unaPlanificacion.setUsuario(unUser);
	
	unaPlanificacion.setReceta(unaReceta);
	
	unaPlanificacion.setUnTipoDeReceta(unTipo);
	
	session.save(unaPlanificacion);
	
	session.getTransaction().commit();
	System.out.println("Done");
	session.close();
	
		
		
		// TODO Auto-generated constructor stub
	}
	@Test
	public void TestPlanifXUser(){
		
		
	Usuario unUser = new Usuario();
		
		//++++++++++++++++++Usuario se Loguea++++++++++++++++++++++++++
		unUser = unUser.buscarUsuarioPorNombre("HOLAMANUEL");
			
			Session session = HibernateConf.getSessionFactory().openSession();

			Query query = session.createQuery("FROM Planificacion p WHERE p.usuario = :usuario");
			
			query.setParameter("usuario", unUser);
			
			List<Planificacion> listaPlanifXUser = query.list();

			session.close();
			
			for (Planificacion unaPl :listaPlanifXUser){
				
				System.out.println(unaPl.getFecha());
				System.out.println(unaPl.getReceta().getNombreReceta());
				System.out.println(unaPl.getUnTipoDeReceta().getTipoReceta());
				
				
				
			
		}
	}
	
}
