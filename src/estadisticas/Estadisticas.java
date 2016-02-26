package estadisticas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

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
	
	
	Date fechaActual = new Date();
	
	return fechaActual;
}
	


public  Date  primerDiaDeLaSemana() {
	  
		Date fechaActual = obtenerFechaActual();
		
		Calendar calendar = Calendar.getInstance();
	   calendar.setTime(fechaActual);
	   calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
	   return calendar.getTime();
	}

public Date  primerDiaDelMes() {
	  
	Date fechaActual = obtenerFechaActual();
	
	Calendar calendar = Calendar.getInstance();
   calendar.setTime(fechaActual);
   
   calendar.set(Calendar.DATE, 1);
   return calendar.getTime();
}

/////////////////////// FIN MANEJO DE FECHAS //////////////////////////////



/////////////////////// CALORIAS X SECTOR PIRAMIDE //////////////////////////////


public int  consolidadoSemanalCaloriasPorComida(){
	
	 int caloriasSemanal = 0;
	 int calHarinas = semanalCaloriasPorComida("Harinas");
	 int calLacteos = semanalCaloriasPorComida("Lacteos");
	 int calVetetales = semanalCaloriasPorComida("Vetetales");
	 int calCarnes = semanalCaloriasPorComida("Carnes");
	 int calDulces = semanalCaloriasPorComida("Dulces");
	 int calAceites = semanalCaloriasPorComida("Aceites");
	 
	 caloriasSemanal = calHarinas +calLacteos+calVetetales+calCarnes+calDulces+calAceites ;
	 
	 return caloriasSemanal;
}


public int  consolidadoMensualCaloriasPorComida(){
	
	 int caloriasMesual = 0;
	 int calHarinas = mesualCaloriasPorComida("Harinas");
	 int calLacteos = mesualCaloriasPorComida("Lacteos");
	 int calVetetales = mesualCaloriasPorComida("Vetetales");
	 int calCarnes = mesualCaloriasPorComida("Carnes");
	 int calDulces = mesualCaloriasPorComida("Dulces");
	 int calAceites = mesualCaloriasPorComida("Aceites");
	 
	 caloriasMesual = calHarinas +calLacteos+calVetetales+calCarnes+calDulces+calAceites ;
	 
	 return caloriasMesual;
}



public int  semanalCaloriasPorComida(String tipoComida){
	

	return estadisticaCaloriasPorComida(tipoComida, primerDiaDeLaSemana());

}

public int  mesualCaloriasPorComida(String tipoComida){
	

	return estadisticaCaloriasPorComida(tipoComida, primerDiaDelMes());

}





public int estadisticaCaloriasPorComida(String tipoComida, Date fechaInicio){
	


				//Obtiene las calorias de un tipo de comida por semana o mes
	
	   			Date hoy =  obtenerFechaActual();
	   			Date comienzoSemanaOmes =  fechaInicio; 
	   			Set<Receta> recetas = new  HashSet<Receta>(); //se debe usar??
	   			int calorias;
	   	
	   			
	   			
	   			//TODO: HACER QUERY le falta comparar fecha
	   			//contra campo-columna FechaAlta  >= comienzoSemanaOmes & FechaAlta <= hoy
	   			//para calculo semanal, tipo
	   			
	   			
	   			Session sessionHIB = HibernateConf.getSessionFactory().openSession();


	   			Query query = sessionHIB.createQuery("FROM Receta sum(e.calorias) where e.sectorPiramideAlimenticia = :sectorPiramide");

	   			query.setString("sectorPiramide", tipoComida);

	   			
	   			java.util.List<?> lista = query.list();
	   			
	   			calorias = (int)lista.get(0);
	   		
	   			
	
	   			
	return  calorias;
	
}




public void buscarEntreFechas(String tipoComida, Date fechaInicio){
	


	//Obtiene las calorias de un tipo de comida por semana o mes

		Date hoy =  obtenerFechaActual();
		Date comienzoSemanaOmes =  fechaInicio; 
		Set<Receta> recetas = new  HashSet<Receta>(); //se debe usar??
		int calorias;
 
		
		
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();


		//Query query //= sessionHIB.createQuery("FROM Receta sum(e.calorias) where e.sectorPiramideAlimenticia = :sectorPiramide");

		         //query.setString("sectorPiramide", tipoComida);

		
		//java.util.List<?> lista = query.list();
		
  
		@SuppressWarnings("unchecked")
		java.util.List<Receta> recetaList = sessionHIB.createQuery("from Receta e where e.fechaAlta between :start and :end").setParameter("start",comienzoSemanaOmes)
		.setParameter("end",hoy).list();	

		
 

}















/////////////////////// FIN CALORIAS X SECTOR PIRAMIDE //////////////////////////////


/////////////////////// TIPO RECETA SEGUN SEXO //////////////////////////////


public String  mesualTipoRecetaSegunSexo(char sexo ){
	

	return tipoRecetaSegunSexo(sexo, primerDiaDelMes());

}

public String  semanalTipoRecetaSegunSexo(char sexo ){
	

	return tipoRecetaSegunSexo(sexo, primerDiaDeLaSemana());

}

public String tipoRecetaSegunSexo(char unSexo, Date Fecha){
	
	   String tipoReceta;
	   
	   Set<Receta> recetasAlmuerzo = new HashSet<Receta>();
	   Set<Receta> recetasDesayuno = new HashSet<Receta>();
	   Set<Receta> recetasCena = new HashSet<Receta>();
	   Set<Receta> recetasMerienda = new HashSet<Receta>();
	   
	   /*
	    TODO: hacer un select u Usuario where u.sexo:=unSexo para
	    
	    y unir busqueda con select del recetario/receta where tipoReceta y guardar las
	    recetas retornadas en cada set segun el tipo
	    
	    SE TIENE QUE HACER CUATRO QUERYs y asignar a cada set el resultado
	    
	    */
	   tipoReceta = mayorCantidadRecetasPorTipo (recetasAlmuerzo,recetasDesayuno,
			   recetasCena, recetasMerienda);
	   
	return tipoReceta;
}

   public String mayorCantidadRecetasPorTipo ( Set<Receta> almuerzo,Set<Receta> desayuno,
		   										Set<Receta> cena, Set<Receta> merienda){
	   
	   
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
		Set<Receta> recetas = new  HashSet<Receta>(); //se debe usar??
		int cantidadRecetas;

		
		
		//TODO: HACER QUERY le falta comparar fecha
		//contra campo-columna FechaAlta  >= comienzoSemanaOmes & FechaAlta <= hoy
		//para calculo semanal o mensual
		
		
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();

											//TODO: agregar al QUERY clausura where aceptada = 'SI'
		Query query = sessionHIB.createQuery("FROM Receta count(e.dificultadReceta) where e.aceptada = :dificultad");

		query.setInteger("dificultadReceta", dificultad);

		
		java.util.List<?> lista = query.list();
		
		cantidadRecetas = (int)lista.get(0);
		
		return  cantidadRecetas;

}
/////////////////////// FIN CONSULTADAS POR NIVEL DIFICULTAD //////////////////////////////
 

/////////////////////// RANKING CONSULTADAS  //////////////////////////////

public Set<Receta> rankingConsultadasAceptadasSemanal(){
	

	return  rankingConsultadasAceptadaspor(primerDiaDeLaSemana());

}

public Set<Receta>  rankingConsultadasAceptadasMensual(){
	

	return  rankingConsultadasAceptadaspor( primerDiaDelMes());

}


public Set<Receta> rankingConsultadasAceptadaspor(Date fechaInicio){
	
	

	Date hoy =  obtenerFechaActual();
	Date comienzoSemanaOmes =  fechaInicio; 
	Set<Receta> rankingRecetas = new  HashSet<Receta>(); 
	 

	
	
	
	Session sessionHIB = HibernateConf.getSessionFactory().openSession();
	//TODO: HACER QUERY le falta comparar fecha
	//contra campo-columna FechaAlta  >= comienzoSemanaOmes & FechaAlta <= hoy
	//para calculo semanal o mensual
	
	
	//TODO: agregar al QUERY clausura where aceptada = 'SI'. 

										
	 Query query = sessionHIB.createQuery("FROM e Receta  where e.aceptada =  'SI' ORDER BY max(e.aceptada)");

 

	
	java.util.List<?> lista = query.list();
	
	rankingRecetas = (Set<Receta>)lista;
	
	return  rankingRecetas;

}

///////////////////////FIN RANKING CONSULTADAS  //////////////////////////////


///////////////////////REPORTE  CONSULTADAS POR PERIODO //////////////////////////////


// Recetas consultadas en un período dado para un usuario

public Set<Receta> reporteConsultadasAceptadasEntre(Date fechaInicio,Date fechaFin ){
	
 
	Set<Receta> recetasAceptadas = new  HashSet<Receta>(); 
	Session sessionHIB = HibernateConf.getSessionFactory().openSession();
	//TODO: HACER QUERY le falta comparar fecha
	//contra campo-columna FechaAlta en RECETARIO entre fechaInicio & FechaFin
	
	
	//TODO: agregar al QUERY clausura where aceptada = 'SI'. 

										
	 Query query = sessionHIB.createQuery("FROM e Receta  where e.aceptada =  'SI' ORDER BY max(e.aceptada)");

 

	
	java.util.List<?> lista = query.list();
	
	recetasAceptadas = (Set<Receta>)lista;
	
	return  recetasAceptadas;

}

/////////////////////// FIN REPORTE  CONSULTADAS POR PERIODO //////////////////////////////

///////////////////////REPORTE  RECETAS NUEVAS POR PERIODO //////////////////////////////



public Set<Receta> reporteNuevasEntre(Date fechaInicio,Date fechaFin ){
	
 
	Set<Receta> recetasNuevas = new  HashSet<Receta>(); 
	Session sessionHIB = HibernateConf.getSessionFactory().openSession();
	
	
	//TODO: HACER QUERY traer todas las recetas con fechaAlta entre 
	//la fechaInicio y fechaFin
	 
	Query  query = sessionHIB.createQuery("FROM e Receta where fechaAlta... ");

	
	 java.util.List<?> lista = query.list();
	
	 recetasNuevas = (Set<Receta>)lista;
	
	return  recetasNuevas;

}

///////////////////////FIN REPORTE  RECETAS NUEVAS POR PERIODO //////////////////////////////


///////////////////////REPORTE  RECETAS  POR RANGO CALORIAS //////////////////////////////

public Set<Receta> reporteRecetasPorCalorias(int caloriasInicio,Date caloriasFin ){
	
	 
	Set<Receta> recetasPorCalorias = new  HashSet<Receta>(); 
	Session sessionHIB = HibernateConf.getSessionFactory().openSession();
	
	
	//TODO: HACER QUERY traer todas las recetas con entre el rango >= y <= de calorias
	
	
	 
	Query  query = sessionHIB.createQuery("FROM e Receta where e.calorias ... ");

	
	 java.util.List<?> lista = query.list();
	
	 recetasPorCalorias = (Set<Receta>)lista;
	
	return  recetasPorCalorias;

}

/////////////////////// FIN REPORTE  RECETAS  POR RANGO CALORIAS //////////////////////////////










	
}
