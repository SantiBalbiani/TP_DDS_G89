package usuario;

import java.util.ArrayList;
import java.util.Set;

import receta.Ingrediente;

public class Filtro {

	
	 private String nombreReceta;
	 private String usuario; 
	 private String nombreingredientePrincipal;
	 private Set<String> nombreingredientesSecundarios;
	 private ArrayList<String> temporada;
	 private int dificultad;
	 private int calorias;
	 private int sectorPiramide;
	 private int calificacion;
	public String getNombreReceta() {
		return nombreReceta;
	}
	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombreingredientePrincipal() {
		return nombreingredientePrincipal;
	}
	public void setNombreingredientePrincipal(String nombreingredientePrincipal) {
		this.nombreingredientePrincipal = nombreingredientePrincipal;
	}
	public Set<String> getNombreingredientesSecundarios() {
		return nombreingredientesSecundarios;
	}
	public void setNombreingredientesSecundarios(
			Set<String> nombreingredientesSecundarios) {
		this.nombreingredientesSecundarios = nombreingredientesSecundarios;
	}
	public ArrayList<String> getTemporada() {
		return temporada;
	}
	public void setTemporada(ArrayList<String> temporada) {
		this.temporada = temporada;
	}
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	public int getSectorPiramide() {
		return sectorPiramide;
	}
	public void setSectorPiramide(int sectorPiramide) {
		this.sectorPiramide = sectorPiramide;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	 
	
	 
	 
	 
	 
}
