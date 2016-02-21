package web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import receta.Receta;
import usuario.Usuario;
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
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		
		
		String nombreReceta = request.getParameter("nombreDeReceta");
		String ingPrincipal = request.getParameter("ingPrincipal");
		String preparacion = request.getParameter("preparacion");
		String categorias = request.getParameter("optionCategoria");
		String dificultad = request.getParameter("dificultad");
		String sector = request.getParameter("sector");
		String calorias = request.getParameter("caloriasIngPpal");
		//String ingredientes = request.getParameter("Ingredientes");
		
		
		//aca levanto los ingredientes secundarios del front!
		String spanIngrediente = request.getParameter("ingredientesDRAGdrop");
		//nota spanIngrediente recibe los nombres de los ingredientes y los tenemos que trabajar, estan separados por valores clave...
		//TODO: hacer una funcion para trabajar el string recibido por las palabras clave...
		
		spanIngrediente = spanIngrediente.replaceAll("\n", "");
		
		spanIngrediente = spanIngrediente.replaceAll("\r", "");
		
		Set<String> listIngredSinToken = new HashSet<String>(0);
		StringTokenizer tokens =new StringTokenizer(spanIngrediente, "&");
		
		while(tokens.hasMoreTokens()){
			listIngredSinToken.add(tokens.nextToken());
		}
		
		Set<Ingrediente> ingredientesSecundarios;
		
		ingredientesSecundarios = listIngredSinToken.stream().map(ing -> Ingrediente.buscarIngredientePorNombre2(ing)).collect(Collectors.toSet());
		
		//desde aca levanto los condimentos desde el front...
		String spanCondimento = request.getParameter("condimentosDRAGdrop");
		//nota spanIngrediente recibe los nombres de los ingredientes y los tenemos que trabajar, estan separados por valores clave...
		//TODO: hacer una funcion para trabajar el string recibido por las palabras clave...
		
		spanCondimento = spanCondimento.replaceAll("\n", "");
		
		spanCondimento = spanCondimento.replaceAll("\r", "");
		
		Set<String> listCondSinToken = new HashSet<String>(0);
		StringTokenizer tokensCond =new StringTokenizer(spanCondimento, "&");
		
		while(tokensCond.hasMoreTokens()){
			listCondSinToken.add(tokensCond.nextToken());
		}
		
		Set<Condimento> condimentosSecundarios;
		
		condimentosSecundarios = listCondSinToken.stream().map(cond -> Condimento.buscarCondimentoPorNombre2(cond)).collect(Collectors.toSet());
		
		
		
		//desde aca sigue con toda la asignacion de la receta nueva
		
		//out.println(spanIngrediente);
		Receta nuevaReceta = new Receta();
		

		for(Ingrediente ingrediente : ingredientesSecundarios){
			
			nuevaReceta.agregarUnIngrediente(ingrediente);
			
		}
		
		for(Condimento condimento : condimentosSecundarios){
			
			nuevaReceta.agregarCondimento(condimento);
			
		}
		
		//Buscar ingrediente principal
		
		Ingrediente ingredPpal = new Ingrediente();
		//TODO: arreglar esto
		ingredPpal = ingredPpal.buscarIngredientePorNombre(ingPrincipal);
		
//		Condimento cond = new Condimento();
//		cond = cond.buscarCondimentoPorNombre("mostaza");
//		
//		Condimento cond2 = new Condimento();
//		cond2 = cond2.buscarCondimentoPorNombre("KETCHUP");
		
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
	
	
		
		nuevaReceta.setNombreReceta(nombreReceta);
		nuevaReceta.setDificultadReceta(dificult);
		nuevaReceta.setCalificacion((short)0);
		nuevaReceta.setCalorias(caloriasIP);
		nuevaReceta.setDificultadReceta(dificult);
		nuevaReceta.setIngredientePrincipal(ingredPpal);
		nuevaReceta.setPreparacion(preparacion);
		nuevaReceta.setSectorPiramideAlimenticia((short)sectorPiramide);
		//nuevaReceta.agregarUnIngrediente(ingredPpal); Lo remuevo porque el ing principal no tiene que ser parte de los secundarios
		//nuevaReceta.agregarCondimento(cond);
		//nuevaReceta.agregarCondimento(cond2);
		
//		Ingrediente ingPrueba = new Ingrediente();
//		
//		ingPrueba = ingPrueba.buscarIngredientePorNombre("Pollo");
//		
//		nuevaReceta.agregarUnIngrediente(ingPrueba);
		
		nuevaReceta.getUsuarioRecetas().add(usuarioActual);
		
		
		
		
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
