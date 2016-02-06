package receta;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import receta.Condimento;
import receta.Ingrediente;


@Entity
@Table(name="RECETA")
public class Receta {

	private int idReceta;
	private String nombreReceta;
	private String preparacion;
	private Ingrediente ingredientePrincipal;
	private short calificacion;		
	private int calorias;
	private Set<Ingrediente> listaIngredientes;
	private Set<Condimento> listaCondimentos;
	private Set<String> listaCategorias;
	private ArrayList<String> listaProcedimiento;
	private String dificultadReceta;
	private ArrayList<String> temporadaPlato;
	private short sectorPiramideAlimenticia;

	List<String> listaPreparacion = new ArrayList<String>();
	
	List<String> listaTemporadaPlato = new ArrayList<String>(){{add("Verano"); add("Otono"); add("Invierno");add("Primavera");add("Pascuas");add("Navidad");}};

	List<String> listaDificultad = new ArrayList<String>(){{add("Facil"); add("Media"); add("Dificil");add("Muy Dificil");}};

	List<String> listaCategoria = new ArrayList<String>(){{add("Desayuno"); add("Almuerzo"); add("Merienda");add("Cena");}};

	
	//Atributos relacionados a la BD
	private String creadoPor;
	private Set<Receta> listaRecetas;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idReceta")
	public int getidReceta(){
		return this.idReceta;
	}
	
	

	
	
	//++++++++++++++++++ INICIO METODOS DE RECETA++++++++++++++++++++++++++++++++++++++++++++//
	
	public Receta crear_receta(Ingrediente unIngredientePrincipal, short calificacion, int calorias,  String unNombre, String unaPreparacion, String unaCategoria,String unaDificultad, String unaTemporada, short unSectorPiramide ){
		//llama a metodo new para crear Receta 
		//invoca los setters de la clase Receta para el alta de
		//ingredientes, condimentos y otros atributos...
		//devuelve la receta creada
		
		Receta nuevaReceta = new Receta();

		nuevaReceta.setNombreReceta(unNombre);
		nuevaReceta.agregarIngredientePrincipal(unIngredientePrincipal);

		nuevaReceta.setListaIngredientes(nuevaReceta.crearListaIngrediente());
		nuevaReceta.setListaCondimentos(nuevaReceta.crearListaCondimentos());
		
		nuevaReceta.agregarPreparacion(unaPreparacion);
		nuevaReceta.setListaCategorias(nuevaReceta.crearListaCategorias());
		nuevaReceta.agregarCategoria(unaCategoria);

		nuevaReceta.calificar(calificacion);
		nuevaReceta.agregarCalorias((int) calorias);
		
		
		nuevaReceta.setDificultadReceta(unaDificultad);
		nuevaReceta.setTemporadaPlato(unaTemporada);
		nuevaReceta.setSectorPiramideAlimenticia(unSectorPiramide);
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory SF = con.buildSessionFactory();
		Session session = SF.openSession();
		

		
		Transaction TR = session.beginTransaction();
		session.save(nuevaReceta);
		System.out.println("Object Saved Succesfully"); // Si imprime es porque persisti� ok el objeto
		TR.commit();
		session.close();
		SF.close();
		
		return nuevaReceta;
		
			
	}

	public void eliminar_receta(){
		
		
		

		this.nombreReceta= null;
		this.ingredientePrincipal = null;

		this.getListaIngredientes().clear();
		this.getListaCondimentos().clear();
		
		this.getListaProcedimiento().clear();
		this.listaCategoria= null;

		this.calificacion= 0;
		this.calorias = 0; 
		
		this.dificultadReceta=null;
		this.getTemporadaPlato().clear();
		this.sectorPiramideAlimenticia =0 ;  // Discutir piramide
			
	}
	
	
	//++++++++++++++++++ GETTERS ++++++++++++++//
	
	public short getCalificacion() {
		return this.calificacion;
	}

	public String getNombreReceta() {
		return this.nombreReceta;
	}
	
	public Ingrediente getIngredientePrincipal() {
		return this.ingredientePrincipal;
	}


	public int getCalorias() {
		return this.calorias;
	}


	public String getPreparacion() {
		return this.preparacion;
	}

	
	public String getDificultadReceta() {
		return this.dificultadReceta;
	}



	public short getSectorPiramideAlimenticia() {
		return sectorPiramideAlimenticia;
	}

	public Set<Condimento> getListaCondimentos() {
		return listaCondimentos;
	}


	public Set<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}


	public Set<String> getListaCategorias() {
		return listaCategorias;
	}
	
public  ArrayList<String> getListaProcedimiento() {
		
		return listaProcedimiento;
	}

	//++++++++++++++++++ SETTERS ++++++++++++++//

	//CALIFICACION
	
	public void setCalificacion(short calificacion) {
		this.calificacion = calificacion;
	}
	
	public short calificar(short unaCalificacion)   
	{
			if ((unaCalificacion >=1) || (unaCalificacion <=5)) {
			this.setCalificacion(unaCalificacion);
			}
			return this.getCalificacion();
	}

	//NOMBRE
	public String setNombreReceta(String unNombre) {
		this.nombreReceta= unNombre;
		return this.nombreReceta;
	}
	

	public String ponerNombreReceta(String nombreReceta) {
		
		if (noEsStringVacio(nombreReceta)) {  
			this.setNombreReceta(nombreReceta); 
		}
		return this.getNombreReceta();
	}
	
	//INGREDIENTE PRINCIPAL
	public void setIngredientePrincipal(Ingrediente ingredientePrincipal) {
		this.ingredientePrincipal = ingredientePrincipal;
	}
	
	public void agregarIngredientePrincipal(Ingrediente unIngrediente){ 
		this.setIngredientePrincipal(unIngrediente);
	}
	
	//CALORIAS
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public int agregarCalorias(int calorias) {
		
		if (calorias >=0) {
			this.setCalorias(calorias);
		};
		return this.getCalorias();
	}
	
	//PREPARACION
	public String agregarPreparacion(String unaPreparacion) {
		
		if (noEsStringVacio(unaPreparacion)) {  
			this.setPreparacion(unaPreparacion); 
		}
		return this.getPreparacion();
	}
		
	
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	
	//DIFICULTAD
	public void setDificultadReceta(String dificultadReceta) {
		this.dificultadReceta = dificultadReceta;
	}
	
	//TEMPORADA
	public void setTemporadaPlato(String  temporadaPlato) {
		this.getTemporadaPlato().add(temporadaPlato);
	}
	
	//PIRAMIDE
	public void setSectorPiramideAlimenticia(short sectorPiramideAlimenticia) {
		this.sectorPiramideAlimenticia = sectorPiramideAlimenticia;
	}
	
	//CONDIMENTOS
	public void setListaCondimentos(Set<Condimento> listaCondimentos) {
		this.listaCondimentos = listaCondimentos;
	}
	
	public Set<Condimento> crearListaCondimentos()
	{
		Set<Condimento> listaCondimentos ; 
		listaCondimentos = new HashSet<Condimento>();
		return listaCondimentos;
	}
	
	public void agregarCondimento(Condimento unCondimento) {
		
		this.getListaCondimentos().add(unCondimento);
	}
	
	
	//INGREDIENTES
	public Set<Ingrediente> crearListaIngrediente()
	{
		Set<Ingrediente> listaIngrediente ; 
		listaIngrediente = new HashSet<Ingrediente>();
		return listaIngrediente;
	}
	
	public void setListaIngredientes(Set<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}
	
	public void agregarIngrediente(Ingrediente unIngrediente) {
		
		this.getListaIngredientes().add(unIngrediente);
	}
	
	//CATEGORIA

	public Set<String> crearListaCategorias()
	{
		Set<String> listaCategoria; 
		listaCategoria = new HashSet<String>();
		return listaCategoria;
	}

	public void setListaCategorias(Set<String> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
public void agregarCategoria(String unaCategoria) {
		
		this.getListaCategorias().add(unaCategoria);
	}

//PROCEDIMIENTO
public Set<String> crearListaProcedimiento()
{
	Set<String> listaProcedimiento; 
	listaProcedimiento = new HashSet<String>();
	return listaProcedimiento;
}

public void setListalistaProcedimiento(ArrayList<String> unaListaProcedimiento) {
	this.listaProcedimiento= unaListaProcedimiento;
}

public void agregarlistaProcedimiento(String unaProcedimiento) {
	
	this.getListaProcedimiento().add(unaProcedimiento);
}


//CATEGORIA
//=========


public List<String> getListaCategoria() {
	return listaCategoria;
}

public void setListaCategoria(List<String> listaCategoria) {
	this.listaCategoria = listaCategoria;
}

public void quitarCategoria(String unaCategoria){
	
	this.getListaCategorias().remove(unaCategoria);
}

//DIFICULTAD
//==========


public List<String> getListaDificultad() {
	return listaDificultad;
}

public void setListaDificultad(List<String> listaDificultad) {
	this.listaDificultad = listaDificultad;
}	

//TEMPORADA PLATO
//=================



	public List<String> getListaTemporadaPlato() {
		return listaTemporadaPlato;
	}

	public void setListaTemporadaPlato(List<String> listaTemporadaPlato) {
		this.listaTemporadaPlato = listaTemporadaPlato;
	}

	
	public void agregarTemporada(String unaTemporada) {
		
		this.getTemporadaPlato().add(unaTemporada);
		
		
	}

	public ArrayList<String> getTemporadaPlato() {
		return temporadaPlato;
	}




//++++++++++++++++++ INICIO METODOS QUITAR DE RECETA ++++++++++++++//
	
	public void quitarTemporada(String unaTemporada){
		
		this.getTemporadaPlato().remove(unaTemporada);
	}
	
	public void quitarIngredientePrincipal(){
		
		this.ingredientePrincipal = null;
	}
	
	public void quitarCondimento(Condimento unCondimento){
		
		this.getListaCondimentos().remove(unCondimento);
	}
	
	public void quitarIngrediente(Ingrediente unIngrediente){
		
		this.getListaIngredientes().remove(unIngrediente);
	}
	
	
	public void quitarProcedimiento(String unProcedimiento){
		
		this.getListaProcedimiento().remove(unProcedimiento);
	}	
	
//++++++++++++++++++ FIN METODOS QUITAR DE RECETA ++++++++++++++//
//++++++++++++++++++ FIN METODOS DE RECETA++++++++++++++++++++++++++++++++++++++++++++//



	
	
	public  void setTotalCalorias(){
		
		this.setCalorias(this.getCaloriasIngredientePrincipal()); //falta sumar calorias del grupo de ingredientes
	}
	
	public int getCaloriasIngredientePrincipal(){
		
		return this.getIngredientePrincipal().getCalorias();
	}
	
public int getCaloriasdeTodosLosIngrediente(){
		
// hacer un foreach getCalorias de cada ingrediente y acumular. retornar el acumulado final		
	return 0;
}
	




/// control string

	@SuppressWarnings("null")
	public boolean noEsStringVacio(String unString)
	{
		try
		{
			//En caso de que no funcione probar con:
			//return (unString !=null && !unString.isEmpty())	;
			return ((unString != null) || (unString.length()!=0));
		}
		catch (NullPointerException npe)
		{
	        return false;
	    }
	}
	
	

}

