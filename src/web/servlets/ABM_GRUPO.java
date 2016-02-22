package web.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usuario.Usuario;
import usuario.GrupoUsuarios;

/**
 * Servlet implementation class ABM_GRUPO
 */
@WebServlet("/ABM_GRUPO")
public class ABM_GRUPO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABM_GRUPO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String esGrupo = request.getParameter("esGrupo");

		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		Set<GrupoUsuarios> grupos = (Set<GrupoUsuarios>) request.getSession().getAttribute("gruposDelUsuario");
		HttpSession session = request.getSession(true);
		
		
		
		if (esGrupo.equals("crear"))		//crearGRupo
		{
			//CREO el grupo
			String crearGrupo = request.getParameter("crearGrupo");
			usuario.GrupoUsuarios grupoNuevo = new usuario.GrupoUsuarios ();
			grupoNuevo.darAltaGrupo(usuarioActual, crearGrupo);
			//usuarioActual.getUserGrupo().add(grupoNuevo);
			grupoNuevo.guardarGrupo(grupoNuevo);
			
			
			grupos.add(grupoNuevo);
			usuarioActual.getUserGrupo().add(grupoNuevo);
			
			session.setAttribute("modificoGrupo", "yes");
			response.sendRedirect("misGrupos.jsp");
		}
		
		if (esGrupo.equals("salir"))		//El usuario quiere salir del grupo...
		{
			//lo saco del grupo
			String salirGrupo = request.getParameter("salirGrupo");
			usuario.GrupoUsuarios grupoViejo = new usuario.GrupoUsuarios ();
			//grupoViejo = grupoViejo.buscarGrupoPorNombre(salirGrupo);
			
			
			try{
				grupoViejo = grupoViejo.buscarGrupoPorNombre(salirGrupo);
			
				if (grupoViejo!=null) {
				//session.setAttribute("recetaEncontrada", recetaBuscada);
				grupoViejo.salirGrupo(usuarioActual);
				//grupos.remove(grupoViejo);	//lo elimino tmb de la isntancia local..! :)
				
				 Set<GrupoUsuarios> gruposActualizacion =  new HashSet<GrupoUsuarios>();
				 gruposActualizacion =usuarioActual.getUserGrupo();
				
				for (GrupoUsuarios c : gruposActualizacion)
				{
					if (c.getNombreDeGrupo().equals(salirGrupo))
						gruposActualizacion.remove(c);
				}
				
				usuarioActual.setUserGrupo(gruposActualizacion);
			
				session.setAttribute("salioGrupo", "yes");
				//session.setAttribute("usuario", usuarioActual);	//por si las dudas...
				response.sendRedirect("misGrupos.jsp");
				}
				else
				{
					session.setAttribute("errorBusquedaG", "yes");
					response.sendRedirect("misGrupos.jsp");
				}
			}catch(Throwable Exception){
				System.out.println(Exception);
			}
			
			//grupos.add(grupoNuevo);
			//usuarioActual.getUserGrupo().add(grupoNuevo);
			
			//session.setAttribute("modificoGrupo", "yes");
			//response.sendRedirect("misGrupos.jsp");
		}
		
		
		
		//doGet(request, response);
	}

}
