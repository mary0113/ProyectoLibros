/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;



/**
 *
 * @author mar13
 */

@Entity
public class Libro {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   
   private int lib_id;
   private String lib_isbn;
   private String lib_titulo;
   private String lib_descripcion;
   private BigDecimal lib_precio;
   private String lib_imagen;
   
   @ManyToOne
   @JoinColumn(name="idioma_id")
   private Idioma idioma;
   
   @ManyToOne
   @JoinColumn(name="categ_id")
   private Categoria categoria;
   
   
   @ManyToOne
   @JoinColumn(name="aut_id")
   private Autor autor;
   
   @ManyToOne
   @JoinColumn(name = "ed_id")
   private Editorial editorial;
  
 /**
     * @return the lib_id
     */
    public int getLib_id() {
        return lib_id;
    }

    /**
     * @param lib_id the lib_id to set
     */
    public void setLib_id(int lib_id) {
        this.lib_id = lib_id;
    }



    /**
     * @return the lib_titulo
     */
    public String getLib_titulo() {
        return lib_titulo;
    }

    /**
     * @param lib_titulo the lib_titulo to set
     */
    public void setLib_titulo(String lib_titulo) {
        this.lib_titulo = lib_titulo;
    }

    /**
     * @return the lib_descripcion
     */
    public String getLib_descripcion() {
        return lib_descripcion;
    }

    /**
     * @param lib_descripcion the lib_descripcion to set
     */
    public void setLib_descripcion(String lib_descripcion) {
        this.lib_descripcion = lib_descripcion;
    }

    /**
     * @return the lib_precio
     */
    public BigDecimal getLib_precio() {
        return lib_precio;
    }

    /**
     * @param lib_precio the lib_precio to set
     */
    public void setLib_precio(BigDecimal lib_precio) {
        this.lib_precio = lib_precio;
    }

    /**
     * @return the lib_imagen
     */
    public String getLib_imagen() {
        return lib_imagen;
    }

    /**
     * @param lib_imagen the lib_imagen to set
     */
    public void setLib_imagen(String lib_imagen) {
        this.lib_imagen = lib_imagen;
    }

    /**
     * @return the lib_isbn
     */
    public String getLib_isbn() {
        return lib_isbn;
    }

    /**
     * @param lib_isbn the lib_isbn to set
     */
    public void setLib_isbn(String lib_isbn) {
        this.lib_isbn = lib_isbn;
    }

    /**
     * @return the editorial
     */
    public Editorial getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the idioma
     */
    public Idioma getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
 
}//Fin de la clase Libros
