package pe.egcc.ventasjpa.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gustavo Coronel
 */
public final class AccesoDB {

  private AccesoDB() {
  }

  public static EntityManager getEntityManager() {
    EntityManager em = null;
    try {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("VentasJPAPU");
      em = emf.createEntityManager();
    } catch (Exception e) {
      throw new RuntimeException("Error, no se tiene acceso a la fuente de datos.");
    }
    return em;
  }

}
