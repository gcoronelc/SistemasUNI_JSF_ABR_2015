package pe.egcc.ventasjpa.util;

public class VentasException extends RuntimeException{

  private static final long serialVersionUID = 1L;

  public VentasException() {
    super("Error, proceso no se puede ejecutar.");
  }
  
  public VentasException(String mensaje) {
    super(mensaje);
  }
}
