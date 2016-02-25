package estadisticas;

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

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.HibernateConf;
import receta.Ingrediente;
import receta.Receta;
import receta.TipoReceta;
import usuario.Usuario;


@Entity
@Table(name = "PLANIFICACION")
public class Planificacion {

	private int idPlanificación;
	private	String fecha;
	private Usuario usuario;
	private Receta receta;
	private TipoReceta unTipoDeReceta;
	

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "ID_PLANIF")
public int getIdPlanificación() {
		return idPlanificación;
	}
	public void setIdPlanificación(int idPlanificación) {
		this.idPlanificación = idPlanificación;
	}
	@Column(name = "FECHA")
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
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






	
	
}
