package com.eduit.spring.ws.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="personas")

public class Persona implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "genero")
    private String genero;    
    
    
	public Persona() {		
	}


	public Persona(String name, String email, String telefono, String genero) {		
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.genero = genero;
	}


	public Persona(Long id, String name, String email, String telefono, String genero) {		
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefono = telefono;
		this.genero = genero;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}
    
    
	 @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("Persona{");
	        sb.append("id=").append(id);
	        sb.append(", name='").append(name).append('\'');
	        sb.append(", email=").append(email);
	        sb.append(", telefono=").append(telefono);
	        sb.append(", genero=").append(genero);
	        sb.append('}');
	        return sb.toString();
	    }

}
