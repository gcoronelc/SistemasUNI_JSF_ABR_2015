package pe.egcc.ventasjpa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Coronel
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
  @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
  @NamedQuery(name = "Usuario.findByIdemp", query = "SELECT u FROM Usuario u WHERE u.idemp = :idemp"),
  @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
  @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
  @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")})
public class Usuario implements Serializable {
  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @Column(name = "IDEMP")
  private BigDecimal idemp;
  @Basic(optional = false)
  @Column(name = "USUARIO")
  private String usuario;
  @Basic(optional = false)
  @Column(name = "CLAVE")
  private String clave;
  @Basic(optional = false)
  @Column(name = "ESTADO")
  private short estado;
  @JoinColumn(name = "IDEMP", referencedColumnName = "IDEMP", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private Empleado empleado;

  public Usuario() {
  }

  public Usuario(BigDecimal idemp) {
    this.idemp = idemp;
  }

  public Usuario(BigDecimal idemp, String usuario, String clave, short estado) {
    this.idemp = idemp;
    this.usuario = usuario;
    this.clave = clave;
    this.estado = estado;
  }

  public BigDecimal getIdemp() {
    return idemp;
  }

  public void setIdemp(BigDecimal idemp) {
    this.idemp = idemp;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public short getEstado() {
    return estado;
  }

  public void setEstado(short estado) {
    this.estado = estado;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
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
    if (!(object instanceof Usuario)) {
      return false;
    }
    Usuario other = (Usuario) object;
    if ((this.idemp == null && other.idemp != null) || (this.idemp != null && !this.idemp.equals(other.idemp))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.ventasjpa.domain.Usuario[ idemp=" + idemp + " ]";
  }
  
}
