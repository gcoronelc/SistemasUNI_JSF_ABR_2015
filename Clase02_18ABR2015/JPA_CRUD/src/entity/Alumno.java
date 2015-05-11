/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email gcoronelc@gmail.com
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
@NamedQueries({
  @NamedQuery(name = "Alumno.findAll", query = "select a from Alumno a")
})
public class Alumno implements Serializable {

  private static final long serialVersionUID = 3340106145531621062L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "alu_id")
  private Integer id;
  @Column(name = "alu_nombre", length = 50, nullable = false)
  private String nombre;
  @Column(name = "alu_apellido", length = 50, nullable = false)
  private String apellido;
  @Column(name = "alu_nota")
  private Integer nota;

  public Alumno() {
  }

  public Alumno(String nombre, String apellido, Integer nota) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.nota = nota;
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

  public Object[] toRowData() {
    Object[] row;
    row = new Object[]{this.getId(), this.getApellido(), this.getNombre(), this.getNota()};
    return row;
  }
}
