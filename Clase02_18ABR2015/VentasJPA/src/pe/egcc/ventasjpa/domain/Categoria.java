package pe.egcc.ventasjpa.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Coronel
 */
@Entity
@Table(name = "CATEGORIA")
@NamedQueries({
  @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
  @NamedQuery(name = "Categoria.findByIdcat", query = "SELECT c FROM Categoria c WHERE c.idcat = :idcat"),
  @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.nombre = :nombre")})
public class Categoria implements Serializable {
  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @Column(name = "IDCAT")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA")
	@SequenceGenerator(name = "SQ_CATEGORIA", sequenceName = "SQ_CATEGORIA")
  private BigInteger idcat;
  @Basic(optional = false)
  @Column(name = "NOMBRE")
  private String nombre;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcat", fetch = FetchType.LAZY)
  private List<Producto> productoList;

  public Categoria() {
  }

  public Categoria(BigInteger idcat) {
    this.idcat = idcat;
  }

  public Categoria(BigInteger idcat, String nombre) {
    this.idcat = idcat;
    this.nombre = nombre;
  }

  public BigInteger getIdcat() {
    return idcat;
  }

  public void setIdcat(BigInteger idcat) {
    this.idcat = idcat;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Producto> getProductoList() {
    if(productoList == null) 
      productoList = new ArrayList<>();
    return productoList;
  }

  public void setProductoList(List<Producto> productoList) {
    this.productoList = productoList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idcat != null ? idcat.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Categoria)) {
      return false;
    }
    Categoria other = (Categoria) object;
    if ((this.idcat == null && other.idcat != null) || (this.idcat != null && !this.idcat.equals(other.idcat))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.ventasjpa.domain.Categoria[ idcat=" + idcat + " ]";
  }
  
}
