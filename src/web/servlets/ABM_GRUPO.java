package web.servlets;

import java.io.IOException;
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
		
		String esCrearGrupo = request.getParameter("esCrearGrupo");
		String crearGrupo = request.getParameter("crearGrupo");
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		Set<GrupoUsuarios> grupos = (Set<GrupoUsuarios>) request.getSession().getAttribute("gruposDelUsuario");
		HttpSession session = request.getSession(true);
		
		
		
		if (esCrearGrupo.equals("si"))
		{
			//CREO el grupo
			usuario.GrupoUsuarios grupoNuevo = new usuario.GrupoUsuarios ();
			grupoNuevo.darAltaGrupo(usuarioActual, crearGrupo);
			//usuarioActual.getUserGrupo().add(grupoNuevo);
			grupoNuevo.guardarGrupo(grupoNuevo);
			
			
			grupos.add(grupoNuevo);
			usuarioActual.getUserGrupo().add(grupoNuevo);
			
			session.setAttribute("modificoGrupo", "yes");
			response.sendRedirect("misGrupos.jsp");
		}
		
		
		
		//doGet(request, response);
	}

}
