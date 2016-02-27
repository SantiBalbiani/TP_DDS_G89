package web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import receta.Condimento;
import receta.Ingrediente;
import receta.Receta;
import usuario.GrupoUsuarios;
import usuario.Usuario;

/**
 * Servlet implementation class LogIn
 */


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*try
		{*/	    
			String nombreUsuario = (request.getParameter("inputUsuario")).toUpperCase();
			String contrasenia = (request.getParameter("inputPassword")).toUpperCase();
			Usuario user = new Usuario();
			
			user = user.buscarUsuarioPorNombre(nombreUsuario);
			
	    	//Validar si existe el usuario
	    	//Buscar las primeras 3 recetas para mostrar
			//Buscar los grupos a los que pertenece
			//Buscar las recomendaciones
			
			if(nombreUsuario.equals(user.getNombreUsuario()) && contrasenia.equals(user.getPassword())){
		         HttpSession session = request.getSession(true);	    
		         session.setAttribute("currentSessionUser", nombreUsuario);
		         
		         user.setNombreUsuario(nombreUsuario);

		         Set<Receta> listaRecetas = new HashSet<Receta>();
		         listaRecetas = user.recetas_ejemplo();
		         
		         Set<GrupoUsuarios> grupos = new HashSet<GrupoUsuarios>();
		         
		         //Ejemplos de grupos
		        usuario.GrupoUsuarios grupo1 = new usuario.GrupoUsuarios ();
		        usuario.GrupoUsuarios grupo2 = new usuario.GrupoUsuarios ();

		        grupo1.setNombreDeGrupo("Felinos Cosmicos");
   		 		grupo1.setAdministrador(user);
   		 		//grupo1.ingresarGrupo(user);
   		 		grupo1.getGrupoDeUsuarios().add(user);
   		 		grupos.add(grupo1);
		 		
   		 		grupo2.setNombreDeGrupo("Utnianos");
 		 		grupo2.setAdministrador(user);
 		 		grupo2.getGrupoDeUsuarios().add(user);
 		 		//grupo2.ingresarGrupo(user);
 		 		grupos.add(grupo2);
		 		 
		         Set<Ingrediente> ingredientes = new HashSet<Ingrediente>();
		         Ingrediente ingrediente = new Ingrediente();
		         //ingredientes = ingrediente.mostrarTodosLosIngredientes();
		         //TODO: revisar esto rompe
		         
		         Set<Condimento> condimentos = new HashSet<Condimento>();
		         Condimento condimento = new Condimento();
		         //condimentos = condimento.mostrarTodosLosCondimentos();
		       //TODO: revisar esto rompe
		         
		         session.setAttribute("recetas", listaRecetas);
		         session.setAttribute("errorBusqueda", "no");
		         session.setAttribute("modificoUsuario", "no");
		         session.setAttribute("modificoGrupo", "no");
		         session.setAttribute("creoReceta", "no");
		         session.setAttribute("errorBusquedaG", "no");
		         session.setAttribute("invitoGrupo", "no");
		         session.setAttribute("salioGrupo", "no");
		         session.setAttribute("seCreoOkCondimento", "no");
		         session.setAttribute("seCreoOkIngrediente", "no");
		         session.setAttribute("noPuedeEliminarGrupo", "no");
		         session.setAttribute("planificacionOK", "no");
		         session.setAttribute("eliminoGrupo", "no");
		         session.setAttribute("usuario", user);
		         session.setAttribute("gruposDelUsuario", grupos);
		       //TODO: revisar esto rompe
		         //session.setAttribute("todosLosIngredientes", ingredientes);
		         //session.setAttribute("todosLosCondimentos", condimentos);
		         
		         response.sendRedirect("welcome.jsp");
		     }else{    	 
		    	 response.sendRedirect("login.jsp?u=1");
		     }
		    	 
		} 
				
				/*
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		*/
	}


 