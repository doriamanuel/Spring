package com.eduit.spring.ws.resource.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageArrayResponse {
 
	@JsonProperty("codigoRespuesta")
    private String codigorespuesta;
    @JsonProperty("mensaje")
    private String mensaje;
    @JsonProperty("respuesta")      
    private List<Errores> respuesta = new ArrayList<Errores>();  
    
	public MessageArrayResponse() {
		super();
	}

	public MessageArrayResponse(String codigorespuesta, String mensaje, List<Errores> respuesta) {
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

	public List<Errores> getRespuesta() {
		return respuesta;
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageArrayResponse{");
        sb.append("codigorespuesta=").append(codigorespuesta);
        sb.append(", mensaje='").append(mensaje).append('\'');
        sb.append(", respuesta=").append(respuesta);       
        sb.append('}');
        return sb.toString();
    }
}
