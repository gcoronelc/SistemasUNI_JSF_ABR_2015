/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.egcc.ventasjpa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Basic;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Coronel
 */
@Entity
@Table(name = "DETALLE")
@NamedQueries({
  @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d"),
  @NamedQuery(name = "Detalle.findByIddetalle", query = "SELECT d FROM Detalle d WHERE d.iddetalle = :iddetalle"),
  @NamedQuery(name = "Detalle.findByPrecio", query = "SELECT d FROM Detalle d WHERE d.precio = :precio"),
  @NamedQuery(name = "Detalle.findByCant", query = "SELECT d FROM Detalle d WHERE d.cant = :cant"),
  @NamedQuery(name = "Detalle.findBySubtotal", query = "SELECT d FROM Detalle d WHERE d.subtotal = :subtotal")})
public class Detalle implements Serializable {
  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @Column(name = "IDDETALLE")
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_DETALLE")
  @SequenceGenerator(name="SQ_DETALLE", sequenceName="SQ_DETALLE", allocationSize=1)
  private BigDecimal iddetalle;
  @Basic(optional = false)
  @Column(name = "PRECIO")
  private BigDecimal precio;
  @Basic(optional = false)
  @Column(name = "CANT")
  private BigInteger cant;
  @Column(name = "SUBTOTAL")
  private BigDecimal subtotal;
  @JoinColumn(name = "IDPROD", referencedColumnName = "IDPROD")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Producto idprod;
  @JoinColumn(name = "IDVENTA", referencedColumnName = "IDVENTA")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Venta idventa;

  public Detalle() {
  }

  public Detalle(BigDecimal iddetalle) {
    this.iddetalle = iddetalle;
  }

  public Detalle(BigDecimal iddetalle, BigDecimal precio, BigInteger cant) {
    this.iddetalle = iddetalle;
    this.precio = precio;
    this.cant = cant;
  }

  public BigDecimal getIddetalle() {
    return iddetalle;
  }

  public void setIddetalle(BigDecimal iddetalle) {
    this.iddetalle = iddetalle;
  }

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  public BigInteger getCant() {
    return cant;
  }

  public void setCant(BigInteger cant) {
    this.cant = cant;
  }

  public BigDecimal getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(BigDecimal subtotal) {
    this.subtotal = subtotal;
  }

  public Producto getIdprod() {
    return idprod;
  }

  public void setIdprod(Producto idprod) {
    this.idprod = idprod;
  }

  public Venta getIdventa() {
    return idventa;
  }

  public void setIdventa(Venta idventa) {
    this.idventa = idventa;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (iddetalle != null ? iddetalle.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Detalle)) {
      return false;
    }
    Detalle other = (Detalle) object;
    if ((this.iddetalle == null && other.iddetalle != null) || (this.iddetalle != null && !this.iddetalle.equals(other.iddetalle))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.ventasjpa.domain.Detalle[ iddetalle=" + iddetalle + " ]";
  }
  
}
