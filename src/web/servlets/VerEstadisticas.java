package web.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import estadisticas.Estadisticas;
import receta.Receta;
import usuario.Usuario;

/**
 * Servlet implementation class VerEstadisticas
 */
@WebServlet("/VerEstadisticas")
public class VerEstadisticas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerEstadisticas() {
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
		
		HttpSession session = request.getSession(true);
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		
		String esReporte = request.getParameter("esReporte");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		
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
			
			if (esReporte.equals("newEntreFechas"))
			{
				String minDate = request.getParameter("newReceta1");
				String maxDate = request.getParameter("newReceta2");
				
				//Date date = formatter.parse(dateInString);
				//Date minfechaN0 = formatter.parse(minDate);
				//Date maxfechaN0 = formatter.parse(maxDate);
				//Date minfechaN = formatter.format(minfechaN0);
				//Date maxfechaN = formatter.format(maxfechaN0);
				
				Estadisticas unasEstadisticas = new Estadisticas();
				
				
			
				Date minDateN0 = unasEstadisticas.parserFechas(minDate);
				Date maxDateN0 = unasEstadisticas.parserFechas(maxDate);
				//Date minfechaN = unasEstadisticas.obtenerFechaInicial(minDateN0);
				//Date maxfechaN = unasEstadisticas.obtenerFechaActual(maxDateN0);
				
				List<Receta> recetasNewEntre = unasEstadisticas.reporteRecetasNuevasEntre(minDateN0, maxDateN0);
								
				session.setAttribute("listaNewEntreFechas", recetasNewEntre);
					
				response.sendRedirect("verNewRecetasEntre.jsp");
			}
			
			
		}catch(Throwable Exception){
			System.out.println(Exception);
		}
		
		System.out.println("no entro al try");
		
		
		
		
	}
	}


