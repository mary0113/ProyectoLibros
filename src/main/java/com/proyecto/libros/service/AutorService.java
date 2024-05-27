/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.service;

import com.proyecto.libros.domain.Autor;
import com.proyecto.libros.repository.AutorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar13
 */
@Service
public class AutorService {
  private final AutorRepository autorRepository;
  
  //Constructor de la clase
  public AutorService(AutorRepository autorRepository){
      this.autorRepository = autorRepository;
  }
  
  //Busca y retorna todos los autores.
  public List<Autor> buscarTodos(){
      return autorRepository.findAll();
  }
   
  
}//Fin de la clase AutorService
