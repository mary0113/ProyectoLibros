/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.service;

import com.proyecto.libros.domain.Idioma;
import com.proyecto.libros.repository.IdiomaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar13
 */
@Service
public class IdiomaService {
  private final IdiomaRepository idiomaRepository;

  //Constructor de la clase
  public IdiomaService(IdiomaRepository idiomaRepository){
    this.idiomaRepository = idiomaRepository;  
  }
  
  //Busca y retorna todos los idiomas.
  public List<Idioma> buscarTodos(){
      return idiomaRepository.findAll();
  }
  
}//Fin de la clase IdiomaService
