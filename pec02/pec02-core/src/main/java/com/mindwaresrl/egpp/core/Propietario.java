package com.mindwaresrl.egpp.core;

import java.util.ArrayList;
import java.util.List;


public class Propietario implements Entidad {

	private String id;
	private String nombre;
	private String poblacion;
	private String email;
	private List<Propiedad> propiedades = new ArrayList<>();
	
	public Propietario(String id, String nombre, String poblacion, String email){
		this.id = id;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.email = email;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
	
	
	
}
