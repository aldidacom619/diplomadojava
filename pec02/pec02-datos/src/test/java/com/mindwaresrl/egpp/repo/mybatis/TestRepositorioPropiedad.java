package com.mindwaresrl.egpp.repo.mybatis;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mindwaresrl.egpp.core.Propiedad;


public class TestRepositorioPropiedad  {

	private static SqlSessionFactory sqlSessionFactory;
	private static RepositorioPropiedad repositorio;
	
	@BeforeClass
	public static void iniciarSuite() throws IOException{
	    if(sqlSessionFactory==null) {
	       InputStream  inputStream = Resources.getResourceAsStream("mybatis-config.xml");
	        sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		}
	    
	    repositorio = new RepositorioPropiedad(sqlSessionFactory
	    										, new RepositorioZonaReparto(sqlSessionFactory)
	    										, new RepositorioPropietario(sqlSessionFactory));
	}

	
	@Test
    public void testRecuperarTodos() {
    	List<Propiedad> zonas = repositorio.recuperarTodos();

    	assertTrue(zonas.size()==19);
    }
    
	@Test
    public void testRecuperar() {
    	Propiedad propiedad = repositorio.recuperar("2-B");

    	assertTrue(propiedad != null);
    }	

	@AfterClass
	public static void finalizarSuite(){

	}

}
