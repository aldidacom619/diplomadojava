package com.mindwaresrl.egpp.repo.archivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import junit.framework.TestCase;
import com.mindwaresrl.egpp.core.ZonaReparto;



public class TestRepositorioZonaReparto extends TestCase {

    public void testConvertirRegistro() {
    	RepositorioZonaReparto repositorio = new RepositorioZonaReparto();
    	ZonaReparto zonaReparto = repositorio.convertirRegistro("E;Escalera;P");

    	assertEquals("E", zonaReparto.getId());
    	assertEquals("Escalera", zonaReparto.getNombre());
    	assertEquals(ZonaReparto.TipoReparto.PROPORCIONAL, zonaReparto.getTipoReparto());
    }

    public void testRecuperarTodos() {
    	RepositorioZonaReparto repositorio = new RepositorioZonaReparto();
    	List<ZonaReparto> zonas = repositorio.recuperarTodos();

    	assertTrue(zonas.size()==3);
    }
    
    public void testobtenerLineas(){
    	try (BufferedReader reader = new BufferedReader(new FileReader("comunidad.txt"))) {
    		RepositorioZonaReparto lineas = new RepositorioZonaReparto();
    		List<String> lineasSeccion = lineas.obtenerLineas(reader);
    		
    		assertEquals(3, lineasSeccion.size());
		}
		catch (FileNotFoundException e) {
			throw new IllegalStateException("Archivo no encontrado " + "comunidad.txt");
		}
		catch (IOException e) {
			throw new IllegalStateException("Error de entrada/salida");
		}
    }    
    
    
}
