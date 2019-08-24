package com.mindwaresrl.egpp.repo.archivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.mindwaresrl.egpp.core.Comunidad;


public class RepositorioComunidad extends RepositorioAbstracto<Comunidad> {

	public static final Integer NRO_CAMPOS = 3;
	public static final Integer INDICE_ID = 0;
	public static final Integer INDICE_NOMBRE = 1;
	public static final Integer INDICE_POBLACION = 2;
	
	public RepositorioComunidad(){
		obtenerRegistros();
	}

	@Override
	protected List<String> obtenerLineas(BufferedReader reader) throws IOException {
		List<String> lineasSeccion = new ArrayList<String>();
		
		String linea = null;
		while ( (linea = reader.readLine()) != null ) {
			
		   if (linea.startsWith("#Comunidad") ) {
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
	Comunidad convertirRegistro(String registro) {
		String[] valores = registro.split(SEPARADOR);
		if (valores.length != NRO_CAMPOS) {
			throw new IllegalStateException("Error en el registro de Comunidad");			
		}
		return new Comunidad(valores[INDICE_ID], valores[INDICE_NOMBRE], valores[INDICE_POBLACION]);
	}


	@Override
	protected String getNombreArchivo() {
		return "comunidad.txt";
	}
	
}
