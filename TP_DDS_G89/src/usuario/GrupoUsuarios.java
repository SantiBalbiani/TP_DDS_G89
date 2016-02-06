package usuario;

import java.util.HashSet;
import java.util.Set;

import receta.Receta;

public class GrupoUsuarios {

	

	private String nombreDeGrupo;
	private  Set<Usuario> grupoDeUsuarios;
	
	public Set<Usuario> crearGrupo(){

		Set<Usuario> grupoDeUsuarios = new HashSet<Usuario>();
		return grupoDeUsuarios;
	
	}
	
	public  Set<Usuario>   getGrupo(){
		
		return grupoDeUsuarios;
	}
	
	public void ingresarGrupo(Usuario unUsuario){
	 
		this.getGrupo().add(unUsuario);
		
		 
	}
	
	public void salirGrupo( Usuario  unUsuario){

		this.getGrupo().remove( unUsuario);

	}
	
	public void darAltaGrupo(Usuario unUsuario, String unNombreDeGrupo){
		
		this.crearGrupo();
		this.ingresarGrupo(unUsuario);
		this.setNombreDeGrupo(unNombreDeGrupo);
		 
	}
	
	
	public void setNombreDeGrupo(String unNombreDeGrupo){
		this.nombreDeGrupo =unNombreDeGrupo;
	}
	
	
	public Set<Receta> getRecetasDelGrupo(){
		
		// coleccion de las recetas del gr los integrantes del grupo
		return Set<Receta>; 
	}
	
	//++++++++++++++++++ FIN OPERACIONES DE GRUPOS DE USUARIO++++++++++++++++++++++++++++++++++++++++++++//
	
	

}
