package pe.egcc.ventasjpa.prueba;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import pe.egcc.ventasjpa.db.AccesoDB;
import pe.egcc.ventasjpa.domain.Categoria;
import pe.egcc.ventasjpa.domain.Producto;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba07 {
  
  public static void main(String[] args) {
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      
      Categoria cat = new Categoria(null, "POSTRES");
      
      Producto p = new Producto(null, "TORTA 3 LECHES", new BigDecimal(10.0), new BigInteger("100"));
      p.setIdcat(cat);
      cat.getProductoList().add(p);
      
      p = new Producto(null, "TORTA HELADA", new BigDecimal(7.0), new BigInteger("100"));
      p.setIdcat(cat);
      cat.getProductoList().add(p);
      
      p = new Producto(null, "100 HOJAS", new BigDecimal(7.5), new BigInteger("100"));
      p.setIdcat(cat);
      cat.getProductoList().add(p);
      
      
      em.getTransaction().begin();
      em.merge(cat);
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
