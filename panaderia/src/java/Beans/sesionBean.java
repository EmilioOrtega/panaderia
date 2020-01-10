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
    public  String usuario;
    public String inv;
    
    public void verificarSesion(){
        try{
             usuario = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"); 
            if(usuario.equals("") ||( usuario.equals("visitante"))){ 
                         FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
 
        }catch(Exception e){
            
        }
    }   
        
        public void verificarSesionInvitado(){
        try{
             vist = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           
            if(!vist.equals("visitante") || vist.equals(null)){
                   FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }

            
        }catch(Exception e){
            
        }
    }
    
        public void verificarSesionAdmin(){
        try{
             admin = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
           
            if(!admin.equals("root")){
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
