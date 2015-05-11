/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 * @blog gcoronelc.blogspot.com
 */
package pe.egcc.app.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TM_ALUMNO")
@NamedQueries({
	@NamedQuery(name = "findAllAlumnos", query = "select a from Alumno a")
})
public class Alumno implements Serializable {

	@Id
	@Column(name = "alu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "panchito")
	@SequenceGenerator(name = "panchito", sequenceName = "sq_alumno")
	private Integer id;
  
	@Column(name = "alu_nombre", length = 100, nullable = false)
	private String nombre;
  
	@Column(name = "alu_apellido", length = 100, nullable = false)
	private String apellido;
  
	@Column(name = "alu_nota")
	private Integer nota;

	public Alumno() {
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

  /**
   * Convierte el objeto en un arreglo de tipo Object.
   * 
   * @return Object[]
   */
	public Object[] toRowData() {
		Object[] row;
		row = new Object[]{this.getId(), this.getApellido(), this.getNombre(), this.getNota()};
		return row;
	}
}
