package pruebas;

import entity.Estudiante;
import entity.Organizacion;
import entity.Proyecto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Prueba01 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoJPACSPU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Organizacion organizacion = new Organizacion("Perú Viajero");

		Proyecto proyecto = new Proyecto("Sistema de Inventarios");
		Estudiante estudiante = new Estudiante("Pedro Segura");
		estudiante.setProyecto(proyecto);
		proyecto.setEstudiante(estudiante);
		proyecto.setOrganizacion(organizacion);
		organizacion.addProyecto(proyecto);

		em.persist(estudiante);
		em.persist(organizacion);
		em.persist(proyecto);

		proyecto = new Proyecto("Sistema de Cobranza");
		estudiante = new Estudiante("Claudia Fernandez");
		estudiante.setProyecto(proyecto);
		proyecto.setEstudiante(estudiante);
		proyecto.setOrganizacion(organizacion);
		organizacion.addProyecto(proyecto);

		em.persist(estudiante);
		em.persist(organizacion);
		em.persist(proyecto);

		organizacion = new Organizacion("Soluciones Informaticas");
		proyecto = new Proyecto("Sistema Contable");
		estudiante = new Estudiante("Nathaly Vertiz");
		estudiante.setProyecto(proyecto);
		proyecto.setEstudiante(estudiante);
		proyecto.setOrganizacion(organizacion);
		organizacion.addProyecto(proyecto);

		em.persist(estudiante);
		em.persist(organizacion);
		em.persist(proyecto);

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

}
