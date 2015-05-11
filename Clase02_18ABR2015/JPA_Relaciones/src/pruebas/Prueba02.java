package pruebas;

import entity.Organizacion;
import entity.Proyecto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Prueba02 {

	public static void main(String[] args) {
		List<String> rpta = new ArrayList<String>();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("DemoJPACSPU");
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select o from Organizacion o");
		for (Organizacion org : (List<Organizacion>) q.getResultList()) {
			rpta.add("Organizacion: " + org.getNombre());
			if (org.getProyectos() != null && org.getProyectos().size() > 0) {
				for (Proyecto p : org.getProyectos()) {
					rpta.add(" - " + p.getNombre() + " asignado a " + p.getEstudiante().getNombre());
				}
			} else {
				rpta.add("No contiene proyectos todavia");
			}
		}
		em.close();
		factory.close();
		for (String dato : rpta) {
			System.out.println(dato);
		}
	}
}
