package pe.egcc.demo02.prueba;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Prueba02 {

  public static void main(String[] args) {
    BigDecimal precio = new BigDecimal("567.79");
    BigInteger cant = new BigInteger("7");
    BigDecimal total = precio.multiply( new BigDecimal(cant));
    BigDecimal subtotal = total.divide(new BigDecimal("1.18"), 2);
    BigDecimal impuesto = total.add(subtotal.negate());
    
    System.out.println("Precio: " + precio);
    System.out.println("Cantidad: " + cant);
    System.out.println("Subtotal: " + subtotal);
    System.out.println("Impuesto: " + impuesto);
    System.out.println("Total: " + total);
  }
}
