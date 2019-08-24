package com.mindwaresrl.egpp.repo.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mindwaresrl.egpp.core.Comunidad;
import com.mindwaresrl.egpp.core.Entidad;
import com.mindwaresrl.egpp.core.Propietario;
import com.mindwaresrl.egpp.repo.Repositorio;
import com.mindwaresrl.egpp.repo.mybatis.mapper.MapperPropietario;

public class RepositorioPropietario implements Repositorio<Propietario>{
	
	private SqlSessionFactory sessionFactory;
	private Map<String, Propietario> bd = null;
	
	public RepositorioPropietario(){
		
	}
	
	public RepositorioPropietario(SqlSessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public List<Propietario> recuperarTodos() {
		if (this.bd == null) {
			bd = new HashMap<>();
			try ( SqlSession sesionMyBatis = sessionFactory.openSession() ) {
				MapperPropietario mapper = sesionMyBatis.getMapper(MapperPropietario.class);
				List<Propietario> entidades =  mapper.recuperarTodos();
				for (Propietario entidad : entidades) {
					this.bd.put(entidad.getId(), entidad);
				}
			}
		}
		
		return new ArrayList<Propietario>(bd.values());		
	}

	@Override
	public Propietario recuperar(String id) {
		if (this.bd == null) {
			recuperarTodos();
		}
		
		return bd.get(id);
	}

}
