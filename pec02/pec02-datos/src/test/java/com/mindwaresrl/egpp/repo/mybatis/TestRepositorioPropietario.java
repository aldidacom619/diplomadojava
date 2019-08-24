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

import com.mindwaresrl.egpp.core.Propietario;


public class TestRepositorioPropietario  {

	private static SqlSessionFactory sqlSessionFactory;
	private static RepositorioPropietario repositorio;
	
	@BeforeClass
	public static void iniciarSuite() throws IOException{
	    if(sqlSessionFactory==null) {
	       InputStream  inputStream = Resources.getResourceAsStream("mybatis-config.xml");
	        sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		}	
    	repositorio = new RepositorioPropietario(sqlSessionFactory);
	}

	
	@Test
    public void testRecuperarTodos() {
    	List<Propietario> propietarios = repositorio.recuperarTodos();

    	assertTrue(propietarios.size()==15);
    }
    
	@Test
    public void testRecuperar() {
    	Propietario propietario = repositorio.recuperar("01");

    	assertTrue(propietario != null);
    }	

	@AfterClass
	public static void finalizarSuite(){

	}

}
