package web.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import receta.Receta;
import usuario.GrupoUsuarios;
import usuario.Usuario;

/**
 * Servlet implementation class BM_RECETA
 */
@WebServlet("/BM_RECETA")
public class BM_RECETA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BM_RECETA() {
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
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String BM_RECETA = request.getParameter("BM_RECETA");

		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		//Set<GrupoUsuarios> grupos = (Set<GrupoUsuarios>) request.getSession().getAttribute("gruposDelUsuario");
		HttpSession session = request.getSession(true);
		
		
		
		if (BM_RECETA.equals("calificar"))		//calificarReceta
		{
			String receta_calificar = request.getParameter("receta_calificar");
			Receta recetaBuscada = new Receta();
			
			try{
				recetaBuscada = recetaBuscada.buscarRecetaPorNombre(receta_calificar);
				System.out.println(recetaBuscada.getNombreReceta());

			
				if (recetaBuscada!=null) {
				//session.setAttribute("recetaEncontrada", recetaBuscada);
					String rating = request.getParameter("rating");
					int rating_ok = Integer.parseInt(rating);
					recetaBuscada.calificar(rating_ok);
					recetaBuscada.modificarReceta(recetaBuscada);
					
					session.setAttribute("calificoOK", "yes");
					response.sendRedirect("verReceta.jsp");
					
				}else
				{
					session.setAttribute("errorBusqueda", "yes");
					response.sendRedirect("verReceta.jsp");
				}
			}catch(Throwable Exception){
				System.out.println(Exception);
			}
		}
	}

}
