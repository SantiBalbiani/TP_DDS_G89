package estadisticas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import hibernate.HibernateConf;
import receta.Ingrediente;
import receta.Receta;

public class Estadisticas {

	
	
	
	
	/*
	TODO: REVISAR SI HAY ERRORES Y CONSULTAR A LA BASE
	FIXME: NO ESTA EN HIBERNATE EL MANEJO DE GRUPO ALIMENTICIO!!!!!
	
	1!-
	Podrá obtener sus estadísticas semanales y mensuales de los tipos de comidas 
	de la piramide  alim y sus calorías (por ejemplo) por comida y consolidado.
	
	int  consolidadoSemanalCaloriasPorComida()
	int  consolidadoMensualCaloriasPorComida()
	int  semanalCaloriasPorComida(String tipoComida)
	int  mesualCaloriasPorComida(String tipoComida) 
	
	=================================================================================

	Estadísticas (por semana y por mes):
	
	2-
	o Según el sexo: tipos de receta más consultadas 
	
	String  mesualTipoRecetaSegunSexo(char sexo )
	
	
	3 -
	o Consultas según nivel de dificultad de la receta 
	
int  semanalConsultadasAceptadasporNivelDificutlad(int dificultad)
 int  mesualConsultadasAceptadasporNivelDificutlad(int dificultad) 
 
 
	
	
	
	4-
	
	o Ranking de recetas más consultadas
	
	Set<Receta> rankingConsultadasAceptadasSemanal()
	Set<Receta>  rankingConsultadasAceptadasMensual()
	
	



	Reportes (según indicación del usuario):
	o Recetas consultadas en un período dado para un usuario
	
	Set<Receta> reporteConsultadasAceptadasEntre(Date fechaInicio,Date fechaFin )
	
	
	o Recetas nuevas propuestas por los usuarios
	
	Set<Receta> reporteNuevasEntre(Date fechaInicio,Date fechaFin )
	
	
	
	o Preferencias de recetas en un período determinado
	
	
	
	
	
	o Recetas según un rango de calorías a indicar por el usuario
	
	Set<Receta> reporteRecetasPorCalorias(int caloriasInicio,Date caloriasFin )
	
	
	*/
	
 
	
/////////////////////// MANEJO DE FECHAS /////////////////////////////////////////////////////////	
public  Date obtenerFechaActual(){
	
	
 
	
	Date hoy =  new Date();
	
	Calendar calendarEnd = Calendar.getInstance();
	calendarEnd.setTime(hoy);   
	calendarEnd.set(Calendar.MILLISECOND, 999);
	calendarEnd.set(Calendar.SECOND, 59);
	calendarEnd.set(Calendar.MINUTE, 59);
	calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
    Date fechaActual =  calendarEnd.getTime();
	
	return fechaActual;
}
	


public  Date  primerDiaDeLaSemana() {
	  
 
		
		Date fecha = new Date();
 
   
	   Calendar calendarStart = Calendar.getInstance();
	   calendarStart.setTime(fecha);   
	   calendarStart.set(Calendar.DAY_OF_WEEK, calendarStart.getFirstDayOfWeek());
       calendarStart.set(Calendar.MILLISECOND, 0);
       calendarStart.set(Calendar.SECOND, 0);
       calendarStart.set(Calendar.MINUTE, 0);
       calendarStart.set(Calendar.HOUR_OF_DAY, 0);
 	   
	   return calendarStart.getTime();
	   
	   
	}

public Date  primerDiaDelMes() {
	  

   		Date fecha = new Date();
	 
	   
	Calendar calendarStart = Calendar.getInstance();
	calendarStart.setTime(fecha);   
	calendarStart.set(Calendar.DATE, 1);
    calendarStart.set(Calendar.MILLISECOND, 0);
    calendarStart.set(Calendar.SECOND, 0);
    calendarStart.set(Calendar.MINUTE, 0);
    calendarStart.set(Calendar.HOUR_OF_DAY, 0);
	   
	   return calendarStart.getTime();
   
   
   
}

public Date  obtenerFechaInicial(Date fechaInicial) {
	  

	
 
   
	Calendar calendarStart = Calendar.getInstance();
	calendarStart.setTime(fechaInicial);   
	calendarStart.set(Calendar.MILLISECOND, 0);
	calendarStart.set(Calendar.SECOND, 0);
	calendarStart.set(Calendar.MINUTE, 0);
	calendarStart.set(Calendar.HOUR_OF_DAY, 0);
   
   return calendarStart.getTime();

}


public  Date obtenerFechaActual(Date fechaFinal){
	
 
	
	Calendar calendarEnd = Calendar.getInstance();
	calendarEnd.setTime(fechaFinal);   
	calendarEnd.set(Calendar.MILLISECOND, 999);
	calendarEnd.set(Calendar.SECOND, 59);
	calendarEnd.set(Calendar.MINUTE, 59);
	calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
    Date fechaActual =  calendarEnd.getTime();
	
	return fechaActual;
}


	public Date dateStringToDate(String fechaEnString){
		
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
 
			Date date = new Date();
			try {
				date = formatter.parse(fechaEnString);
			} catch (ParseException e) {
				 
				e.printStackTrace();
			}
			return date;
 
	}
	
	public Date parserFechas (String unString)
	{
		try {
			java.util.Date temp = new SimpleDateFormat("yyyy-MM-dd").parse(unString);
			return temp;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Date dateStringToDate2(String fechaEnString){
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = new Date();
		try {
			date = formatter.parse(fechaEnString);
		} catch (ParseException e) {
			 
			e.printStackTrace();
		}
		return date;

}

/////////////////////// FIN MANEJO DE FECHAS //////////////////////////////



/////////////////////// CALORIAS X SECTOR PIRAMIDE //////////////////////////////


public int  consolidadoSemanalCaloriasPorComida(){
	
	 int caloriasSemanal = 0;
	 int sectorPiramide; 
	 
	 for (sectorPiramide = 0;sectorPiramide < 6 ; sectorPiramide++){
//		 (0); //("Harinas");
//		 (1); //("Lacteos");
//		 (2); //("Vetetales");
//		 (3); //("Carnes");
//		 (4); //("Dulces");
//		 (5); //("Aceites");
	 		caloriasSemanal = caloriasSemanal + semanalCaloriasPorComida(sectorPiramide);
	 	}

	 return caloriasSemanal;
}


public int  consolidadoMensualCaloriasPorComida(){
	
	 int caloriasMensual = 0;
	 int sectorPiramide; 
 
	 for (sectorPiramide = 0;sectorPiramide <= 5 ; sectorPiramide++){
		 
//		 (0); //("Harinas");
//		 (1); //("Lacteos");
//		 (2); //("Vetetales");
//		 (3); //("Carnes");
//		 (4); //("Dulces");
//		 (5); //("Aceites");
	 		
		 caloriasMensual = caloriasMensual + semanalCaloriasPorComida(sectorPiramide);
	 	}

	 return caloriasMensual;
}



public int  semanalCaloriasPorComida(int tipoComida){
	

	return estadisticaCaloriasPorComida(tipoComida, primerDiaDeLaSemana());

}

public int  mesualCaloriasPorComida(int tipoComida){
	

	return estadisticaCaloriasPorComida(tipoComida, primerDiaDelMes());

}





public int estadisticaCaloriasPorComida(int tipoComida, Date fechaInicio){

				int calorias = 0;
 	   			Date hoy =  obtenerFechaActual();
	   			Date comienzoSemanaOmes =  fechaInicio; 
	   			 	
	   			Session sessionHIB = HibernateConf.getSessionFactory().openSession();

		 		Criteria recetas = sessionHIB.createCriteria(Receta.class).add(Restrictions.eq("sectorPiramideAlimenticia", tipoComida)).add(Restrictions.between("fechaAlta", comienzoSemanaOmes, hoy));
		 		
		 		
		 		@SuppressWarnings("unchecked")
				List<Receta> recetaList = recetas.list();
	   	 
	   			
	   			calorias = sumarCalorias(recetaList);
	   		
	   			return calorias;
	
	   			
	 
	
}


public int sumarCalorias(List<Receta> recetaList){
	int total = 0;
	
		for ( Receta   receta : recetaList){
			
			total = total + receta.getCalorias();
		}

	
	return total;
}



/////////////////////// FIN CALORIAS X SECTOR PIRAMIDE //////////////////////////////


/////////////////////// TIPO RECETA SEGUN SEXO //////////////////////////////


public String  mesualTipoRecetaSegunSexo(char sexo ){
	

	return tipoRecetaSegunSexo(sexo, primerDiaDelMes());

}

public String  semanalTipoRecetaSegunSexo(char sexo ){
	

	return tipoRecetaSegunSexo(sexo, primerDiaDeLaSemana());

}

public String tipoRecetaSegunSexo(char unSexo, Date fechaInicio){
		
	   int idTipoReceta;
	   String tipoReceta;
		
		// DESAYUNO 
		  idTipoReceta = 1;
		  List<Receta>  recetasDesayunoList  = consultaDBtipoRecetaSegunSexo( fechaInicio,  unSexo,  idTipoReceta );		
	   
		// ALMUERZO 
		  idTipoReceta = 2;
		  List<Receta> recetasAlmuerzoList = consultaDBtipoRecetaSegunSexo( fechaInicio,  unSexo,  idTipoReceta );
	     
		// MERIENDA 
		  idTipoReceta = 3;
		  List<Receta> recetasMeriendaList = consultaDBtipoRecetaSegunSexo( fechaInicio,  unSexo,  idTipoReceta );
 		
		// CENA
		  idTipoReceta = 4;
		  List<Receta> recetasCenaList = consultaDBtipoRecetaSegunSexo( fechaInicio,  unSexo,  idTipoReceta );
	   
	   
	   tipoReceta = mayorCantidadRecetasPorTipo (recetasAlmuerzoList,recetasDesayunoList,
			   recetasCenaList, recetasMeriendaList);
	   
	return tipoReceta;
}


public List<Receta>  consultaDBtipoRecetaSegunSexo(Date fechaInicio, char unSexo, int tipoReceta ){
	
	   
		Date hoy = obtenerFechaActual();
		
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		Criteria recetas = sessionHIB.createCriteria(Planificacion.class)
								   .createAlias("Usuario", "user").add(Restrictions.eq("user.sexo", unSexo))
								   .createAlias("Receta", "recipe").add(Restrictions.eq("recipe.tipoReceta", tipoReceta))
								   .add(Restrictions.between("fechaAlta", fechaInicio, hoy));;
		@SuppressWarnings("unchecked")
		List<Receta>  recetasList =  recetas.list();
	
			return recetasList;
	
}




   public String mayorCantidadRecetasPorTipo ( List<Receta> almuerzo, List<Receta> desayuno,
		   List<Receta> cena,  List<Receta> merienda){
	   
	   
		if(almuerzo.size() >= desayuno.size() && almuerzo.size() >= cena.size() && almuerzo.size() >= merienda.size()){		
			return "Almuerzo";		
		}
   
   
	if(cena.size() >= desayuno.size() && cena.size() >= almuerzo.size() && cena.size() >= merienda.size()){		
		return "Cena";		
	}
	   										
	if(desayuno.size() >= almuerzo.size() && desayuno.size() >= cena.size() && desayuno.size() >= merienda.size()){		
		return "Desayuno";		
	}   
	
	if(merienda.size() >= almuerzo.size() && merienda.size() >= cena.size() && merienda.size() >= almuerzo.size()){		
		return "Merienda";		
	}  
 
	   return "Almuerzo"; //por defecto para que no rompa
	   
   }



/////////////////////// FIN TIPO RECETA SEGUN SEXO //////////////////////////////


 

/////////////////////// CONSULTADAS POR NIVEL DIFICULTAD //////////////////////////////

public int  semanalConsultadasAceptadasporNivelDificutlad(int dificultad){
	

	return consultadasAceptadasporNivelDificutlad(dificultad, primerDiaDeLaSemana());

}

public int  mesualConsultadasAceptadasporNivelDificutlad(int dificultad){
	

	return consultadasAceptadasporNivelDificutlad(dificultad, primerDiaDelMes());

}




public int consultadasAceptadasporNivelDificutlad(int dificultad, Date fechaInicio){
	
	

		Date hoy =  obtenerFechaActual();
		Date comienzoSemanaOmes =  fechaInicio; 
 
		int cantidadRecetas = 0;

		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
 	  

 		Criteria recetas = sessionHIB.createCriteria(Planificacion.class).add(Restrictions.eq("dificultadReceta", dificultad)).add(Restrictions.between("fechaAlta", comienzoSemanaOmes, hoy));
		
 		@SuppressWarnings("unchecked")
		List<Receta> recetaList = recetas.list();
		
 		cantidadRecetas =  recetaList.size();
		
		return  cantidadRecetas;

}
/////////////////////// FIN CONSULTADAS POR NIVEL DIFICULTAD //////////////////////////////
 

/////////////////////// RANKING CONSULTADAS  //////////////////////////////

public  List<Receta> rankingConsultadasAceptadasSemanal(){
	

	return  rankingConsultadasAceptadaspor(primerDiaDeLaSemana());

}

public  List<Receta> rankingConsultadasAceptadasMensual(){
	

	return  rankingConsultadasAceptadaspor( primerDiaDelMes());

}


public List<Receta> rankingConsultadasAceptadaspor(Date fechaInicio){
	
	

		Date hoy =  obtenerFechaActual();
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		
		
		Criteria recetas = sessionHIB.createCriteria(Planificacion.class).add(Restrictions.between("fecha", fechaInicio, hoy));
			
		@SuppressWarnings("unchecked")
		List<Receta> rankingRecetas = recetas.list();
	
	
	return  rankingRecetas;

}

///////////////////////FIN RANKING CONSULTADAS  //////////////////////////////


///////////////////////REPORTE  CONSULTADAS POR PERIODO //////////////////////////////


// Recetas consultadas en un período dado para un usuario

public List<Receta> reporteConsultadasAceptadasEntre(Date fechaInicio,Date fechaFin ){
	
 
 
	Session sessionHIB = HibernateConf.getSessionFactory().openSession();

	Criteria recetas = sessionHIB.createCriteria(Receta.class).add(Restrictions.between("fechaAlta", fechaInicio, fechaFin));
	
	
	@SuppressWarnings("unchecked")
	List<Receta> recetasAceptadas = recetas.list();

 
	
	return  recetasAceptadas;

}

/////////////////////// FIN REPORTE  CONSULTADAS POR PERIODO //////////////////////////////

///////////////////////REPORTE  RECETAS NUEVAS POR PERIODO //////////////////////////////



public List<Receta> reporteRecetasNuevasEntre(Date fechaInicio,Date fechaFin ){
	
  
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();

		Criteria recetas = sessionHIB.createCriteria(Receta.class).add(Restrictions.between("fechaAlta", fechaInicio, fechaFin));
		
		
		@SuppressWarnings("unchecked")
		List<Receta> recetasNuevas = recetas.list();
	
 
	
	return  recetasNuevas;

}

///////////////////////FIN REPORTE  RECETAS NUEVAS POR PERIODO //////////////////////////////


///////////////////////REPORTE  RECETAS  POR RANGO CALORIAS //////////////////////////////

public  List<Receta> reporteRecetasPorCalorias(int caloriasInicio,int caloriasFin ){
	 
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
 
		Criteria recetas = sessionHIB.createCriteria(Receta.class).add(Restrictions.between("calorias", caloriasInicio, caloriasFin));
	
		@SuppressWarnings("unchecked")
		List<Receta> recetasPorCalorias = recetas.list();
	
	
	
	return  recetasPorCalorias;

}

/////////////////////// FIN REPORTE  RECETAS  POR RANGO CALORIAS //////////////////////////////










	
}
