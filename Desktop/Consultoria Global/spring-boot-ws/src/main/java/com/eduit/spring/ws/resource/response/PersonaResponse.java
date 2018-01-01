package com.eduit.spring.ws.resource.response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaResponse {

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

    public PersonaResponse() {
    }

    public PersonaResponse(Long id, String name, String email, String telefono, String genero)
    {
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
        final StringBuilder sb = new StringBuilder("PersonaResponse{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email=").append(email);
        sb.append(", telefono=").append(telefono);
        sb.append(", genero=").append(genero);
        sb.append('}');
        return sb.toString();
    }
}

