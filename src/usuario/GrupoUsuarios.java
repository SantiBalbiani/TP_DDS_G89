package usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.HibernateConf;
import receta.Receta;

@Entity
@Table(name = "GRUPO")
public class GrupoUsuarios {

	private int idGrupo;

	private String nombreDeGrupo;
	private  Set<Usuario> grupoDeUsuarios= new HashSet<Usuario>(0);// Para EL MANY TO MANY DE USUARIO-GRUPO
	private Usuario Administrador;
	
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_GRUPO")
	public int getIdGrupo() {
		return idGrupo;
	}
	
	
	//TODO: Ojo aca hay que guardar el ID de usuario y mapear...
	@Transient
	public Usuario getAdministrador() {
		return Administrador;
	}

	public void setAdministrador(Usuario administrador) {
		Administrador = administrador;
	}
	
	public Set<Usuario> crearGrupo(){

		Set<Usuario> grupoDeUsuarios = new HashSet<Usuario>();
		return grupoDeUsuarios;
	
	}
	
	//********ACA HACER MANY TO MANY********
	public  Set<Usuario>   obtenerGrupo(){
		
		return grupoDeUsuarios;
	}
	

@ManyToMany(fetch = FetchType.LAZY, mappedBy = "userGrupo", cascade=CascadeType.ALL)
	public Set<Usuario> getGrupoDeUsuarios() {
		return this.grupoDeUsuarios;
	}
	//********ACA HACER MANY TO MANY********
	
	public void ingresarGrupo(Usuario unUsuario){
	 
		this.getGrupoDeUsuarios().add(unUsuario);
		
		 
	}
	
	public void salirGrupo( Usuario  unUsuario){

		this.getGrupoDeUsuarios().remove( unUsuario);

	}
	
	public void darAltaGrupo(Usuario unUsuario, String unNombreDeGrupo)
	{
		//Agrego el setter en este metodo, evaluar ponerlo dentro de crearGrupo...
		this.grupoDeUsuarios = this.crearGrupo();
		this.ingresarGrupo(unUsuario);
		this.setNombreDeGrupo(unNombreDeGrupo);
		/*TODO:
		 * 
		 * ACA SE DEBE HACER EL ALTA EN LA DB
		 * 
		 * 
		 */ 
	}
	
	@Column(name = "NOMBRE")
	public String getNombreDeGrupo() {
		return nombreDeGrupo;
	}

	public void setNombreDeGrupo(String unNombreDeGrupo){
		this.nombreDeGrupo =unNombreDeGrupo;
	}

	
	public void EliminarGrupo( Usuario  admin){

		if(this.puedeEliminarGrupo(admin)){
			//TODO: ELIMINAR EL GRUPO DE LA DB
			this.salirGrupo(admin);	
		}
	}	
	
	public boolean puedeEliminarGrupo(Usuario usuario){
		
		//TODO: EN DB PODRIA COMPARAR LOS IDS DE USUARIO, SETEADO ADMNISTRADOR EL ID DEL CREADOR DEL GRUPO
		return ((this.getAdministrador().equals(usuario)) && (this.getGrupoDeUsuarios().contains(usuario)) && (this.getGrupoDeUsuarios().size() == 1)) ; 
	}
	
	//TODO: hay que hacer otro many to many a las recetas del grupo
	 @Transient
		public ArrayList<Receta> getRecetasDelGrupo(){
			// coleccion de las recetas  los integrantes del grupo
			ArrayList<Receta> recetasDelGrupo = new ArrayList<Receta>();
			
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.getGrupoDeUsuarios();

		      for(Usuario integrante : usuarios ){
		    	 
		    	  recetasDelGrupo.addAll(integrante.getRecetario().getListaRecetas()); 
		      }
			
			return recetasDelGrupo; 
		}

	
		public Set<GrupoUsuarios> buscarGrupo(String unNombre){
			
			 Set<GrupoUsuarios> gruposEncontrados =  new HashSet<GrupoUsuarios>();

				 		
				 		Session session = HibernateConf.getSessionFactory().openSession();
				 
				 		Query query = session.createQuery("FROM Receta e where e.nombreDeGrupo = :nombre");
				 
				 		query.setString("nombre", unNombre);
				 		
				 		java.util.List<?> lista = query.list();
				 		
				 	 gruposEncontrados = (Set<GrupoUsuarios>) lista;
				 
				 
			  return gruposEncontrados;
		}
		
		public void guardarGrupo(GrupoUsuarios unGrupo) {
			// TODO: revisar este metodo para que guarde todos los campos....

			// Configuration con = new Configuration();
			// con.configure("hibernate.cfg.xml");
			// SessionFactory SF = con.buildSessionFactory();
			// Session session = SF.openSession();
			// Session session = HibernateConf.getSessionFactory().openSession();
			// Session session = HibernateConf.getSessionFactory().openSession();
			Session session = HibernateConf.getSessionFactory().openSession();
			session.beginTransaction();

			//Usuario nuevoUsuario = new Usuario();
			//String nombre = unUsuario.getNombreUsuario().toU;
			 //unUsuario.setIdUsuario(unUsuario.getIdUsuario());
			//nuevoUsuario.setNombreUsuario(nombre);
			// nuevoUsuario.setAltura(unUsuario.getAltura());
			// nuevoUsuario.setComplexion(unUsuario.getComplexion());
			// nuevoUsuario.setFecha_nacimiento(unUsuario.getFecha_nacimiento());
			// nuevoUsuario.setSexo(unUsuario.getSexo());
			// nuevoUsuario.setEdad(unUsuario.getEdad());
			// nuevoUsuario.setPassword(unUsuario.getPassword());

			// Transaction TR = session.beginTransaction();
			// session.save(unUsuario);
			// System.out.println("Object Saved Succesfully"); // Si imprime es
			// porque persisti� ok el objeto
			// TR.commit();
			// session.close();
			// SF.close();

			session.save(unGrupo);
			session.getTransaction().commit();
			System.out.println("Done");
			session.close();
			// factory.close();

		}
		
		
		@Transient
		public List<String> getListaPiramide() {
			return listaPiramide;
		}

		public void setListaPiramide(List<String> listaPiramide) {
			this.listaPiramide = listaPiramide;
		}

		public void setIdGrupo(int idGrupo) {
			this.idGrupo = idGrupo;
		}

		public void setGrupoDeUsuarios(Set<Usuario> grupoDeUsuarios) {
			this.grupoDeUsuarios = grupoDeUsuarios;
		}
	

}