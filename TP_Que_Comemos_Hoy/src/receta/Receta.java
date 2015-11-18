package receta;

/*

import java.util.Scanner;

import java.util.HashSet;
import java.util.Set;

public class Receta {

	
	public String nombreReceta;
	private String preparacion;
	private Ingrediente ingredientePrincipal;
	
	
	public void agregarIngredientePrincipal(Ingrediente unIngrediente){
		
		
	}

	public String nombreReceta(String unNombre) {
		this.nombreReceta= unNombre;
		return this.nombreReceta;
	}

	public void agregarIngrediente(Ingrediente unIngrediente) {
		// TODO Auto-generated method stub
		
	}

	public void agregarIngredienteCalorias(int calorias) {
		// TODO Auto-generated method stub
		
	}

	public void agregarCondimento(Condimento unCondimento) {
		// TODO Auto-generated method stub
		
	}

//TODO CORREGIR ESTO!!!
	
	public String agregarPreparacion() {   
		this.preparacion= new Scanner(System.in).next();
		return this.preparacion;
	}

	public void temporadaReceta() {
		// TODO Auto-generated method stub
		
	}

	public void borrarIngrediente(Ingrediente unIngrediente) {
		// TODO Auto-generated method stub
		
	}

	public void calificarReceta(int calificacion) {
		// TODO Auto-generated method stub
		
	}

	public void borrarCondimento(Condimento unCondimento) {
		// TODO Auto-generated method stub
	}

	public String getNombreReceta() {
		// TODO Auto-generated method stub
		return this.nombreReceta;
	}

	public String getDificultad() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTemporada() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCalificacion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
*/



import java.util.HashSet;
import java.util.Set;

import usuario.Usuario;

//import java.util.Scanner;

public class Receta {

	
	private String nombreReceta;
	private String preparacion;
	private Ingrediente ingredientePrincipal;
	private short calificacion;		//Atributo para poder hacer pruebas
	private int calorias;
	private Set<Ingrediente> listaIngredientes;
	private Set<Condimento> listaCondimentos;
	private Set<String> listaCategorias;
	private String dificultadReceta;
	private String temporadaPlato;
	private short sectorPiramideAlimenticia;
	//private Evento temporada_plato;
	
	
	public Receta crear_receta(Ingrediente unIngrediente, short calificacion, int calorias, Condimento unCondimento, String unNombre, String unaPreparacion, String unaCategoria,String unaDificultad, String unaTemporada, short unSectorPiramide ){
		//llama a metodo new para crear Receta 
		//invoca los setters de la clase Receta para el alta de
		//ingredientes, condimentos y otros atributos...
		//devuelve la receta creada
		
		Receta nuevaReceta = new Receta();

		//nuevaReceta.nombreReceta(unNombre); //entrada x teclado
		nuevaReceta.setNombreReceta(unNombre);
		nuevaReceta.agregarIngredientePrincipal(unIngrediente);

		nuevaReceta.setListaIngredientes(nuevaReceta.crearListaIngrediente());
		nuevaReceta.setListaCondimentos(nuevaReceta.crearListaCondimento());
		
		//TODO: debe haber un loop de 1 a n ingredientes y/o condimentos 
		nuevaReceta.agregarIngrediente(unIngrediente);
		nuevaReceta.agregarCondimento(unCondimento);
		
		
		
		//nuevaReceta.agregarPreparacion();//entrada x teclado
		nuevaReceta.setListaCategorias(nuevaReceta.crearListaCategorias());
		nuevaReceta.agregarCategoria(unaCategoria);
		
		nuevaReceta.setPreparacion(unaPreparacion);
		//nuevaReceta.temporadaReceta();
		nuevaReceta.calificar(calificacion);
		nuevaReceta.setCalorias((int) calorias);
		
		
		nuevaReceta.setDificultadReceta(unaDificultad);
		nuevaReceta.setTemporadaPlato(unaTemporada);
		nuevaReceta.setSectorPiramideAlimenticia(unSectorPiramide);
		
		
		return nuevaReceta;
		
			
	}
	
	//++++++++++++++++++ INICIO OPERACIONES DE AGREGAR INGREDIENTE++++++++++++++++++++++++++++++++++++++++++++//
		public Set<Ingrediente> crearListaIngrediente()
		{
			Set<Ingrediente> listaIngrediente ; 
			listaIngrediente = new HashSet<Ingrediente>();
			return listaIngrediente;
		}
		
		public boolean agregarIngrediente(Ingrediente unIngrediente)
		{
		    //se agrega el ingrediente
			Set<Ingrediente> unaListaIngrediente;
			unaListaIngrediente = this.getListaIngredientes();
			unaListaIngrediente = unIngrediente.agregar(unaListaIngrediente);
			this.setListaIngredientes(unaListaIngrediente);
			return true;
		}
		
		public boolean eliminarIngrediente(Ingrediente unIngrediente)
		{
			//el ingrediente se vaa 
			Set<Ingrediente> unaListaIngrediente;
			unaListaIngrediente = this.getListaIngredientes();
			unaListaIngrediente = unIngrediente.eliminar(unaListaIngrediente);
			this.setListaIngredientes(unaListaIngrediente);
			return true;
		}
		//++++++++++++++++++ FIN OPERACIONES DE AGREGAR INGREDIENTE++++++++++++++++++++++++++++++++++++++++++++//
	
	
		//++++++++++++++++++ INICIO OPERACIONES DE AGREGAR Condimento++++++++++++++++++++++++++++++++++++++++++++//
		public Set<Condimento> crearListaCondimento()
		{
			Set<Condimento> listaCondimento ; 
			listaCondimento = new HashSet<Condimento>();
			return listaCondimento;
		}
		
		public boolean agregarCondimento(Condimento unCondimento)
		{
		    //se agrega el Condimento
			Set<Condimento> unaListaCondimento;
			unaListaCondimento = this.getListaCondimentos();
			unaListaCondimento = unCondimento.agregar(unaListaCondimento);
			this.setListaCondimentos(unaListaCondimento);
			return true;
		}
		
		public boolean eliminarCondimento(Condimento unCondimento)
		{
			//el Condimento se vaa 
			Set<Condimento> unaListaCondimento;
			unaListaCondimento = this.getListaCondimentos();
			unaListaCondimento = unCondimento.eliminar(unaListaCondimento);
			this.setListaCondimentos(unaListaCondimento);
			return true;
		}
		//++++++++++++++++++ FIN OPERACIONES DE AGREGAR INGREDIENTE++++++++++++++++++++++++++++++++++++++++++++//
		
		//++++++++++++++++++ INICIO OPERACIONES DE AGREGAR CATEGORIAS++++++++++++++++++++++++++++++++++++++++++++//
		public Set<String> crearListaCategorias()
		{
			Set<String> listaCategoria; 
			listaCategoria = new HashSet<String>();
			return listaCategoria;
		}
		
		public boolean agregarCategoria(String unaCategoria)
		{
		    //se agrega la categoria
			Set<String> unaListaCategoria;
			unaListaCategoria = this.getListaCategorias();
			unaListaCategoria.add(unaCategoria);
			this.setListaCategorias(unaListaCategoria);
			return true;
		}
		
		public boolean eliminarCategoria(String unaCategoria)
		{
			//la categoria se vaa 
			Set<String> unaListaCategoria;
			unaListaCategoria = this.getListaCategorias();
			unaListaCategoria.add(unaCategoria);
			this.setListaCategorias(unaListaCategoria);
			return true;
		}
		//++++++++++++++++++ FIN OPERACIONES DE AGREGAR INGREDIENTE++++++++++++++++++++++++++++++++++++++++++++//
		
		
	public void agregarIngredientePrincipal(Ingrediente unIngrediente){
		this.setIngredientePrincipal(unIngrediente);
	}


	public short getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(short calificacion) {
		this.calificacion = calificacion;
	}
	
	public String nombreReceta(String unNombre) {
		this.nombreReceta= unNombre;
		return this.nombreReceta;
	}

/*
	public void agregarIngredienteCalorias(int calorias) {
		// TODO Auto-generated method stub
		
	}
*/
/*
	public String agregarPreparacion() {
		this.preparacion= new Scanner(System.in).next();
		return this.preparacion;
	}
	*/
/*
	public void temporadaReceta() {
		// TODO Auto-generated method stub
		
	}


	public void calificarReceta(int calificacion) {
		// TODO Auto-generated method stub
		
	}


	public String getDificultad() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTemporada() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	/* Metodo para calificar una receta, invocando al setter */
	/* Los datos vienen validados desde el usuario */
	
	public boolean calificar(short unaCalificacion) 
	{
			this.setCalificacion(unaCalificacion);
			return true;		//Salio Todo bien
	}


	public Ingrediente getIngredientePrincipal() {
		return ingredientePrincipal;
	}


	public void setIngredientePrincipal(Ingrediente ingredientePrincipal) {
		this.ingredientePrincipal = ingredientePrincipal;
	}


	public int getCalorias() {
		return calorias;
	}


	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}


	public String getPreparacion() {
		return preparacion;
	}


	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public Set<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(Set<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	public Set<Condimento> getListaCondimentos() {
		return listaCondimentos;
	}

	public void setListaCondimentos(Set<Condimento> listaCondimentos) {
		this.listaCondimentos = listaCondimentos;
	}

	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}
	
	public String getNombreReceta() {
		return this.nombreReceta;
	}

	public Set<String> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(Set<String> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public String getDificultadReceta() {
		return dificultadReceta;
	}

	public void setDificultadReceta(String dificultadReceta) {
		this.dificultadReceta = dificultadReceta;
	}

	public String getTemporadaPlato() {
		return temporadaPlato;
	}

	public void setTemporadaPlato(String temporadaPlato) {
		this.temporadaPlato = temporadaPlato;
	}

	public short getSectorPiramideAlimenticia() {
		return sectorPiramideAlimenticia;
	}

	public void setSectorPiramideAlimenticia(short sectorPiramideAlimenticia) {
		this.sectorPiramideAlimenticia = sectorPiramideAlimenticia;
	}

	public void agregarPreparacion() {
		// TODO Auto-generated method stub
		
	}

	public void temporadaReceta() {
		// TODO Auto-generated method stub
		
	}

	public void agregarIngredienteCalorias(int calorias2) {
		// TODO Auto-generated method stub
		
	}

	public void calificarReceta(int calificacion2) {
		// TODO Auto-generated method stub
		
	}
}

