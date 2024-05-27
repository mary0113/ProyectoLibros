/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.controller;

import com.proyecto.libros.domain.Editorial;
import com.proyecto.libros.service.EditorialService;
import com.proyecto.libros.service.LibroService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mar13
 */
@Controller
public class EditorialAbmController {
    
    // Servicio para manejar las operaciones relacionadas con editoriales.
    private final EditorialService editorialService;
    
    //Constructor de la clase
    public EditorialAbmController(EditorialService editorialService){
    this.editorialService = editorialService;
    }  
 
    //Muestra el formulario para dar de alta una nueva editorial.
    @RequestMapping("/editoriales/crear")
    public String mostrarFormAltaEd(Model model){
        //Añade un nuevo objeto Editorial al modelo
        model.addAttribute("editorial", new Editorial());
       //Retorna el nombre de la vista para mostrar el formulario
        return "formeditorial.html";
    }
    
    //Inserta una nueva editorial en la bd
    @PostMapping("/editoriales/guardar")
    public String guardar(Editorial editorial){
        //Guarda la editorial usando el servicio editorialService
        editorialService.guardar(editorial);
        //Redirige a la lista de editoriales después de guardar
        return "redirect:/editoriales";
    }
    
    //Muestra la lista de todas a editoriales
    @GetMapping("/editoriales")
    public String mostrarEditoriales(Model model){
       //Obtiene todas las editoriales usando el servicio editorialService
        List<Editorial> editoriales = editorialService.buscarTodos();
       //Añade la lista de editoriales al modelo
        model.addAttribute("editoriales", editoriales);
       //Retorna el nombre de la vista para mostrar la lista de editoriales
        return "editoriales";
    }
    
    //Elimina una editorial segun su id
    @RequestMapping("editoriales/eliminar")
    public String eliminarEditorialPorId(@RequestParam("id") String idEditorial){
       // Convierte el ID de String a int
        int ide = Integer.parseInt(idEditorial);
        // Llama al servicio para eliminar la editorial por su ID
        editorialService.eliminarPorId(ide);
        // Redirige a la lista de editoriales después de eliminar
        return "redirect:/editoriales";
    }
    
    //Muestra el formulario para editar una editorial según su ID.
    @RequestMapping("editoriales/editar")
    public String mostrarEditarEditorial (@RequestParam("id")String idEditorial, Model model){
     String mensajeError ="";
     
     try{
         //Intenta convertir el id de la editorial a un entero
         int id = Integer.parseInt(idEditorial);
         
         //Busca la editorial por su id
         Optional<Editorial> opcionalEditorial = editorialService.buscarPorId(id);
         
         if(opcionalEditorial.isPresent()){
             //Si la editorial se encuentra, lo agrega al modelo y muestra la vista de la editorial
             Editorial editorial = opcionalEditorial.get();
             model.addAttribute("editorial", editorial);
             return "formEditarEditorial.html";
         }else{
             //si la editorial no se encuentra, muestra una página de error con el mensaje correspondiente
             mensajeError = "Editorial no encontrado";
             model.addAttribute("mensajeError", mensajeError);
             return "error";
         }
       }catch(NumberFormatException e){
           // Si ocurre una excepción al convertir el ID a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. de la editorial inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error"; 
       }
    }
    
    //Guardar cambios al editar una editorial
    @PostMapping("/editoriales/guardarCambios")
    public String guardarCambios(Editorial editorial){
       // Guarda los cambios de la editorial usando el servicio editorialService
        editorialService.guardarCambios(editorial);
       // Redirige a la lista de editoriales después de guardar los cambios
        return "redirect:/editoriales";
    }
   

    
}//Fin de la clase EditorialAbmController

