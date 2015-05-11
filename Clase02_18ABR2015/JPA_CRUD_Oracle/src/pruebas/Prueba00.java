package pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pe.egcc.app.domain.Alumno;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba00 {

  public static void main(String[] args) {
    
    EntityManagerFactory emf = null;
    EntityManager em = null;

    try {

      Alumno alumno = new Alumno();
      alumno.setApellido("AQUINO");
      alumno.setNombre("GUILLERMO");
      alumno.setNota(20);

      emf = Persistence.createEntityManagerFactory("JPADemo");
      em = emf.createEntityManager();

      em.getTransaction().begin();
      em.persist(alumno);
      em.getTransaction().commit();

    } catch (Exception e) {
      try {
        if(em != null) em.getTransaction().rollback();
      } catch (Exception e1) {
      }
      e.printStackTrace();
      
    } finally{
      try {
        em.close();
        emf.close();
      } catch (Exception e) {
      }
      
    }
  }
}
