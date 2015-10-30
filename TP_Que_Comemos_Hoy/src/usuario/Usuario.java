package usuario;

import java.util.HashSet;
import java.util.Set;

import receta.Condimento;
import receta.Ingrediente;
import receta.Receta;
import usuario.Usuario;

public class Usuario {
	private String nombreUsuario;
	private char sexo;
	private String fecha_nacimiento;
	private String complexion;
	private float  altura;
	private String preferencias_alimenticias;
	private String dieta;
	private String condicionesPreexistentes;
	private String rutina;
	
	//++++++++++++++++++ INICIO OPERACIONES DE GRUPOS DE USUARIO++++++++++++++++++++++++++++++++++++++++++++//
	public Set<Usuario> crearGrupo(){
	Set<Usuario> grupo ; 
	grupo = new HashSet<Usuario>();
	
	return grupo;
	}
	
	public Set<Usuario> ingresarGrupo(Set<Usuario> unGrupo){
	    //se agrega el usuario
		unGrupo.add(this);
		
		return unGrupo;
	}
	public Set<Usuario> salirGrupo(Set<Usuario> unGrupo){
		//el usuario sale del grupo 
		unGrupo.remove(this);
		
		return unGrupo;
	}
	//++++++++++++++++++ FIN OPERACIONES DE GRUPOS DE USUARIO++++++++++++++++++++++++++++++++++++++++++++//
	
	
	public Usuario altaUsuario(char sexo, String fnac, String complexion,float altura,String preferencias_alimenticias, String condPreexistentes,String dieta, String rutina ) {
		
		this.sexo=sexo;
		this.fecha_nacimiento= fnac; //formato mmddaaa
		this.complexion= complexion;
		this.altura = altura;
		this.preferencias_alimenticias = preferencias_alimenticias;
		this.condicionesPreexistentes= condPreexistentes;
		this.dieta= dieta;
		this.rutina = rutina;
		
		return this;
	}
	
	
	public Receta crear_receta(Ingrediente unIngrediente, int calificacion, int calorias, Condimento unCondimento, String unNombre ){
		//llama a metodo new para crear Receta 
		//invoca los setters de la clase Receta para el alta de
		//ingredientes, condimentos y otros atributos...
		//devuelve la receta creada
		
		Receta nuevaReceta = new Receta();

		nuevaReceta.nombreReceta(unNombre); //entrada x teclado
		nuevaReceta.agregarIngredientePrincipal(unIngrediente);
		
		//TODO: debe haber un loop de 1 a n ingredientes y/o condimentos 
		nuevaReceta.agregarIngrediente(unIngrediente);
		nuevaReceta.agregarIngredienteCalorias(calorias);
		
		
		nuevaReceta.agregarCondimento(unCondimento);
		nuevaReceta.agregarPreparacion();//entrada x teclado
		nuevaReceta.temporadaReceta();
		nuevaReceta.calificarReceta(calificacion);
		return nuevaReceta;
		
		
		
		
	}
	
	
	//++++++++++++++++++ INICIO GETTERS y SETTERS+++++++++++++++++++++++++++++++++++++++++++++++++++++
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
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	//++++++++++++++++++ FIN GETTERS y SETTERS+++++++++++++++++++++++++++++++++++++++++++++++++++++
}
