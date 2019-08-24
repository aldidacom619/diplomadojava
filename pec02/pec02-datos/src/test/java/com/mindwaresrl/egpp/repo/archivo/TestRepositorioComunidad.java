package com.mindwaresrl.egpp.repo.archivo;

import java.util.List;
import junit.framework.TestCase;
import com.mindwaresrl.egpp.core.Comunidad;

public class TestRepositorioComunidad extends TestCase {

    public void testConvertirRegistro() {
    	RepositorioComunidad repositorio = new RepositorioComunidad();
    	Comunidad comunidad = repositorio.convertirRegistro("01;Trebol;La Paz");

    	assertEquals("01", comunidad.getId());
    	assertEquals("Trebol", comunidad.getNombre());
    	assertEquals("La Paz", comunidad.getPoblacion());
    }

    public void testRecuperarTodos() {
    	RepositorioComunidad repositorio = new RepositorioComunidad();
    	List<Comunidad> comunidades = repositorio.recuperarTodos();

    	assertTrue(comunidades.size()==1);
    }
    
    
}
