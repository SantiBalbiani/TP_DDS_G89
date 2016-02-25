package usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateConf;
import receta.Receta;

@Entity
@Table(name = "GRUPO")
public class GrupoUsuarios {

	private int idGrupo;

	private String nombreDeGrupo;
	private  Set<Usuario> grupoDeUsuarios= new HashSet<Usuario>(0);// Para EL MANY TO MANY DE USUARIO-GRUPO
	private Usuario administrador;
	
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
	//@Transient
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "adminGrupo")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADMIN", nullable = false)
	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario unAdministrador) {
		administrador = unAdministrador;
	}
	
	public Set<Usuario> crearGrupo(){

		Set<Usuario> grupoDeUsuarios = new HashSet<Usuario>();
		return grupoDeUsuarios;
	
	}
	
	//********ACA HACER MANY TO MANY********
	public  Set<Usuario>   obtenerGrupo(){
		
		return grupoDeUsuarios;
	}
	

//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "userGrupo")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_por_grupo", joinColumns = { // agregar
																// catalogo de
																// ser
																// necesario...
			@JoinColumn(name = "ID_GRUPO", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_USER", nullable = false, updatable = false) })
	public Set<Usuario> getGrupoDeUsuarios() {
		return this.grupoDeUsuarios;
	}
	
	
	public void ingresarGrupo(Usuario unUsuario){
	 
		this.getGrupoDeUsuarios().add(unUsuario);	
		 
	}
	
	public void ingresarUsuarioAGrupo(Usuario unUsuario){
		 
		this.getGrupoDeUsuarios().add(unUsuario);
		
//		//TODO: evaluar cambiar en guardarGrupo por saveOrUpdate para evitar duplicar codigo...
//		GrupoUsuarios grupos = new GrupoUsuarios();
//		grupos = this;
		
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		//Session sessionHIB = HibernateConf.getSessionFactory().);
		sessionHIB.beginTransaction();
		//sessionHIB.flush();
		//sessionHIB.clear();
		sessionHIB.saveOrUpdate(this);
		sessionHIB.getTransaction().commit();
		System.out.println("Done");
		sessionHIB.close();
		
//		Session sessionHIB = null ; 
//	    Transaction tran = null;
//	    try {
//	        sessionHIB = HibernateConf.getSessionFactory().getCurrentSession();        
//	        tran =  sessionHIB.beginTransaction();
//	        sessionHIB.saveOrUpdate(this);
//	        sessionHIB.flush();
//	        tran.commit();
//	    } catch(Exception ex ) {
//	       // ex.printstacktrance(); 
//	    	System.out.println("Error");
//	    }
		 
	}
	
	public void salirGrupo( Usuario  unUsuario){

		this.getGrupoDeUsuarios().remove(unUsuario);
		//unUsuario.getUserGrupo().remove(this);

		// ADEMAS LO ELIMINO DE LA BD...
		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
		sessionHIB.getTransaction().begin();

		String sql_query = "delete from usuario_por_grupo   where ID_USER = :idUser and ID_GRUPO = :idGrupo" ;

		Query query = sessionHIB.createSQLQuery(sql_query);
		query.setParameter("idUser", unUsuario.getIdUsuario());
		query.setParameter("idGrupo", this.getIdGrupo());

		query.executeUpdate();
		sessionHIB.flush();
		sessionHIB.clear();
		sessionHIB.getTransaction().commit();
		System.out.println("Done");
		sessionHIB.close();
		
		//TODO: REVISAR SI ERA EL ULTIMO USUARIO QUE ELIMINE EL GRUPO Y ADEMAS QUE SI ERA ADMINISTRADOR, LE ASIGNE SER ADMINISTRADOR A OTRO.

	}
	
	public void darAltaGrupo(Usuario unUsuario, String unNombreDeGrupo)
	{
		//Agrego el setter en este metodo, evaluar ponerlo dentro de crearGrupo...
		this.grupoDeUsuarios = this.crearGrupo();
		this.ingresarGrupo(unUsuario);
		this.setNombreDeGrupo(unNombreDeGrupo);
		this.setAdministrador(unUsuario);
		
		//this.guardarGrupo(this);
	}
	
	@Column(name = "NOMBRE")
	public String getNombreDeGrupo() {
		return nombreDeGrupo;
	}

	public void setNombreDeGrupo(String unNombreDeGrupo){
		this.nombreDeGrupo =unNombreDeGrupo;
	}

	
	public void eliminarGrupo( Usuario  admin){

		if(this.puedeEliminarGrupo(admin)){
			this.salirGrupo(admin);	
		
				Session sessionHIB = HibernateConf.getSessionFactory().openSession();
				sessionHIB.getTransaction().begin();
				
				String sql_query = "delete from GRUPO  where ID_GRUPO = :idGrupo";
				//TODO: me parece que hace falta borrar la tabla intermedia... usuario_por_grupo
				
				Query query = sessionHIB.createSQLQuery(sql_query);
				query.setParameter("idGrupo", this.getIdGrupo());

				
				query.executeUpdate();
				sessionHIB.getTransaction().commit();
				System.out.println("Done");
				sessionHIB.close();
		
		}
		}
	
	public boolean puedeEliminarGrupo(Usuario usuario){
		
		//TODO: EN DB PODRIA COMPARAR LOS IDS DE USUARIO, SETEADO ADMNISTRADOR EL ID DEL CREADOR DEL GRUPO
		return ((this.getAdministrador().equals(usuario)) && (this.getGrupoDeUsuarios().contains(usuario)) && (this.getGrupoDeUsuarios().size() == 1)) ; 
	}
	

	 @Transient
		public ArrayList<Receta> getRecetasDelGrupo(){
			// coleccion de las recetas  los integrantes del grupo
			ArrayList<Receta> recetasDelGrupo = new ArrayList<Receta>();
			
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.getGrupoDeUsuarios();

		      for(Usuario integrante : usuarios ){
		    	 
		    	  recetasDelGrupo.addAll(integrante.getRecetasUser()); 
		      }
			
			return recetasDelGrupo; 
		}

	
		public Set<GrupoUsuarios> buscarGrupo(String unNombre){
			
			Session sessionHIB = HibernateConf.getSessionFactory().openSession();
			
			
			try {
			 
		
				Set<GrupoUsuarios> gruposEncontrados =  new HashSet<GrupoUsuarios>();
				 		
				 		
				 
				 		Query query = sessionHIB.createQuery("FROM GrupoUsuarios e where e.nombreDeGrupo = :nombre");
				 
				 		query.setString("nombre", unNombre);
				 		
				 		java.util.List<?> lista = query.list();
				 		
				 	 gruposEncontrados = (Set<GrupoUsuarios>) lista;
				 
				 	
			  return gruposEncontrados;
		}catch(Throwable theException) 	  {
			return null;
			//DO something
		}finally {
			sessionHIB.getTransaction().commit();
			System.out.println("Done");
			sessionHIB.close();
		}
		}
		
		
		
		public GrupoUsuarios buscarGrupoPorNombre(String unNombre){
			
			Session sessionHIB = HibernateConf.getSessionFactory().openSession();
			try
			{
			 Set<GrupoUsuarios> gruposEncontrados =  new HashSet<GrupoUsuarios>();

				 		
				 		
				 
				 		Query query = sessionHIB.createQuery("FROM GrupoUsuarios e where e.nombreDeGrupo = :nombre");
				 
				 		query.setString("nombre", unNombre);
				 		
				 		java.util.List<?> lista = query.list();
				 		
				 	// gruposEncontrados = (Set<GrupoUsuarios>) lista;
				 
				 	if (!lista.isEmpty())
					{
				GrupoUsuarios grupoBuscado = (GrupoUsuarios)lista.get(0);
				//sessionHIB.getTransaction().commit();
				return grupoBuscado;
					}
					else
						return null;
					}
					catch(Throwable Exception){
						System.out.println(Exception);
						return null;
					}finally {
						//sessionHIB.getTransaction().commit();
						System.out.println("Done");
						sessionHIB.close();
					}
				}
				 
			 // return gruposEncontrados;
		
		
		
		
		public void guardarGrupo(GrupoUsuarios unGrupo) {
			// TODO: revisar este metodo para que guarde todos los campos....

			// Configuration con = new Configuration();
			// con.configure("hibernate.cfg.xml");
			// SessionFactory SF = con.buildSessionFactory();
			// Session sessionHIB = SF.openSession();
			// Session sessionHIB = HibernateConf.getSessionFactory().openSession();
			// Session sessionHIB = HibernateConf.getSessionFactory().openSession();
			Session sessionHIB = HibernateConf.getSessionFactory().openSession();
			sessionHIB.beginTransaction();

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

			// Transaction TR = sessionHIB.beginTransaction();
			// sessionHIB.save(unUsuario);
			// System.out.println("Object Saved Succesfully"); // Si imprime es
			// porque persisti� ok el objeto
			// TR.commit();
			// sessionHIB.close();
			// SF.close();

			sessionHIB.save(unGrupo);
			sessionHIB.getTransaction().commit();
			System.out.println("Done");
			sessionHIB.close();
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
		
//		public static Set<GrupoUsuarios> buscarGruposDelUsuario(Usuario unUsuario){
//			
//			 Set<GrupoUsuarios> gruposEncontrados =  new HashSet<GrupoUsuarios>();
//
//				 		
//				 		Session sessionHIB = HibernateConf.getSessionFactory().openSession();
//				 
//				 		Query query = sessionHIB.createQuery("FROM usuario.GrupoUsuarios e join usuario.Usuario r where r.idUsuario = :idUser");
//				 
//				 		query.setString("idUser", String.valueOf(unUsuario.getIdUsuario()));
//				 		
//				 		java.util.List<?> lista = query.list();
//				 		
//				 	 gruposEncontrados = (Set<GrupoUsuarios>) lista;
//				 
//				 
//			  return gruposEncontrados;
//		}

}