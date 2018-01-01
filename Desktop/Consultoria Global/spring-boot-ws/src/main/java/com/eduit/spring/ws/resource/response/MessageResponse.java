package com.eduit.spring.ws.resource.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse {
	
	@JsonProperty("codigoRespuesta")
    private String codigorespuesta;
    @JsonProperty("mensaje")
    private String mensaje;
    @JsonProperty("respuesta")      
    private String respuesta;
    
    
	public MessageResponse() {
		super();
	}


	public MessageResponse(String codigorespuesta, String mensaje, String respuesta) {
		super();
		this.codigorespuesta = codigorespuesta;
		this.mensaje = mensaje;
		this.respuesta = respuesta;
	}


	public String getCodigorespuesta() {
		return codigorespuesta;
	}


	public String getMensaje() {
		return mensaje;
	}


	public String getRespuesta() {
		return respuesta;
	}
    
	
    
 

}
