package pe.egcc.ventasjpa.prueba;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import pe.egcc.ventasjpa.db.AccesoDB;
import pe.egcc.ventasjpa.domain.Categoria;
import pe.egcc.ventasjpa.domain.Producto;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba05 {
  
  public static void main(String[] args) {
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      Query q = em.createNamedQuery("Categoria.findByIdcat");
      q.setParameter("idcat", 5067);
      Categoria cat;
      try{
        cat = (Categoria) q.getSingleResult();
      } catch(Exception e){
        cat = null;
      }
      if(cat != null)
        System.out.println(cat.getIdcat() + " - " + cat.getNombre());
      else
        System.err.println("Error, no existe la categoria.");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    } finally{
      try {
        if( em != null ) em.close();
      } catch (Exception e) {
      }
    }
  }
  
}
