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

import com.mindwaresrl.egpp.core.Comunidad;


public class TestRepositorioComunidad  {

	private static SqlSessionFactory sqlSessionFactory;
	private static RepositorioComunidad repositorio = new RepositorioComunidad(sqlSessionFactory);
	
	@BeforeClass
	public static void iniciarSuite() throws IOException{
	    if(sqlSessionFactory==null) {
	       InputStream  inputStream = Resources.getResourceAsStream("mybatis-config.xml");
	        sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		}
		repositorio = new RepositorioComunidad(sqlSessionFactory);
	}

	
	@Test
    public void testRecuperarTodos() {
    	List<Comunidad> comunidades = repositorio.recuperarTodos();

    	assertTrue(comunidades.size()==1);
    }
    
	@Test
    public void testRecuperar() {
    	Comunidad comunidad = repositorio.recuperar("01");

    	assertTrue(comunidad != null);
    }	

	@AfterClass
	public static void finalizarSuite(){

	}
}
