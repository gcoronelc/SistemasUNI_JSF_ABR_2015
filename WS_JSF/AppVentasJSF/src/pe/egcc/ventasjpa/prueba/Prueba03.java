package pe.egcc.ventasjpa.prueba;

import java.util.List;
import javax.persistence.EntityManager;
import pe.egcc.ventasjpa.db.AccesoDB;
import pe.egcc.ventasjpa.domain.Categoria;
import pe.egcc.ventasjpa.domain.Producto;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba03 {
  
  public static void main(String[] args) {
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      Categoria cat = new Categoria(null, "BEBIDAS");
      em.getTransaction().begin();
      em.persist(cat);
      em.getTransaction().commit();
      System.out.println("IDCAT: " + cat.getIdcat());
    } catch (Exception e) {
      try {
        if(em != null) em.getTransaction().rollback();
      } catch (Exception e2) {
      }
      System.err.println(e.getMessage());
    } finally{
      try {
        if( em != null ) em.close();
      } catch (Exception e) {
      }
    }
  }
  
}
