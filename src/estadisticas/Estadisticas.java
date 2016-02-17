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
	
	Podrá obtener sus estadísticas semanales y mensuales de los tipos de comidas y sus calorías
	(por ejemplo) por comida y consolidado.

	Estadísticas (por semana y por mes):
	o Según el sexo: tipos de receta más consultadas 
	o Consultas según nivel de dificultad de la receta >>> aceptadas
	o Ranking de recetas más consultadas
	•
	Reportes (según indicación del usuario):
	o Recetas consultadas en un período dado para un usuario
	o Recetas nuevas propuestas por los usuarios
	o Preferencias de recetas en un período determinado
	o Recetas según un rango de calorías a indicar por el usuario
	
	*/
	
 
	
	
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
	   			
	   			
	   			Session session = HibernateConf.getSessionFactory().openSession();


	   			Query query = session.createQuery("FROM Receta sum(e.calorias) where e.sectorPiramideAlimenticia = :sectorPiramide");

	   			query.setString("sectorPiramide", tipoComida);

	   			
	   			java.util.List<?> lista = query.list();
	   			
	   			calorias = (int)lista.get(0);
	   		
	   			
	
	   			
	return  calorias;
	
}



////////////////////////////////////////////////////////////////////////////////////////////////



public int  semanalConsultadasAceptadasporNivelDificutlad(int dificultad){
	

	return ConsultadasAceptadasporNivelDificutlad(dificultad, primerDiaDeLaSemana());

}

public int  mesualConsultadasAceptadasporNivelDificutlad(int dificultad){
	

	return ConsultadasAceptadasporNivelDificutlad(dificultad, primerDiaDelMes());

}




public int ConsultadasAceptadasporNivelDificutlad(int dificultad, Date fechaInicio){
	
	

		Date hoy =  obtenerFechaActual();
		Date comienzoSemanaOmes =  fechaInicio; 
		Set<Receta> recetas = new  HashSet<Receta>(); //se debe usar??
		int cantidadRecetas;

		
		
		//TODO: HACER QUERY le falta comparar fecha
		//contra campo-columna FechaAlta  >= comienzoSemanaOmes & FechaAlta <= hoy
		//para calculo semanal o mensual
		
		
		Session session = HibernateConf.getSessionFactory().openSession();

											//TODO: agregar al QUERY clausura where aceptada = 'SI'
		Query query = session.createQuery("FROM Receta count(e.dificultadReceta) where e.aceptada = :dificultad");

		query.setInteger("dificultadReceta", dificultad);

		
		java.util.List<?> lista = query.list();
		
		cantidadRecetas = (int)lista.get(0);
		
		return  cantidadRecetas;

}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////

public Set<Receta> rankingConsultadasAceptadasSemanal(){
	

	return  rankingConsultadasAceptadaspor(primerDiaDeLaSemana());

}

public Set<Receta>  rankingConsultadasAceptadasMensual(){
	

	return  rankingConsultadasAceptadaspor( primerDiaDelMes());

}


public Set<Receta> rankingConsultadasAceptadaspor(Date fechaInicio){
	
	

	Date hoy =  obtenerFechaActual();
	Date comienzoSemanaOmes =  fechaInicio; 
	Set<Receta> rankingRecetas = new  HashSet<Receta>(); //se debe usar??
	 

	
	
	
	Session session = HibernateConf.getSessionFactory().openSession();
	//TODO: HACER QUERY le falta comparar fecha
	//contra campo-columna FechaAlta  >= comienzoSemanaOmes & FechaAlta <= hoy
	//para calculo semanal o mensual
	
	
	//TODO: agregar al QUERY clausura where aceptada = 'SI'. 

										
	 Query query = session.createQuery("FROM e Receta  where e.aceptada =  'SI' ORDER BY max(e.aceptada)");

 

	
	java.util.List<?> lista = query.list();
	
	rankingRecetas = (Set<Receta>)lista;
	
	return  rankingRecetas;

}










	
}
