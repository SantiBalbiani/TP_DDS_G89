package receta;

import java.util.Set;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




@Entity
@Table(name="INGREDIENTE")
public class Ingrediente {
	
	public String nombre;
	public int porcion;
	public int calorias;
	
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
	
	public void guardarIngrediente(Ingrediente unIngrediente){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory SF = con.buildSessionFactory();
		Session session = SF.openSession();
		
		Transaction TR = session.beginTransaction();
		session.save(unIngrediente);
		System.out.println("Object Saved Succesfully"); // Si imprime es porque persistió ok el objeto
		TR.commit();
		session.close();
		SF.close();
	}
	//++++++++++++++++++ FIN OPERACIONES DE AGREGAR INGREDIENTE++++++++++++++++++++++++++++++++++++++++++++//
	@Id
	@Column(name="NOMBRE")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPorcion() {
		return porcion;
	}
	public void setPorcion(int porcion) {
		this.porcion = porcion;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
}