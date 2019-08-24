package com.mindwaresrl.egpp.repo.archivo;

import java.util.List;
import junit.framework.TestCase;
import com.mindwaresrl.egpp.core.Gasto;



public class TestRepositorioGasto extends TestCase {

    public void testConvertirRegistro() {
    	RepositorioZonaReparto repositorioZona = new RepositorioZonaReparto();
    	RepositorioGasto repositorio = new RepositorioGasto(repositorioZona);
    	Gasto gasto = repositorio.convertirRegistro("L001;Luz Escalera;56.1;E");

    	assertEquals("L001", gasto.getId());
    	assertEquals("Luz Escalera", gasto.getDescripcion());
    	assertEquals(56.1, gasto.getImporte());
    	assertEquals("E", gasto.getZonaReparto().getId());
    }

    public void testRecuperarTodos() {
    	RepositorioZonaReparto repositorioZona = new RepositorioZonaReparto();
    	RepositorioGasto repositorio = new RepositorioGasto(repositorioZona);
    	List<Gasto> gastos = repositorio.recuperarTodos();

    	assertTrue(gastos.size()==13);
    }
    
}
