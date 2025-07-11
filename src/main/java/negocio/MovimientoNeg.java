package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Entidades.Cuenta;
import Entidades.Movimiento;

public interface MovimientoNeg {
boolean Agregar(Movimiento movReceptor, Movimiento movEmisor);
ArrayList<Movimiento> Listarxcuentas(Movimiento mov);
ArrayList<Movimiento> filtrar(Movimiento mov,String nombre, String operador, LocalDate desde, LocalDate hasta, int tipoMovimiento);
boolean movimiento(Movimiento mov);
boolean EliminarMovimientos(int idUsuario);
boolean EliminarxCuenta(int idCuenta);
int contarMovimientos(Movimiento mov);
List<Movimiento> ListarxcuentasPaginado(Movimiento mov, int offset, int limite);
}
