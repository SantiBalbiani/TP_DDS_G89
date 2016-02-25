package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import receta.Ingrediente;
import usuario.Usuario;

/**
 * Servlet implementation class ABM_INGREDIENTE
 */
@WebServlet("/ABM_INGREDIENTE")
public class ABM_INGREDIENTE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ABM_INGREDIENTE() {
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
		
		String crearIngrediente = request.getParameter("esCrearIngrediente");
		//nota en los otros formularios que llamen a este servlet, agregar un hidden con esta variable seteada en "no"
		//Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		HttpSession session = request.getSession(true);
		
		if (crearIngrediente.equals("si"))
		{
			//creo un ingrediente...
			String nombreIngrediente = request.getParameter("inputNombre");
			String caloriasIngrediente = request.getParameter("inputCalorias");
			String porcionIngrediente = request.getParameter("inputPorcion");
			
			//parsear los strings calorias y porcios a (int)
			int caloriasI = Integer.parseInt(caloriasIngrediente);
			int porcionI = Integer.parseInt(porcionIngrediente);
			
			
			Ingrediente unIngrediente = new Ingrediente();
			unIngrediente = unIngrediente.crearIngrediente(nombreIngrediente, (int)porcionI, (int)caloriasI);
			unIngrediente.guardarIngrediente(unIngrediente);
			
			session.setAttribute("seCreoOkIngrediente", "yes");
			response.sendRedirect("crearIngredientes.jsp");	//Adaptar esta web page...
		}
		else
		{
		
		//no hace nada..... por ahora! despues eliminaria y/o modificaria---
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
		}
	}

}
