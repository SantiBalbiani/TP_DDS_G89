package receta;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;



public class Receta {

	
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
	private List<String> temporadaPlato;
	private short sectorPiramideAlimenticia;

	
	//Buscar_Receta
	Recetario buscarReceta (String nombreReceta, String usuario, String ingredientePrincipal, String temporada, int dificultad, int calorias, String sectorPiramide, int calificacion)
	{
		if (nombreReceta !=null && !nombreReceta.isEmpty())
		{
			//TODO: consulta BD por jerarquia1 (nombre_receta)
			//return Recetario
		}
		if (usuario !=null && !usuario.isEmpty())
		{
			//TODO: consulta BD por jerarquia2 (usuario/grupo)
			//return Recetario
		}
		if ((ingredientePrincipal !=null && !ingredientePrincipal.isEmpty()) || (temporada !=null && !temporada.isEmpty()) || (dificultad!=-1) || (calorias !=-1) || (calificacion !=-1) || (sectorPiramide !=null && !sectorPiramide.isEmpty()))
		//revisa que alguno de los campos restantes no este vacio
		{
			//TODO: consulta BD por jerarquia3 (lo demas)
			//return Recetario
		}
		//para que compile le pongo un return recetario generico..
		//   {
		Receta pruebaReceta = new Receta ();			//Instancio una nueva receta
		pruebaReceta.setNombreReceta("tiranosaurioREX_GRRRR");
		receta.Recetario recetario = new receta.Recetario ();
		recetario.crearRecetario() ;
		recetario.agregarReceta(pruebaReceta);
		return recetario;
		//    }
		
		//TODO: si llego hasta aca devuelve error...
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


	public List<String> getTemporadaPlato() {
		return temporadaPlato;
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
	
	public void quitarCategoria(String unaCategoria){
		
		this.getListaCategorias().remove(unaCategoria);
	}
	
	public void quitarProcedimiento(String unProcedimiento){
		
		this.getListaProcedimiento().remove(unProcedimiento);
	}	
	
//++++++++++++++++++ FIN METODOS QUITAR DE RECETA ++++++++++++++//
//++++++++++++++++++ FIN METODOS DE RECETA++++++++++++++++++++++++++++++++++++++++++++//

//++++++++++++++++++ INICIO LISTAS BAGS SETS ETC++++++++++++++++++++++++++++++++++++++++++++//

	List<String> listaPreparacion = new ArrayList<String>();
	
	List<String> listaCategoria = new ArrayList<String>(){{add("Desayuno"); add("Almuerzo"); add("Merienda");add("Cena");add("Colacion");}};
	
	List<String> listaDificultad = new ArrayList<String>(){{add("Facil"); add("Media"); add("Dificil");add("Muy Dificil");}};
	
	List<String> listaTemporadaPlato = new ArrayList<String>(){{add("Verano"); add("Otono"); add("Invierno");add("Primavera");add("Pascuas");add("Navidad");}};
	
	//Esto va en la clase usuario
	//List<String> listaCondicionesPreexistentes = new ArrayList<String>(){{add("Diabetes"); add("Hipertension"); add("Celiasis");}};
	
	
	
	//++++++++++++++++++ MISC ++++++++++++++++++++++++++++++++++++++++++++//

	
	
	
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
	public boolean noEsStringVacio(String unString){
		
			
		return ((unString != null) || (unString.length()!=0));
	}
	
	

}

