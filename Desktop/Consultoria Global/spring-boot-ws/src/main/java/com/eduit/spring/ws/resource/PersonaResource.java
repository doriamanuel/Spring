package com.eduit.spring.ws.resource;

import com.eduit.spring.ws.resource.request.PersonaRequest;
import com.eduit.spring.ws.resource.response.PersonaResponse;
import com.eduit.spring.ws.resource.response.MessageResponse;
import com.eduit.spring.ws.resource.response.Errores;
import com.eduit.spring.ws.resource.response.MessageArrayResponse;
import com.eduit.spring.ws.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class PersonaResource {
	
	ArrayList<Errores> err = new ArrayList<Errores>();

	@Autowired
	private PersonaService personaService;
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonaResource.class);

	@RequestMapping(value = "/persona/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable("id") Long id) {
		LOGGER.info("getting persona id {} ", id);
		if (!personaService.exists(id)) {
			LOGGER.info("persona id {} not found", id);			
			return new ResponseEntity(
					new MessageResponse("-1", "Parametros incorrectos", "id: " + Long.toString(id) + " no encontrado "),
					HttpStatus.BAD_REQUEST);
		}

		PersonaResponse personaResponse = personaService.getById(id);
		LOGGER.info("persona found ", personaResponse);
		return new ResponseEntity(personaResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/persona", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<?> get() {
		LOGGER.info("getting all personas ");
		List<PersonaResponse> personaResponses = personaService.getAll();
		LOGGER.info("personas founds {} ", personaResponses);
		return new ResponseEntity(personaResponses, HttpStatus.OK);
	}

	@RequestMapping(value = "/persona", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<?> updatePersona(@RequestBody PersonaRequest personaRequest) {
		LOGGER.info("incoming message {} ", personaRequest);
		if (!personaService.exists(personaRequest.getId())) {
			Errores err1= new Errores(Long.toString(personaRequest.getId())," not found ");        	
			LOGGER.info("persona id {} not found", personaRequest.getId());
			return new ResponseEntity(new MessageResponse("-1 ", "Parametros incorrectos", 
					"id: "+ Long.toString(personaRequest.getId()) + " no encontrado"),
					HttpStatus.BAD_REQUEST);
		}
		PersonaResponse personaResponse = personaService.saveOrUpdate(personaRequest);
		LOGGER.info("response message {} ", personaResponse);
		return new ResponseEntity(personaResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/persona",method = RequestMethod.PUT,produces="application/json", consumes="application/json")
    public @ResponseBody ResponseEntity<PersonaResponse> savePersona(@RequestBody PersonaRequest personaRequest){
		err.clear();
		LOGGER.info("incoming message {} ",personaRequest);
        if(personaRequest.getId() != null ){        	
            LOGGER.info("persona id {}must be null",personaRequest.getId());
            return new ResponseEntity(new MessageResponse("-1", "Parametros Incorrectos ",
            		" no se debe ingresar id "), 
            		HttpStatus.BAD_REQUEST);
        }                
        
        if(!personaService.validarEmail(personaRequest.getEmail())){ 	
           	Errores err1= new Errores("email","Formato incorrecto de email"); 
        	err.add(err1);
        }
        if(!personaService.validarTelefono(personaRequest.getTelefono())){        	
        	Errores err2= new Errores("telefono","Formato incorrecto de telefono"); 
        	err.add(err2);
        } 
        
        if	(!err.isEmpty())
        {  
        return new ResponseEntity(new MessageArrayResponse("-1", "Parametros Incorrectos ",  
         		err), HttpStatus.BAD_REQUEST);       
        }      
                                
	PersonaResponse personaResponse = personaService.saveOrUpdate(
			personaRequest);LOGGER.info("response message {} ",personaResponse);
			return new ResponseEntity(new MessageResponse ("0","Transaccion exitosa",
					"  Datos insertados para la persona : " + personaResponse.getName()
					+ " con id : " + personaResponse.getId()),
					HttpStatus.OK);
	}

	@RequestMapping(value = "/persona/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody ResponseEntity<?> delete(@PathVariable("id") Long id) {
		LOGGER.info("Fuiste id {} ", id);
		if (id == null) {
			LOGGER.info("persona id {} is mandatory", id);			
			return new ResponseEntity(
					new MessageResponse("-1 ", "Parametros incorrectos", " id es Obligatory"),
					HttpStatus.BAD_REQUEST);
		}
		if (!personaService.exists(id)) {
			LOGGER.info("persona id {} not found", id);			
			return new ResponseEntity(
					new MessageResponse("-1", "Parametros incorrectos", "id: " + Long.toString(id) + " no encontrado "),
					HttpStatus.BAD_REQUEST);
		}
		personaService.delete(id);
		LOGGER.info("persona id {} deleted successfully ", id);		
		return new ResponseEntity(new MessageResponse("0", "Transaccion exitosa ", "id: " + 
		id + " Borrado Exitoso"), HttpStatus.OK);
	}
	
	}
