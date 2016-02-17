package receta;

import java.util.ArrayList;
import java.util.List;

public class GrupoAlimenticio {
	
		
		private String nombreGrupo;
		private String descripcionGrupo;
		private String contraindicaciones;

		List<String> listaPiramide = new ArrayList<String>() {
			{
				add("Harinas y Legumbres");
				add("Lacteos");
				add("Frutas y Vetetales");
				add("Pescado, Carne y Huevo");
				add("Sal, Azucar, Grasas y Dulces");
				add("Aceites");
			}
		};
		
		
		public static GrupoAlimenticio crearGrupo(){
	
			GrupoAlimenticio nuevoGrupoAlimenticio = new GrupoAlimenticio();
	 
			return nuevoGrupoAlimenticio;
	 
		}
		

		public String getNombreGrupo() {
			return nombreGrupo;
		}
		public void setNombreGrupo(String nombreGrupo) {
			this.nombreGrupo = nombreGrupo;
		}
		public String getDescripcionGrupo() {
			return descripcionGrupo;
		}
		public void setDescripcionGrupo(String descripcionGrupo) {
			this.descripcionGrupo = descripcionGrupo;
		}
		public String getContraindicaciones() {
			return contraindicaciones;
		}
		public void setContraindicaciones(String contraindicaciones) {
			this.contraindicaciones = contraindicaciones;
		}	
}
