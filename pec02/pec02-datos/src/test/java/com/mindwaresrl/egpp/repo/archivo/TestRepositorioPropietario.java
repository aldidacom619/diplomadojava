package com.mindwaresrl.egpp.repo.archivo;

import java.util.List;
import junit.framework.TestCase;
import com.mindwaresrl.egpp.core.Propietario;


public class TestRepositorioPropietario extends TestCase {

    public void testConvertirRegistro() {
    	RepositorioPropietario repositorio = new RepositorioPropietario();
    	Propietario propietario = repositorio.convertirRegistro("01;Jorge Salas;Sopocachi (La Paz);jsalas@dominio.com");

    	assertEquals("01", propietario.getId());
    	assertEquals("Jorge Salas", propietario.getNombre());
    	assertEquals("Sopocachi (La Paz)", propietario.getPoblacion());
    	assertEquals("jsalas@dominio.com", propietario.getEmail());
    }

    public void testRecuperarTodos() {
    	RepositorioPropietario repositorio = new RepositorioPropietario();
    	List<Propietario> propietarios = repositorio.recuperarTodos();

    	assertTrue(propietarios.size()==15);  	
    }

}
