package negocioImpl;

import java.util.ArrayList;
import java.util.List;

import Daos.daoPais;
import Entidades.Pais;
import Entidades.Provincia;
import negocio.PaisNeg;

public class PaisNegImpl implements PaisNeg{
	daoPais dp= new daoPais();
	public Pais buscarXNombre(String nombre) {
		return dp.buscarXNombre(nombre);
	}
	public Pais buscarXID(int id) {
		return dp.buscarXID(id);
	}
	public ArrayList<Pais> listarTodo(){
		return dp.listarTodo();
	}
}
