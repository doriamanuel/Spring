package com.eduit.spring.ws.repository;

import org.springframework.data.repository.CrudRepository;

import com.eduit.spring.ws.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
