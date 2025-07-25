package Presentacion;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Entidades.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.*;
import negocioImpl.*;


/**
 * Servlet implementation class ServletAgregarCliente
 */
@WebServlet("/ServletAgregarCliente")
public class ServletAgregarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final PersonaNegImpl negPersona= new PersonaNegImpl(); 
	private static final TelefonoNegImpl negTelefono = new TelefonoNegImpl();
	private static final UsuarioNeg negUsuario = new UsuarioNegImpl();
	private static final ProvinciaNegImpl ProvinciaNeg = new ProvinciaNegImpl();
	private static final LocalidadNegImpl localidadNeg = new LocalidadNegImpl();
	private static final PaisNeg negPais = new PaisNegImpl();
    public ServletAgregarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Cargar ventana agregar si viene openAgregarUsu
	    if (request.getParameter("openAgregarUsu") != null) {
	        String ventana = "AdminMode/clientesAdmin_agregar.jsp";
	        windowDefault(request, response, ventana);
	        return;
	    }


	    if (request.getParameter("listarProvincias") != null) {
	    	int idPais = Integer.parseInt(request.getParameter("idPais").trim());
	    	List<Provincia> provincia = ProvinciaNeg.listarProvinciasxPais(idPais);

	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");

	        StringBuilder json = new StringBuilder();
	        json.append("[");
	        for (int i = 0; i < provincia.size(); i++) {
	            Provincia prov = provincia.get(i);
	            json.append("{");
	            json.append("\"idProvincia\":").append(prov.getIdProvincia()).append(",");
	            json.append("\"nombre\":\"").append(prov.getNombre().replace("\"", "\\\"")).append("\"");
	            json.append("}");
	            if (i < provincia.size() - 1) {
	                json.append(",");
	            }
	        }
	        json.append("]");

	        response.getWriter().write(json.toString());
	        return;
	    }

	    if (request.getParameter("listarLocalidades") != null) {
	    	int idProvincia = Integer.parseInt(request.getParameter("idProvincia").trim());
	    	List<Localidad> localidades = localidadNeg.listarLocalidadesPorProvincia(idProvincia);

	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");

	        StringBuilder json = new StringBuilder();
	        json.append("[");
	        for (int i = 0; i < localidades.size(); i++) {
	            Localidad loc = localidades.get(i);
	            json.append("{");
	            json.append("\"idLocalidad\":").append(loc.getIdLocalidad()).append(",");
	            json.append("\"nombre\":\"").append(loc.getNombre().replace("\"", "\\\"")).append("\"");
	            json.append("}");
	            if (i < localidades.size() - 1) {
	                json.append(",");
	            }
	        }
	        json.append("]");

	        response.getWriter().write(json.toString());
	        return;
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		System.out.println("provincia"+ request.getParameter("provincia"));
	    try {
	        String nombre = request.getParameter("nombre");
	        String apellido = request.getParameter("apellido");
	        String dni = request.getParameter("dni");
	        String cuil = request.getParameter("cuil");
	        int localidad = Integer.parseInt( request.getParameter("localidad"));
	        int provincia = Integer.parseInt(request.getParameter("provincia"));
	        String direccion = request.getParameter("direccion");
	        int nacionalidad = Integer.parseInt(request.getParameter("nacionalidad"));
	        LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fecha_nacimiento"));
	        String correo = request.getParameter("correo_electronico");
	        String sexo = request.getParameter("sexo");
	        String[] telefonos = request.getParameterValues("telefonos");

	        String nombreUsuario = request.getParameter("usuario");
	        String contrasena = request.getParameter("contrasena");

	        Persona persona = new Persona();
	        persona.setDni(dni);
	        persona.setCuil(cuil);
	        persona.setNombre(nombre);
	        persona.setApellido(apellido);
	        Provincia prov = ProvinciaNeg.buscarPorId(provincia);
	        Localidad loc = localidadNeg.buscarPorId(localidad, prov.getIdProvincia());
	        persona.setLocalidad(loc);    
	        persona.setProvincia(prov);
	        persona.setDireccion(direccion);
	        Pais pais = negPais.buscarXID(nacionalidad);
	        persona.setPais(pais);
	        persona.setFechaNacimiento(fechaNacimiento);
	        persona.setCorreoElectronico(correo);
	        persona.setSexo(sexo);
	        persona.setEstado(true);

		List<TelefonoxPersona> telefonosLista=new ArrayList<TelefonoxPersona>();
		for(String numero: telefonos) {
	        TelefonoxPersona telPersona = new TelefonoxPersona();
	        if(!numero.isEmpty()) {
	        telPersona.setDni(persona);
	        telPersona.setTelefono(numero.trim());
	        telefonosLista.add(telPersona);
	        }else break;
	        }
		

	        Usuario usuario = new Usuario();
	        usuario.setNombreUsuario(nombreUsuario);
	        usuario.setContrasena(contrasena);
	        usuario.setPersona(persona);
	        usuario.setTipoUsuario(false); 

	        boolean usuarioCreado = negUsuario.AgregarUsuario(usuario, persona, telefonosLista);

	        
	        if ( usuarioCreado) {
	            request.setAttribute("mensaje", "✅ Persona agregada correctamente.");
	            windowDefault(request, response, "AdminMode/clientesAdmin_agregar.jsp");
	        } else {
	            request.setAttribute("mensaje", "❌ Error al agregar la persona.");
	            windowDefault(request, response, "AdminMode/clientesAdmin_agregar.jsp");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        windowDefault(request, response, "AdminMode/clientesAdmin_agregar.jsp?error=Excepcion");
	    }
	}
	private void windowDefault(HttpServletRequest request, HttpServletResponse response, String jsp) throws ServletException, IOException{
		 request.setAttribute("ListaPais",  negPais.listarTodo());
		 RequestDispatcher rd= request.getRequestDispatcher(jsp);
		 rd.forward(request, response);
	}
}


