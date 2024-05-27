/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.libros.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author mar13
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
   
    // Indica a spring que debe inyectar una instancia de UserDetailsService
    //UserDetailsService se utiliza para recuperar la información de los usuarios necesarios para la autenticación y autorización
    @Autowired
    private UserDetailsService userDetailsService;
    
    //Define un bean para PasswordEncoder
    //Utiliza BCryptPasswordEncoder para codificar las contraseñas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    //Configura la cadena de filtros de seguridad (SecurityFilterChain)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/home", "/register").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .defaultSuccessUrl("/listado", true)
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .logoutUrl("/logout") // URL para realizar el logout
                    .logoutSuccessUrl("/login?logout") // URL de redireccionamiento 
                    .invalidateHttpSession(true) // Invalida la sesión HTTP 
                    .deleteCookies("JSESSIONID") // Borrar la cookie de sesión 
                    .permitAll() // Permitir el acceso al logout
            );
        return http.build();
    }
    
    //Define un bean para AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }  
}
