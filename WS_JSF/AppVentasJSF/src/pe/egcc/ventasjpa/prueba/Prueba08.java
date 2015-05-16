package pe.egcc.ventasjpa.prueba;

import pe.egcc.ventasjpa.domain.Empleado;

public class Prueba08 {
  
  public static void main(String[] args) {
    Empleado a = new Empleado();
    a.setNombre("Gustavo");
    a.setApellido("Coronel");
    System.out.println(a.getNombre() + " " + a.getApellido());
    
    Empleado b = (Empleado) a.clone();
    System.out.println(b.getNombre() + " " + b.getApellido());       
    b.setNombre("Claudia");
    b.setApellido("Torres");
    System.out.println(a.getNombre() + " " + a.getApellido());
    System.out.println(b.getNombre() + " " + b.getApellido());   
  }

}
