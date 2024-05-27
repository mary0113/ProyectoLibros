/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.service;

import com.proyecto.libros.domain.Categoria;
import com.proyecto.libros.repository.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar13
 */
@Service
public class CategoriaService {
   private final CategoriaRepository categoriaRepository;
   
   //Constructor de la clase
   public CategoriaService(CategoriaRepository categoriaRepository){
       this.categoriaRepository = categoriaRepository;
   }
   
   //Busca y retorna todas las categorias
   public List<Categoria> buscarTodos(){
       return categoriaRepository.findAll();
   }
   
}//Fin de la clase
