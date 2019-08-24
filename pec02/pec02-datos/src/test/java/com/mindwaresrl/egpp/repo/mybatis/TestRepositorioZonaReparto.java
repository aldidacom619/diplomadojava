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

import com.mindwaresrl.egpp.core.ZonaReparto;


public class TestRepositorioZonaReparto  {

	private static SqlSessionFactory sqlSessionFactory;
	private static  RepositorioZonaReparto repositorio;
	
	@BeforeClass
	public static void iniciarSuite() throws IOException{
	    if(sqlSessionFactory==null) {
	       InputStream  inputStream = Resources.getResourceAsStream("mybatis-config.xml");
	        sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		}	
	    repositorio = new RepositorioZonaReparto(sqlSessionFactory);
	}

	
	@Test
    public void testRecuperarTodos() {
    	List<ZonaReparto> zonas = repositorio.recuperarTodos();

    	assertTrue(zonas.size()==3);
    }
    
	@Test
    public void testRecuperar() {
    	ZonaReparto zona = repositorio.recuperar("C");

    	assertTrue(zona != null);
    }	

	@AfterClass
	public static void finalizarSuite(){

	}

}
