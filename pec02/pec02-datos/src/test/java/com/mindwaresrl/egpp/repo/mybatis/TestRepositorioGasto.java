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

import com.mindwaresrl.egpp.core.Gasto;


public class TestRepositorioGasto  {

	private static SqlSessionFactory sqlSessionFactory;
	private static RepositorioGasto repositorio;
	
	@BeforeClass
	public static void iniciarSuite() throws IOException{
	    if(sqlSessionFactory==null) {
	       InputStream  inputStream = Resources.getResourceAsStream("mybatis-config.xml");
	        sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		}
	    
	    repositorio = new RepositorioGasto(sqlSessionFactory
	    										, new RepositorioZonaReparto(sqlSessionFactory));
	}

	
	@Test
    public void testRecuperarTodos() {
    	List<Gasto> gastos = repositorio.recuperarTodos();

    	assertTrue(gastos.size()==13);
    }
    
	@Test
    public void testRecuperar() {
    	Gasto gasto = repositorio.recuperar("L001");

    	assertTrue(gasto != null);
    }	

	@AfterClass
	public static void finalizarSuite(){

	}

}
