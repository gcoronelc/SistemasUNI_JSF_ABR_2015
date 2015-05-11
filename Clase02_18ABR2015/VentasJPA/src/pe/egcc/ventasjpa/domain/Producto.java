package pe.egcc.ventasjpa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PRODUCTO")
@NamedQueries({
  @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
  @NamedQuery(name = "Producto.findByIdprod", query = "SELECT p FROM Producto p WHERE p.idprod = :idprod"),
  @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
  @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
  @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock")})
public class Producto implements Serializable {

  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @Column(name = "IDPROD")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUCTO")
  @SequenceGenerator(name = "SQ_PRODUCTO", sequenceName = "SQ_PRODUCTO")
  private BigInteger idprod;
  @Basic(optional = false)
  @Column(name = "NOMBRE")
  private String nombre;
  @Basic(optional = false)
  @Column(name = "PRECIO")
  private BigDecimal precio;
  @Basic(optional = false)
  @Column(name = "STOCK")
  private BigInteger stock;
  @JoinColumn(name = "IDCAT", referencedColumnName = "IDCAT")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Categoria idcat;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprod", fetch = FetchType.LAZY)
  private List<Detalle> detalleList;

  public Producto() {
  }

  public Producto(BigInteger idprod) {
    this.idprod = idprod;
  }

  public Producto(BigInteger idprod, String nombre, BigDecimal precio, BigInteger stock) {
    this.idprod = idprod;
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
  }

  public BigInteger getIdprod() {
    return idprod;
  }

  public void setIdprod(BigInteger idprod) {
    this.idprod = idprod;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  public BigInteger getStock() {
    return stock;
  }

  public void setStock(BigInteger stock) {
    this.stock = stock;
  }

  public Categoria getIdcat() {
    return idcat;
  }

  public void setIdcat(Categoria idcat) {
    this.idcat = idcat;
  }

  public List<Detalle> getDetalleList() {
    return detalleList;
  }

  public void setDetalleList(List<Detalle> detalleList) {
    this.detalleList = detalleList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idprod != null ? idprod.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Producto)) {
      return false;
    }
    Producto other = (Producto) object;
    if ((this.idprod == null && other.idprod != null) || (this.idprod != null && !this.idprod.equals(other.idprod))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.ventasjpa.domain.Producto[ idprod=" + idprod + " ]";
  }

}
