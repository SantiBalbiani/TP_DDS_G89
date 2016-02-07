package usuario;



import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import receta.Condimento;
import receta.Ingrediente;
import receta.Receta;
//import usuario.Usuario;
import receta.Recetario;

 
@Entity
@Table(name="usuarios")
public class Usuario {
	

	private int idUsuario;
	private String nombreUsuario;
	private String password;
	private char sexo;
	private String fecha_nacimiento;
	private String complexion;
	private double  altura;
	private String preferencias_alimenticias;
	private String dieta;
	private Set<Integer> condicionesPreexistentes;
	private String rutina;
	private Recetario recetario;
	
	
	List<String> listaDieta = new ArrayList<String>(){{add("Normal"); add("Ovolacteovegetariano"); add("Vegetariano"); add("Vegano");}};
	
	List<String> listaRutina = new ArrayList<String>(){{add("Sedentaria con algo de ejercicio (-30 min.) LEVE");
														add("Sedentaria con nada de ejercicio NADA");
														add("Sedentaria con ejercicio MEDIANO");
														add("Activa con ejercicio adicional (+30 min.) INTENSIVO");
														add("Activa con ejercicio adicional (+30 min.)");}};
	
//++++++++++++++++++ INICIO_HARDCODE_PARA_MARTIN+++++++++++++++++++++++++++++++++++++++++++++++++++++

public Set<Receta> recetas_ejemplo(){
															
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

		//unaReceta.setListaIngredientes(unaReceta.crearListaIngrediente());
		unaReceta.agregarunIngrediente(unIngrediente);
		unaReceta.setListaCondimentos(unaReceta.crearListaCondimentos());
		unaReceta.agregarCondimento(unCondimento);

		// unaReceta.setIngredientePrincipal(ingredientePrincipal);
		unaReceta.setCalificacion(calificacion);
		unaReceta.setSectorPiramideAlimenticia(sectorP);
		unaReceta.setIngredientePrincipal(unIngrediente);
		unaReceta.setCalorias(500);
		unaReceta.setPreparacion("cortas la papa le pones manteca y wuala");
		unaReceta.setNombreReceta("La_PAPA_Milanesa");
		unaReceta.setDificultadReceta(5);

		// ---------------------------------

		// Creo Ingrediente
		Ingrediente unIngrediente2 = new Ingrediente();
		unIngrediente2.crearIngrediente("estiercol", 10, 56);
		// unIngrediente.guardarIngrediente(unIngrediente);

		// Creo Condimento

		Condimento unCondimento2 = new Condimento();
		unCondimento2.crearCondimento("Noe", "aderezo");
		// unCondimento.guardarCondimento(unCondimento);

		// Creo Receta

		Receta unaReceta2 = new Receta();
		short calificacion2 = 4;
		short sectorP2 = 4;

		// Agrego Condimentos

		//unaReceta2.setListaIngredientes(unaReceta2.crearListaIngrediente());
		unaReceta2.agregarunIngrediente(unIngrediente2);
		unaReceta2.setListaCondimentos(unaReceta2.crearListaCondimentos());
		unaReceta2.agregarCondimento(unCondimento2);

		// unaReceta.setIngredientePrincipal(ingredientePrincipal);
		unaReceta2.setCalificacion(calificacion2);
		unaReceta2.setSectorPiramideAlimenticia(sectorP2);
		unaReceta2.setIngredientePrincipal(unIngrediente2);
		unaReceta2.setCalorias(250);
		unaReceta2.setPreparacion("noe se fue a la altamar");
		unaReceta2.setNombreReceta("noe_en_altamar");
		unaReceta2.setDificultadReceta(1);

		// ---------------------------------

		// Creo Ingrediente
		Ingrediente unIngrediente3 = new Ingrediente();
		unIngrediente3.crearIngrediente("lucas", 10, 56);
		// unIngrediente.guardarIngrediente(unIngrediente);

		// Creo Condimento

		Condimento unCondimento3 = new Condimento();
		unCondimento3.crearCondimento("quindimil", "aderezo");
		// unCondimento.guardarCondimento(unCondimento);

		// Creo Receta

		Receta unaReceta3 = new Receta();
		short calificacion3 = 4;
		short sectorP3 = 4;

		// Agrego Condimentos

		//unaReceta3.setListaIngredientes(unaReceta3.crearListaIngrediente());
		unaReceta3.agregarunIngrediente(unIngrediente3);
		unaReceta3.setListaCondimentos(unaReceta3.crearListaCondimentos());
		unaReceta3.agregarCondimento(unCondimento3);

		// unaReceta.setIngredientePrincipal(ingredientePrincipal);
		unaReceta3.setCalificacion(calificacion3);
		unaReceta3.setSectorPiramideAlimenticia(sectorP3);
		unaReceta3.setIngredientePrincipal(unIngrediente3);
		unaReceta3.setCalorias(100);
		unaReceta3.setPreparacion("accenture es muy linda y le gusta los cursos");
		unaReceta3.setNombreReceta("accenture se fue a vw");
		unaReceta3.setDificultadReceta(3);

		Set<Receta> listaRecetas;
		listaRecetas = new HashSet<Receta>();
		listaRecetas.add(unaReceta);
		listaRecetas.add(unaReceta2);
		listaRecetas.add(unaReceta3);
		
		return listaRecetas;
		
	}
														
//++++++++++++++++++ FIN_HARDCODE_PARA_MARTIN+++++++++++++++++++++++++++++++++++++++++++++++++++++
														
														
														
														
														
														
														
														
														
														
//++++++++++++++++++ INICIO GETTERS y SETTERS+++++++++++++++++++++++++++++++++++++++++++++++++++++
														
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idUsuario")
	public int getIdUsuario() {
		return idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getComplexion() {
		return complexion;
	}
	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}


	public String getDieta() { 
		return dieta;
	}
	public void setDieta(String unaDieta) {
		this.dieta= unaDieta;
	}	
	public String getRutina() { 
		return rutina;
	}
	public void setRutina(String unaRutina) {
		this.rutina= unaRutina;
	}	
		
	public String getPreferencias_alimenticias() {
		return preferencias_alimenticias;
	}

	public void setPreferencias_alimenticias(String preferencias_alimenticias) {
		this.preferencias_alimenticias = preferencias_alimenticias;
	}

	public Set<Integer> getCondicionesPreexistentes() {
		return condicionesPreexistentes;
	}

	public void setCondicionesPreexistentes(Set<Integer> condicionesPreexistentes) {
		this.condicionesPreexistentes = condicionesPreexistentes;
	
	
	}
	
	
	//++++++++++++++++++ FIN GETTERS y SETTERS+++++++++++++++++++++++++++++++++++++++++++++++++++++

	
	
	public void altaUsuario(String nombreUsuario, char sexo, String fnac, String complexion,double altura,String preferencias_alimenticias, Set<Integer> condPreexistentes,String dieta, String rutina, String password ) {
		
		
		//this.setIdUsuario(13);
		this.setNombreUsuario(nombreUsuario);
		this.setPassword(password);
		this.setSexo(sexo);
		this.setFecha_nacimiento(fnac); //formato mmddaaa
		this.setComplexion(complexion);
		this.setAltura(altura);
		this.setPreferencias_alimenticias(preferencias_alimenticias);
		this.setCondicionesPreexistentes(condPreexistentes);
		this.setDieta(dieta);
		this.setRutina(rutina);
		
		
	}
	
	
	
	public void  calificar(Receta unaReceta, short unaCalificacion )  
	{
		
		unaReceta.calificar(unaCalificacion);
		
	}
	

	
	
	public void guardarUsuario(Usuario unUsuario){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory SF = con.buildSessionFactory();
		Session session = SF.openSession();
		
		Usuario nuevoUsuario = new Usuario();
		String nombre = unUsuario.getNombreUsuario();
		//nuevoUsuario.setIdUsuario(unUsuario.getIdUsuario());
		nuevoUsuario.setNombreUsuario(nombre);
		nuevoUsuario.setAltura(unUsuario.getAltura());
		nuevoUsuario.setComplexion(unUsuario.getComplexion());
		nuevoUsuario.setFecha_nacimiento(unUsuario.getFecha_nacimiento());
		nuevoUsuario.setSexo(unUsuario.getSexo());
		nuevoUsuario.setPassword(unUsuario.getPassword());
		
		Transaction TR = session.beginTransaction();
		session.save(unUsuario);
		System.out.println("Object Saved Succesfully"); // Si imprime es porque persisti� ok el objeto
		TR.commit();
		session.close();
		SF.close();
		
	}
	
	
	
	
	
	
	public Receta crearReceta(Ingrediente unIngrediente, short calificacion, int calorias, Condimento unCondimento, String unNombre, String unaPreparacion, String temporadaPlato ){
		//llama a metodo new para crear Receta 
		//invoca los setters de la clase Receta para el alta de
		//ingredientes, condimentos y otros atributos...
		//devuelve la receta creada
		
		Receta nuevaReceta = new Receta();

		nuevaReceta.setNombreReceta(unNombre); //entrada x teclado
		nuevaReceta.agregarIngredientePrincipal(unIngrediente);
		
		//TODO: debe haber un loop de 1 a n ingredientes y/o condimentos 
		nuevaReceta.agregarunIngrediente(unIngrediente);
		nuevaReceta.agregarCalorias(calorias);
		
		
		nuevaReceta.agregarCondimento(unCondimento);
		nuevaReceta.agregarPreparacion(unaPreparacion);
		nuevaReceta.setTemporadaPlato(temporadaPlato);
		nuevaReceta.calificar(calificacion);
		return nuevaReceta;
		
		
		
		
	}
	

public void buscarReceta(Filtro unFiltroDeBusqueda){
	//Benja revisa esta parte del codigo... lo arregle para que no tire error pero nose si esta era la idea del codigo
	CondicionesPreexistentes cond1 = new CondicionesPreexistentes();
	cond1.buscarReceta(this, unFiltroDeBusqueda);
}

	
	
public Set<Receta> buscarMisRecetas(){
	
	return this.getRecetario().getListaRecetas();
	
}
	
	
		

	
/*
public Set<Receta> getUltimas10RecetasAceptadas(){
	return  this.get;
	
}

public Set<Receta> getrecomendacionesDiarias() {
	return  Set<Receta>;
	
}
*/



public void obtenerPesoIdeal(char sexo, float altura)
{
	//TODO:     Hacer una consulta a la base de datos segun sexo y altura me muestre:
	//  IX. Peso-Ideal-Hombres: altura, medida-tórax, medida-cintura, medida-cadera peso,
	//  peso-min, peso-max
	//  X. Peso-Ideal-Mujeres: altura, medida-tórax, medida-cintura, medida-cadera peso,
	//  peso-min, peso-max
}

public Recetario getRecetario() {
	return recetario;
}

public void setRecetario(Recetario recetario) {
	this.recetario = recetario;
}


}
