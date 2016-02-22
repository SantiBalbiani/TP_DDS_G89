package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import receta.Condimento;
import receta.Ingrediente;
import usuario.Usuario;

/**
 * Servlet implementation class ABM_CONDIMENTO
 */
@WebServlet("/ABM_CONDIMENTO")
public class ABM_CONDIMENTO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABM_CONDIMENTO() {
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
		String crearCondimento = request.getParameter("esCrearCondimento");
		//nota en los otros formularios que llamen a este servlet, agregar un hidden con esta variable seteada en "no"
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		HttpSession session = request.getSession(true);
		
		if (crearCondimento.equals("si"))
		{
			//creo un ingrediente...
			String nombreCondimento = request.getParameter("inputNombre");
			String tipoCondimento = request.getParameter("inputTipo");
						
			
			Condimento unCondimento = new Condimento();
			unCondimento = unCondimento.crearCondimento(nombreCondimento, tipoCondimento);
			unCondimento.guardarCondimento(unCondimento);
			
			//TODO: decirle a emiliano una vez que este bien puesta la pagina en el front, que ponga las alertas de "se creo ok condimento"...
			response.sendRedirect("listadoDeRecetas.jsp");	//Adaptar esta web page...
		}
		else
		{
		
		//no hace nada..... por ahora! despues eliminaria y/o modificaria---
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
		}
	}

}
