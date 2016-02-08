package receta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import usuario.CondicionesPreexistentes;
import usuario.Filtro;
import usuario.Usuario;





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
		
			//Buscar_Receta
			 
			
			public ArrayList<Receta> buscarRecetaPorFiltro(Usuario unUsuario , Filtro  unFiltroBusqueda){
				
				
				ArrayList<Receta> resultadoBusqueda = new  ArrayList<Receta>();
				
				String nombreReceta = unFiltroBusqueda.getNombreReceta();

 
				if (noEsStringVacio(nombreReceta)) {
					
						resultadoBusqueda.addAll( consultarBusquedaPorNombreReceta( unUsuario ,   unFiltroBusqueda));
					}
				 
 
					else if (tieneIngredientesUOtrosCamposdeBusqueda(unFiltroBusqueda)) {
						
						resultadoBusqueda.addAll( consultarBusquedaPorIngredienteYOtrosCampos( unUsuario ,  unFiltroBusqueda))	;
					}
	
	
				return resultadoBusqueda;
			}
			

			
			
			public boolean tieneIngredientesUOtrosCamposdeBusqueda(Filtro unFiltroBusqueda){
				
				String ingredientePrincipal = unFiltroBusqueda.getNombreingredientePrincipal();				 
				String  ingredienteSecundario  = unFiltroBusqueda.getNombreingredienteSecundario();
				int dificultad = unFiltroBusqueda.getDificultad();
				int calorias = unFiltroBusqueda.getCalorias();
				int calificacion = unFiltroBusqueda.getCalificacion();
				int  temporada =  unFiltroBusqueda.getTemporada();
				return ( noEsStringVacio(ingredientePrincipal) || ( noEsStringVacio(ingredienteSecundario)) || (dificultad<0) || (calorias <0) || (calificacion <0) || (temporada <0)) ;
				
				
			}
			
 
			
			
		public ArrayList<Receta> consultarBusquedaPorNombreReceta(Usuario unUsuario , Filtro  unFiltroBusqueda)	{
						
						ArrayList<Receta> recetarasObtenidasPorNombre = new  ArrayList<Receta>();
						
						/*
						 * TODO:
						 * HACER CONSULTAS A LA DB
						 * AGREGAR LOS RESULTADOS EN recetarioObtenidoPorNombre
						 * 
						 * 
						 */
						
						
						return recetarasObtenidasPorNombre;
						
		}
			
		public ArrayList<Receta> consultarBusquedaPorIngredienteYOtrosCampos(Usuario unUsuario , Filtro  unFiltroBusqueda)	{
			
			ArrayList<Receta> recetasObtenidas = new  ArrayList<Receta>();
			
			String ingredientePrincipal = unFiltroBusqueda.getNombreingredientePrincipal();				 
			String ingredienteSecundario = unFiltroBusqueda.getNombreingredienteSecundario();
			int dificultad = unFiltroBusqueda.getDificultad();
			int calorias = unFiltroBusqueda.getCalorias();
			int calificacion = unFiltroBusqueda.getCalificacion();
			int  temporada =  unFiltroBusqueda.getTemporada();
			

			/*
			 * TODO:
			 * HACER CONSULTAS A LA DB 
			 * AGREGAR LOS RESULTADOS EN recetasObtenidas
			 * 
			 * 
			 * 
			 * 
			 */
			
			
	       return recetasObtenidas;						
			
}			
			
			
			
			
	
	public Set<Receta> getListaRecetas() { // el metodo  deberia consultar a la base por las recetas del usuario
		return listaRecetas;
	}

	public void setListaRecetas(Set<Receta> listaRecetas) {
		this.listaRecetas = listaRecetas;
	}
	
	
	
	/// control string
	
	@SuppressWarnings("null")
	public boolean noEsStringVacio(String unString)
	{
		try
		{
			//En caso de que no funcione probar con:
			//return (unString !=null && !unString.isEmpty())	;
			return ((unString != null) || (unString.length()!=0));
		}
		catch (NullPointerException npe)
		{
	        return false;
	    }
	}
	
}




