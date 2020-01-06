/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Emilio
 */
@Entity
@Table (name = "encuesta")
public class Encuesta {
    @Id
    @Column
    private int id_encuesta;
    @Column 
    private String pregunta;
    @Column
    private String respuesta;
    @Column 
    private String opciones;

    public Encuesta() {
    }
    
    public Encuesta(String pregunta, String respuesta, String opciones) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.opciones = opciones;
    }

    public int getId_encuesta() {
        return id_encuesta;
    }

    public void setId_encuesta(int id_encuesta) {
        this.id_encuesta = id_encuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }
}
