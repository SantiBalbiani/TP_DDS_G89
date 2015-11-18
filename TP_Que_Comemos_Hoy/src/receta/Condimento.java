package receta;

import java.util.Set;

public class Condimento {
	public String nombre;
	public String tipo;
	
	
	//++++++++++++++++++ INICIO OPERACIONES DE AGREGAR CONDIMENTO++++++++++++++++++++++++++++++++++++++++++++//
	
		public Set<Condimento> agregar(Set<Condimento> unaListaCondimento)
		{
		    //se agrega el condimento
			unaListaCondimento.add(this);
			return unaListaCondimento;
		}
		
		
		public Set<Condimento> eliminar(Set<Condimento> unaListaCondimento)
		{
		    //se agrega el condimento
			unaListaCondimento.remove(this);
			return unaListaCondimento;
		}
		
		//++++++++++++++++++ FIN OPERACIONES DE AGREGAR CONDIMENTO++++++++++++++++++++++++++++++++++++++++++++//
		
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}