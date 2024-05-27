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
public class Idioma {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer idioma_id;
  private String idioma_nombre;

    /**
     * @return the idioma_id
     */
    public Integer getIdioma_id() {
        return idioma_id;
    }

    /**
     * @param idioma_id the idioma_id to set
     */
    public void setIdioma_id(Integer idioma_id) {
        this.idioma_id = idioma_id;
    }

    /**
     * @return the idioma_nombre
     */
    public String getIdioma_nombre() {
        return idioma_nombre;
    }

    /**
     * @param idioma_nombre the idioma_nombre to set
     */
    public void setIdioma_nombre(String idioma_nombre) {
        this.idioma_nombre = idioma_nombre;
    }
  
}//Fin de la clase idioma
