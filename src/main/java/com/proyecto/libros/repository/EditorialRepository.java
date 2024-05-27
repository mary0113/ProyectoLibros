/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.libros.repository;

import com.proyecto.libros.domain.Editorial;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author mar13
 */
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{

//buscar el nombre de la editorial por medio del buscador
@Query("from Editorial ed where ed.ed_nombre like %?1%")
List<Editorial> buscar(String consulta); 
 

// Procedimiento almacenado
    @Procedure(name = "UpdateEditorial")
    void updateEditorial(@Param("p_ed_id") Integer id, @Param("p_ed_nombre") String nombre);
}
