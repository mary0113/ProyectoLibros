/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.service;

import com.proyecto.libros.domain.Role;
import com.proyecto.libros.domain.User;
import com.proyecto.libros.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 *
 * @author mar13
 */

/**
 * UserDetailServiceImpl es una implementación de la interfaz UserDetailsService,
 * que se utiliza para autenticar y autorizar a los usuarios en una aplicación
 * Spring Security.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    
    //Carga un usuario por su nombre de usuario.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // Busca el usuario en el repositorio por su nombre de usuario.
        User user = userRepository.findByUsername(username);
        
        // Si el usuario no se encuentra, lanza una excepción
        if ( user == null){
            throw new UsernameNotFoundException("User not found");
        }
        
        // Crea un conjunto de autoridades (roles) otorgadas al usuario.
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        // Agrega cada rol del usuario a las autoridades otorgadas.
        for(Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));           
        }
        
        // Retorna un objeto UserDetails que contiene el nombre de usuario, contraseña y autoridades.
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    
}//Fin de la clase
