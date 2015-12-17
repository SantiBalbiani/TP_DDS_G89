package usuario;

import org.hibernate.cfg.Configuration;
import org.hibernate.*;

public class DataInsertion {

	public static void main(String[] args) {

		new DataInsertion().insertInfo();
		
	}
	public void insertInfo(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory SF = con.buildSessionFactory();
		Session session = SF.openSession();
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setIdUsuario(12);
		nuevoUsuario.setNombreUsuario("Santi");
		nuevoUsuario.setAltura(1.5);
		nuevoUsuario.setComplexion("mediana");
		nuevoUsuario.setFecha_nacimiento("2015");
		nuevoUsuario.setSexo('M');
		nuevoUsuario.setPassword("1234");
		Transaction TR = session.beginTransaction();
		session.save(nuevoUsuario);
		System.out.println("Object Saved Succesfully");
		TR.commit();
		session.close();
		SF.close();
		
	}
}
