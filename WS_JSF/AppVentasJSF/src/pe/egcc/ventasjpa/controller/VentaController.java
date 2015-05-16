package pe.egcc.ventasjpa.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.egcc.ventasjpa.domain.Detalle;
import pe.egcc.ventasjpa.domain.Producto;
import pe.egcc.ventasjpa.domain.Venta;
import pe.egcc.ventasjpa.service.AppService;

@ManagedBean
@SessionScoped
public class VentaController {
  
  @ManagedProperty(value="#{logonController}")
  private LogonController logonController;

  private Venta venta;
  private Detalle item;
  private List<Producto> listaProductos;
  private BigInteger idprod;

  @PostConstruct
  public void initBean() {
    doResetVenta();
  }

  public void setLogonController(LogonController logonController) {
    this.logonController = logonController;
  }
  
  public LogonController getLogonController() {
    return logonController;
  }
  
  public BigInteger getIdprod() {
    return idprod;
  }
  public void setIdprod(BigInteger idprod) {
    this.idprod = idprod;
  }
  
  public List<Producto> getListaProductos() {
    System.out.println("Size: " + listaProductos.size());
    return listaProductos;
  }

  public void setListaProductos(List<Producto> listaProductos) {
    this.listaProductos = listaProductos;
  }

  public Detalle getItem() {
    return item;
  }

  public void setItem(Detalle item) {
    this.item = item;
  }

  public Venta getVenta() {
    return venta;
  }

  public void setVenta(Venta venta) {
    this.venta = venta;
  }

  public void doNuevoItem() {
    item = new Detalle();
  }
  
  public void doAgregrItem(){
    for(Producto p: listaProductos){
      if(p.getIdprod().intValue() == idprod.intValue()){
        item.setIdprod(p);
        item.setPrecio(p.getPrecio());
        BigDecimal cant = new BigDecimal(item.getCant());
        item.setSubtotal(item.getPrecio().multiply(cant));
        item.setIdventa(venta);
        break;
      }
    }
    venta.getDetalleList().add(item);
    venta.calcularImporte();
    item = new Detalle();
  }
  
  public void doGrabarVenta() {
    FacesMessage fm = null;
    try{
      // Recuperar el objeto empleado
      venta.setIdemp(logonController.getUsuario().getEmpleado());
      // Fecha actual
      venta.setFecha(new Date());
      // Grabar la venta
      AppService as = new AppService();
      as.grabarVenta(venta);
      doResetVenta();
      fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso ok.", "Venta registrada correctamente.");
    } catch(Exception e){
      
      fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Proceso ok.", e.getMessage());
    }
    FacesContext.getCurrentInstance().addMessage(null, fm);
  }

  public void doResetVenta() {
    venta = new Venta();
    item = new Detalle();
    venta.setImporte(new BigDecimal("0.0"));
    AppService appService = new AppService();
    listaProductos = appService.traerProductos();
  }
}
