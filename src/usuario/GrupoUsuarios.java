package usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import receta.Receta;

public class GrupoUsuarios {

	

	private String nombreDeGrupo;
	private  Set<Usuario> grupoDeUsuarios;
	private Usuario Administrador;
	
	public Usuario getAdministrador() {
		return Administrador;
	}

	public void setAdministrador(Usuario administrador) {
		Administrador = administrador;
	}
	
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
	
	public void darAltaGrupo(Usuario unUsuario, String unNombreDeGrupo)
	{
		//Agrego el setter en este metodo, evaluar ponerlo dentro de crearGrupo...
		this.grupoDeUsuarios = this.crearGrupo();
		this.ingresarGrupo(unUsuario);
		this.setNombreDeGrupo(unNombreDeGrupo);
		/*TODO:
		 * 
		 * ACA SE DEBE HACER EL ALTA EN LA DB
		 * 
		 * 
		 */ 
	}
	
	
	public String getNombreDeGrupo() {
		return nombreDeGrupo;
	}

	public void setNombreDeGrupo(String unNombreDeGrupo){
		this.nombreDeGrupo =unNombreDeGrupo;
	}

	
	public void EliminarGrupo( Usuario  admin){

		if(this.puedeEliminarGrupo(admin)){
			//TODO: ELIMINAR EL GRUPO DE LA DB
			this.salirGrupo(admin);	
		}
	}	
	
	public boolean puedeEliminarGrupo(Usuario usuario){
		
		//TODO: EN DB PODRIA COMPARAR LOS IDS DE USUARIO, SETEADO ADMNISTRADOR EL ID DEL CREADOR DEL GRUPO
		return ((this.getAdministrador().equals(usuario)) && (this.getGrupo().contains(usuario)) && (this.getGrupo().size() == 1)) ; 
	}
	
	 
		public ArrayList<Receta> getRecetasDelGrupo(){
			// coleccion de las recetas  los integrantes del grupo
			ArrayList<Receta> recetasDelGrupo = new ArrayList<Receta>();
			
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.getGrupo();

		      for(Usuario integrante : usuarios ){
		    	 
		    	  recetasDelGrupo.addAll(integrante.getRecetario().getListaRecetas()); 
		      }
			
			return recetasDelGrupo; 
		}

	
	

}
