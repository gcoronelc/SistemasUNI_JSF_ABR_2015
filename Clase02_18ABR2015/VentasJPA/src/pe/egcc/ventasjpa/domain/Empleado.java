package pe.egcc.ventasjpa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Coronel
 */
@Entity
@Table(name = "EMPLEADO")
@NamedQueries({
  @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
  @NamedQuery(name = "Empleado.findByIdemp", query = "SELECT e FROM Empleado e WHERE e.idemp = :idemp"),
  @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
  @NamedQuery(name = "Empleado.findByApellido", query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido"),
  @NamedQuery(name = "Empleado.findByEmail", query = "SELECT e FROM Empleado e WHERE e.email = :email"),
  @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono")})
public class Empleado implements Serializable {
  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @Column(name = "IDEMP")
  private BigDecimal idemp;
  @Basic(optional = false)
  @Column(name = "NOMBRE")
  private String nombre;
  @Basic(optional = false)
  @Column(name = "APELLIDO")
  private String apellido;
  @Basic(optional = false)
  @Column(name = "EMAIL")
  private String email;
  @Column(name = "TELEFONO")
  private String telefono;
  @OneToMany(mappedBy = "idemp", fetch = FetchType.LAZY)
  private List<Venta> ventaList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
  private Usuario usuario;

  public Empleado() {
  }

  public Empleado(BigDecimal idemp) {
    this.idemp = idemp;
  }

  public Empleado(BigDecimal idemp, String nombre, String apellido, String email) {
    this.idemp = idemp;
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
  }

  public BigDecimal getIdemp() {
    return idemp;
  }

  public void setIdemp(BigDecimal idemp) {
    this.idemp = idemp;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public List<Venta> getVentaList() {
    return ventaList;
  }

  public void setVentaList(List<Venta> ventaList) {
    this.ventaList = ventaList;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idemp != null ? idemp.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Empleado)) {
      return false;
    }
    Empleado other = (Empleado) object;
    if ((this.idemp == null && other.idemp != null) || (this.idemp != null && !this.idemp.equals(other.idemp))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.ventasjpa.domain.Empleado[ idemp=" + idemp + " ]";
  }
  
}
