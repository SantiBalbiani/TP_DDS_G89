package usuario;

import java.util.ArrayList;
import java.util.List;

public class CondicionesPreexistentes {
	
	List<String> listaCondicionesPreexistentes = new ArrayList<String>(){{add("Diabetes"); add("Hipertension"); add("Celiasis");}};

	public List<String> getListaCondicionesPreexistentes() {
		return listaCondicionesPreexistentes;
	}

	public void setListaCondicionesPreexistentes(
			List<String> listaCondicionesPreexistentes) {
		this.listaCondicionesPreexistentes = listaCondicionesPreexistentes;
	}
	
	public void agregarCondicionesPreexistentes(String unaCondicionPreexistente) {
		this.getListaCondicionesPreexistentes().add(unaCondicionPreexistente) ;
	
	
	}
	
	public void buscarReceta(Usuario unUsuario /* */){
		
		//unUsuario.getRecetario().buscarReceta(unUsuario,this);
		
	}

}
