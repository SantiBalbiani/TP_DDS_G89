package web.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import estadisticas.Planificacion;
import receta.Receta;
import receta.TipoReceta;
import usuario.GrupoUsuarios;
import usuario.Usuario;

/**
 * Servlet implementation class PlanificarComidas
 */
@WebServlet("/PlanificarComidas")
public class PlanificarComidas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanificarComidas() {
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
		String esPlanificacion = request.getParameter("esPlanificacion");
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		HttpSession session = request.getSession(true);
		
		
		if (esPlanificacion.equals("planificacion"))		//creo Planificacion
		{
			//levanto atributos front - mapeo receta si la encuentra... - mapeo tipoReceta .. valido - guardo la nueva planificacion y vuelvo a la pagina... -mostrar alerta.
			String planFecha = request.getParameter("planFecha");
			String planNombre = request.getParameter("planNombre");
			String planTipo = request.getParameter("planTipo");
			
			
			Receta recetaBuscada = new Receta();
			
			try{
				recetaBuscada = recetaBuscada.buscarRecetaPorNombre(planNombre);
			
				if (recetaBuscada!=null) {	//encontro la receta por nombre
					TipoReceta unNuevoTipo = new TipoReceta();
					unNuevoTipo = unNuevoTipo.buscarTipoRecetaPorNombre(planTipo);
					if (unNuevoTipo!=null){	//encontro el tipo
						//guardo la planificacion...
						
						Planificacion nuevaPlanificacion = new Planificacion();
						
						
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //;
						Date date = new Date();
						try {
							date = formatter.parse(planFecha);
						} catch (ParseException e) {
							 
							e.printStackTrace();
						}
						nuevaPlanificacion.setFecha(date);
						
						
						
						nuevaPlanificacion.setReceta(recetaBuscada);
						nuevaPlanificacion.setUnTipoDeReceta(unNuevoTipo);
						nuevaPlanificacion.setUsuario(usuarioActual);
						nuevaPlanificacion.guardarPlanificacion(nuevaPlanificacion);
						
						session.setAttribute("planificacionOK", "yes");
						response.sendRedirect("planificar.jsp");
						
					}else
					{
						session.setAttribute("errorBusqueda", "yes");
						response.sendRedirect("planificar.jsp");
					}

												
				}
				else
				{
					session.setAttribute("errorBusqueda", "yes");
					response.sendRedirect("planificar.jsp");
				}
			}catch(Throwable Exception){
				System.out.println(Exception);
			}
			
			
			

		}
	}

}
