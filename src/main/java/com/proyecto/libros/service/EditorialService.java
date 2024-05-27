/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.service;

import com.proyecto.libros.domain.Editorial;
import com.proyecto.libros.repository.EditorialRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar13
 */

@Service
public class EditorialService {

    private final EditorialRepository editorialRepository;
    
    //Constructor de la clase
    public EditorialService(EditorialRepository editorialRepository){
       this.editorialRepository = editorialRepository;
    }
    
    //Busca y retorna todas las editoriales.
    public List<Editorial> buscarTodos(){
        return editorialRepository.findAll();
    }
    
    //Guardar una editorial en la bd
    public Editorial guardar(Editorial editorial){
       return editorialRepository.save(editorial);
    }
    
    //Permite buscar una editorial por su id
    public Optional<Editorial> buscarPorId(int id){
        return editorialRepository.findById(id);
    }
    
    //Elimina una editorial por su id
    public void eliminarPorId(int id){
        editorialRepository.deleteById(id);
    }
    
    //Guarda los cambios
    public void guardarCambios(Editorial editorial){
        editorialRepository.save(editorial);
    }
    
    
    //Realiza una consulta en la bd para buscar editorial por nombre
    public List<Editorial> buscar(String consulta){
        return editorialRepository.buscar(consulta);
    }
    
    // Actualizar una editorial utilizando el procedimiento almacenado
    public void updateEditorial(Integer id, String nombre) {
        editorialRepository.updateEditorial(id, nombre);
    }
    
}//Fin de la clase
