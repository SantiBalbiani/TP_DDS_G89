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
	
	List<String> listaDieta = new ArrayList<String>(){{add("Normal"); add("Ovolacteovegetariano"); add("Vegetariano"); add("Vegano");}};
	
	List<String> listaRutina = new ArrayList<String>(){{add("Sedentaria con algo de ejercicio (-30 min.)"); add("Sedentaria con nada de ejercicio");
														add("Sedentaria con ejercicio (+30 min.)"); add("Vegano");}};
	
	

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
		nuevaReceta.agregarIngrediente(unIngrediente);
		nuevaReceta.agregarCalorias(calorias);
		
		
		nuevaReceta.agregarCondimento(unCondimento);
		nuevaReceta.agregarPreparacion(unaPreparacion);
		nuevaReceta.setTemporadaPlato(temporadaPlato);
		nuevaReceta.calificar(calificacion);
		return nuevaReceta;
		
		
		
		
	}
	

public void buscarReceta(){
	
//	this.getCondicionesPreexistentes().buscarReceta(this);
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


}
