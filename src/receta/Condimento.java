package receta;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.Query;
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
	@Column(name = "ID_CONDIMENTO")
	public int getIdCondimento() {
		return idCondimento;
	}

	public void setIdCondimento(int idCondimento) {
		this.idCondimento = idCondimento;
	}

	public String nombre;
	public String tipo;
	
	private Set<Receta> recetas = new HashSet<Receta>(0);	//para el many-to-many

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

	public java.util.List<Condimento> obtenerTodoslosCondimentos(){
		
		Session session = HibernateConf.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Condimento");
		
		java.util.List<Condimento> listaDeTodosLosCondimentos = query.list();

		
	return listaDeTodosLosCondimentos;
			
		
	}
public Condimento buscarCondimentoPorNombre(String unNombre){
		
		Session session = HibernateConf.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Condimento e where e.nombre = :nombre");

		query.setString("nombre", unNombre);
		
		java.util.List<?> lista = query.list();
		
	Condimento condimentoBuscado = (Condimento)lista.get(0);


	return condimentoBuscado;
}
	public void guardarCondimento(Condimento unCondimento) {

		//Condimento nuevoCondimento = new Condimento();
//
	//	nuevoCondimento.setNombre(unCondimento.getNombre());
		//nuevoCondimento.setTipo(unCondimento.getTipo());

		// Configuration con = new Configuration();
		// con.configure("hibernate.cfg.xml");
		// SessionFactory SF = con.buildSessionFactory();
		// Session session = SF.openSession();

		Session session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(unCondimento);

		session.getTransaction().commit();
		// Transaction TR = session.beginTransaction();
		// session.save(unCondimento);
		System.out.println("Object Saved Succesfully"); // Si imprime es porque
														// persisti� ok el
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
		this.nombre = (nombre.toUpperCase());
	}

	@Column(name = "TIPO")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo.toUpperCase();
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listaCondimentos", cascade=CascadeType.ALL)
	public Set<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(Set<Receta> recetas) {
		this.recetas = recetas;
	}
	
	
	
	public Set<Condimento> mostrarTodosLosCondimentos(){
		
		
		Set<Condimento> condimentosCargados = new HashSet<Condimento>(); 
		
		
		//TODO: HACER DEBUG
		
		
		Session session = HibernateConf.getSessionFactory().openSession();

		Query query = session.createQuery("FROM  Condimento");


		
		java.util.List<?> lista = query.list();
		
		condimentosCargados = (Set<Condimento>)lista;
		
		
		
		return condimentosCargados;
			
		
	}
	
	
	
	
	
	
	
	
	
}