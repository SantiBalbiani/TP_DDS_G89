package Testeo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import hibernate.HibernateConf;
import receta.Receta;

public class TestBd {

	
	
	@Test	
	public void buscarReceta(){
		
		Session session = HibernateConf.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Receta e where e.nombreReceta = :nombre");

		query.setString("nombre", "tarta");
		
		java.util.List<?> lista = query.list();
		
	Receta nombreReceta1 = (Receta)lista.get(0);
	Receta nombreReceta2 = (Receta)lista.get(0);
	Receta nombreReceta3 = (Receta)lista.get(0);
		
		System.out.println(nombreReceta1.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
		System.out.println(nombreReceta2.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
		System.out.println(nombreReceta3.getNombreReceta()+" Dificultad "+nombreReceta1.getDificultadReceta());
				
		
	}
	
}
