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
public class Categoria {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)   
  private Integer categ_id;
  private String categ_nombre;

    /**
     * @return the categ_id
     */
    public Integer getCateg_id() {
        return categ_id;
    }

    /**
     * @param categ_id the categ_id to set
     */
    public void setCateg_id(Integer categ_id) {
        this.categ_id = categ_id;
    }

    /**
     * @return the categ_nombre
     */
    public String getCateg_nombre() {
        return categ_nombre;
    }

    /**
     * @param categ_nombre the categ_nombre to set
     */
    public void setCateg_nombre(String categ_nombre) {
        this.categ_nombre = categ_nombre;
    }
  
}//Fin de la clase categoria
