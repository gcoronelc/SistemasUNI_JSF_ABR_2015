package pe.egcc.ventasjpa.service;

import java.util.List;

/**
 * Operaciones generales
 * 
 * @author Gustavo Coronel
 *
 * @param <T>
 */
public interface ICrud<T> {

  void insertar(T bean);
  
  void actualizar(T bean);
  
  void eliminar(T bean);
  
  List<T> traerTodos();
  
  List<T> traerPorNombre(T bean);
  
  T traerPorId(T bean);
  
}
