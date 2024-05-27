/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.libros.repository;

import com.proyecto.libros.domain.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mar13
 */
public interface IdiomaRepository extends JpaRepository<Idioma, Integer>{
    
    
}
