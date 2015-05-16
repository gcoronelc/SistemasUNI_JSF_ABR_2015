package pe.egcc.demo02.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pe.egcc.demo02.dto.VentaDto;
import pe.egcc.demo02.model.VentaModel;

@ManagedBean
@RequestScoped
public class VentaController {

  private VentaDto dto;
  
  @PostConstruct
  public void initBean(){
    dto = new VentaDto();
  }
  
  public void setDto(VentaDto dto) {
    this.dto = dto;
  }
  
  public VentaDto getDto() {
    return dto;
  }
  
  public String doProcesar(){
    String destino;
    try {
      VentaModel model = new VentaModel();
      model.procesar(dto);
      destino = "ventaResult";
    } catch (Exception e) {
      FacesMessage msg;
      msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
          "Error, datos incorrectos.","");
      FacesContext.getCurrentInstance().addMessage(null, msg);
      destino = "ventaForm";
    }
    return destino;
  }
  
}
