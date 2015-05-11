
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organizacion implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORG_ID")
	private Long id;
	@Column(name="ORG_NOMBRE", length=50, nullable=false)
	private String nombre;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="organizacion")
	private List<Proyecto> proyectos;

	public Organizacion() {
	}

	public Organizacion(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public List<Proyecto> getProyectos() {
		if( proyectos == null ){
			proyectos = new ArrayList<Proyecto>();
		}
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		
		this.proyectos = proyectos;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}


