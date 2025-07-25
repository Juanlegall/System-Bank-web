package negocioImpl;

import Interfaces.inCuentas;

import java.math.BigDecimal;
import java.sql.Connection;

import java.util.Date;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.*;
import Daos.*;
import Entidades.Cuenta;
import Entidades.Usuario;

public class CuentasNegImpl implements CuentasNeg {
	private inCuentas dao = new daoCuentas();
	private UsuarioNeg nUsuario;
	private MovimientoNeg negMovimiento;
	private PrestamosNeg negPrestamos;

	@Override
	public boolean Agregar(Cuenta cuenta) {
		PersonaNegImpl negPersona = new PersonaNegImpl();
		nUsuario = new UsuarioNegImpl();
		
		if (!negPersona.existe(cuenta.getUsuario().getPersona().getDni()))
			return false;
		
		if (nUsuario.BuscarDni(cuenta.getUsuario().getPersona().getDni()).isTipoUsuario())
			return false;
		
		if (dao.maximoCuentas(cuenta.getUsuario().getIdUsuario()) >= 3)
			return false;
		return dao.Agregar(cuenta);
	}

	public ArrayList<Cuenta> ListarxUsuario(int Id) {
		return dao.ListarxUsuario(Id);
	}

	@Override
	public boolean Modificar(Cuenta cuenta) {
		return dao.Modificar(cuenta);
	}

	@Override
	public boolean Eliminar(int nroCuenta) {
		negPrestamos = new PrestamosNegImpl();
		negMovimiento = new MovimientoNegImpl();

		System.out.println("1, prestamo");
		if (!negPrestamos.EliminarxCuenta(nroCuenta)) {
			System.out.println("1404 error prestamo");
			return false;
		}
		System.out.println("2, movimiento");
		if (!negMovimiento.EliminarxCuenta(nroCuenta)) {
			System.out.println("2404 error movimiento");
			return false;
		}
		System.out.println("3, Cuenta");
		return dao.Eliminar(nroCuenta);
	}

	@Override
	public ArrayList<Cuenta> ListarTodo() {
		return dao.ListarTodo();
	}

	public boolean EliminarCuentas(int idUsuario) {
		return dao.EliminarCuentas(idUsuario);
	}

	@Override
	public Cuenta BuscarPorNro(int nroCuenta) {
		return dao.BuscarPorNro(nroCuenta);
	}

	public int obtenerId() {
		return dao.obtenerIdCuenta();
	}

	@Override
	public boolean existe(int nroCuenta) {
		return dao.existe(nroCuenta);
	}

	public String generarCBU() {
		return dao.generarCBUAleatorio();
	}

	public Cuenta cuentaxCbu(String cbu) {
		return dao.cuentaxCbu(cbu);
	}

	@Override
	public boolean actualizarSaldo(int nroCuenta, BigDecimal monto, Connection conn) {
		return dao.actualizarSaldo(nroCuenta, monto, conn);
	}

	@Override
	public int obtenerNroCuentaPorIdUsuario(int idUsuario, Connection conn) throws SQLException {
		return dao.obtenerNroCuentaPorIdUsuario(idUsuario, conn);
	}
	
	public ArrayList<Cuenta> filtrar(String dniParcial, int idTipoCuenta, String ordenSaldo){
		StringBuilder condicionesExtras = new StringBuilder();
		StringBuilder orden = new StringBuilder();
		ArrayList<Object> parametrosExtras = new ArrayList<>();
		System.out.println("dni= "+ dniParcial);
		if (dniParcial != null && !dniParcial.isEmpty()) {
			System.out.println("dni= "+ dniParcial);
		    condicionesExtras.append(" AND usuarios.dni LIKE ? ");
		    parametrosExtras.add("%" + dniParcial + "%");
		}

		if (idTipoCuenta > 0) {
		    condicionesExtras.append(" AND cuentas.IdtipoCuenta = ? ");
		    System.out.println(idTipoCuenta);
		    parametrosExtras.add(idTipoCuenta);
		}

		if (ordenSaldo != null && (ordenSaldo.equalsIgnoreCase("ASC") || ordenSaldo.equalsIgnoreCase("DESC"))) {
		    orden.append(" ORDER BY cuentas.Saldo ").append(ordenSaldo);
		} else {
		    orden.append(" ORDER BY cuentas.Saldo ASC"); 
		}
		return dao.filtrar(condicionesExtras.toString(), orden.toString(), parametrosExtras);
	}

	@Override
	public int contarCuentasCreadasEnRango(Date desde, Date hasta) {
		return dao.contarCuentasCreadasEnRango(desde, hasta);
	}

	@Override
	public BigDecimal obtenerPromedioSaldoInicialEnRango(Date desde, Date hasta) {
		return dao.obtenerPromedioSaldoInicialEnRango(desde, hasta);
	}

    @Override
    public String obtenerTipoCuentaMasCreadaEnRango(Date desde, Date hasta) {
    	
    	System.out.println("DEBUG Negocio: Entrando a obtenerCuentasCreadasEnRango en CuentasNegImpl.");
        System.out.println("DEBUG Negocio: Llamando a daoCuentas.obtenerCuentasCreadasEnRango con fechas: " + desde + " a " + hasta);
        
        return dao.obtenerTipoCuentaMasCreadaEnRango(desde, hasta);
	}

	@Override
	public List<Cuenta> obtenerCuentasCreadasEnRango(Date desde, Date hasta) {
		return dao.obtenerCuentasCreadasEnRango(desde, hasta);
	}
}
