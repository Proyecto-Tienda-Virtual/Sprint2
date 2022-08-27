package Modelo;

public class MovimientoDinero {
    private int monto;
    private String conceptoMovimiento;
    private String usuario;

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "monto=" + monto +
                ", conceptoMovimiento='" + conceptoMovimiento + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }

    public MovimientoDinero(int monto, String conceptoMovimiento, String usuario) {
        this.monto = monto;
        this.conceptoMovimiento = conceptoMovimiento;
        this.usuario = usuario;
    }
    public MovimientoDinero() {
        super();
    }
}
