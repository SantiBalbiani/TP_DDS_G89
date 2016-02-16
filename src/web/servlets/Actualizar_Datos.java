package web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usuario.Usuario;

/**
 * Servlet implementation class Actualizar_Datos
 */
@WebServlet("/Actualizar_Datos")
public class Actualizar_Datos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actualizar_Datos() {
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

//		---------------------------------------------------
//		Desde aca para abajo el codigo deberia ser el mismo que registrarse!
		String nombreUsuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String fechaNac = request.getParameter("fechaNacimiento");
		String altura = request.getParameter("altura");
		String sexo = request.getParameter("optionSexo");
		String complexion = request.getParameter("complexion");		
		String dieta = request.getParameter("dieta");		
		String rutina = request.getParameter("rutina");	
		
		//TODO: falta agregar: String preferencias_alimenticias, 
		//ejemplo de prueba compilar
		//Set<Integer> condPreexis;
		//condPreexis = new HashSet<Integer>();
		//condPreexis.add(1); //generico

		//TODO: hay que agregar preferencias alimenticias
		//nuevoUsuario.setPreferencias_alimenticias("algo");

		Usuario nuevoUsuario = new Usuario();
				
		//si el sexo es hombre que sea 'M' (Masculino) y 'F' (Femenino)
		char sexo_char = sexo.charAt(0);
		sexo_char = ((sexo_char=='M')|| (sexo_char=='F')) ? sexo_char : 'e';
		nuevoUsuario.setSexo(sexo_char);
		//el char e es de error...
		
		
		//String text = "192"; // example String.... recordar que es en centimetros
		double doubleAltura = Double.parseDouble(altura);
		nuevoUsuario.setAltura(doubleAltura);
//	---------------------------------------------------
//		Hasta aca para abajo el codigo deberia ser el mismo que registrarse!
		
		//TODO: agregar setparameter nuevoUsuario...
		nuevoUsuario.altaUsuario(nombreUsuario, sexo_char, fechaNac, complexion, doubleAltura , " ", dieta, rutina, password);
		nuevoUsuario.guardarUsuario(nuevoUsuario);
		
		response.sendRedirect("welcome.jsp");
		//response.sendRedirect("login.jsp");
	}
	
	

}
