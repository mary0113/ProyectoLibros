/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.controller;

import com.proyecto.libros.domain.Autor;
import com.proyecto.libros.domain.Editorial;
import com.proyecto.libros.domain.Libro;
import com.proyecto.libros.service.CategoriaService;
import com.proyecto.libros.service.EditorialService;
import com.proyecto.libros.service.LibroService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mar13
 */
@Controller

public class ListadoController {
    // Servicio para manejar las operaciones relacionadas con libros.
    private final LibroService libroService;
    
    // Servicio para manejar las operaciones relacionadas con editoriales
    private final EditorialService editorialService;
    
    // Servicio para manejar las operaciones relacionadas con categorias
    private final CategoriaService categoriaService;
    
    
    //Constructor que recibe como parámetros variables de tipo libroService, editorialService, usuarioService, categoriaService
    public ListadoController(LibroService libroService, EditorialService editorialService,
            CategoriaService categoriaService){
        this.libroService = libroService;
        this.editorialService = editorialService;
        this.categoriaService = categoriaService;
    } 
    
    //Lista los libros destacados y los muestra en una vista.
    //Recibe un parémetro de tipo Model para mandar la informacion de cada libro
   @RequestMapping("/listado")
    public String listarLibros(Model model){
        // busqueda de los libros
        List<Libro> destacados = libroService.buscarDestacados();
        
       // Agrega los libros destacados al modelo con el nombre "libros"
        model.addAttribute("libros", destacados);
       
       // Retorna el nombre de la vista que muestra el listado de libros
        return "listado";
    }
    
    
     /**
     * Retorna una lista de elementos según la editorial
     * @param ed_id
     * @param model
     * @return 
     */
    @RequestMapping("/librosPorEditorial")
    public String listarLibrosPorEditorial(int ed_id, Model model){
         // Realiza una búsqueda de los libros asociados a la editorial
        List<Libro> libros = libroService.buscarPorEditorial(ed_id);
       // Agrega los libros al modelo con el nombre "libros"
        model.addAttribute("libros", libros);
        // Retorna el nombre de la vista que muestra el listado de libros asociados a la editorial
        return "listado.html";
    }
    
    
    //Permite realizar busquedas de libros por su nombre
    @RequestMapping("/buscar")
    public String buscar(@RequestParam("q") String consulta, Model model){
       // Realiza una búsqueda de los libros que coincidan con el término de búsqueda
        List<Libro> libros =libroService.buscar(consulta);
         // Agrega los libros al modelo con el nombre "libros"
        model.addAttribute("libros", libros);
        // Retorna el nombre de la vista que muestra el listado de libros que coinciden con el término de búsqueda
        return "listado.html";
    }
    
   
    
    //Permite realizar busquedas de editoriales por su nombre
    @RequestMapping("/buscarEd")
    public String buscarEd(@RequestParam("q") String consulta, Model model){
       // Realiza una búsqueda de las editoriales que coincidan con el término de búsqueda
        List<Editorial> editoriales = editorialService.buscar(consulta);
       // Agrega los libros al modelo con el nombre editoriales
        model.addAttribute("editoriales", editoriales);
       // Retorna el nombre de la vista que muestra el listado de editoriales que coinciden con el término de búsqueda
        return "editoriales.html";
    }
    
    
    //Busca un libro por su ID y lo muestra en una vista.
    @RequestMapping("/buscarLibroPorId")
    public String buscarLibroPorId(@RequestParam("libroId") String idLibro, Model model){
        String mensajeError = "";
        
        try{
            //Intenta convertir el ID del libro a un entero
            int id = Integer.parseInt(idLibro);
            
            //Busca el libro por su Id
            Optional<Libro> opcionalLibro = libroService.buscarPorId(id);
            
            if(opcionalLibro.isPresent()){
               //Si el libro se encuentra, lo agrega al modelo y muestra la vista del libro
               Libro libro = opcionalLibro.get();
               model.addAttribute("libro", libro);
               return "libro.html";
            }else{
                //Si el libro no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Libro no encontrado";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        }catch(NumberFormatException e){
            //Si ocurre una excepción al convertir el id a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. del libro inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }
    
    
    //Busca una editorial por su ID y lo muestra en una vista.
    @RequestMapping("/buscarEditorialPorId")
    public String buscarEditorialPorId(@RequestParam("editorialId") String idEditorial, Model model){
        String mensajeError = "";
        
        try{
            //Intenta convertir el ID de editorial a un entero
            int id = Integer.parseInt(idEditorial);
            
            //Busca la editorial por su Id
            Optional<Editorial> opcionalEditorial = editorialService.buscarPorId(id);
            
            if(opcionalEditorial.isPresent()){
               //Si la editorial se encuentra, lo agrega al modelo y muestra la vista 
               Editorial editorial = opcionalEditorial.get();
               model.addAttribute("editorial", editorial);
               return "editoriales.html";
            }else{
                //Si la editorial no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Editorial no encontrado";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        }catch(NumberFormatException e){
            //Si ocurre una excepción al convertir el id a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. de editorial inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }
    
    
    
    
    
    
    //Consultas
    
    @RequestMapping("/librosPorAutorYEditorial")
    public String listarLibrosPorAutorYEditorial(@RequestParam("autor_id") int autorId,
                                                 @RequestParam("editorial_id") int editorialId, Model model) {
        List<Libro> libros = libroService.buscarPorAutorYEditorial(autorId, editorialId);
        model.addAttribute("libros", libros);
        return "listado";
    }
/*
    @RequestMapping("/librosPorPrecioYCategoria")
    public String listarLibrosPorPrecioYCategoria(@RequestParam("precio") String precioStr,
                                                  @RequestParam("categoria_id") int categoriaId, Model model) {
        BigDecimal precio = new BigDecimal(precioStr);
        List<Libro> libros = libroService.buscarPorPrecioYCategoria(precio, categoriaId);
        model.addAttribute("libros", libros);
        return "listado";
    }

    @RequestMapping("/librosPorIdiomaYPrecio")
    public String listarLibrosPorIdiomaYPrecio(@RequestParam("idioma") String idioma,
                                               @RequestParam("precio") String precioStr, Model model) {
        BigDecimal precio = new BigDecimal(precioStr);
        List<Libro> libros = libroService.buscarPorIdiomaYPrecio(idioma, precio);
        model.addAttribute("libros", libros);
        return "listado";
    }

    @RequestMapping("/librosPorAutor")
    public String listarLibrosPorAutor(@RequestParam("autor_id") int autorId, Model model) {
        List<Libro> libros = libroService.buscarPorAutor(autorId);
        model.addAttribute("libros", libros);
        return "listado";
    }*/

    @RequestMapping("/librosPorCategoria")
    public String listarLibrosPorCategoria(@RequestParam("categoria_id") int categoriaId, Model model) {
        List<Libro> libros = libroService.buscarPorCategoria(categoriaId);
        model.addAttribute("libros", libros);
        return "listado";
    }
   
    
    //Subconsultas
     // Endpoint para obtener libros en un idioma específico
    @GetMapping("/idioma")
    public String listarLibrosPorIdioma(@RequestParam("nombreIdioma") String nombreIdioma, Model model) {
        List<Libro> libros = libroService.buscarPorIdioma(nombreIdioma);
        model.addAttribute("libros", libros);
        return "listado";
    }

    // Endpoint para obtener libros en una categoría específica con precio mayor a un valor dado
    @GetMapping("/categoriaPrecio")
    public String listarLibrosPorPrecioYCategoria(@RequestParam("nombreCategoria") String nombreCategoria, @RequestParam("precio") String precioStr, 
            Model model) {
        BigDecimal precio = new BigDecimal(precioStr);
        List<Libro> libros = libroService.buscarPorPrecioYCategoria(precio, nombreCategoria);
        model.addAttribute("libros", libros);
        return "listado";
    }

   // Endpoint para obtener libros por la nacionalidad del autor
    @GetMapping("/nacionalidadAutor")
    public String listarLibrosPorNacionalidadAutor(@RequestParam("nacionalidad") String nacionalidad, Model model) {
        List<Libro> libros = libroService.buscarLibrosPorNacionalidadAutor(nacionalidad);
        model.addAttribute("libros", libros);
        return "listado";
    }

}//Fin de la clase ListadoController


  