package Entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movimiento {
    private int idMovimiento;
    private Usuario usuario;
    private TipoMovimiento tipoMovimiento;
    private Cuenta cuenta;
    private String detalle;
    private BigDecimal importe;
    private LocalDate fecha;

    public Movimiento() {}

    public Movimiento(int idMovimiento, Usuario usuario, TipoMovimiento tipoMovimiento, Cuenta cuenta,
                      String detalle, BigDecimal importe, LocalDate fecha) {
        this.idMovimiento = idMovimiento;
        this.usuario = usuario;
        this.tipoMovimiento = tipoMovimiento;
        this.cuenta = cuenta;
        this.detalle = detalle;
        this.importe = importe;
        this.fecha = fecha;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }
    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;//skibidi
    } 
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }
    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public BigDecimal getImporte() {
        return importe;
    }
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return  "Movimiento" +
                "ID=" + idMovimiento +
                ", Usuario=" + usuario.getIdUsuario() +
                ", TipoMovimiento=" +tipoMovimiento.getIdTipoMovimiento() +
                ", Cuenta=" + cuenta.getNroCuenta() +
                ", Detalle='" + detalle + '\'' +
                ", Importe=" + importe +
                ", Fecha=" + fecha+""
                ;}
}
