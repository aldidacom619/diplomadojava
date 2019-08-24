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
import com.mindwaresrl.egpp.core.Propiedad;
import com.mindwaresrl.egpp.core.Propietario;
import com.mindwaresrl.egpp.core.ZonaReparto;
import com.mindwaresrl.egpp.repo.Repositorio;
import com.mindwaresrl.egpp.repo.mybatis.dto.RegistroPropiedad;
import com.mindwaresrl.egpp.repo.mybatis.mapper.MapperPropiedad;

public class RepositorioPropiedad implements Repositorio<Propiedad>{
	
	public static final Integer INDICE_ID_ZONA = 0;
	public static final Integer INDICE_PORCENTAJE_PARTICIPACION = 1;	
	
	private SqlSessionFactory sessionFactory;
	private Map<String, Propiedad> bd = null;
	private Repositorio<ZonaReparto> repositorioZona;
	private Repositorio<Propietario> repositorioPropietario;
	
	public RepositorioPropiedad(){
		
	}
	
	public RepositorioPropiedad(SqlSessionFactory sessionFactory
								, Repositorio<ZonaReparto> repositorioZona
								, Repositorio<Propietario> repositorioPropietario ){
		this.sessionFactory = sessionFactory;
		this.repositorioZona = repositorioZona;
		this.repositorioPropietario = repositorioPropietario;
	}
	

	@Override
	public List<Propiedad> recuperarTodos() {
		if (this.bd == null) {
			bd = new HashMap<>();
			try ( SqlSession sesionMyBatis = sessionFactory.openSession() ) {
				MapperPropiedad mapper = sesionMyBatis.getMapper(MapperPropiedad.class);
				List<RegistroPropiedad> registros =  mapper.recuperarTodos();
				for (RegistroPropiedad registro : registros) {
					Propiedad propiedad = convertirRegistro(registro);
					this.bd.put(propiedad.getId(), propiedad);
				}
			}
		}
		
		return new ArrayList<Propiedad>(bd.values());		
	}

	@Override
	public Propiedad recuperar(String id) {
		if (this.bd == null) {
			recuperarTodos();
		}
		
		return bd.get(id);
	}
	
	private Propiedad convertirRegistro(RegistroPropiedad registro) {
		
		Propiedad propiedad = null;
		switch (registro.tipo) {
		case "D":
			propiedad = crearDepartamento(registro);
			break;
		case "L":
			propiedad = crearLocalComercial(registro);
			break;
		case "G":
			propiedad = crearPlazaGaraje(registro);
			break;

		default:
			throw new IllegalStateException("Tipo de propiedad desconocido");		
		}

		return propiedad;
	}

	//TODO Crear una instancia de la clase Departamento empleando los datos del registro
	private Propiedad crearDepartamento(RegistroPropiedad registro) {
		Propiedad propiedad = null;

		return propiedad;
	}
	
	private Propiedad crearLocalComercial(RegistroPropiedad registro) {
		Propiedad propiedad = null;

		Propietario propietario = repositorioPropietario.recuperar(registro.idPropietario);
		Map<ZonaReparto, Double> porcentajePorZona = convertirZonaReparto(registro.porcentajeReparto); 
		
		propiedad = new LocalComercial(registro.id
							, registro.metrosCuadrados
							, propietario
							, porcentajePorZona
							, registro.extra1
							, registro.extra1
						);
		return propiedad;
	}	
	
	private Propiedad crearPlazaGaraje(RegistroPropiedad registro) {
		Propiedad propiedad = null;

		Propietario propietario = repositorioPropietario.recuperar(registro.idPropietario);
		Map<ZonaReparto, Double> porcentajePorZona = convertirZonaReparto(registro.porcentajeReparto); 
		
		propiedad = new PlazaGaraje(registro.id
							, registro.metrosCuadrados
							, propietario
							, porcentajePorZona
							, TipoGaraje.convert(registro.extra1) 
							, "true".equals(registro.extra2)
						);	
		return propiedad;
	}		

	private Map<ZonaReparto, Double> convertirZonaReparto(String cadenaZonaReparto) {
		Map<ZonaReparto, Double> porcentajePorZona = new HashMap<>();
		
		if (StringUtils.isEmpty(cadenaZonaReparto)) return porcentajePorZona;
		
		String[] zonas = cadenaZonaReparto.split(",");
		for (String zona: zonas) {
			String[] valores = zona.split("\\-");
			ZonaReparto zonaReparto = repositorioZona.recuperar(valores[INDICE_ID_ZONA]);
			Double porcentajeParticipacion = Double.valueOf(valores[INDICE_PORCENTAJE_PARTICIPACION]);
			porcentajePorZona.put(zonaReparto, porcentajeParticipacion);
		}
		return porcentajePorZona;
	}	

}
