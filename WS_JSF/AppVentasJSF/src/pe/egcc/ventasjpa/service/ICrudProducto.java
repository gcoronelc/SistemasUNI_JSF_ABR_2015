package pe.egcc.ventasjpa.service;

import java.util.List;

import pe.egcc.ventasjpa.domain.Categoria;
import pe.egcc.ventasjpa.domain.Producto;

public interface ICrudProducto extends ICrud<Producto>{

  List<Producto> traerPorCategoria(Categoria bean);
  
}
