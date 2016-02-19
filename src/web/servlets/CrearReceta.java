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
		
		
		String nombreReceta = request.getParameter("nombreDeReceta");
		String ingPrincipal = request.getParameter("ingPrincipal");
		String preparacion = request.getParameter("preparacion");
		String categorias = request.getParameter("optionCategoria");
		String dificultad = request.getParameter("dificultad");
		String sector = request.getParameter("sector");
		String calorias = request.getParameter("caloriasIngPpal");
		String ingredientes = request.getParameter("Ingredientes");
		Receta nuevaReceta = new Receta();
		
		//Buscar ingrediente principal
		
		Ingrediente ingredPpal = new Ingrediente();
		//TODO: arreglar esto
		ingredPpal.buscarIngredientePorNombre("unChori");
		
		Condimento cond = new Condimento();
		cond = cond.buscarCondimentoPorNombre("mostaza");
		
		int sectorPiramide = Integer.parseInt(sector);
		int caloriasIP = Integer.parseInt(calorias);
		
		nuevaReceta.agregarIngredientePrincipal(ingredPpal);
		nuevaReceta.setNombreReceta(nombreReceta);
		//nuevaReceta.setListaCategoria(listaCategoria);
		int dificult = 0;
		if (dificultad == "F"){
			dificult = 1;
		}
		if (dificultad == "M"){
			dificult = 2;
		}
		if (dificultad == "D"){
			dificult = 3;
		}
	
		System.out.println(nuevaReceta.getNombreReceta()+"   acaaaa");
		
		nuevaReceta.setNombreReceta(nombreReceta);
		nuevaReceta.setDificultadReceta(dificult);
		nuevaReceta.setCalificacion((short)0);
		nuevaReceta.setCalorias(caloriasIP);
		nuevaReceta.setDificultadReceta(dificult);
		nuevaReceta.setIngredientePrincipal(ingredPpal);
		nuevaReceta.setPreparacion(preparacion);
		nuevaReceta.setSectorPiramideAlimenticia((short)sectorPiramide);
		nuevaReceta.agregarUnIngrediente(ingredPpal);
		
		nuevaReceta.guardarReceta(nuevaReceta);

		
		session.setAttribute("recetaEncontrada", nuevaReceta);
		
		response.sendRedirect("verReceta.jsp");
		
		//Completar ingredientes y condimentos
		//nuevaReceta.crear_receta(ingredPpal, indexIngredientes, indexCondimentos, 0, caloriasIP, nombreReceta, preparacion, categorias, dificult, unaTemporada, sectorPiramide);
		//nuevaReceta.setSectorPiramideAlimenticia(sectorPiramideAlimenticia);
		
		
		
		//Ingrediente ingredientePrincipal = new Ingrediente();
//		ingredientePrincipal.crearIngrediente(ingPrincipal, null, unasCalorias);
		
//		receta.crear_receta(ingPrincipal, indexIngredientes, indexCondimentos, calificacion, calorias, unNombre, unaPreparacion, unaCategoria, unaDificultad, unaTemporada, unSectorPiramide)
	}

}
