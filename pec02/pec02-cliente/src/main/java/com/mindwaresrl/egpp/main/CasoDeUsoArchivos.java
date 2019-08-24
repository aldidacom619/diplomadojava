package com.mindwaresrl.egpp.main;

import com.mindwaresrl.egpp.casodeuso.CasoUsoCrearReporte;
import com.mindwaresrl.egpp.casodeuso.CasoUsoCrearReporteImpl;
import com.mindwaresrl.egpp.core.Comunidad;
import com.mindwaresrl.egpp.core.Gasto;
import com.mindwaresrl.egpp.core.Propiedad;
import com.mindwaresrl.egpp.core.Propietario;
import com.mindwaresrl.egpp.core.ZonaReparto;
import com.mindwaresrl.egpp.repo.Repositorio;
import com.mindwaresrl.egpp.repo.archivo.RepositorioComunidad;
import com.mindwaresrl.egpp.repo.archivo.RepositorioGasto;
import com.mindwaresrl.egpp.repo.archivo.RepositorioPropiedad;
import com.mindwaresrl.egpp.repo.archivo.RepositorioPropietario;
import com.mindwaresrl.egpp.repo.archivo.RepositorioZonaReparto;



public class CasoDeUsoArchivos {
	
	public static CasoUsoCrearReporte crearCasoUsoCrearReporte() {
		
		Repositorio<Comunidad> repositorioComunidad = new RepositorioComunidad();
		Repositorio<Propietario> repositorioPropietario = new RepositorioPropietario();
		Repositorio<ZonaReparto> repositorioZonaReparto = new RepositorioZonaReparto();
		Repositorio<Propiedad> repositorioPropiedad = new RepositorioPropiedad(repositorioZonaReparto, repositorioPropietario);
		Repositorio<Gasto> repositorioGasto = new RepositorioGasto(repositorioZonaReparto);
		
		CasoUsoCrearReporte casoUso = new CasoUsoCrearReporteImpl(repositorioComunidad
																			, repositorioPropietario 
																			, repositorioZonaReparto
																			, repositorioPropiedad
																			, repositorioGasto
																			);
		return casoUso;
	}

}
