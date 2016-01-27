package receta;

public class GrupoAlimenticio {
	
		
		private String nombreGrupo;
		private String descripcionGrupo;
		private String contraindicaciones;

		
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
