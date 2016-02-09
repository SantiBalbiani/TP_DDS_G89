package receta;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateConf;

@Entity
@Table(name = "CONDIMENTO")
public class Condimento {

	private int idCondimento;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDCONDIMENTO")
	public int getIdCondimento() {
		return idCondimento;
	}

	public void setIdCondimento(int idCondimento) {
		this.idCondimento = idCondimento;
	}

	public String nombre;
	public String tipo;

	// ++++++++++++++++++ INICIO OPERACIONES DE AGREGAR
	// CONDIMENTO++++++++++++++++++++++++++++++++++++++++++++//

	public Set<Condimento> agregar(Set<Condimento> unaListaCondimento) {
		// se agrega el condimento
		unaListaCondimento.add(this);
		return unaListaCondimento;
	}

	public Set<Condimento> eliminar(Set<Condimento> unaListaCondimento) {
		// se elimina el condimento
		unaListaCondimento.remove(this);
		return unaListaCondimento;
	}

	public Condimento crearCondimento(String nombre, String tipo) {
		Condimento nuevoCondimento = new Condimento();
		nuevoCondimento.setNombre(nombre);
		nuevoCondimento.setTipo(tipo);
		return nuevoCondimento;
	}

	public void guardarCondimento(Condimento unCondimento) {

		Condimento nuevoCondimento = new Condimento();

		nuevoCondimento.setNombre(unCondimento.getNombre());
		nuevoCondimento.setTipo(unCondimento.getTipo());

		// Configuration con = new Configuration();
		// con.configure("hibernate.cfg.xml");
		// SessionFactory SF = con.buildSessionFactory();
		// Session session = SF.openSession();

		Session session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(nuevoCondimento);

		session.getTransaction().commit();
		// Transaction TR = session.beginTransaction();
		// session.save(unCondimento);
		System.out.println("Object Saved Succesfully"); // Si imprime es porque
														// persistió ok el
														// objeto
		// TR.commit();
		session.close();
		// SF.close();

	}

	// ++++++++++++++++++ FIN OPERACIONES DE AGREGAR
	// CONDIMENTO++++++++++++++++++++++++++++++++++++++++++++//

	
	
	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "TIPO")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}