package usuario;



import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import receta.Condimento;
import receta.Ingrediente;
import receta.Receta;
//import usuario.Usuario;

 

public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private String password;
	private char sexo;
	private String fecha_nacimiento;
	private String complexion;

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

	private double  altura;
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
	
	
	
	
	public void altaUsuario(String nombreUsuario, char sexo, String fnac, String complexion,double altura,String preferencias_alimenticias, String condPreexistentes,String dieta, String rutina, String password ) {
		
		
		this.setIdUsuario(13);
		this.setNombreUsuario(nombreUsuario);
		this.setPassword(password);
		this.setSexo(sexo);
		this.setFecha_nacimiento(fnac); //formato mmddaaa
		this.setComplexion(complexion);
		this.setAltura(altura);
		this.setPrefAlim(preferencias_alimenticias);
		this.setCondPreexistentes(condPreexistentes);
		this.setDieta(dieta);
		this.setRutina(rutina);
		
		
	}
	
	
	
	public boolean calificar(Receta unaReceta, short unaCalificacion ) 
	{
			if ((unaCalificacion > 5) | (unaCalificacion < 1))		//Compruebo 1 <= unaCalificacion <= 5
			{
				//System.out.println("La calificacion debe ser entre 1 y 5 estrellas\n");
				return false;
			}
			if (unaReceta instanceof Receta)			//Compruebo si es una Receta
			{
				if (unaReceta.calificar(unaCalificacion))
				{
					//La calificacion fue exitosa
					//System.out.println("La calificacion fue exitosa\n");
					return true;
				}
			}											//Hubo un problema
			//System.out.println("Hubo un error calificando la receta\n");
			return false;
	}
	
	
	public void obtenerPesoIdeal(char sexo, float altura)
	{
		//TODO:     Hacer una consulta a la base de datos segun sexo y altura me muestre:
		//  IX. Peso-Ideal-Hombres: altura, medida-tórax, medida-cintura, medida-cadera peso,
		//  peso-min, peso-max
		//  X. Peso-Ideal-Mujeres: altura, medida-tórax, medida-cintura, medida-cadera peso,
		//  peso-min, peso-max
	}
	
	
	
	public void guardarUsuario(Usuario unUsuario){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory SF = con.buildSessionFactory();
		Session session = SF.openSession();
		Usuario nuevoUsuario = new Usuario();
		String nombre = unUsuario.getNombreUsuario();
		nuevoUsuario.setIdUsuario(unUsuario.getIdUsuario());
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
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getPrefAlim() { //Preferencias Alimenticias
		return preferencias_alimenticias;
	}
	public void setPrefAlim(String prefAlim) {//Preferencias Alimenticias
		this.preferencias_alimenticias = prefAlim;
	}
	
	public String getCondPreexistentes() { 
		return condicionesPreexistentes;
	}
	public void setCondPreexistentes(String condPreexsistente) {
		this.condicionesPreexistentes =  condPreexsistente;
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
	

	
	
	///////////////////SE REPITE!
	
	
	public String getPreferencias_alimenticias() {
		return preferencias_alimenticias;
	}

	public void setPreferencias_alimenticias(String preferencias_alimenticias) {
		this.preferencias_alimenticias = preferencias_alimenticias;
	}

	public String getCondicionesPreexistentes() {
		return condicionesPreexistentes;
	}

	public void setCondicionesPreexistentes(String condicionesPreexistentes) {
		this.condicionesPreexistentes = condicionesPreexistentes;
	
	
	}
	
	
	
	
	//++++++++++++++++++ FIN GETTERS y SETTERS+++++++++++++++++++++++++++++++++++++++++++++++++++++
}
