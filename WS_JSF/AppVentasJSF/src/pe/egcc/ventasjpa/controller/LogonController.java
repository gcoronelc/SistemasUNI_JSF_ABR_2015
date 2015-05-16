package pe.egcc.ventasjpa.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.egcc.ventasjpa.domain.Usuario;
import pe.egcc.ventasjpa.service.LogonService;

@ManagedBean
@SessionScoped
public class LogonController {

  private Usuario usuario;
  
  @PostConstruct
  private void initBean(){
    usuario = new Usuario();
  }
  
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
  
  public Usuario getUsuario() {
    return usuario;
  }
  
  public String doIngresar(){
    String destino;
    try {
      LogonService ls = new LogonService();
      usuario = ls.validar(usuario.getUsuario(), usuario.getClave());
      destino = "main";
    } catch (Exception e) {
      destino = "index";
      FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
          "Error en el proceso.", e.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    return destino;
  }
}
