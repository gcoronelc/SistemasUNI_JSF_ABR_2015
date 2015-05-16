package pe.egcc.ventasjpa.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.egcc.ventasjpa.db.AccesoDB;
import pe.egcc.ventasjpa.domain.Usuario;
import pe.egcc.ventasjpa.util.Encripta;
import pe.egcc.ventasjpa.util.VentasException;

public class LogonService {

  public Usuario validar(String usuario, String clave) {
    Usuario bean = null;
    EntityManager em = null;
    try {
      em = AccesoDB.getEntityManager();
      Query q = em.createQuery("SELECT u FROM Usuario u "
          + "WHERE u.usuario = :usuario AND u.estado = 1");
      try {
        q.setParameter("usuario", usuario);
        bean = (Usuario) q.getSingleResult();
      } catch (Exception e) {
        bean = null;
      }
      if(bean == null) 
        throw new VentasException("Error, datos son incorrectos.");
      if(!Encripta.sha1(clave).equals(bean.getClave())){
        throw new VentasException("Error, datos son incorrectos.");
      }
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
    return bean;
  }
  
}
