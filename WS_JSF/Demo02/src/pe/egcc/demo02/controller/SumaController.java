package pe.egcc.demo02.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="panchito")
@RequestScoped
public class SumaController {

  private Integer num1;
  private Integer num2;
  private Integer suma;
  public Integer getNum1() {
    return num1;
  }
  public void setNum1(Integer num1) {
    this.num1 = num1;
  }
  public Integer getNum2() {
    return num2;
  }
  public void setNum2(Integer num2) {
    this.num2 = num2;
  }
  public Integer getSuma() {
    return suma;
  }
  public void setSuma(Integer suma) {
    this.suma = suma;
  }
  
  public void doSumar() {
    try{
      suma = num1 + num2;
    } catch(Exception e){
      FacesMessage msg;
      msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
          "Error en el proceso.", "Datos podrian estar incorrectos.");
      FacesContext.getCurrentInstance().addMessage(null, msg);
    }
  }
  
}
