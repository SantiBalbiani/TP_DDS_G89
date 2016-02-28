package web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import receta.Receta;

/**
 * Servlet implementation class ListarRecetasEncontradas
 */
@WebServlet("/ListarRecetasEncontradas")
public class ListarRecetasEncontradas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nombreReceta;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRecetasEncontradas() {
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
		HttpSession session = request.getSession(true);
		
		
		nombreReceta = request.getParameter("buscar_nombreReceta");
		Receta recetaBuscada = new Receta();
		
		List<Receta> recetasBuscadas;
		
		try{
			
			recetasBuscadas = recetaBuscada.buscarRecetasPorNombre(nombreReceta);
		
			if (recetaBuscada!=null) {
			session.setAttribute("recetasEncontradas", recetasBuscadas);
		
			response.sendRedirect("listadoDeRecetas.jsp");
			}
			else
			{
				session.setAttribute("errorBusqueda", "yes");
				response.sendRedirect("welcome.jsp");
			}
		}catch(Throwable Exception){
			System.out.println(Exception);
		}
		
	}
}


