package pe.egcc.demo02.model;

import java.math.BigDecimal;
import pe.egcc.demo02.dto.VentaDto;

public class VentaModel {

  public void procesar(VentaDto dto){
    // Proceso
    BigDecimal total = dto.getPrecio().multiply( 
        new BigDecimal(dto.getCantidad()));
    BigDecimal subtotal = total.divide(new BigDecimal("1.18"), 2);
    BigDecimal impuesto = total.add(subtotal.negate());
    // Retornar
    dto.setSubtotal(subtotal);
    dto.setImpuesto(impuesto);
    dto.setTotal(subtotal);
  }
  
}
