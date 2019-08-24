package com.mindwaresrl.egpp.repo.archivo;

import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import com.mindwaresrl.egpp.core.Departamento;
import com.mindwaresrl.egpp.core.Departamento.TipoVivienda;
import com.mindwaresrl.egpp.core.LocalComercial;
import com.mindwaresrl.egpp.core.PlazaGaraje;
import com.mindwaresrl.egpp.core.PlazaGaraje.TipoGaraje;
import com.mindwaresrl.egpp.core.Propiedad;
import com.mindwaresrl.egpp.core.ZonaReparto;


public class TestRepositorioPropiedad extends TestCase {

    public void testConvertirRegistroLocal() {
    	RepositorioZonaReparto repositorioZona = new RepositorioZonaReparto();
    	RepositorioPropietario repositorioPropietario = new RepositorioPropietario();
    	RepositorioPropiedad repositorio = new RepositorioPropiedad(repositorioZona, repositorioPropietario);
    	LocalComercial local = (LocalComercial) repositorio.convertirRegistro("L;0-C;90;06;E-9;Caprabo;Alimentacion");

    	assertEquals("0-C", local.getId());
    	assertEquals(90.0, local.getMetrosCuadrados());
    	assertEquals("06", local.getPropietario().getId());
    	assertEquals(9.0, local.getPorcentajePorZona().get(repositorioZona.recuperar("E")));
    	assertEquals("Caprabo", local.getNombre());
    	assertEquals("Alimentacion", local.getActividad());
    }
    
    public void testConvertirRegistroDepartamento() {
    	RepositorioZonaReparto repositorioZona = new RepositorioZonaReparto();
    	RepositorioPropietario repositorioPropietario = new RepositorioPropietario();
    	RepositorioPropiedad repositorio = new RepositorioPropiedad(repositorioZona, repositorioPropietario);
    	Departamento departamento = (Departamento) repositorio.convertirRegistro("D;1-A;90;05;E-12,C-12;VH;3");

    	assertEquals(departamento.getId(), "1-A");
    	assertEquals(90.0, departamento.getMetrosCuadrados());
    	assertEquals(departamento.getPropietario().getId(), "05");
    	assertEquals(12.0, departamento.getPorcentajePorZona().get(repositorioZona.recuperar("E")));
    	assertEquals(12.0, departamento.getPorcentajePorZona().get(repositorioZona.recuperar("C")));
    	assertEquals(TipoVivienda.HABITUAL, departamento.getTipoVivienda());
    	assertTrue(departamento.getNumeroDomitorios().equals(3));
    }
    
    public void testConvertirRegistroGaraje() {
    	RepositorioZonaReparto repositorioZona = new RepositorioZonaReparto();
    	RepositorioPropietario repositorioPropietario = new RepositorioPropietario();
    	RepositorioPropiedad repositorio = new RepositorioPropiedad(repositorioZona, repositorioPropietario);
    	PlazaGaraje garaje = (PlazaGaraje) repositorio.convertirRegistro("G;P01;12;05;G-10;A;S");

    	assertEquals(garaje.getId(), "P01");
    	assertEquals(12.0, garaje.getMetrosCuadrados());
    	assertEquals(garaje.getPropietario().getId(), "05");
    	assertEquals(10.0, garaje.getPorcentajePorZona().get(repositorioZona.recuperar("G")));
    	assertEquals(TipoGaraje.ABIERTO, garaje.getTipoGaraje());
    	assertTrue(garaje.isConDeposito());
    }    
    
    public void convertirZonaReparto() {
    	RepositorioZonaReparto repositorioZona = new RepositorioZonaReparto();
    	RepositorioPropietario repositorioPropietario = new RepositorioPropietario();
    	RepositorioPropiedad repositorio = new RepositorioPropiedad(repositorioZona, repositorioPropietario);
    	
    	Map<ZonaReparto, Double> porcentajePorZonaReparto = repositorio.convertirZonaReparto("E-9,C-12");
    	
    	assertTrue(porcentajePorZonaReparto.size() == 2);
    	assertEquals(9.0, porcentajePorZonaReparto.get(repositorioZona.recuperar("E")));    	
    	assertEquals(12.0, porcentajePorZonaReparto.get(repositorioZona.recuperar("C")));    	
    }
    
    public void testRecuperarTodos() {
    	RepositorioZonaReparto repositorioZona = new RepositorioZonaReparto();
    	RepositorioPropietario repositorioPropietario = new RepositorioPropietario();
    	RepositorioPropiedad repositorio = new RepositorioPropiedad(repositorioZona, repositorioPropietario);

    	List<Propiedad> propietarios = repositorio.recuperarTodos();

    	assertTrue(propietarios.size()==19);
    }
    
    
}
