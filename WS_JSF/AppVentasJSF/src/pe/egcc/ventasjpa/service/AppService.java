package pe.egcc.ventasjpa.service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.egcc.ventasjpa.db.AccesoDB;
import pe.egcc.ventasjpa.domain.Categoria;
import pe.egcc.ventasjpa.domain.Empleado;
import pe.egcc.ventasjpa.domain.Producto;
import pe.egcc.ventasjpa.domain.Venta;
import pe.egcc.ventasjpa.util.VentasException;

public class AppService {

  @SuppressWarnings("unchecked")
  public List<Categoria> traerCategorias() {
    List<Categoria> lista = null;
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      Query q = em.createNamedQuery("Categoria.findAll");
      lista = q.getResultList();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error, no se puede validar los datos.");
    }finally{
      try {
        if( em != null ) em.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }
  
  @SuppressWarnings("unchecked")
  public List<Categoria> traerCategorias(boolean conProductos) {
    List<Categoria> lista = null;
    EntityManager em = null;
    try {
      lista = traerCategorias();
      if(conProductos){
       int n = 0;
       while(n < lista.size()){
         if(lista.get(n).getProductoList().size() == 0){
           lista.remove(n);
         } else {
           n++;
         }
       }
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error, no se puede validar los datos.");
    }finally{
      try {
        if( em != null ) em.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }
  
  @SuppressWarnings("unchecked")
  public List<Producto> traerProductos(BigInteger idcat) {
    List<Producto> lista = null;
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      Query q = em.createQuery("Select p from Producto p where p.idcat.idcat = :idcat");
      q.setParameter("idcat", idcat);
      lista = q.getResultList();
    } catch (VentasException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error, no se puede validar los datos.");
    }finally{
      try {
        if( em != null ) em.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }
  
  @SuppressWarnings("unchecked")
  public List<Producto> traerProductos() {
    List<Producto> lista = null;
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      Query q = em.createQuery("Select p from Producto p");
      lista = q.getResultList();
    } catch (VentasException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error, no se puede validar los datos.");
    }finally{
      try {
        if( em != null ) em.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }
  
  public Empleado traerEmpleado(BigInteger idemp) {
    Empleado bean = null;
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      Query q = em.createNamedQuery("Empleado.findByIdemp");
      q.setParameter("idemp", idemp);
      bean = (Empleado) q.getSingleResult();
    } catch (VentasException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException("Error, no acceso a la base de datos.");
    }finally{
      try {
        if( em != null ) em.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }
  
  public void grabarVenta(Venta venta) {
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      em.getTransaction().begin();
      em.persist(venta);
      em.getTransaction().commit();
    } catch (VentasException e) {
      try {
        em.getTransaction().rollback();
      } catch (Exception e2) {
      }
      throw e;
    } catch (Exception e) {
      try {
        em.getTransaction().rollback();
      } catch (Exception e2) {
      }
      e.printStackTrace();
      throw new RuntimeException("Error, no acceso a la base de datos.");
    }finally{
      try {
        if( em != null ) em.close();
      } catch (Exception e) {
      }
    }
  }
}
