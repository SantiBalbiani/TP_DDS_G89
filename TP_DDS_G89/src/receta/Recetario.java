package receta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
			 
			
			public Recetario buscarRecetaPorFiltro(Usuario unUsuario , Filtro  unFiltroBusqueda){
				
				String nombreReceta = unFiltroBusqueda.getNombreReceta();
				String nombreUsuario = unUsuario.getNombreUsuario();
				String ingredientePrincipal = unFiltroBusqueda.getNombreingredientePrincipal();
				Set<String> ingredientesSecundarios = unFiltroBusqueda.getNombreingredientesSecundarios();
				ArrayList<String> temporada =  unFiltroBusqueda.getTemporada();
				int dificultad = unFiltroBusqueda.getDificultad();
				int calorias = unFiltroBusqueda.getCalorias();
				int sectorPiramide = unFiltroBusqueda.getSectorPiramide();
				int calificacion = unFiltroBusqueda.getCalificacion();
				
		 
				if (noEsStringVacio(nombreReceta))
				{
					//TODO: consulta BD por jerarquia1 (nombre_receta)
					//return Recetario
					//
					//para que compile le pongo un return recetario generico..
					//   {
					Receta pruebaReceta = new Receta ();			//Instancio una nueva receta
					pruebaReceta.setNombreReceta("receta_buscada_por_nombre_receta");
					receta.Recetario recetario = new receta.Recetario ();
					recetario.crearRecetario() ;
					recetario.agregarReceta(pruebaReceta);
					return recetario;
					//    }
				}
				if (noEsStringVacio(nombreUsuario))
				{
					//TODO: consulta BD por jerarquia2 (usuario/grupo)
					//return Recetario
					//
					//para que compile le pongo un return recetario generico..
					//   {
					Receta pruebaReceta = new Receta ();			//Instancio una nueva receta
					pruebaReceta.setNombreReceta("receta_buscada_por_usuario_grupo");
					receta.Recetario recetario = new receta.Recetario ();
					recetario.crearRecetario() ;
					recetario.agregarReceta(pruebaReceta);
					return recetario;
					//    }
				}
				if (noEsStringVacio(ingredientePrincipal) || noEsStringVacio(temporada) || (dificultad<=0) || (calorias <=0) || (calificacion <=0) || noEsStringVacio(sectorPiramide))
				//TODO: coordinar con el front para que los campos incompletos por defecto los pase en un numero negativo
				//revisa que alguno de los campos restantes no este vacio
				{
					//TODO: consulta BD por jerarquia3 (lo demas)
					//return Recetario
					//
					//para que compile le pongo un return recetario generico..
					//   {
					Receta pruebaReceta = new Receta ();			//Instancio una nueva receta
					pruebaReceta.setNombreReceta("tiranosaurioREX_GRRRR");
					receta.Recetario recetario = new receta.Recetario ();
					recetario.crearRecetario() ;
					recetario.agregarReceta(pruebaReceta);
					return recetario;
					//    }
				}
				//TODO: si llego hasta aca devuelve error...
				return null;
			}
			
			
	
	public Set<Receta> getListaRecetas() {
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




