package receta;

import java.util.HashSet;
import java.util.Set;





public class Recetario 
{
	private Set<Receta> listaRecetas;

	
	//++++++++++++++++++ INICIO OPERACIONES DE AGREGAR Recetas++++++++++++++++++++++++++++++++++++++++++++//
			
			public boolean crearRecetario()
			{
				this.setListaRecetas(this.crearRecetarioPrivado());
				return true;
			}
	
			private Set<Receta> crearRecetarioPrivado()
			{
				Set<Receta> recetario ; 
				recetario = new HashSet<Receta>();
				return recetario;
			}
			
			public boolean agregarReceta(Receta unaReceta)
			{
			    //se agrega la receta
				Set<Receta> unRecetario;
				unRecetario = this.getListaRecetas();
				unRecetario.add(unaReceta);
				this.setListaRecetas(unRecetario);
				return true;
			}
			
			public boolean eliminarReceta(receta.Receta unaReceta)
			{
				//se vaaa la receta
				Set<Receta> unRecetario;
				unRecetario = this.getListaRecetas();
				unRecetario.remove(unaReceta);
				this.setListaRecetas(unRecetario);
				return true;
			}
			//++++++++++++++++++ FIN OPERACIONES DE AGREGAR Recetas++++++++++++++++++++++++++++++++++++++++++++//
		
	
	
	public Set<Receta> getListaRecetas() {
		return listaRecetas;
	}

	public void setListaRecetas(Set<Receta> listaRecetas) {
		this.listaRecetas = listaRecetas;
	}
	
	
}




