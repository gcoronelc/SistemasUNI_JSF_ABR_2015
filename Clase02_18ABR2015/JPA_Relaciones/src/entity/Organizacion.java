package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organizacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "org_id")
	private int idOrganizacion;
	@Basic
	@Column(name = "org_nombre", nullable = false, length = 100)
	private String nombre;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organizacion")
	private List<Proyecto> proyectos;

	public Organizacion() {
	}

	public Organizacion(String nombre) {
		this.nombre = nombre;
	}

	public int getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Proyecto> getProyectos() {

		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public void addProyecto(Proyecto proyecto) {
		if (proyectos == null) {
			proyectos = new ArrayList<Proyecto>();
		}
		if (proyecto != null) {
			proyectos.add(proyecto);
		}

	}
}
