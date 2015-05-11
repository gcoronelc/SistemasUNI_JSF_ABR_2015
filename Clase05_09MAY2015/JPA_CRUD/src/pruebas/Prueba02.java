/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package pruebas;

import dao.AlumnoDAO;
import entity.Alumno;

public class Prueba02 {

  public static void main(String[] args) {

    try {
      AlumnoDAO dao = new AlumnoDAO();
      Alumno alumno = dao.read(1);
      System.out.println("ID: " + alumno.getId());
      System.out.println("Apellido: " + alumno.getApellido());
      System.out.println("Nombre: " + alumno.getNombre());
      System.out.println("Nota: " + alumno.getNota());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
