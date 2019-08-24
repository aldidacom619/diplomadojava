package com.mindwaresrl.egpp.repo.archivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.mindwaresrl.egpp.core.ZonaReparto;
import com.mindwaresrl.egpp.core.ZonaReparto.TipoReparto;


public class RepositorioZonaReparto extends RepositorioAbstracto<ZonaReparto> {

	public static final Integer NRO_CAMPOS = 3;
	public static final Integer INDICE_ID = 0;
	public static final Integer INDICE_NOMBRE = 1;
	public static final Integer INDICE_TIPO_DEPARTO = 2;
	
	public RepositorioZonaReparto(){
		obtenerRegistros();
	}
	
	@Override
	List<String> obtenerLineas(BufferedReader reader) throws IOException {
		List<String> lineasSeccion = new ArrayList<String>();
		
		String linea = null;
		while ( (linea = reader.readLine()) != null ) {
			
		   if (linea.startsWith("#Zona")) {
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
	
	@Override
	ZonaReparto convertirRegistro(String registro) {
		String[] valores = registro.split(SEPARADOR);
		if (valores.length != NRO_CAMPOS) {
			throw new IllegalStateException("Error en el registro de Zona de Reparto");			
		}
		return new ZonaReparto(valores[INDICE_ID], valores[INDICE_NOMBRE], TipoReparto.convert(valores[INDICE_TIPO_DEPARTO]));
	}
	
	@Override
	protected String getNombreArchivo() {
		return "comunidad.txt";
	}
		
}
