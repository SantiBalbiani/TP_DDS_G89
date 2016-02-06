package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CondicionesPreexistentes {
	
	
	private int idCond;
	private String descripcion;
	
	Set<CondicionesPreexistentes> listaGrobalCondiciones;	
  // private	List<String> listaCondicionesPreexistentes = new ArrayList<String>(){{add("Diabetes"); add("Hipertension"); add("Celiasis");}};

	
	//ESTE METODO LLAMA A LA BASE (condiiones diabetes, hipertension etc...)
	public Set<CondicionesPreexistentes> getListaGlobalCondiciones() {
		return listaGrobalCondiciones;
	}


	
	
	public void buscarReceta(Usuario unUsuario){
		
		Set<Integer> condicionesDelUsuario = unUsuario.getCondicionesPreexistentes();
		Set<CondicionesPreexistentes> condicionesGlobales =  this.getListaGlobalCondiciones();
		
		//unUsuario.getRecetario().buscarReceta(unUsuario,this);
		
	}


	
	
	
	
	
}
