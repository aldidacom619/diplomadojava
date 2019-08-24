package com.mindwaresrl.egpp.repo.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mindwaresrl.egpp.core.Comunidad;
import com.mindwaresrl.egpp.repo.Repositorio;
import com.mindwaresrl.egpp.repo.mybatis.mapper.MapperComunidad;

public class RepositorioComunidad implements Repositorio<Comunidad>{
	
	private SqlSessionFactory sessionFactory;
	private Map<String, Comunidad> bd = null;
	
	public RepositorioComunidad(){
		
	}
	
	public RepositorioComunidad(SqlSessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public List<Comunidad> recuperarTodos() {
		if (this.bd == null) {
			bd = new HashMap<>();
			try ( SqlSession sesionMyBatis = sessionFactory.openSession() ) {
				//TODO Complete esta sección consultando la BD para obtener una List<Comunidad>
				//debe emplear los mecanismos de MyBatis para realizar la consulta
				//agrege los elementos de la lista al Map db
			}
		}
		
		return new ArrayList<Comunidad>(bd.values());
	}

	@Override
	public Comunidad recuperar(String id) {
		if (this.bd == null) {
			recuperarTodos();
		}
		
		return bd.get(id);
	}

}
