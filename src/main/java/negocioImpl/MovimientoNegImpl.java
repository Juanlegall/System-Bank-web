package negocioImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Daos.daoMovimiento;
import Daos.daoUsuario;
import Entidades.Cuenta;
import Entidades.Movimiento;
import Entidades.Usuario;
import negocio.UsuarioNeg;
import negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg {
	private final CuentasNegImpl nCuenta= new CuentasNegImpl();
	private final daoMovimiento dMov= new daoMovimiento();
public boolean Agregar(Movimiento movReceptor, Movimiento movEmisor) {
	
if(!(movEmisor.getCuentaEmisor().getSaldo().compareTo(movReceptor.getImporte()) >= 0))return false;
BigDecimal saldoEmisor=movEmisor.getCuentaEmisor().getSaldo().subtract(movEmisor.getImporte());
BigDecimal saldoReceptor=movReceptor.getCuentaEmisor().getSaldo().add(movReceptor.getImporte());
Cuenta Emisor= new Cuenta();
Cuenta receptor = new Cuenta();

Emisor=movEmisor.getCuentaEmisor();
Emisor.setSaldo(saldoEmisor);
receptor=movEmisor.getCuentaReceptor();
movEmisor.setImporte(movEmisor.getImporte().negate());
receptor.setSaldo(saldoReceptor);

if(receptor.getUsuario().getIdUsuario()==Emisor.getUsuario().getIdUsuario())return false;

boolean exitoEmisor=nCuenta.Modificar(Emisor);
boolean exitoReceptor = nCuenta.Modificar(receptor);
if(!exitoEmisor)return false;
if(!exitoReceptor)return false;

if(dMov.Agregar(movEmisor)&&dMov.Agregar(movReceptor)) {
	return true;
}
return false;
}
public ArrayList<Movimiento> Listarxcuentas(Movimiento mov){
	return dMov.Listarxcuentas(mov);
}
public ArrayList<Movimiento> filtrar(Movimiento mov,String nombre, String operador, LocalDate desde, LocalDate hasta,int tipoMovimiento){
	    StringBuilder condicionesExtras = new StringBuilder();
	    ArrayList<Object> parametrosExtras = new ArrayList<>();
	    if(tipoMovimiento!=0) {
	    	condicionesExtras.append("and idtipomovimiento=?");
	    	parametrosExtras.add(tipoMovimiento);
	    }
	    if (desde != null && hasta != null) {
	        condicionesExtras.append(" AND fecha BETWEEN ? AND ? ");
	        parametrosExtras.add(desde);
	        parametrosExtras.add(hasta);
	    }

	    if (operador.equals(">")) {
	        condicionesExtras.append(" AND importe > 0 ");
	    } else if (operador.equals("<")) {
	        condicionesExtras.append(" AND importe < 0 ");
	    }

	    daoMovimiento dao = new daoMovimiento();
	    return dao.Filtrar(mov.getUsuario().getIdUsuario(),mov.getCuentaEmisor().getNroCuenta(),nombre,condicionesExtras.toString(),parametrosExtras
	    );
}

public boolean movimiento(Movimiento mov) {
    return dMov.Agregar(mov);
}

public boolean EliminarMovimientos(int idUsuario) {
	return dMov.EliminarMovimientos(idUsuario);
}

public boolean EliminarxCuenta(int idCuenta) {

	if (dMov.BuscarxCuenta(idCuenta) > 0) {
		return dMov.EliminarxCuenta(idCuenta);
	} else {
		System.out.println("No hay movimientos");
		return true;
	}

}

@Override
public int contarMovimientos(Movimiento mov) {
	return dMov.contarMovimientos(mov);
}
@Override
public List<Movimiento> ListarxcuentasPaginado(Movimiento mov, int offset, int limite) {
	return dMov.ListarxcuentasPaginado(mov, offset, limite);
}
}
