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
				
		String eliminarUsuario = request.getParameter("esEliminarUsuario");
		
		if (eliminarUsuario.equals("si"))
		{
			System.out.println("holafdafdasfdsafafdasfdasfsafsa");
		}
		else
		{
		
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		//(Integer)req.getSession().getAttribute("variable");
		//out.println(user.getNombreUsuario());
		
//		---------------------------------------------------
//		Desde aca para abajo el codigo deberia ser el mismo que registrarse!
		
		//String nombreUsuario = request.getParameter("usuario");
		String password = request.getParameter("inputPassword");
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

//		Usuario nuevoUsuario = new Usuario();
		
		//si el sexo es hombre que sea 'M' (Masculino) y 'F' (Femenino)
		char sexo_char = sexo.charAt(0);
		sexo_char = ((sexo_char=='M')|| (sexo_char=='F')) ? sexo_char : 'e';
		//el char e es de error...
		
		
		//String text = "192"; // example String.... recordar que es en centimetros
		double doubleAltura = Double.parseDouble(altura);
//	---------------------------------------------------
//		Hasta aca para abajo el codigo deberia ser el mismo que registrarse!
		
		usuarioActual.setAltura(doubleAltura);
		usuarioActual.setSexo(sexo_char);
		usuarioActual.setFecha_nacimiento(fechaNac);
		usuarioActual.setComplexion(complexion);
		usuarioActual.setDieta(dieta);
		usuarioActual.setRutina(rutina);
		
		
		if (this.noEsStringVacio(password))
		{
			usuarioActual.setPassword(password);
		}

		//TODO: revisar si cambio la contraseña y segun eso la cambia o no..


		usuarioActual.modificarUsuario(usuarioActual);
		
		
		response.sendRedirect("welcome.jsp");
		}
		//response.sendRedirect("login.jsp");
	}
	
	@SuppressWarnings("null")
	public boolean noEsStringVacio(String unString) {
		try {
			
			//saco espacios en blanco
			for (int x=0; x < unString.length(); x++) {
				  if (unString.charAt(x) != ' ')
					  unString += unString.charAt(x);
				}
			
			return ((unString != null) && (unString.length() != 0)) ;
		} catch (NullPointerException npe) {
			return false;
		}
	}

}
