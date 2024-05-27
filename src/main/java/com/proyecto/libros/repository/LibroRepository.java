/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.libros.repository;

import com.proyecto.libros.domain.Autor;
import com.proyecto.libros.domain.Libro;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author mar13
 */
public interface LibroRepository extends JpaRepository <Libro, Integer> {
    
//Busca y retorna todos los libros ordenados por título.
@Query("Select lib from Libro lib order by lib.lib_titulo")
List<Libro> buscarTodos();

//Busca y retorna todos los libros asociados a una editorial específica ordenados por título.
@Query("from Libro lib where lib.editorial.ed_id =?1 order by lib.lib_titulo")
List<Libro> buscarPorEditorial(int ed_id);
 
//Busca y retorna todos los libros que contienen un término específico en el título.
@Query("from Libro lib where lib.lib_titulo like %?1%")
List<Libro> buscar(String consulta);




//Consultas

 @Query("SELECT l FROM Libro l WHERE l.autor.aut_id = :autorId AND l.editorial.ed_id = :editorialId")
 List<Libro> buscarPorAutorYEditorial(@Param("autorId") int autorId, @Param("editorialId") int editorialId);


 @Query("SELECT l FROM Libro l WHERE l.categoria.categ_id = :categoriaId")
 List<Libro> buscarPorCategoria(@Param("categoriaId") int categoriaId);

 
 //Suconsultas
    // Consulta 2: Libros en un Idioma Específico (Con Subconsulta)
    @Query("SELECT l FROM Libro l WHERE l.idioma.idioma_id = (SELECT i.idioma_id FROM Idioma i WHERE i.idioma_nombre = :nombreIdioma)")
    List<Libro> buscarPorIdioma(@Param("nombreIdioma") String nombreIdioma);

    // Consulta 3: Libros en una Categoría Específica con Precio Mayor a un Valor (Con Subconsulta)
    @Query("SELECT l FROM Libro l WHERE l.categoria.categ_id = (SELECT c.categ_id FROM Categoria c WHERE c.categ_nombre = :nombreCategoria) AND l.lib_precio > :precio")
    List<Libro> buscarPorPrecioYCategoria(@Param("precio") BigDecimal precio, @Param("nombreCategoria") String nombreCategoria);

    // Consulta 4 para buscar libros por la nacionalidad del autor
    @Query("SELECT l FROM Libro l WHERE l.autor.aut_id IN (SELECT a.aut_id FROM Autor a WHERE a.aut_nacionalidad = :nacionalidad)")
    List<Libro> buscarLibrosPorNacionalidadAutor(@Param("nacionalidad") String nacionalidad);

}//Fin de LibroRepository
