package receta;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateConf;
import receta.Condimento;
import receta.Ingrediente;
import usuario.CondicionesPreexistentes;
import usuario.Usuario;

@Entity
@Table(name = "RECETA")
public class Receta {

	private int idReceta;
	private String nombreReceta;
	private String preparacion;

	private Set<Ingrediente> ingredientes = new HashSet<Ingrediente>(0); // Para
																			// el
																			// many-to-many
	
	private Set<Usuario> usuarioRecetas = new HashSet<Usuario>(0); //para el many-to-many
	
	private Set<Integer> indiceDeIngredientes; 
	private Set<Integer> indiceDeCondimentos;
	
	private short calificacion;
	private int calorias;
	private int dificultadReceta;
	private short sectorPiramideAlimenticia;

	private Ingrediente ingredientePrincipal;
	private Set<Condimento> listaCondimentos = new HashSet<Condimento>(0);
	private Set<String> listaCategorias;
	private ArrayList<String> listaProcedimiento;
	private ArrayList<String> contraindicaciones;

	@Transient
	public ArrayList<String> getContraindicaciones() {
		return contraindicaciones;
	}

	public void setContraindicaciones(ArrayList<String> contraindicaciones) {
		this.contraindicaciones = contraindicaciones;
	}

	// @ManyToMany(fetch = FetchType.LAZY, mappedBy = "recetas")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "receta_por_ingrediente", joinColumns = { // agregar
																// catalogo de
																// ser
																// necesario...
			@JoinColumn(name = "ID_RECETA", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_INGREDIENTE", nullable = false, updatable = false) })
	
	
	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	//@Column(name = "INDEX_INGREDIENTES")
	//TODO: mapear esto a la BD
	@Transient
	public Set<Integer> getIndiceDeIngredientes() {
		return indiceDeIngredientes;
	}

	public void setIndiceDeIngredientes(Set<Integer> indiceDeIngredientes) {
		this.indiceDeIngredientes = indiceDeIngredientes;
	}
	//@Column(name = "INDEX_CONDIMENTOS")
	//TODO: mapear esto a la BD
	@Transient
	public Set<Integer> getIndiceDeCondimentos() {
		return indiceDeCondimentos;
	}

	public void setIndiceDeCondimentos(Set<Integer> indiceDeCondimentos) {
		this.indiceDeCondimentos = indiceDeCondimentos;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	private ArrayList<String> temporadaPlato;

	List<String> listaPreparacion = new ArrayList<String>();

	List<String> listaTemporadaPlato = new ArrayList<String>() {
		{
			add("Verano");
			add("Otono");
			add("Invierno");
			add("Primavera");
			add("Pascuas");
			add("Navidad");
		}
	};

	List<String> listaDificultad = new ArrayList<String>() {
		{
			add("Facil");
			add("Media");
			add("Dificil");
			add("Muy Dificil");
		}
	};

	List<String> listaCategoria = new ArrayList<String>() {
		{
			add("Desayuno");
			add("Almuerzo");
			add("Merienda");
			add("Cena");
		}
	};

	// TODO: agregar estos campos al mapeo BD!!
	// Atributos relacionados a la BD
	// private String creadoPor; //REVISAR.. NO TENDRIA QUE SER EL ID??
	// private Set<Receta> listaRecetas;

	// ++++++++++++++++++ GETTERS ++++++++++++++//

	@Column(name = "NOMBRE")
	public String getNombreReceta() {
		return this.nombreReceta;
	}

	public int obtenerIdIngredientePrincipal() {
		return ingredientePrincipal.getIdIngrediente();
	}

	@Column(name = "PREPARACION")
	public String getPreparacion() {
		return this.preparacion;
	}

	@Column(name = "CALIFICACION")
	public short getCalificacion() {
		return this.calificacion;
	}

	@Column(name = "CALORIAS")
	public int getCalorias() {
		return this.calorias;
	}

	@Column(name = "DIFICULTAD")
	public int getDificultadReceta() {
		return this.dificultadReceta;
	}

	@Column(name = "SECTOR_PIRAMIDE")
	public short getSectorPiramideAlimenticia() {
		return sectorPiramideAlimenticia;
	}

	// @Transient
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "receta_por_condimento", joinColumns = { // agregar
																// catalogo de
																// ser
																// necesario...
			@JoinColumn(name = "ID_RECETA", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_CONDIMENTO", nullable = false, updatable = false) })
	public Set<Condimento> getListaCondimentos() {
		return listaCondimentos;
	}

	@Transient
	public Set<String> getListaCategorias() {
		return listaCategorias;
	}

	@Transient
	public ArrayList<String> getListaProcedimiento() {

		return listaProcedimiento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_RECETA")
	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	@Transient
	public List<String> getListaPreparacion() {
		return listaPreparacion;
	}

	public void setListaPreparacion(List<String> listaPreparacion) {
		this.listaPreparacion = listaPreparacion;
	}

	// @Transient
	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name = "ID_INGREDIENTE")
	// @ManyToOne(fetch = FetchType.LAZY, mappedBy = "stock")
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_INGREDIENTE", nullable = false)
	public Ingrediente getIngredientePrincipal() {
		return ingredientePrincipal;
	}

	public void setListaProcedimiento(ArrayList<String> listaProcedimiento) {
		this.listaProcedimiento = listaProcedimiento;
	}

	public void setTemporadaPlato(ArrayList<String> temporadaPlato) {
		this.temporadaPlato = temporadaPlato;
	}

	// ++++++++++++++++++ SETTERS ++++++++++++++//

	
	public void agregarIndexIngredientes(Set<Integer> IndexIngredientes){
		this.setIndiceDeIngredientes(IndexIngredientes);
		
	}
	
	
	
	
	
	public void setCalificacion(short calificacion) {
		this.calificacion = calificacion;
	}

	public short calificar(short unaCalificacion) {
		if ((unaCalificacion >= 1) || (unaCalificacion <= 5)) {
			this.setCalificacion(unaCalificacion);
		}
		return this.getCalificacion();
	}

	// NOMBRE
	public String setNombreReceta(String unNombre) {
		this.nombreReceta = unNombre.toUpperCase();
		return this.nombreReceta;
	}

	public String ponerNombreReceta(String nombreReceta) {

		if (noEsStringVacio(nombreReceta)) {
			this.setNombreReceta(nombreReceta);
		}
		return this.getNombreReceta();
	}

	// INGREDIENTE PRINCIPAL
	public void setIngredientePrincipal(Ingrediente ingredientePrincipal) {
		this.ingredientePrincipal = ingredientePrincipal;
	}

	public void agregarIngredientePrincipal(Ingrediente unIngrediente) {
		this.setIngredientePrincipal(unIngrediente);
	}

	// CALORIAS
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public int agregarCalorias(int calorias) {

		if (calorias >= 0) {
			this.setCalorias(calorias);
		}
		;
		return this.getCalorias();
	}

	// PREPARACION
	public String agregarPreparacion(String unaPreparacion) {

		if (noEsStringVacio(unaPreparacion)) {
			this.setPreparacion(unaPreparacion);
		}
		return this.getPreparacion();
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion.toUpperCase();
	}

	// DIFICULTAD
	public void setDificultadReceta(int dificultadReceta) {
		this.dificultadReceta = dificultadReceta;
	}

	// TEMPORADA
	public void setTemporadaPlato(String temporadaPlato) {
		this.getTemporadaPlato().add(temporadaPlato.toUpperCase());
	}

	// PIRAMIDE
	public void setSectorPiramideAlimenticia(short sectorPiramideAlimenticia) {
		this.sectorPiramideAlimenticia = sectorPiramideAlimenticia;
	}

	
	
	// CONDIMENTOS
	
	public void agregarIndexCondimentos(Set<Integer> IndexCondimentos){
		this.setIndiceDeCondimentos(IndexCondimentos);
		
	}

	
	public void setListaCondimentos(Set<Condimento> listaCondimentos) {
		this.listaCondimentos = listaCondimentos;
	}

	public Set<Condimento> crearListaCondimentos() {
		Set<Condimento> listaCondimentos;
		listaCondimentos = new HashSet<Condimento>();
		return listaCondimentos;
	}

	public void agregarCondimento(Condimento unCondimento) {

		this.listaCondimentos.add(unCondimento);
	}

	public void agregarUnIngrediente(Ingrediente unIngrediente) {

		this.ingredientes.add(unIngrediente);
	}

	public void agregarIngredientes(Set<Ingrediente> unIngredientes) {

		this.setIngredientes(unIngredientes);
	}
	
	public Set<Ingrediente> crearListaIngrediente() {
		Set<Ingrediente> listaIngrediente;
		listaIngrediente = new HashSet<Ingrediente>();
		return listaIngrediente;
	}

	// CATEGORIA

	public Set<String> crearListaCategorias() {
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

	// PROCEDIMIENTO
	public Set<String> crearListaProcedimiento() {
		Set<String> listaProcedimiento;
		listaProcedimiento = new HashSet<String>();
		return listaProcedimiento;
	}

	public void setListalistaProcedimiento(ArrayList<String> unaListaProcedimiento) {
		this.listaProcedimiento = unaListaProcedimiento;
	}

	public void agregarlistaProcedimiento(String unaProcedimiento) {

		this.getListaProcedimiento().add(unaProcedimiento);
	}

	// CATEGORIA
	// =========

	@Transient
	public List<String> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<String> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public void quitarCategoria(String unaCategoria) {

		this.getListaCategorias().remove(unaCategoria);
	}

	// DIFICULTAD
	// ==========

	@Transient
	public List<String> getListaDificultad() {
		return listaDificultad;
	}

	public void setListaDificultad(List<String> listaDificultad) {
		this.listaDificultad = listaDificultad;
	}

	// TEMPORADA PLATO
	// =================

	@Transient
	public List<String> getListaTemporadaPlato() {
		return listaTemporadaPlato;
	}

	public void setListaTemporadaPlato(List<String> listaTemporadaPlato) {
		this.listaTemporadaPlato = listaTemporadaPlato;
	}

	public void agregarTemporada(String unaTemporada) {

		this.getTemporadaPlato().add(unaTemporada);

	}

	@Transient
	public ArrayList<String> getTemporadaPlato() {
		return temporadaPlato;
	}

	// ++++++++++++++++++ INICIO METODOS QUITAR DE RECETA ++++++++++++++//

	public void quitarTemporada(String unaTemporada) {

		this.getTemporadaPlato().remove(unaTemporada);
	}

	public void quitarIngredientePrincipal() {

		this.ingredientePrincipal = null;
	}

	public void quitarCondimento(Condimento unCondimento) {

		this.getListaCondimentos().remove(unCondimento);
	}

	public void quitarIngrediente(Ingrediente unIngrediente) {

		this.getIngredientes().remove(unIngrediente);
	}

	public void quitarProcedimiento(String unProcedimiento) {

		this.getListaProcedimiento().remove(unProcedimiento);
	}

	// ++++++++++++++++++ FIN METODOS QUITAR DE RECETA ++++++++++++++//
	// ++++++++++++++++++ FIN METODOS DE
	// RECETA++++++++++++++++++++++++++++++++++++++++++++//

	// ++++++++++++++++++ INICIO METODOS DE
	// RECETA++++++++++++++++++++++++++++++++++++++++++++//

	public Receta crear_receta(Ingrediente unIngredientePrincipal, Set<Integer> indexIngredientes, Set<Integer> indexCondimentos,
			short calificacion, int calorias, String unNombre, String unaPreparacion, String unaCategoria,
			int unaDificultad, String unaTemporada, short unSectorPiramide) {
		// llama a metodo new para crear Receta
		// invoca los setters de la clase Receta para el alta de
		// ingredientes, condimentos y otros atributos...`

		
		// devuelve la receta creada

		Receta nuevaReceta = new Receta();

		nuevaReceta.setNombreReceta(unNombre);
		nuevaReceta.agregarIngredientePrincipal(unIngredientePrincipal);

		
		
		nuevaReceta.agregarIndexIngredientes(indexIngredientes);
		nuevaReceta.agregarIndexCondimentos(indexCondimentos);

		nuevaReceta.agregarPreparacion(unaPreparacion);
		nuevaReceta.setListaCategorias(nuevaReceta.crearListaCategorias());
		nuevaReceta.agregarCategoria(unaCategoria);

		nuevaReceta.calificar(calificacion);
		nuevaReceta.agregarCalorias((int) calorias);

		nuevaReceta.setDificultadReceta(unaDificultad);
		nuevaReceta.setTemporadaPlato(unaTemporada);
		nuevaReceta.setSectorPiramideAlimenticia(unSectorPiramide);

		Session session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(nuevaReceta);
		session.getTransaction().commit();
		session.close();  		
		
		/*
		 * Configuration con = new Configuration();
		 * con.configure("hibernate.cfg.xml"); SessionFactory SF =
		 * con.buildSessionFactory(); Session session = SF.openSession();
		 * 
		 * 
		 * 
		 * Transaction TR = session.beginTransaction();
		 * session.save(nuevaReceta); System.out.println(
		 * "Object Saved Succesfully"); // Si imprime es porque persisti� ok
		 * el objeto TR.commit(); session.close(); SF.close();
		 */
		return nuevaReceta;

	}

	public void eliminar_receta() {

		this.nombreReceta = null;
		this.ingredientePrincipal = null;

		this.getIngredientes().clear();
		this.getListaCondimentos().clear();

		this.getListaProcedimiento().clear();
		this.listaCategoria = null;

		this.calificacion = 0;
		this.calorias = 0;

		this.dificultadReceta = 0;
		this.getTemporadaPlato().clear();
		this.sectorPiramideAlimenticia = 0; // Discutir piramide

	}
	
	
	public Receta buscarRecetaPorNombre(String unNombre){
		
		Session session = HibernateConf.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Receta e where e.nombreReceta = :nombre");

		query.setString("nombre", unNombre);
		
		java.util.List<?> lista = query.list();
		
	Receta recetaBuscada = (Receta)lista.get(0);


	return recetaBuscada;
			
		
	}

	public void setTotalCalorias() {
		//TODO falta sumar calorias del grupo de ingredientes y grabar en la base??

		this.setCalorias(this.obtenerCaloriasIngredientePrincipal() + obtenerCaloriasdeTodosLosIngrediente());

	}

	public int obtenerCaloriasIngredientePrincipal() {

		return this.getIngredientePrincipal().getCalorias();
	}

	public int obtenerCaloriasdeTodosLosIngrediente() {

		Set<Ingrediente> ingredientes = this.getIngredientes();
		int calorias = 0;
		for (Ingrediente ingrediente : ingredientes) {

			calorias = calorias + ingrediente.getCalorias();

		}
		return calorias;
	}

	/// control string

	public boolean noEsStringVacio(String unString) {
		try {
			
			//saco espacios en blanco
			for (int x=0; x < unString.length(); x++) {
				  if (unString.charAt(x) != ' ')
					  unString += unString.charAt(x);
				}
			
			return ((unString != null) && (unString.length() != 0)) ;
		} catch (NullPointerException npe) {
			return false;
		}
	}

	public void guardarReceta(Receta unaReceta) {
		// TODO: revisar este metodo para que guarde todos los campos....

		Session session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(unaReceta);
		session.getTransaction().commit();
		System.out.println("Done");
		session.close();
		// factory.close();

	}

	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "recetasUser", cascade=CascadeType.ALL)
	public Set<Usuario> getUsuarioRecetas() {
		return usuarioRecetas;
	}

	public void setUsuarioRecetas(Set<Usuario> usuarioRecetas) {
		this.usuarioRecetas = usuarioRecetas;
	}

	


}
