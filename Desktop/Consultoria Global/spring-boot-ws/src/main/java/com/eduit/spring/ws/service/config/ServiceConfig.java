package com.eduit.spring.ws.service.config;

import com.eduit.spring.ws.repository.PersonaRepository;
import com.eduit.spring.ws.service.PersonaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
   
    
    @Bean
    public PersonaService personaService(PersonaRepository personaRepository){
        return new PersonaService(personaRepository);
    }

}
