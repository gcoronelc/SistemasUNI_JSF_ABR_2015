/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.egcc.ventasjpa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Coronel
 */
@Entity
@Table(name = "PAGO")
@NamedQueries({
  @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
  @NamedQuery(name = "Pago.findByIdpago", query = "SELECT p FROM Pago p WHERE p.idpago = :idpago"),
  @NamedQuery(name = "Pago.findByDetalle", query = "SELECT p FROM Pago p WHERE p.detalle = :detalle"),
  @NamedQuery(name = "Pago.findByImporte", query = "SELECT p FROM Pago p WHERE p.importe = :importe"),
  @NamedQuery(name = "Pago.findByObs", query = "SELECT p FROM Pago p WHERE p.obs = :obs")})
public class Pago implements Serializable {
  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @Column(name = "IDPAGO")
  private BigDecimal idpago;
  @Basic(optional = false)
  @Column(name = "DETALLE")
  private String detalle;
  @Basic(optional = false)
  @Column(name = "IMPORTE")
  private BigDecimal importe;
  @Basic(optional = false)
  @Column(name = "OBS")
  private String obs;
  @JoinColumn(name = "IDTIPO", referencedColumnName = "IDTIPO")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private TipoPago idtipo;
  @JoinColumn(name = "IDVENTA", referencedColumnName = "IDVENTA")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Venta idventa;

  public Pago() {
  }

  public Pago(BigDecimal idpago) {
    this.idpago = idpago;
  }

  public Pago(BigDecimal idpago, String detalle, BigDecimal importe, String obs) {
    this.idpago = idpago;
    this.detalle = detalle;
    this.importe = importe;
    this.obs = obs;
  }

  public BigDecimal getIdpago() {
    return idpago;
  }

  public void setIdpago(BigDecimal idpago) {
    this.idpago = idpago;
  }

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public BigDecimal getImporte() {
    return importe;
  }

  public void setImporte(BigDecimal importe) {
    this.importe = importe;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public TipoPago getIdtipo() {
    return idtipo;
  }

  public void setIdtipo(TipoPago idtipo) {
    this.idtipo = idtipo;
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
    hash += (idpago != null ? idpago.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Pago)) {
      return false;
    }
    Pago other = (Pago) object;
    if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.ventasjpa.domain.Pago[ idpago=" + idpago + " ]";
  }
  
}
