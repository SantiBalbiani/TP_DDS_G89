package estadisticas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import hibernate.HibernateConf;
import receta.Ingrediente;
import receta.Receta;
import receta.TipoReceta;
import usuario.Usuario;


@Entity
@Table(name = "PLANIFICACION")
public class Planificacion {

	private int idPlanificacion;
	private	Date fecha;
	private Usuario usuario;
	private Receta receta;
	private TipoReceta unTipoDeReceta;
	

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "ID_PLANIF")
public int getIdPlanificacion() {
		return idPlanificacion;
	}
	public void setIdPlanificacion(int idPlanificacion) {
		this.idPlanificacion = idPlanificacion;
	}
	@Column(name = "FECHA")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ID_USER", nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ID_RECETA", nullable = false)
	public Receta getReceta() {
		return receta;
	}
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ID_TIPORECETA", nullable = false)
	public TipoReceta getUnTipoDeReceta() {
		return unTipoDeReceta;
	}
	public void setUnTipoDeReceta(TipoReceta unTipoDeReceta) {
		this.unTipoDeReceta = unTipoDeReceta;
	}


	public java.util.List<Planificacion> obtenerPlanificacionesUser(int unIdUser){
		
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();

		Query query = sessionHIB.createQuery("FROM Planificacion p WHERE p.idUsuario = :idUsuario");
		
		query.setInteger("idUsuario", unIdUser);
		
		List<Planificacion> listaDeTodosLosIngredientes = query.list();


	return listaDeTodosLosIngredientes;
			
		
	}


	public void guardarPlanificacion(Planificacion unaPlanificacion) {
		
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		//sessionHIB = HibernateConf.getSessionFactory().openSession();
		sessionHIB.beginTransaction();

		sessionHIB.save(unaPlanificacion);

		sessionHIB.getTransaction().commit();
		System.out.println("Done");
		sessionHIB.close();
	}


		public Date stringFechaToDate (String unaFecha)
		{
		//String fechaEnString = "24/02/2016";
		
		   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //;

			Date date = new Date();
			try {
				date = formatter.parse(unaFecha);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}

		}
		
		
		public List<Planificacion> recetasUsuarioPlanificadas(Usuario unUsuario ){
			
			  
			Session sessionHIB = HibernateConf.getSessionFactory().openSession();

			Criteria planificacionesNuevas = sessionHIB.createCriteria(Planificacion.class)
					.add(Restrictions.between("fecha", this.obtenerFechaActual(), this.parserFechas()))
					.createAlias("usuario", "user").add(Restrictions.eq("user.idUsuario", unUsuario.getIdUsuario()));
			
					//.add(Restrictions.eq("usuario", unUsuario.getIdUsuario()))
			System.out.println(this.parserFechas()); //2013/10/15 16:16:39
			System.out.println(this.parserFechas()); //2013/10/15 16:16:39
			
			
			@SuppressWarnings("unchecked")
			List<Planificacion> planificacionesFinales = planificacionesNuevas.list();
		
	 
		
		return  planificacionesFinales;

	}
		
		public List<Planificacion> historialRecetasUser(Usuario unUsuario ){
			
			  
			Session sessionHIB = HibernateConf.getSessionFactory().openSession();

			Criteria planificacionesNuevas = sessionHIB.createCriteria(Planificacion.class)
					.add(Restrictions.between("fecha", this.parserFechas3(), this.obtenerFechaActual()))
					.createAlias("usuario", "user").add(Restrictions.eq("user.idUsuario", unUsuario.getIdUsuario()));
			
					//.add(Restrictions.eq("usuario", unUsuario.getIdUsuario()))
			System.out.println(this.parserFechas()); //2013/10/15 16:16:39
			System.out.println(this.parserFechas()); //2013/10/15 16:16:39
			
			
			@SuppressWarnings("unchecked")
			List<Planificacion> planificacionesFinales = planificacionesNuevas.list();
		
	 
		
		return  planificacionesFinales;

	}
		
		
//		public Date laFechaActual()
//		{
//			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //;
//			Date date = new Date();
//			try {
//				date = formatter.parse(planFecha);
//			} catch (ParseException e) {
//				 
//				e.printStackTrace();
//			}
//			return(date);
//		}
		
		public Date parserFechas ()
		{
			try {
				java.util.Date temp = new SimpleDateFormat("yyyy-MM-dd").parse("2020-07-10 14:58:00");
				return temp;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	
		public Date parserFechas2 (String unString)
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
		
		public Date parserFechas3 ()
		{
			try {
				java.util.Date temp = new SimpleDateFormat("yyyy-MM-dd").parse("2010-07-10 14:58:00");
				return temp;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		public  Date obtenerFechaActual(){
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); //2013/10/15 16:16:39
			//return this.parserFechas2((dateFormat.format(date)));
			java.util.Date temp = null;
			try {
				temp = new SimpleDateFormat("yyyy-MM-dd").parse((dateFormat.format(date)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return temp;
		}
}
