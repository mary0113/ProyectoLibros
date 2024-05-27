/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.service;

import com.proyecto.libros.domain.Autor;
import com.proyecto.libros.domain.Libro;
import com.proyecto.libros.repository.LibroRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author mar13
*/
@Service
public class LibroService {
    
    //Atributo del tipo LibroRepository 
    private final LibroRepository libroRepository;
    
    //Constructor que recibe como parametro un objeto de tipo LibroRepository
    public LibroService(LibroRepository libroRepository ){
        this.libroRepository = libroRepository;
    }
    
    
    //Busca y retorna todos los libros destacados.
    public List<Libro> buscarDestacados(){
     return libroRepository.buscarTodos();
    }
    
    //Busca lista de libros por id de la editorial
    public List<Libro> buscarPorEditorial(int ed_id){
        return libroRepository.buscarPorEditorial(ed_id);
    }
    
    //Realiza una consulta en la bd para buscar libros por nombre
    public List<Libro> buscar(String consulta){
        return libroRepository.buscar(consulta);
    }
    
    //Guarda un libro en la bd
    public Libro guardar(Libro libro){
        return libroRepository.save(libro);
    }
    
    //Permite buscar un libro por su identificador
    public Optional<Libro> buscarPorId(int id){
        return libroRepository.findById(id);
    }
    
    //Elimina un libro por su id
    public void eliminarPorId(int id){
        libroRepository.deleteById(id);
    }
    
    //Guarda los cambios realizados en un libro
    public void guardarCambios(Libro libro){
        libroRepository.save(libro);
    }
   
   
    
   //Consultas
   public List<Libro> buscarPorAutorYEditorial(int autorId, int editorialId) {
        return libroRepository.buscarPorAutorYEditorial(autorId, editorialId);
    }

    public List<Libro> buscarPorCategoria(int categoriaId) {
        return libroRepository.buscarPorCategoria(categoriaId);
    }

    //Subconsultas
    //Metodo para buscar libro por categoria y precio
    public List<Libro> buscarPorPrecioYCategoria(BigDecimal precio, String nombreCategoria) {
        return libroRepository.buscarPorPrecioYCategoria(precio, nombreCategoria);
    }
 
    //Metodo para buscar libros por idioma
    public List<Libro> buscarPorIdioma(String nombreIdioma) {
        return libroRepository.buscarPorIdioma(nombreIdioma);
    }

    // Método para buscar libros por la nacionalidad del autor
    public List<Libro> buscarLibrosPorNacionalidadAutor(String nacionalidad) {
        return libroRepository.buscarLibrosPorNacionalidadAutor(nacionalidad);
    }
    
}//Fin de la clase


