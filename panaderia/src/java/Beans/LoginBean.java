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
@ManagedBean (name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    public String usuario;
    public String contrasena;
    public Cliente cliente;
    
    
    public String loginControl(){
        Cliente user;
        user = new Cliente(); 
        if(user.encontrar(this.usuario, this.contrasena)){
            if(this.usuario.equals("root")){
                return "admin";
            }else{
                return "cuenta_cliente";
            }
            
        }
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalido"));        
        return "";
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LoginBean() {
    }

    public LoginBean(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
