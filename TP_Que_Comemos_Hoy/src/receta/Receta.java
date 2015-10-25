package receta;

import java.util.Scanner;

public class Receta {

	
	public String nombreReceta;
	private String preparacion;
	private Ingrediente ingredientePrincipal;
	
	
	public void agregarIngredientePrincipal(Ingrediente unIngrediente){
		
		
	}

	public String nombreReceta(String unNombre) {
		this.nombreReceta= unNombre;
		return this.nombreReceta;
	}

	public void agregarIngrediente(Ingrediente unIngrediente) {
		// TODO Auto-generated method stub
		
	}

	public void agregarIngredienteCalorias(int calorias) {
		// TODO Auto-generated method stub
		
	}

	public void agregarCondimento(Condimento unCondimento) {
		// TODO Auto-generated method stub
		
	}

	public String agregarPreparacion() {
		this.preparacion= new Scanner(System.in).next();
		return this.preparacion;
	}

	public void temporadaReceta() {
		// TODO Auto-generated method stub
		
	}

	public void borrarIngrediente(Ingrediente unIngrediente) {
		// TODO Auto-generated method stub
		
	}

	public void calificarReceta(int calificacion) {
		// TODO Auto-generated method stub
		
	}

	public void borrarCondimento(Condimento unCondimento) {
		// TODO Auto-generated method stub
	}

	public String getNombreReceta() {
		// TODO Auto-generated method stub
		return this.nombreReceta;
	}

	public String getDificultad() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTemporada() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCalificacion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
