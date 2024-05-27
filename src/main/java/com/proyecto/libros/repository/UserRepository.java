/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.libros.repository;

import com.proyecto.libros.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mar13
 */
public interface UserRepository extends JpaRepository<User, Long>{
   
    //Busca un usuario por su nombre de usuario.
    User findByUsername(String username); 
}
