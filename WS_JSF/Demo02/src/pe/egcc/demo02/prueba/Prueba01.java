package pe.egcc.demo02.prueba;

public class Prueba01 {

  public static void main(String[] args) {
    double precio = 567.79;
    int cant = 7;
    double total = precio * cant;
    double impuesto = total / 1.18;
    double subtotal = total - impuesto;
    
    System.out.println("Precio: " + precio);
    System.out.println("Cantidad: " + cant);
    System.out.println("Subtotal: " + subtotal);
    System.out.println("Impuesto: " + impuesto);
    System.out.println("Total: " + total);
  }
}
