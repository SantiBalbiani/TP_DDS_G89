package receta;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import receta.Receta;





@Entity
@Table(name="INGREDIENTE")
public class Ingrediente {
	
	int idIngrediente;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="IDINGREDIENTE", unique = true, nullable = false )
	public int getIdIngrediente() {
		return idIngrediente;
	}


	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String nombre;
	public int porcion;
	public int calorias;
	private Set<Receta> recetas = new HashSet<Receta>(0);
	
	//++++++++++++++++++ INICIO OPERACIONES DE AGREGAR INGREDIENTE++++++++++++++++++++++++++++++++++++++++++++//
	
	
	
	public Set<Ingrediente> agregar(Set<Ingrediente> unaListaIngrediente)
	{
	    //se agrega el ingrediente
		unaListaIngrediente.add(this);
		return unaListaIngrediente;
	}
	
	
	public Set<Ingrediente> eliminar(Set<Ingrediente> unaListaIngrediente)
	{
	    //se agrega el ingrediente
		unaListaIngrediente.remove(this);
		return unaListaIngrediente;
	}
	
	public Ingrediente crearIngrediente(String unNombre, int porcion, int unasCalorias){
		Ingrediente nuevoIngrediente = new Ingrediente();
		nuevoIngrediente.setCalorias(unasCalorias);
		nuevoIngrediente.setNombre(unNombre);
		nuevoIngrediente.setPorcion(porcion);
		
		return nuevoIngrediente;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "ingredientes")
	public Set<Receta> getRecetas() {
		return this.recetas;
	}
	
	public void guardarIngrediente(Ingrediente unIngrediente){
		
		Ingrediente nuevoIngrediente = new Ingrediente();
		
		nuevoIngrediente.setCalorias(unIngrediente.getCalorias());
		nuevoIngrediente.setNombre(unIngrediente.getNombre());
		nuevoIngrediente.setPorcion(unIngrediente.getPorcion());
		
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory SF = con.buildSessionFactory();
		Session session = SF.openSession();
		
		Transaction TR = session.beginTransaction();
		session.save(nuevoIngrediente);
		System.out.println("Object Saved Succesfully"); // Si imprime es porque persistió ok el objeto
		TR.commit();
		session.close();
		SF.close();
	}
	//++++++++++++++++++ FIN OPERACIONES DE AGREGAR INGREDIENTE++++++++++++++++++++++++++++++++++++++++++++//
	
	@Column(name="NOMBRE", nullable = false, length = 45)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name = "porcion", nullable = false)
	public int getPorcion() {
		return porcion;
	}
	public void setPorcion(int porcion) {
		this.porcion = porcion;
	}@Column(name = "calorias", nullable = false)
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
}