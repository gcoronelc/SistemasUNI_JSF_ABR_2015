/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package pruebas;

import dao.AlumnoDAO;
import entity.Alumno;

public class Prueba01 {

  public static void main(String[] args) {
    
    Alumno alumno = new Alumno();
    alumno.setApellido("Ramirez");
    alumno.setNombre("reynaldo");
    alumno.setNota(15);

    try {
      AlumnoDAO dao = new AlumnoDAO();
      dao.create(alumno);
      System.out.println("ID: " + alumno.getId());
      System.out.println("Ok");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
