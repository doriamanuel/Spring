package com.eduit.spring.ws.resource.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaRequest {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("genero")
    private String genero;

    public PersonaRequest() {
    }

    @JsonCreator
    public PersonaRequest(@JsonProperty("id") Long id,
                       @JsonProperty("name") String name,
                       @JsonProperty("email")String email,
                       @JsonProperty("telefono")String telefono,
    				   @JsonProperty("genero")String genero){
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefono = telefono;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

   

    public String getEmail() {
		return email;
	}
	
	public String getTelefono() {
		return telefono;
	}	

	public String getGenero() {
		return genero;
	}
	
	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonaRequest{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append(", genero=").append(genero);
        sb.append('}');
        return sb.toString();
    }
}

