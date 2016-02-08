package usuario;

import java.util.ArrayList;
import java.util.Set;

import receta.Ingrediente;

public class Filtro {

	
	 private String nombreReceta;
	 private String usuario; 
	 private String nombreingredientePrincipal;
	 private String nombreingredienteSecundario;
	 private int temporada;
	 private int dificultad;
	 private int calorias;
	 private int sectorPiramide;
	 private int calificacion;
	 private ArrayList<CondicionesPreexistentes> condicionesPreexistentes ;
	 
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
	public  String  getNombreingredienteSecundario() {
		return nombreingredienteSecundario;
	}
	public void setNombreingredienteSecundario(
			 String  nombreingredienteSecundario) {
		this.nombreingredienteSecundario  = nombreingredienteSecundario ;
	}
	
	//TODO: CONSULTAR ID A LA BASE
	public int getTemporada() {
		return temporada;
	}
	public void setTemporada(int  temporada) {
		this.temporada = temporada;
	}
	
	
	//TODO: CONSULTAR ID A LA BASE
	public ArrayList<CondicionesPreexistentes> getcondicionesPreexistentes() {
		return condicionesPreexistentes;
	}
	public void setcondicionesPreexistentes(ArrayList<CondicionesPreexistentes> condicionesPreexistentes) {
		this.condicionesPreexistentes = condicionesPreexistentes;
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
