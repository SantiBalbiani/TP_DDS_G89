package web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import estadisticas.Estadisticas;
import receta.Condimento;
import receta.Receta;
import usuario.Usuario;

/**
 * Servlet implementation class ReporteRecetas
 */
@WebServlet("/ReporteRecetas")
public class ReporteRecetas extends HttpServlet {
	private static final long serialVersionUID = 1L;
   // private String reporte; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteRecetas() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		//levantar cosas. session, usuarios, variables form (como strings), parses, llamar metodo,
		// try/catch, no vacia. 
		//sesion y setparameter
		//getparameter
		
		HttpSession session = request.getSession(true);
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		
		String esReporte = request.getParameter("esReporte");
		
		
		
		//llamar al metodo , estadisticas.reporteRecetasNuevasEntre(min,max);
		
		try {
			
			if (esReporte.equals("entreCalorias"))
			{
				String minCals = request.getParameter("MinCal");
				String maxCals = request.getParameter("MaxCal");
				
				int minCal = Integer.parseInt(minCals);
				int maxCal = Integer.parseInt(maxCals);	
				
				Estadisticas unasEstadisticas = new Estadisticas();
					
					List<Receta> recetasPorCalorias = unasEstadisticas.reporteRecetasPorCalorias(minCal, maxCal);
								
					session.setAttribute("listaEntreCals", recetasPorCalorias);
					
					response.sendRedirect("verRecetasPorCalorias.jsp");
			}
			
			
		}catch(Throwable Exception){
			System.out.println(Exception);
		}
		
		System.out.println("no entro al try");
		
		
		
		
	}

}
