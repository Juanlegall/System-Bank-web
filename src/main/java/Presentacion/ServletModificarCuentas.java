package Presentacion;

import java.io.IOException;
import Entidades.*;
import negocio.CuentasNeg;
import negocioImpl.CuentasNegImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jdi.request.InvalidRequestStateException;

import Daos.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Formatter.BigDecimalLayoutForm;
/**
 * Servlet implementation class ServletModificarCuentas
 */
@WebServlet("/ServletModificarCuentas")
public class ServletModificarCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private daoCuentas daoCuenta = new daoCuentas();
	private CuentasNeg cuentaNeg= new CuentasNegImpl();
   
    public ServletModificarCuentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("nroCuenta")!=null) {
			Cuenta cuenta= new Cuenta();
			int nroCuenta=Integer.parseInt(request.getParameter("nroCuenta"));
			cuenta=cuentaNeg.BuscarPorNro(nroCuenta);
			 String json = "{"
                     + "\"nroCuenta\": \"" + cuenta.getNroCuenta() + "\","
                     + "\"dniCliente\": \"" + cuenta.getUsuario().getPersona().getDni() + "\","
                     + "\"fechaCreacion\": \"" + cuenta.getFechaCreacion() + "\","
                     + "\"tipoCuenta\": \"" + cuenta.getTipoCuenta() + "\","
                     + "\"cbu\": \"" + cuenta.getCbu() + "\","
                     + "\"saldo\": \"" + cuenta.getSaldo() + "\""
                     + "}";
			 response.setContentType("application/json");
             response.setCharacterEncoding("UTF-8");
             response.getWriter().write(json);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. Obtener parámetros del formulario
            int nroCuenta = Integer.parseInt(request.getParameter("nro_cuenta_mod"));
            String dniCliente = request.getParameter("dni_cliente_mod");
            LocalDate fechaCreacion = LocalDate.parse(request.getParameter("fecha_creacion_mod"));
            String tipoCuentaTexto = request.getParameter("tipo_cuenta_mod");
            String cbu = request.getParameter("cbu_mod");
            BigDecimal saldo = new BigDecimal(request.getParameter("saldo_mod"));

            // 2. Obtener idTipoCuenta según texto
            int idTipoCuenta = tipoCuentaTexto.equalsIgnoreCase("Corriente") ? 1 : 2;

            // 3. Buscar usuario por DNI (asumiendo que tienes daoUsuario y método BuscarDni)
            daoUsuario daoU = new daoUsuario();
            Usuario usuario = daoU.BuscarDni(dniCliente);
            if (usuario == null) {
                // Si no existe el usuario, redirigir con error
                response.sendRedirect(request.getContextPath() + "/AdminMode/cuentaAdmin_modificar.jsp?error=Usuario no encontrado");
                return;
            }

            // 4. Armar objeto Cuenta con los datos actualizados
            Cuenta cuenta = new Cuenta();
            cuenta.setNroCuenta(nroCuenta);
            cuenta.setUsuario(usuario);
            cuenta.setFechaCreacion(fechaCreacion);

            TipoCuenta tipoCuenta = new TipoCuenta();
            tipoCuenta.setIdTipoCuenta(idTipoCuenta);
            cuenta.setTipoCuenta(tipoCuenta);

            cuenta.setCbu(cbu);
            cuenta.setSaldo(saldo);

            // 5. Actualizar cuenta en base de datos (debe estar implementado daoCuentas.Modificar o similar)
            boolean exito = daoCuenta.Modificar(cuenta);

            // 6. Redirigir según resultado
            if (exito) {
                response.sendRedirect(request.getContextPath() + "/BancoParcial/ServletListarCuentas?openListar=1");
            } else {
                response.sendRedirect(request.getContextPath() + "/AdminMode/cuentaAdmin_modificar.jsp?error=Error al modificar la cuenta");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/AdminMode/cuentaAdmin_modificar.jsp?error=Error inesperado");
        }
    }

}
	/*private Cuenta setAtributosCuenta(HttpServletRequest request)throws ServletException, IOException { 
	int nroCuenta = Integer.parseInt(request.getParameter("nro_cuenta_mod"));
    String dniCliente = request.getParameter("dni_cliente_mod");
    LocalDate fechaCreacion = LocalDate.parse(request.getParameter("fecha_creacion_mod"));
    String tipoCuentaTexto = request.getParameter("tipo_cuenta_mod");
    String cbu = request.getParameter("cbu_mod");
    BigDecimal saldo = new BigDecimal(request.getParameter("saldo_mod"));

    // 2. Obtener idTipoCuenta según texto
    int idTipoCuenta = tipoCuentaTexto.equalsIgnoreCase("Corriente") ? 1 : 2;

    // 3. Buscar usuario por DNI (asumiendo que tienes daoUsuario y método BuscarDni)
    daoUsuario daoU = new daoUsuario();
    Usuario usuario = daoU.BuscarDni(dniCliente);
    if (usuario == null) {
        // Si no existe el usuario, redirigir con error
        response.sendRedirect(request.getContextPath() + "/AdminMode/cuentaAdmin_modificar.jsp?error=Usuario no encontrado");
        return;
    }

    // 4. Armar objeto Cuenta con los datos actualizados
    Cuenta cuenta = new Cuenta();
    cuenta.setNroCuenta(Integer.parseInt(request.getParameter("nro_cuenta_mod")));
    cuenta.setUsuario(daoU.BuscarDni(r("dni_cliente_mod")));
    cuenta.setFechaCreacion(LocalDate.parse(request.getParameter("fecha_creacion_mod")));

    TipoCuenta tipoCuenta = new TipoCuenta();
    tipoCuenta.setIdTipoCuenta( tipoCuentaTexto.equalsIgnoreCase("Corriente") ? 1 : 2);
    cuenta.setTipoCuenta(tipoCuenta);

    cuenta.setCbu(request.getParameter("cbu_mod"));
    double saldoD= Double.parseDouble(request.getParameter("saldo_mod"));
    cuenta.setSaldo(BigDecimal.valueOf(saldoD));
	}
}*/
