package com.eduit.spring.ws.service;

import com.eduit.spring.ws.model.Persona;
import com.eduit.spring.ws.repository.PersonaRepository;
import com.eduit.spring.ws.resource.request.PersonaRequest;
import com.eduit.spring.ws.resource.response.PersonaResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonaService {

	private PersonaRepository personaRepository;

	public PersonaService(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	public PersonaResponse getById(Long id) {
		Persona persona = personaRepository.findOne(id);
		PersonaResponse personaResponse = toPersonaResponse(persona);
		return personaResponse;
	}

	public boolean exists(long id) {
		return personaRepository.exists(id);
	}

	public static boolean validarEmail(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
		}
	
	public static boolean validarTelefono(String telefono) {
		//String regex = "/^([0-9]{3})+(-){0,1}([0-9]{6})$/";
		String regex = "^([0-9]{8})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher2 = pattern.matcher(telefono);

		return matcher2.matches();
		}

	public List<PersonaResponse> getAll() {
		List<PersonaResponse> personaResponses = new ArrayList<>();
		personaRepository.findAll().forEach(persona -> {
			PersonaResponse personaResponse = toPersonaResponse(persona);
			personaResponses.add(personaResponse);
		});
		return personaResponses;
	}

	private PersonaResponse toPersonaResponse(Persona persona) {
		return new PersonaResponse(persona.getId(), persona.getName(), persona.getEmail(), persona.getTelefono(),
				persona.getGenero());
	}

	@Transactional
	public PersonaResponse saveOrUpdate(PersonaRequest personaRequest) {
		Persona persona = new Persona(personaRequest.getId(), personaRequest.getName(), personaRequest.getEmail(),
				personaRequest.getTelefono(), personaRequest.getGenero());
		Persona saved = personaRepository.save(persona);
		PersonaResponse personaResponse = toPersonaResponse(saved);
		return personaResponse;
	}

	public void delete(long id) {
		personaRepository.delete(id);
	}

}
