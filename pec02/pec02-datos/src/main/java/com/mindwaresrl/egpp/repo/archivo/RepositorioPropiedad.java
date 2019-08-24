package com.mindwaresrl.egpp.repo.archivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import com.mindwaresrl.egpp.core.Departamento;
import com.mindwaresrl.egpp.core.Departamento.TipoVivienda;
import com.mindwaresrl.egpp.core.LocalComercial;
import com.mindwaresrl.egpp.core.PlazaGaraje;
import com.mindwaresrl.egpp.core.PlazaGaraje.TipoGaraje;
import com.mindwaresrl.egpp.core.Propiedad;
import com.mindwaresrl.egpp.core.Propietario;
import com.mindwaresrl.egpp.core.ZonaReparto;
import com.mindwaresrl.egpp.repo.Repositorio;

public class RepositorioPropiedad extends RepositorioAbstracto<Propiedad> {

	public static final Integer NRO_CAMPOS = 7;	
	public static final Integer INDICE_ID = 1;
	public static final Integer INDICE_METROS_CUADRADOS = 2;
	public static final Integer INDICE_ID_PROPIETARIO = 3;
	public static final Integer INDICE_ZONA_REPARTO = 4;
	
	public static final Integer INDICE_ID_ZONA = 0;
	public static final Integer INDICE_PORCENTAJE_PARTICIPACION = 1;	

	public static final Integer INDICE_TIPO_VIVIENDA = 5;
	public static final Integer INDICE_NRO_DORMITORIOS= 6;
	
	public static final Integer INDICE_NOMBRE = 5;
	public static final Integer INDICE_ACTIVIDAD = 6;	
	
	public static final Integer INDICE_TIPO_GARAJE = 5;
	public static final Integer INDICE_CON_DEPOSITO = 6;		
	
	private Repositorio<ZonaReparto> repositorioZona;
	private Repositorio<Propietario> repositorioPropietario;
	
	public RepositorioPropiedad(Repositorio<ZonaReparto> repositorioZona, Repositorio<Propietario> repositorioPropietario){
		this.repositorioZona = repositorioZona;
		this.repositorioPropietario = repositorioPropietario;
		obtenerRegistros();
	}
	
	@Override
	protected List<String> obtenerLineas(BufferedReader reader) throws IOException {
		List<String> lineasSeccion = new ArrayList<String>();
		
		String linea = null;
		while ( (linea = reader.readLine()) != null ) {
			
		   if (linea.startsWith("#Propiedad") ) {
			   while  ( (linea = reader.readLine()) != null ) {
				   if ( StringUtils.isBlank(linea) ) {
					   break;
				   } else if (linea.startsWith(".") ) {
					   continue;
				   }
				   lineasSeccion.add(linea);
			   }
			   break;
		   }
		}
		
		return lineasSeccion;
	}
	
	
	Map<ZonaReparto, Double> convertirZonaReparto(String cadenaZonaReparto) {
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
	
	@Override
	Propiedad convertirRegistro(String registro) {
		String[] valores = registro.split(SEPARADOR);
		
		Propiedad propiedad = null;
		switch (valores[0]) {
		case "D":
			propiedad = crearDepartamento(valores);
			break;
		case "L":
			propiedad = crearLocalComercial(valores);
			break;
		case "G":
			propiedad = crearPlazaGaraje(valores);
			break;

		default:
			throw new IllegalStateException("Tipo de propiedad desconocido");		
		}

		return propiedad;
	}

	@Override
	protected String getNombreArchivo() {
		return "comunidad.txt";
	}
		
	
	private Propiedad crearDepartamento(String[] valores) {
		Propiedad propiedad;
		if (valores.length != NRO_CAMPOS) {
			throw new IllegalStateException("Error en el registro de Departamento");			
		}
		Propietario propietario = repositorioPropietario.recuperar(valores[INDICE_ID_PROPIETARIO]);
		Map<ZonaReparto, Double> porcentajePorZona = convertirZonaReparto(valores[INDICE_ZONA_REPARTO]); 
		
		propiedad = new Departamento(valores[INDICE_ID]
							, Double.valueOf(valores[INDICE_METROS_CUADRADOS])
							, propietario
							, porcentajePorZona
							, TipoVivienda.convert(valores[INDICE_TIPO_VIVIENDA])
							, Integer.valueOf(valores[INDICE_NRO_DORMITORIOS])
						);
//		propietario.getPropiedades().add(propiedad);
		return propiedad;
	}
	
	private Propiedad crearLocalComercial(String[] valores) {
		Propiedad propiedad;
		if (valores.length != NRO_CAMPOS) {
			throw new IllegalStateException("Error en el registro de LocalComercial");			
		}
		Propietario propietario = repositorioPropietario.recuperar(valores[INDICE_ID_PROPIETARIO]);
		Map<ZonaReparto, Double> porcentajePorZona = convertirZonaReparto(valores[INDICE_ZONA_REPARTO]); 
		
		propiedad = new LocalComercial(valores[INDICE_ID]
							, Double.valueOf(valores[INDICE_METROS_CUADRADOS])
							, propietario
							, porcentajePorZona
							, valores[INDICE_NOMBRE]
							, valores[INDICE_ACTIVIDAD]
						);
//		propietario.getPropiedades().add(propiedad);
		return propiedad;
	}	
	
	private Propiedad crearPlazaGaraje(String[] valores) {
		Propiedad propiedad;
		if (valores.length != NRO_CAMPOS) {
			throw new IllegalStateException("Error en el registro de PlazaGaraje");			
		}
		Propietario propietario = repositorioPropietario.recuperar(valores[INDICE_ID_PROPIETARIO]);
		Map<ZonaReparto, Double> porcentajePorZona = convertirZonaReparto(valores[INDICE_ZONA_REPARTO]); 
		
		propiedad = new PlazaGaraje(valores[INDICE_ID]
							, Double.valueOf(valores[INDICE_METROS_CUADRADOS])
							, propietario
							, porcentajePorZona
							, TipoGaraje.convert(valores[INDICE_TIPO_GARAJE]) 
							, "S".equals(valores[INDICE_CON_DEPOSITO])
						);
//		propietario.getPropiedades().add(propiedad);		
		return propiedad;
	}		
	

}
