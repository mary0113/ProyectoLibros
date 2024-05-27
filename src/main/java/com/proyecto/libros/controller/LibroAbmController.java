/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.controller;

import com.proyecto.libros.domain.Libro;
import com.proyecto.libros.service.AutorService;
import com.proyecto.libros.service.CategoriaService;
import com.proyecto.libros.service.EditorialService;
import com.proyecto.libros.service.IdiomaService;
import com.proyecto.libros.service.LibroService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mar13
 */
@Controller
public class LibroAbmController {
    // Servicio para manejar las operaciones relacionadas con editoriales.
    private final EditorialService editorialService;
    
    // Servicio para manejar las operaciones relacionadas con libros
    private final LibroService libroService;
   
    // Servicio para manejar las operaciones relacionadas con categorias
    private final CategoriaService categoriaService;
    
    // Servicio para manejar las operaciones relacionadas con idiomas
    private final IdiomaService idiomaService;
    
    // Servicio para manejar las operaciones relacionadas con autores
    private final AutorService autorService;
    
    
    //Constructor de la clase 
    public LibroAbmController(EditorialService editorialService,
             LibroService libroService, CategoriaService categoriaService,
             IdiomaService idiomaService, AutorService autorService){
        this.editorialService = editorialService;
        this.libroService = libroService;
        this.categoriaService = categoriaService;
        this.idiomaService = idiomaService;
        this.autorService = autorService;
    }
    
    //Muestra el formulario para dar de alta un nuevo libro
    @RequestMapping("/libros/crear")
    public String mostrarFormAlta(Model model){
      // Agrega listas de editoriales, categorías, idiomas y autores al modelo
        model.addAttribute("editoriales", editorialService.buscarTodos());
        model.addAttribute("categorias", categoriaService.buscarTodos());
        model.addAttribute("idiomas", idiomaService.buscarTodos());
        model.addAttribute("autores", autorService.buscarTodos());
        
       // Agrega un nuevo objeto Libro al modelo
        model.addAttribute("libro", new Libro());
        
        // Retorna el nombre de la vista para mostrar el formulario
        return "formlibro.html";
    }
    
    //Inserta un nuevo libro en la bd
    @PostMapping("/libros/guardar")
    public String guardar(Libro libro){
       // Guarda el nuevo libro usando el servicio libroService
        libroService.guardar(libro);
        
        // Redirige a la página principal después de guardar el libro
        return "redirect:/listado";
    }
    
    
   //Elimina un libro segun su id
    @RequestMapping("/libros/eliminar")
    public String eliminarLibroPorId(@RequestParam("id") String idLibro){
        // Convierte el ID de String a int
        int idl = Integer.parseInt(idLibro);
        
        // Llama al servicio para eliminar el libro por su ID
        libroService.eliminarPorId(idl);
        
        // Redirige a la página principal después de eliminar
        return "redirect:/listado";
    }
    
    //Muestra el formulario para editar un libro según su ID.
    @RequestMapping("/libros/editar")
    public String mostrarEditarLibro(@RequestParam("id") String idLibro, Model model){
     String mensajeError ="";
        
    try{
        //Intenta convertir el id del libro a un entero
        int id = Integer.parseInt(idLibro);
    
        //Busca el libro por su id
        Optional<Libro> opcionalLibro = libroService.buscarPorId(id);
     
        if(opcionalLibro.isPresent()){
             //Si el libro se encuentra, lo agrega al modelo y muestra la vista del libro
             Libro libro = opcionalLibro.get();
             model.addAttribute("libro", libro);
             //Aquí puedes hacer cualquier procesamiento adicional necesario antes de mostrar la página
             model.addAttribute("editoriales", editorialService.buscarTodos());
             model.addAttribute("categorias", categoriaService.buscarTodos());
             model.addAttribute("idiomas", idiomaService.buscarTodos());
             model.addAttribute("autores", autorService.buscarTodos());
             return "formEditarLibro.html";
        }else{
            //si el videojuego no se encuentra, muestra una página de error con el mensaje correspondiente
            mensajeError = "Libro no encontrado";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }catch(NumberFormatException e){
        //Si ocurre una excepcion al convertir el id a entero, muestra una pagina de error con el mensaje correspondiente
        mensajeError = "Id. del libro inválido";
        model.addAttribute("mensajeError", mensajeError);
        return "error";
   }
  }
    
   //Guardar cambios al editar un libro
    @PostMapping("/libros/guardarCambios")
    public String guardarCambios(Libro libro){
       // Guarda los cambios del libro usando el servicio libroService
        libroService.guardarCambios(libro);
        // Redirige a la página principal después de guardar los cambios
        return "redirect:/listado";
    }
}//Fin de la clase   
  
           
   
