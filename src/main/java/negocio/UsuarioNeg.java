package negocio;
import java.util.ArrayList;
import java.util.List;

import Entidades.*;
public interface UsuarioNeg {
	 boolean AgregarUsuario(Usuario usuario, Persona persona, List<TelefonoxPersona> listaTelefonos);
	    Usuario Login(String nombreUsuario, String contrasena); 
	     Usuario BuscarDni(String dni);
	     ArrayList<Usuario> listarTodo();
	     boolean Eliminar(String nombreUsuario);
	     boolean Modificar(Usuario usuario);
	    ArrayList<Usuario> filtrar(String dniParcial, int idProvincia, int idLocalidad, int idPais);
	    Usuario buscarId(int id);
}
