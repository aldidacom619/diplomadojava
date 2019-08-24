package com.mindwaresrl.egpp.main;

import com.mindwaresrl.egpp.casodeuso.CasoUsoCrearReporte;
import com.mindwaresrl.egpp.casodeuso.CasoUsoCrearReporteImpl;
import com.mindwaresrl.egpp.core.Comunidad;
import com.mindwaresrl.egpp.core.Gasto;
import com.mindwaresrl.egpp.core.Propiedad;
import com.mindwaresrl.egpp.core.Propietario;
import com.mindwaresrl.egpp.core.ZonaReparto;
import com.mindwaresrl.egpp.repo.Repositorio;
import com.mindwaresrl.egpp.repo.mybatis.MyBatis;
import com.mindwaresrl.egpp.repo.mybatis.RepositorioComunidad;
import com.mindwaresrl.egpp.repo.mybatis.RepositorioGasto;
import com.mindwaresrl.egpp.repo.mybatis.RepositorioPropiedad;
import com.mindwaresrl.egpp.repo.mybatis.RepositorioPropietario;
import com.mindwaresrl.egpp.repo.mybatis.RepositorioZonaReparto;



public class CasoDeUsoMyBatis {
	
	public static CasoUsoCrearReporte crearCasoUsoCrearReporte() {
		
		MyBatis.getSqlSessionFactory();
		
		Repositorio<Comunidad> repositorioComunidad = new RepositorioComunidad(MyBatis.getSqlSessionFactory());
		Repositorio<Propietario> repositorioPropietario = new RepositorioPropietario(MyBatis.getSqlSessionFactory());
		Repositorio<ZonaReparto> repositorioZonaReparto = new RepositorioZonaReparto(MyBatis.getSqlSessionFactory());
		Repositorio<Propiedad> repositorioPropiedad = new RepositorioPropiedad(MyBatis.getSqlSessionFactory(),repositorioZonaReparto, repositorioPropietario);
		Repositorio<Gasto> repositorioGasto = new RepositorioGasto(MyBatis.getSqlSessionFactory(),repositorioZonaReparto);
		
		CasoUsoCrearReporte casoUso = new CasoUsoCrearReporteImpl(repositorioComunidad
																			, repositorioPropietario 
																			, repositorioZonaReparto
																			, repositorioPropiedad
																			, repositorioGasto
																			);
		return casoUso;
	}
	
}
