package com.mindwaresrl.egpp.repo.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mindwaresrl.egpp.core.Departamento;
import com.mindwaresrl.egpp.core.Departamento.TipoVivienda;
import com.mindwaresrl.egpp.core.LocalComercial;
import com.mindwaresrl.egpp.core.PlazaGaraje;
import com.mindwaresrl.egpp.core.PlazaGaraje.TipoGaraje;
import com.mindwaresrl.egpp.core.Gasto;
import com.mindwaresrl.egpp.core.Propietario;
import com.mindwaresrl.egpp.core.ZonaReparto;
import com.mindwaresrl.egpp.repo.Repositorio;
import com.mindwaresrl.egpp.repo.mybatis.dto.RegistroGasto;
import com.mindwaresrl.egpp.repo.mybatis.mapper.MapperGasto;

public class RepositorioGasto implements Repositorio<Gasto>{
	
	public static final Integer INDICE_ID_ZONA = 0;
	public static final Integer INDICE_PORCENTAJE_PARTICIPACION = 1;	
	
	private SqlSessionFactory sessionFactory;
	private Map<String, Gasto> bd = null;
	private Repositorio<ZonaReparto> repositorioZona;;
	
	public RepositorioGasto(){
		
	}
	
	public RepositorioGasto(SqlSessionFactory sessionFactory
								, Repositorio<ZonaReparto> repositorioZona
								){
		this.sessionFactory = sessionFactory;
		this.repositorioZona = repositorioZona;
	}
	

	@Override
	public List<Gasto> recuperarTodos() {
		if (this.bd == null) {
			bd = new HashMap<>();
			try ( SqlSession sesionMyBatis = sessionFactory.openSession() ) {
				MapperGasto mapper = sesionMyBatis.getMapper(MapperGasto.class);
				List<RegistroGasto> registros =  mapper.recuperarTodos();
				for (RegistroGasto registro : registros) {
					//TODO crear las instancia de Gasto empleando las instancia de RegistroGasto
					Gasto gasto = null;
					this.bd.put(gasto.getId(), gasto);
				}
			}
		}
		
		return new ArrayList<Gasto>(bd.values());		
	}

	@Override
	public Gasto recuperar(String id) {
		if (this.bd == null) {
			recuperarTodos();
		}
		
		return bd.get(id);
	}
	

}
