/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Cliente;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Emilio
 */
@ManagedBean (name = "sesion")
@SessionScoped
public class sesionBean implements Serializable{
    
    public void verificarSesion(){
        try{
            Cliente cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
            LoginBean loginBean = new LoginBean();
            loginBean.usuario = cliente.getNombre(); 
            if(cliente == null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("index");
            }
        }catch(Exception e){
            
        }
    }
    public String cerrarSesion(){
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index";
    }
}
