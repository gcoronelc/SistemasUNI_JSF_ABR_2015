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
public class Prueba06 {
  
  public static void main(String[] args) {
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      Query q = em.createNamedQuery("Categoria.findByIdcat");
      q.setParameter("idcat", 506);
      List<Categoria> lista = q.getResultList();
      if(!lista.isEmpty()){
        Categoria cat = lista.get(0);
        System.out.println(cat.getIdcat() + " - " + cat.getNombre());
      }else
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
