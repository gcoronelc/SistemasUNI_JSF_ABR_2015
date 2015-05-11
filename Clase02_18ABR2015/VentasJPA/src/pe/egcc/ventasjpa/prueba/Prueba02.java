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
public class Prueba02 {
  
  public static void main(String[] args) {
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      List<Categoria> lista = em.createNamedQuery("Categoria.findAll").getResultList();
      for(Categoria cat: lista){
        System.out.println(cat.getIdcat() + " - " + cat.getNombre());
        if(cat.getIdcat().intValue() == 507){
          for(Producto prod: cat.getProductoList()){
            System.out.println("     - " + prod.getIdprod() + " - " + prod.getNombre());
          }
        }
      }
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
