package receta;

import java.util.ArrayList;


public class Piramide {

	
	 private ArrayList<GrupoAlimenticio> gruposAlimenticios ;
	
	
	public Piramide crearPiramide(){
		
		//grupo1: harinas
		//grupo2: frutas y verduras
		//grupo3: carnes,pescado y huevos 
		//grupo4: legumbres y frutos secos
		//grupo5: lacteos
		//grupo6: grasas,aceites  y dulces
		
		
	 Piramide nuevaPiramide = new Piramide();
	 
	 GrupoAlimenticio harinas = GrupoAlimenticio.crearGrupo();
	 harinas.setNombreGrupo("Harinas");
	 harinas.setDescripcionGrupo("descripcion");
	 harinas.setContraindicaciones("contraindicaciones");
	 this.agregarGrupoAlimenticio(harinas);
	 
	 GrupoAlimenticio frutasYVerduras = GrupoAlimenticio.crearGrupo();
	 frutasYVerduras.setNombreGrupo("Frutas y Verduras");
	 frutasYVerduras.setDescripcionGrupo("descripcion");
	 frutasYVerduras.setContraindicaciones("contraindicaciones");
	 this.agregarGrupoAlimenticio(frutasYVerduras);
	 
	 GrupoAlimenticio carnesPescadoHuevos = GrupoAlimenticio.crearGrupo();
	 carnesPescadoHuevos.setNombreGrupo("Carnes, Pescado y Huevos");
	 carnesPescadoHuevos.setDescripcionGrupo("descripcion");
	 carnesPescadoHuevos.setContraindicaciones("contraindicaciones");
	 this.agregarGrupoAlimenticio(carnesPescadoHuevos);
	 
	 GrupoAlimenticio legumbresYFrutosSecos = GrupoAlimenticio.crearGrupo();
	 legumbresYFrutosSecos.setNombreGrupo("Legumbres Y Frutos Secos");
	 legumbresYFrutosSecos.setDescripcionGrupo("descripcion");
	 legumbresYFrutosSecos.setContraindicaciones("contraindicaciones");
	 this.agregarGrupoAlimenticio(legumbresYFrutosSecos);
	 
	 GrupoAlimenticio lacteos = GrupoAlimenticio.crearGrupo();
	 lacteos.setNombreGrupo("Lacteos");
	 lacteos.setDescripcionGrupo("descripcion");
	 lacteos.setContraindicaciones("contraindicaciones");
	 this.agregarGrupoAlimenticio(lacteos);
	  
	 GrupoAlimenticio grasasAceitesDulces = GrupoAlimenticio.crearGrupo();
	 grasasAceitesDulces.setNombreGrupo("Grasas, Aceites y Dulces");
	 grasasAceitesDulces.setDescripcionGrupo("descripcion");
	 grasasAceitesDulces.setContraindicaciones("contraindicaciones");
	 this.agregarGrupoAlimenticio(grasasAceitesDulces);
	 
	return nuevaPiramide;
	}
	
	
	public void agregarGrupoAlimenticio(GrupoAlimenticio unGrupo){
	
		 this.getGruposAlimenticios().add(unGrupo);	
	}

	public ArrayList<GrupoAlimenticio> getGruposAlimenticios() {
		return gruposAlimenticios;
	}

	public void setGruposAlimenticios(ArrayList<GrupoAlimenticio> gruposAlimenticios) {
		this.gruposAlimenticios = gruposAlimenticios;
	}	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

