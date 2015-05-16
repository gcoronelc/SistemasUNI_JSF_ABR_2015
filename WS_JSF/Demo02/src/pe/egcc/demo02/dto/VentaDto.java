package pe.egcc.demo02.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class VentaDto {

  private BigDecimal precio;
  private BigInteger cantidad;
  private BigDecimal subtotal;
  private BigDecimal impuesto;
  private BigDecimal total;

  public BigDecimal getPrecio() {
    return precio;
  }

  public void setPrecio(BigDecimal precio) {
    this.precio = precio;
  }

  public BigInteger getCantidad() {
    return cantidad;
  }

  public void setCantidad(BigInteger cantidad) {
    this.cantidad = cantidad;
  }

  public BigDecimal getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(BigDecimal subtotal) {
    this.subtotal = subtotal;
  }

  public BigDecimal getImpuesto() {
    return impuesto;
  }

  public void setImpuesto(BigDecimal impuesto) {
    this.impuesto = impuesto;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

}
