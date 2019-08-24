package com.mindwaresrl.egpp.repo.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mindwaresrl.egpp.core.ZonaReparto;
import com.mindwaresrl.egpp.repo.Repositorio;
import com.mindwaresrl.egpp.repo.mybatis.mapper.MapperZonaReparto;

public class RepositorioZonaReparto implements Repositorio<ZonaReparto>{
	
	private SqlSessionFactory sessionFactory;
	private Map<String, ZonaReparto> bd = null;
	
	public RepositorioZonaReparto(){
		
	}
	
	public RepositorioZonaReparto(SqlSessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public List<ZonaReparto> recuperarTodos() {
		if (this.bd == null) {
			bd = new HashMap<>();
			try ( SqlSession sesionMyBatis = sessionFactory.openSession() ) {
				MapperZonaReparto mapper = sesionMyBatis.getMapper(MapperZonaReparto.class);
				List<ZonaReparto> entidades =  mapper.recuperarTodos();				
				for (ZonaReparto entidad : entidades) {
					this.bd.put(entidad.getId(), entidad);
				}
			}
		}
		
		return new ArrayList<ZonaReparto>(bd.values());		
	}

	@Override
	public ZonaReparto recuperar(String id) {
		//TODO recuperar la ZonaReparto del Map BD, cargar la estructura si es necesario 

		return null;
	}

}
