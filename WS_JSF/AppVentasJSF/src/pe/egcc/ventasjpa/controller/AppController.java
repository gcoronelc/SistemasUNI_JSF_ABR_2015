package pe.egcc.ventasjpa.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.egcc.ventasjpa.domain.Categoria;
import pe.egcc.ventasjpa.domain.Producto;
import pe.egcc.ventasjpa.service.AppService;

@ManagedBean
@SessionScoped
public class AppController {

  // Listas
  private List<Categoria> listaCategorias;
  private List<Producto> listaProductos;
  // Variable simples
  private BigInteger idcat;
  // Objects
  private AppService appService;
  
  @PostConstruct
  private void initBean(){
    try {
      appService = new AppService();
    } catch (Exception e) {
    }
  }
  
  public List<Categoria> getListaCategorias() {
    if(listaCategorias == null){
      try {
        listaCategorias = appService.traerCategorias(true);
      } catch (Exception e) {
      }
    }
    return listaCategorias;
  }
  
  public void setListaCategorias(List<Categoria> listaCategorias) {
    this.listaCategorias = listaCategorias;
  }
  
  public List<Producto> getListaProductos() {
    if(listaProductos == null){
      listaProductos = new ArrayList<Producto>();
    }
    return listaProductos;
  }
  
  public void setListaProductos(List<Producto> listaProductos) {
    this.listaProductos = listaProductos;
  }
  
  public BigInteger getIdcat() {
    return idcat;
  }
  
  public void setIdcat(BigInteger idcat) {
    this.idcat = idcat;
  }
  
  public void doConsultarProductos() {
    FacesMessage fm = null;
    try {
      listaProductos = appService.traerProductos(idcat);
      if(listaProductos.isEmpty()){
        fm = new FacesMessage(FacesMessage.SEVERITY_INFO, 
            "No se encontros resultado.", "La categoria no tiene productos registrados.");
      }
    } catch (Exception e) {
      fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
          "Error en el proceso.", e.getMessage());
    }
    if(fm != null){
      FacesContext.getCurrentInstance().addMessage(null, fm);
    }
  }
  
}
