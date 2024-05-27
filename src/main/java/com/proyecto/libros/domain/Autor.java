/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author mar13
 */
@Entity
public class Autor {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) 
   private Integer aut_id;
   private String aut_nombre;
   private String aut_apellido;
   private String aut_nacionalidad;

   
   //Getter y Setters
   
    /**
     * @return the aut_id
     */
    public Integer getAut_id() {
        return aut_id;
    }

    /**
     * @param aut_id the aut_id to set
     */
    public void setAut_id(Integer aut_id) {
        this.aut_id = aut_id;
    }

    /**
     * @return the aut_nombre
     */
    public String getAut_nombre() {
        return aut_nombre;
    }

    /**
     * @param aut_nombre the aut_nombre to set
     */
    public void setAut_nombre(String aut_nombre) {
        this.aut_nombre = aut_nombre;
    }

    /**
     * @return the aut_apellido
     */
    public String getAut_apellido() {
        return aut_apellido;
    }

    /**
     * @param aut_apellido the aut_apellido to set
     */
    public void setAut_apellido(String aut_apellido) {
        this.aut_apellido = aut_apellido;
    }

    /**
     * @return the aut_nacionalidad
     */
    public String getAut_nacionalidad() {
        return aut_nacionalidad;
    }

    /**
     * @param aut_nacionalidad the aut_nacionalidad to set
     */
    public void setAut_nacionalidad(String aut_nacionalidad) {
        this.aut_nacionalidad = aut_nacionalidad;
    }
   
   
}//Fin de la clase Autor
