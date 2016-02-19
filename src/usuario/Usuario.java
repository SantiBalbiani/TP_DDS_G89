package usuario;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateConf;
import receta.Condimento;
import receta.Ingrediente;
import receta.Receta;
import receta.Recetario;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	private int idUsuario;
	private String nombreUsuario;
	private String password;
	private char sexo;
	private String fecha_nacimiento;
	private String complexion;
	private double altura;
	private String preferencias_alimenticias;
	private String dieta;
	private String email;
	// private ArrayList<Integer> condicionesPreexistentes;

	private Set<Receta> recetasUser = new HashSet<Receta>(0); // Para EL MANY TO MANY DE USUARIO-RECETA
	private Set<GrupoUsuarios> userGrupo = new HashSet<GrupoUsuarios>(0); // Para EL MANY TO MANY DE USUARIO-GRUPO
	
	private CondicionesPreexistentes condicionesPreexistentes;
	private String rutina;
	private Recetario recetario;
	//private int edad; 	//damos de baja el atributo... hay que calcular la edad!! no guardarla

	List<String> listaDieta = new ArrayList<String>() {
		{
			add("Normal");
			add("Ovolacteovegetariano");
			add("Vegetariano");
			add("Vegano");
		}
	};

	List<String> listaRutina = new ArrayList<String>() {
		{
			add("Sedentaria con algo de ejercicio (-30 min.) LEVE");
			add("Sedentaria con nada de ejercicio NADA");
			add("Sedentaria con ejercicio MEDIANO");
			add("Activa con ejercicio adicional (+30 min.) INTENSIVO");
			add("Activa con ejercicio adicional (+30 min.)");
		}
	};

	List<String> listaComplexion = new ArrayList<String>() {
		{
			add("Pequena");
			add("Media");
			add("Grande");
		}
	};

	// ++++++++++++++++++ INICIO_HARDCODE_PARA_MARTIN +++++++++++++++++++++++++++++++++++++++++++++++++++++

	public Set<Receta> recetas_ejemplo() {

		// Creo Ingrediente
		Ingrediente unIngrediente = new Ingrediente();
		unIngrediente.crearIngrediente("papa", 10, 56);
		// unIngrediente.guardarIngrediente(unIngrediente);

		// Creo Condimento

		Condimento unCondimento = new Condimento();
		unCondimento.crearCondimento("mostaza", "aderezo");
		// unCondimento.guardarCondimento(unCondimento);

		// Creo Receta

		Receta unaReceta = new Receta();
		short calificacion = 4;
		short sectorP = 4;

		// Agrego Condimentos

		// unaReceta.setListaIngredientes(unaReceta.crearListaIngrediente());
		unaReceta.agregarUnIngrediente(unIngrediente);
		unaReceta.setListaCondimentos(unaReceta.crearListaCondimentos());
		unaReceta.agregarCondimento(unCondimento);

		// unaReceta.setIngredientePrincipal(ingredientePrincipal);
		unaReceta.setCalificacion(calificacion);
		unaReceta.setSectorPiramideAlimenticia(sectorP);
		unaReceta.setIngredientePrincipal(unIngrediente);
		unaReceta.setCalorias(500);
		unaReceta.setPreparacion(" Se compran las milanesas hechas, se ponen al horno y se cocinan. Las papas las hacemos fritas. Se sirve todo junto y se condimenta a gusto");
		unaReceta.setNombreReceta("Milanesa con papas");
		unaReceta.setDificultadReceta(5);

		// ---------------------------------

		// Creo Ingrediente
		Ingrediente unIngrediente2 = new Ingrediente();
		unIngrediente2.crearIngrediente("papa", 10, 56);
		// unIngrediente.guardarIngrediente(unIngrediente);

		// Creo Condimento

		Condimento unCondimento2 = new Condimento();
		unCondimento2.crearCondimento("Pimienta", "aderezo");
		// unCondimento.guardarCondimento(unCondimento);

		// Creo Receta

		Receta unaReceta2 = new Receta();
		short calificacion2 = 4;
		short sectorP2 = 4;

		// Agrego Condimentos

		// unaReceta2.setListaIngredientes(unaReceta2.crearListaIngrediente());
		unaReceta2.agregarUnIngrediente(unIngrediente2);
		unaReceta2.setListaCondimentos(unaReceta2.crearListaCondimentos());
		unaReceta2.agregarCondimento(unCondimento2);

		// unaReceta.setIngredientePrincipal(ingredientePrincipal);
		unaReceta2.setCalificacion(calificacion2);
		unaReceta2.setSectorPiramideAlimenticia(sectorP2);
		unaReceta2.setIngredientePrincipal(unIngrediente2);
		unaReceta2.setCalorias(250);
		unaReceta2.setPreparacion("Se cocinan las salchichas en un jarro con agua caliente y se ponen dentro de un pan. Se condimenta a gusto");
		unaReceta2.setNombreReceta("Hot Dogs");
		unaReceta2.setDificultadReceta(1);

		// ---------------------------------

		// Creo Ingrediente
		Ingrediente unIngrediente3 = new Ingrediente();
		unIngrediente3.crearIngrediente("tomate", 10, 56);
		// unIngrediente.guardarIngrediente(unIngrediente);

		// Creo Condimento

		Condimento unCondimento3 = new Condimento();
		unCondimento3.crearCondimento("salsa barbacoa", "aderezo");
		// unCondimento.guardarCondimento(unCondimento);

		// Creo Receta

		Receta unaReceta3 = new Receta();
		short calificacion3 = 4;
		short sectorP3 = 4;

		// Agrego Condimentos

		// unaReceta3.setListaIngredientes(unaReceta3.crearListaIngrediente());
		unaReceta3.agregarUnIngrediente(unIngrediente3);
		unaReceta3.setListaCondimentos(unaReceta3.crearListaCondimentos());
		unaReceta3.agregarCondimento(unCondimento3);

		// unaReceta.setIngredientePrincipal(ingredientePrincipal);
		unaReceta3.setCalificacion(calificacion3);
		unaReceta3.setSectorPiramideAlimenticia(sectorP3);
		unaReceta3.setIngredientePrincipal(unIngrediente3);
		unaReceta3.setCalorias(100);
		unaReceta3.setPreparacion("Se cocina el matambre a la parrilla durante un buen rato hasta que esta bien cocido, se le agrega salsa de tomate y queso.");
		unaReceta3.setNombreReceta("Matambre a la pizza");
		unaReceta3.setDificultadReceta(3);

		Set<Receta> listaRecetas;
		listaRecetas = new HashSet<Receta>();
		listaRecetas.add(unaReceta);
		listaRecetas.add(unaReceta2);
		listaRecetas.add(unaReceta3);

		return listaRecetas;

	}

// ++++++++++++++++++FIN_HARDCODE_PARA_MARTIN+++++++++++++++++++++++++++++++++++++++++++++++++++++

	
	
// ++++++++++++++++++ INICIO GETTERS y SETTERS+++++++++++++++++++++++++++++++++++++++++++++++++++++

	public void setPassword(String password) {
		this.password = password.toUpperCase();
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario.toUpperCase();
	}
/*		--proximamente borrar
	public void setEdad(int edad) {
		this.edad = edad;
	}
*/
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento.toUpperCase();
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion.toUpperCase();
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setDieta(String unaDieta) {
		this.dieta = unaDieta.toUpperCase();
	}

	public void setRutina(String unaRutina) {
		this.rutina = unaRutina.toUpperCase();
	}

	public void setPreferencias_alimenticias(String preferencias_alimenticias) {
		this.preferencias_alimenticias = preferencias_alimenticias.toUpperCase();
	}

	public void setCondicionesPreexistentes(CondicionesPreexistentes condicionesPreexistentes) {
		this.condicionesPreexistentes = condicionesPreexistentes;

	}
	
	public void setRecetario(Recetario recetario) {
		this.recetario = recetario;
	}

	public void setListaDieta(List<String> listaDieta) {
		this.listaDieta = listaDieta;
	}

	public void setListaRutina(List<String> listaRutina) {
		this.listaRutina = listaRutina;
	}

	public void setListaComplexion(List<String> listaComplexion) {
		this.listaComplexion = listaComplexion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USER")
	public int getIdUsuario() {
		return idUsuario;
	}

	@Column(name = "NOMBRE")
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	@Column(name = "SEXO")
	public char getSexo() {
		return sexo;
	}

	@Column(name = "F_NAC")
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	@Column(name = "COMPLEXION")
	public String getComplexion() {
		return complexion;
	}

	@Column(name = "ALTURA")
	public double getAltura() {
		return altura;
	}

	@Column(name = "PREF_ALIM")
	public String getPreferencias_alimenticias() {
		return preferencias_alimenticias;
	}

	@Column(name = "DIETA")
	public String getDieta() {
		return dieta;
	}

	@Transient
	public CondicionesPreexistentes getCondicionesPreexistentes() {
		return condicionesPreexistentes;
	}

	@Column(name = "RUTINA")
	public String getRutina() {
		return rutina;
	}

/*		--proximamente borrar
	@Column(name = "EDAD")
	public int getEdad() {
		return edad;
	}
*/
	@Transient
	public Recetario getRecetario() {
		return recetario;
	}

	@Transient
	public List<String> getListaDieta() {
		return listaDieta;
	}

	@Transient
	public List<String> getListaRutina() {
		return listaRutina;
	}

	@Transient
	public List<String> getListaComplexion() {
		return listaComplexion;
	}


// ++++++++++++++++++ FIN GETTERS y	SETTERS+++++++++++++++++++++++++++++++++++++++++++++++++++++

	public void altaUsuario(String nombreUsuario, char sexo, String fnac, String complexion, double altura,
			String preferencias_alimenticias, String dieta, String rutina,
			String password) {

		//TODO: agregar condicionesPreexistentes
		//revisar este metodo para que guarde todos los campos....
		// this.setIdUsuario(13);
		this.setNombreUsuario(nombreUsuario);
		this.setPassword(password);
		this.setSexo(sexo);
		//this.setEdad(edad); 		--proximamente borrar
		this.setFecha_nacimiento(fnac); // formato mmddaaa
		this.setComplexion(complexion);
		this.setAltura(altura);
		this.setPreferencias_alimenticias(preferencias_alimenticias);
		// this.setCondicionesPreexistentes(condPreexistentes);
		this.setDieta(dieta);
		this.setRutina(rutina);

	}

	public void calificar(Receta unaReceta, short unaCalificacion) {

		unaReceta.setCalificacion(unaCalificacion);

	}

	public void guardarUsuario(Usuario unUsuario) {
		// TODO: revisar este metodo para que guarde todos los campos....

		// Configuration con = new Configuration();
		// con.configure("hibernate.cfg.xml");
		// SessionFactory SF = con.buildSessionFactory();
		// Session session = SF.openSession();
		// Session session = HibernateConf.getSessionFactory().openSession();
		// Session session = HibernateConf.getSessionFactory().openSession();
		Session session = HibernateConf.getSessionFactory().openSession();
		session.beginTransaction();

		//Usuario nuevoUsuario = new Usuario();
		//String nombre = unUsuario.getNombreUsuario().toU;
		 //unUsuario.setIdUsuario(unUsuario.getIdUsuario());
		//nuevoUsuario.setNombreUsuario(nombre);
		// nuevoUsuario.setAltura(unUsuario.getAltura());
		// nuevoUsuario.setComplexion(unUsuario.getComplexion());
		// nuevoUsuario.setFecha_nacimiento(unUsuario.getFecha_nacimiento());
		// nuevoUsuario.setSexo(unUsuario.getSexo());
		// nuevoUsuario.setEdad(unUsuario.getEdad());
		// nuevoUsuario.setPassword(unUsuario.getPassword());

		// Transaction TR = session.beginTransaction();
		// session.save(unUsuario);
		// System.out.println("Object Saved Succesfully"); // Si imprime es
		// porque persisti� ok el objeto
		// TR.commit();
		// session.close();
		// SF.close();

		session.save(unUsuario);
		session.getTransaction().commit();
		System.out.println("Done");
		session.close();
		// factory.close();

	}

	public Receta crearReceta(Ingrediente unIngrediente, short calificacion, int calorias, Condimento unCondimento,
			String unNombre, String unaPreparacion, String temporadaPlato) {
		// llama a metodo new para crear Receta
		// invoca los setters de la clase Receta para el alta de
		// ingredientes, condimentos y otros atributos...
		// devuelve la receta creada

		Receta nuevaReceta = new Receta();

		nuevaReceta.setNombreReceta(unNombre); // entrada x teclado
		nuevaReceta.agregarIngredientePrincipal(unIngrediente);

		// TODO: debe haber un loop de 1 a n ingredientes y/o condimentos
		nuevaReceta.agregarUnIngrediente(unIngrediente);
		nuevaReceta.agregarCalorias(calorias);

		nuevaReceta.agregarCondimento(unCondimento);
		nuevaReceta.agregarPreparacion(unaPreparacion);
		nuevaReceta.setTemporadaPlato(temporadaPlato);
		nuevaReceta.calificar(calificacion);
		return nuevaReceta;

	}

	
	public Usuario buscarUsuarioPorNombre(String unNombre){
		
		
		Session session = HibernateConf.getSessionFactory().openSession();
		
		Usuario usuarioBuscado;
		
		Query query = session.createQuery("FROM Usuario e where e.nombreUsuario = :nombreUsuario");
		
		query.setString("nombreUsuario", unNombre);
	try{
		
		java.util.List<?> lista = query.list();
		
		usuarioBuscado = (Usuario)lista.get(0);
		return usuarioBuscado;
	}catch(Throwable theException) 	    
	
	{
	    Usuario usuarioNoEncontrado = new Usuario();
	    usuarioNoEncontrado.setNombreUsuario("Nombre de Usuario/Constrase�a inexistentes");
	    usuarioNoEncontrado.setIdUsuario(9999);
	    return usuarioNoEncontrado;
	}
		
		
}
	
	public void modificarUsuario (Usuario unUsuario)
	{
		Session session = HibernateConf.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		//String sql_query = "update Usuario set NOMBRE = :nuevoNombre " + " where ID_USER = :idUsuario";
		String sql_query = "update Usuario set PASSWORD = :nuevaPWD, F_NAC = :nuevaF_NAC, SEXO = :nuevoSexo, RUTINA = :nuevaRutina, DIETA = :nuevaDieta, COMPLEXION = :nuevaComplexion, ALTURA = :nuevaAltura, EMAIL = :nuevoMail " + " where ID_USER = :idUsuario";
		
		
//		UPDATE `usuario` SET `ID_USER`=[value-1],`ALTURA`=[value-2],`COMPLEXION`=[value-3],`DIETA`=[value-4],`F_NAC`=[value-5],`NOMBRE`=[value-6],`PASSWORD`=[value-7],`PREF_ALIM`=[value-8],`RUTINA`=[value-9],`SEXO`=[value-10] WHERE `ID_USER`= 1
		Query query = session.createSQLQuery(sql_query);
		//query.setParameter("nuevoNombre", unUsuario.getNombreUsuario());	//el nombre de usuario no se pueda cambiar..
		query.setParameter("idUsuario", unUsuario.getIdUsuario());
		query.setParameter("nuevaAltura", unUsuario.getAltura());
		query.setParameter("nuevaComplexion", unUsuario.getComplexion());
		query.setParameter("nuevaDieta", unUsuario.getDieta());
		query.setParameter("nuevaF_NAC", unUsuario.getFecha_nacimiento());
		query.setParameter("nuevaPWD", unUsuario.getPassword());
		query.setParameter("nuevoMail", unUsuario.getEmail());
		query.setParameter("nuevaRutina", unUsuario.getRutina());
		query.setParameter("nuevoSexo", unUsuario.getSexo());
		
		
		query.executeUpdate();
		session.getTransaction().commit();
		System.out.println("Done");
		session.close();
		
	}
	
	public void eliminarUsuario (Usuario unUsuario)
	{
		Session session = HibernateConf.getSessionFactory().openSession();
		session.getTransaction().begin();
		
		String sql_query = "delete from Usuario  where ID_USER = :idUsuario";
		
		Query query = session.createSQLQuery(sql_query);
		query.setParameter("idUsuario", unUsuario.getIdUsuario());

		
		query.executeUpdate();
		session.getTransaction().commit();
		System.out.println("Done");
		session.close();
		
	}
	
	
	public ArrayList<Receta> buscarReceta(Filtro unFiltroDeBusqueda) {

		return this.getCondicionesPreexistentes().buscarReceta(this, unFiltroDeBusqueda);
	}

	public Set<Receta> buscarMisRecetas() {

		return this.getRecetario().getListaRecetas(); // el metodo
														// getListaRecetas()
														// deberia consultar a
														// la base por las
														// recetas del usuario

	}

	public ArrayList<Receta> mostrarDiezRecetas() {

		ArrayList<Receta> mostrarRecetas = new ArrayList<Receta>();

		// ultimas diez recetas que acepto
		mostrarRecetas.addAll(this.recetasUltimasDiezRecetasAceptadas());

		// si no acepto recetas ultiamas 10 que califico
		if (mostrarRecetas.isEmpty()) {

			mostrarRecetas.addAll(this.recetasMejoresDiezQueCalifico());
		}

		// si tampoco califico las ultimas 10 que busco
		if (mostrarRecetas.isEmpty()) {

			mostrarRecetas.addAll(this.recetasUltimasDiezBuscadas());
		}

		// si ingresa por primera vez vera las mejores 10 calificadas
		if (mostrarRecetas.isEmpty()) {

			mostrarRecetas.addAll(this.mejoresDiezCalificadas());

		}

		return mostrarRecetas;
	}

	public ArrayList<Receta> mejoresDiezCalificadas() {

		ArrayList<Receta> mostrarDiezRecetasCalificadas = new ArrayList<Receta>();

		/*
		 * 
		 * CONSULTAR A LA BASE CON LIMITE DE RESULTADOS 10 CON MAYOR
		 * CALIFICACION
		 * 
		 */

		return mostrarDiezRecetasCalificadas;

	}

	public ArrayList<Receta> recetasUltimasDiezBuscadas() {

		ArrayList<Receta> mostrarDiezBuscadas = new ArrayList<Receta>();

		/*
		 * TODO:
		 * CONSULTAR A LA BASE TABLA DIEZBUSCADAS
		 * 
		 */

		return mostrarDiezBuscadas;

	}

	public ArrayList<Receta> recetasMejoresDiezQueCalifico() {

		ArrayList<Receta> mostrarDiezRecetasQueCalifico = new ArrayList<Receta>();

		/*
		 * TODO:
		 * CONSULTAR A LA BASE "CALIFICADAS POR USUARIO" CON LIMITE DE
		 * RESULTADOS 10 ORDENADO POR TRANSACCION MAS RECIENTE
		 * 
		 */

		return mostrarDiezRecetasQueCalifico;

	}

	public ArrayList<Receta> recetasUltimasDiezRecetasAceptadas() {

		ArrayList<Receta> ultimasDiezRecetas = new ArrayList<Receta>();

		/*
		 * TODO:
		 * CONSULTAR A LA BASE "ACEPTADAS" CON LIMITE DE RESULTADOS 10 ORDENADO
		 * POR TRANSACCION MAS RECIENTE
		 * 
		 */

		return ultimasDiezRecetas;

	}

	public  Receta  recomendacionDiaria() {
		
		 Receta  recomendacionDiaria = new  Receta(); 
		 String  preferenciasAlimenticias = this.getPreferencias_alimenticias(); 
		 String categoriaSegunHora  = obtenerCategoriaSegunHora(); 
		  
		 
		 /*TODO:  
		  * HACER SELECT SINGLE 
		  * USANDO EL MISMO SELECT DE getRecetasDelGrupo() JUNTO CON LOS FILTROS DE LAS VARIABLES DE ARRIBA
		  *  
		  * 
		  */
		 
		 
		return recomendacionDiaria;
		
	}
	
	public String obtenerCategoriaSegunHora(){
		
		Date date = new Date();    
		Calendar calendar = GregorianCalendar.getInstance(); 
		calendar.setTime(date);  
		int horaDelDia= calendar.get(Calendar.HOUR_OF_DAY);	
		
		String categoria= null;
		 /* 
		  * horario:
		  * 04-10hs: desayuno 
		  * 10-15hs: almuerzo
		  * 15-19hs. merienda
		  * 19-04hs:cena
		  */
		
		
		if ((horaDelDia >4) &&  (horaDelDia <=10)){
			categoria = "Desayuno" ;
		}
		
		if ((horaDelDia >10) &&  (horaDelDia <=15)){
			categoria = "Almuerzo" ;
		}
					
		if ((horaDelDia >15) &&  (horaDelDia <=19)){
			categoria = "Merienda" ;
		}		
		if ((horaDelDia >19) &&  (horaDelDia <=4)){
			categoria = "Cena" ;
		}	
		
		return categoria;
	}



	
	public double obtenerPesoIdeal() {

		double altura = this.getAltura();
		String complexion = this.getComplexion();
		double indiceComplexion = calcularIndiceComplexion(complexion);
		int edad = this.calcularEdad(this.getFecha_nacimiento());

		return ((altura - 100 + (edad / 10)) * 0.9 * indiceComplexion);

	}

	public double calcularIndiceComplexion(String complexion) {

		double indiceComplexion = 1;

		if (complexion == "Pequena") {
			indiceComplexion = 0.9;
		}
		if (complexion == "Media") {
			indiceComplexion = 1;
		}
		if (complexion == "Grande") {
			indiceComplexion = 1.1;
		}

		return indiceComplexion;
	}

	public int calcularEdad(String fecha) {
		java.util.Date fechaNac = null;
		try {
			/*
			 * Se puede cambiar la mascara por el formato de la fecha que se
			 * quiera recibir, por ejemplo a�o mes d�a "yyyy-MM-dd" en este caso
			 * es d�a mes a�o
			 */
			/*	------Ejemplo de como llamarlo --------
			 * Usuario nuevoUsuario = new Usuario(); int prueba =
			 * nuevoUsuario.calcularEdad("2014-02-10");
			 * System.out.println(prueba);
			 * 
			 * //De "2014-02-09" a "2016-02-09"... la funcion devuelve 2 
			 * //De "2014-02-09" a "2016-02-10"... la funcion devuelve 1
			 *
			 */
			fechaNac = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(fecha);
		} catch (Exception ex) {
			System.out.println("Error:" + ex);
		}
		java.util.Calendar fechaNacimiento = java.util.Calendar.getInstance();
		// Se crea un objeto con la fecha actual
		java.util.Calendar fechaActual = java.util.Calendar.getInstance();
		// Se asigna la fecha recibida a la fecha de nacimiento.
		fechaNacimiento.setTime(fechaNac);
		// Se restan la fecha actual y la fecha de nacimiento
		int anio = fechaActual.get(java.util.Calendar.YEAR) - fechaNacimiento.get(java.util.Calendar.YEAR);
		int mes = fechaActual.get(java.util.Calendar.MONTH) - fechaNacimiento.get(java.util.Calendar.MONTH);
		int dia = fechaActual.get(java.util.Calendar.DATE) - fechaNacimiento.get(java.util.Calendar.DATE);
		// Se ajusta el a�o dependiendo el mes y el d�a
		if (mes < 0 || (mes == 0 && dia < 0)) {
			anio--;
		}
		// Regresa la edad en base a la fecha de nacimiento
		return (int) anio;
	}
	
	
	//el usuario selecciona la receta solo 
	public void seleccionarReceta(Receta unaReceta){
		
		this.getRecetario().usuarioSeleccionaReceta(this, unaReceta);
	}
	
	public void planificarReceta(Usuario unUsuario, Receta unaReceta, String fechaPlanif, String categoria){
		
		this.getRecetario().usuarioPlanificaReceta(unUsuario, unaReceta, fechaPlanif, categoria);
	}
	
	
	
	//TODO:
	/*
	Para una Rutina-Ejercicio-Físico particular de usuario, las calorías máximas a
	consumir en una receta, por ejemplo para una rutina LEVE.
	*/
	
	
	
	
	Set<Receta> recetasDisponiblesSegunDieta(){
		
		Set<Receta>  recetasPorDieta = new HashSet<Receta>();
		String dieta =  this.getDieta();
		

		/*TODO: Select para: 
		Para un Dieta determinada mostrar las recetas disponibles, por ejemplo para un
		Vegano.
		*/
		
		return recetasPorDieta;
	}

	
	
	// @ManyToMany(fetch = FetchType.LAZY, mappedBy = "recetas")
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinTable(name = "receta_por_usuario", joinColumns = { // agregar
																	// catalogo de
																	// ser
																	// necesario...
				@JoinColumn(name = "ID_USER", nullable = false, updatable = false) }, inverseJoinColumns = {
						@JoinColumn(name = "ID_RECETA", nullable = false, updatable = false) })
	public Set<Receta> getRecetasUser() {
		return recetasUser;
	}

	public void setRecetasUser(Set<Receta> recetasUser) {
		this.recetasUser = recetasUser;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_por_grupo", joinColumns = { // agregar
																// catalogo de
																// ser
																// necesario...
			@JoinColumn(name = "ID_USER", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_GRUPO", nullable = false, updatable = false) })
	
		
	public Set<GrupoUsuarios> getUserGrupo() {
		return userGrupo;
	}

	public void setUserGrupo(Set<GrupoUsuarios> userGrupo) {
		this.userGrupo = userGrupo;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	

}
