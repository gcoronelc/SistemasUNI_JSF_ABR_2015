/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package dao;

import entity.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlumnoDAO {

  private EntityManagerFactory emf;

  public AlumnoDAO() {
    this.emf = Persistence.createEntityManagerFactory("JPADemo");
  }

  // Crea un nuevo alumno en la tabla alumno.
  public void create(Alumno entity) throws Exception {
    EntityManager em = emf.createEntityManager();
    EntityTransaction entr = em.getTransaction();
    try {
      entr.begin();
      em.persist(entity);
      entr.commit();
      em.close();
    } catch (Exception e) {
      try {
        entr.rollback();
        em.close();
      } catch (Exception e1) {
      }
      throw e;
    }
  }

  // Lee un alumno desde la tabla alumno
  public Alumno read(int id) throws Exception {
    EntityManager em = emf.createEntityManager();
    Alumno alu = em.find(Alumno.class, id);
    return alu;
  }

  // Utilizando Dynamic Query
  public List<Alumno> readAll1() throws Exception {
    EntityManager em = emf.createEntityManager();
    Query query = em.createQuery("select a from Alumno a");
    List<Alumno> lista = query.getResultList();
    return lista;
  }

  // Utilizando Named Query
  public List<Alumno> readAll2() throws Exception {
    EntityManager em = emf.createEntityManager();
    Query query = em.createNamedQuery("Alumno.findAll");
    List<Alumno> lista = query.getResultList();
    return lista;
  }
  
  // Consulta con parámetros
  public List<Alumno> readForName(String name) throws Exception {
    EntityManager em = emf.createEntityManager();
    String sql = "select a from Alumno a "
            + "where a.nombre like :name or a.apellido like :name";
    Query query = em.createQuery(sql);
    query.setParameter("name", name + "%");
    List<Alumno> lista = query.getResultList();
    return lista;
  }

  // Actualiza los datos de un alumno
  public void update(Alumno entity) throws Exception {
    EntityManager em = emf.createEntityManager();
    EntityTransaction entr = em.getTransaction();
    try {
      entr.begin();
      em.merge(entity);
      entr.commit();
      em.close();
    } catch (Exception e) {
      try {
        entr.rollback();
        em.close();
      } catch (Exception e1) {
      }
      throw e;
    }
  }

  // Elimina un alumno de la tabla
  public void delete(Integer id) throws Exception {
    EntityManager em = emf.createEntityManager();
    EntityTransaction entr = em.getTransaction();
    try {
      entr.begin();
      Alumno alumno = em.find(Alumno.class, id);
      em.remove(alumno);
      entr.commit();
      em.close();
    } catch (Exception e) {
      try {
        entr.rollback();
        em.close();
      } catch (Exception e1) {
      }
      throw e;
    }
  }
}
