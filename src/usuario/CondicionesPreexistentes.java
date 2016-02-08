package usuario;
 

import java.util.ArrayList;

import receta.Receta;

public class CondicionesPreexistentes {
	
	
	private int idCond;
	private String descripcion;
	private ArrayList<CondicionesPreexistentes> condicionesDelUsuario;
	private ArrayList<Integer> indiceCondicionesDelUsuario;
	
	public ArrayList<Integer> getIndiceCondicionesDelUsuario() {
		return indiceCondicionesDelUsuario;
	}


	public void setIndiceCondicionesDelUsuario(
			ArrayList<Integer> indiceCondicionesDelUsuario) {
		this.indiceCondicionesDelUsuario = indiceCondicionesDelUsuario;
	}


	private ArrayList<CondicionesPreexistentes> listaGrobalCondiciones;	
	
  // private	List<String> listaCondicionesPreexistentes = new ArrayList<String>(){{add("Diabetes"); add("Hipertension"); add("Celiasis");}};

	
	//ESTE METODO LLAMA A LA BASE (consultando: "diabetes", "hipertension","celiasis")
	public ArrayList<CondicionesPreexistentes> getListaGlobalCondiciones() {
		return listaGrobalCondiciones;
	}

 
	public ArrayList<Receta> buscarReceta(Usuario unUsuario, Filtro unFiltroBusqueda){
		
		
		ArrayList<CondicionesPreexistentes> condicionesGlobales = new ArrayList<CondicionesPreexistentes>(); 
		indiceCondicionesDelUsuario = new ArrayList<Integer>();
		condicionesDelUsuario = new ArrayList<CondicionesPreexistentes>();
		
		condicionesGlobales =  this.getListaGlobalCondiciones(); 
		
		
		
		 if (!indiceCondicionesDelUsuario.isEmpty()) {
	
			   
			 	for (Integer   index  : indiceCondicionesDelUsuario) {
				
					condicionesDelUsuario.add(  condicionesGlobales.get(index));
			 	}
		 
			 	unFiltroBusqueda.setcondicionesPreexistentes(condicionesDelUsuario);
		  
		 	}

		 ArrayList<Receta> recetasEncontradas = unUsuario.getRecetario().buscarRecetaPorFiltro(unUsuario , unFiltroBusqueda);

		 	//FILTRA LOS RESULTADOS SI EL USUARUIO TIENE CONDICIONES PREEXISTENTES
			if (!indiceCondicionesDelUsuario.isEmpty()){
				ArrayList<CondicionesPreexistentes> condicionesPreexistentes = unFiltroBusqueda.getcondicionesPreexistentes();
				this.filtrarContraindicacionesDeCondicionesPreexitentes(recetasEncontradas, condicionesPreexistentes);
				
			}
		 
		 return recetasEncontradas;
	  }
 

	
	public void filtrarContraindicacionesDeCondicionesPreexitentes( ArrayList<Receta> resultadoBusqueda, ArrayList<CondicionesPreexistentes> condicionesPreexistentes) {
		
		
		for (CondicionesPreexistentes   condicion  : condicionesPreexistentes) {
			
			for (Receta   receta  : resultadoBusqueda) {
			
				if (receta.getContraindicaciones().contains(condicion)){
					resultadoBusqueda.remove(receta);
				}
				
			}
		}
 	
	}
 
	public String getDescripcion() {
		return descripcion;
	}

 
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

 
	public int getIdCond() {
		return idCond;
	}

 
	public void setIdCond(int idCond) {
		this.idCond = idCond;
	}
	
 
}
