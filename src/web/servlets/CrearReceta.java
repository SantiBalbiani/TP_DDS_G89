package web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;
import receta.Receta;
import receta.Ingrediente;
import receta.Condimento;

/**
 * Servlet implementation class CrearReceta
 */
@WebServlet("/CrearReceta")
public class CrearReceta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearReceta() {
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
		
		Ingrediente ingredPpal = new Ingrediente();
		Condimento unCondimento = new Condimento();
		
		java.util.List<Condimento> todosloscondimentos = unCondimento.obtenerTodoslosCondimentos();
		
		java.util.List<Ingrediente> todoslosingredientes = ingredPpal.obtenerTodoslosIngredientes();
		
		Set<Condimento> todosloscond = (Set<Condimento>)todosloscondimentos; 
		Set<Ingrediente> todosLosIng = (Set<Ingrediente>)todoslosingredientes;
		
		session.setAttribute("todosLosIngredientes",todosLosIng);
		session.setAttribute("todosLosCondimentos", todosloscondimentos);
		
		String nombreReceta = request.getParameter("nombreReceta");
		String ingPrincipal = request.getParameter("ingPrincipal");
		String preparacion = request.getParameter("preparacion");
		String categorias = request.getParameter("optionCategoria");
		String dificultad = request.getParameter("dificultad");
		String sector = request.getParameter("sector");
		
		Receta receta = new Receta();
		
		//Buscar ingrediente principal
		
		ingredPpal.buscarIngredientePorNombre(ingPrincipal);
		
		Receta nuevaReceta = new Receta();
		
		nuevaReceta.agregarIngredientePrincipal(ingredPpal);
		nuevaReceta.setNombreReceta(nombreReceta);
		//nuevaReceta.setListaCategoria(listaCategoria);
		int dificult = Integer.parseInt(dificultad);
		
		nuevaReceta.setDificultadReceta(dificult);
		
		//nuevaReceta.setSectorPiramideAlimenticia(sectorPiramideAlimenticia);
		
		
		
		//Ingrediente ingredientePrincipal = new Ingrediente();
//		ingredientePrincipal.crearIngrediente(ingPrincipal, null, unasCalorias);
		
//		receta.crear_receta(ingPrincipal, indexIngredientes, indexCondimentos, calificacion, calorias, unNombre, unaPreparacion, unaCategoria, unaDificultad, unaTemporada, unSectorPiramide)
	}

}
