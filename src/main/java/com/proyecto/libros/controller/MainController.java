/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author mar13
 */
@Controller
public class MainController {
    
    //Maneja las solicitudes GET a la raíz ("/").
    //Este método devuelve el nombre de la vista "home", que corresponde a la página de inicio de la aplicación
    @GetMapping("/")
    public String home(){
        return "home";
    }
    
    //Maneja las solicitudes GET a la ruta "/login"
    //Este método devuelve el nombre de la vista "login", que corresponde a la página  de inicio de sesión de la aplicación
    @GetMapping("/login")
    public String login(){
        return "login";
    }     
}//Fin de la clase
