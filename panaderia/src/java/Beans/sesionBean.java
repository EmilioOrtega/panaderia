/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Cliente;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Emilio
 */
@ManagedBean (name = "sesion")
@SessionScoped
public class sesionBean implements Serializable{
    public  String admin;
    public  String vist;
    public  Cliente usuario;
    
    public void verificarSesion(){
        try{
             usuario = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"); 
                  vist = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"); 
            if(usuario == null && (!vist.equals("visitante")) ){ 
                         FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                        
               
            }
 
        }catch(Exception e){
            
        }
    }   
    
        public void verificarSesionAdmin(){
        try{
             admin = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           
            if(admin.equals("root")){
   
            }
            else if(admin==null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
            else{
                  FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml"); 
            }
        }catch(Exception e){
            
        }
    }
    
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }
}
