package receta;

import java.util.HashSet;
import java.util.Set;





public class Recetario 
{
	private Set<Receta2> listaRecetas;

	
	//++++++++++++++++++ INICIO OPERACIONES DE AGREGAR Recetas++++++++++++++++++++++++++++++++++++++++++++//
			
			public boolean crearRecetario()
			{
				this.setListaRecetas(this.crearRecetarioPrivado());
				return true;
			}
	
			private Set<Receta2> crearRecetarioPrivado()
			{
				Set<Receta2> recetario ; 
				recetario = new HashSet<Receta2>();
				return recetario;
			}
			
			public boolean agregarReceta(receta.Receta2 unaReceta)
			{
			    //se agrega la receta
				Set<Receta2> unRecetario;
				unRecetario = this.getListaRecetas();
				unRecetario.add(unaReceta);
				this.setListaRecetas(unRecetario);
				return true;
			}
			
			public boolean eliminarReceta(receta.Receta2 unaReceta)
			{
				//se vaaa la receta
				Set<Receta2> unRecetario;
				unRecetario = this.getListaRecetas();
				unRecetario.remove(unaReceta);
				this.setListaRecetas(unRecetario);
				return true;
			}
			//++++++++++++++++++ FIN OPERACIONES DE AGREGAR Recetas++++++++++++++++++++++++++++++++++++++++++++//
		
	
	
	public Set<Receta2> getListaRecetas() {
		return listaRecetas;
	}

	public void setListaRecetas(Set<Receta2> listaRecetas) {
		this.listaRecetas = listaRecetas;
	}
	
	
}




