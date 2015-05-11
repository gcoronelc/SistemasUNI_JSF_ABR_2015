/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.persistence.Table;

/**
 *
 * @author Gustavo Coronel
 */
@Entity
@Table(name = "TIPO_PAGO")
@NamedQueries({
  @NamedQuery(name = "TipoPago.findAll", query = "SELECT t FROM TipoPago t"),
  @NamedQuery(name = "TipoPago.findByIdtipo", query = "SELECT t FROM TipoPago t WHERE t.idtipo = :idtipo"),
  @NamedQuery(name = "TipoPago.findByNombre", query = "SELECT t FROM TipoPago t WHERE t.nombre = :nombre")})
public class TipoPago implements Serializable {
  private static final long serialVersionUID = 1L;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Id
  @Basic(optional = false)
  @Column(name = "IDTIPO")
  private BigDecimal idtipo;
  @Basic(optional = false)
  @Column(name = "NOMBRE")
  private String nombre;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipo", fetch = FetchType.LAZY)
  private List<Pago> pagoList;

  public TipoPago() {
  }

  public TipoPago(BigDecimal idtipo) {
    this.idtipo = idtipo;
  }

  public TipoPago(BigDecimal idtipo, String nombre) {
    this.idtipo = idtipo;
    this.nombre = nombre;
  }

  public BigDecimal getIdtipo() {
    return idtipo;
  }

  public void setIdtipo(BigDecimal idtipo) {
    this.idtipo = idtipo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Pago> getPagoList() {
    return pagoList;
  }

  public void setPagoList(List<Pago> pagoList) {
    this.pagoList = pagoList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idtipo != null ? idtipo.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TipoPago)) {
      return false;
    }
    TipoPago other = (TipoPago) object;
    if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "pe.egcc.ventasjpa.domain.TipoPago[ idtipo=" + idtipo + " ]";
  }
  
}
