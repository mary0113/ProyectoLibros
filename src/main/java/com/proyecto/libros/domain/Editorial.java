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
public class Editorial {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ed_id;
    private String ed_nombre;

    /**
     * @return the ed_id
     */
    public Integer getEd_id() {
        return ed_id;
    }

    /**
     * @param ed_id the ed_id to set
     */
    public void setEd_id(Integer ed_id) {
        this.ed_id = ed_id;
    }

    /**
     * @return the ed_nombre
     */
    public String getEd_nombre() {
        return ed_nombre;
    }

    /**
     * @param ed_nombre the ed_nombre to set
     */
    public void setEd_nombre(String ed_nombre) {
        this.ed_nombre = ed_nombre;
    }
    
    
}//Fin de la clase editorial
