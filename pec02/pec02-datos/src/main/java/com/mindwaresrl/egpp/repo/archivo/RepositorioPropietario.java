package com.mindwaresrl.egpp.repo.archivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.mindwaresrl.egpp.core.Propietario;

public class RepositorioPropietario extends RepositorioAbstracto<Propietario> {
	
	public static final Integer NRO_CAMPOS = 4;
	public static final Integer INDICE_ID = 0;
	public static final Integer INDICE_NOMBRE = 1;
	public static final Integer INDICE_POBLACION = 2;
	public static final Integer INDICE_EMAIL = 3;	


	public RepositorioPropietario(){
		obtenerRegistros();
	}

	@Override
	protected List<String> obtenerLineas(BufferedReader reader) throws IOException {
		List<String> lineasSeccion = new ArrayList<String>();
		
		String linea = null;
		while ( (linea = reader.readLine()) != null ) {
			
		   if (linea.startsWith("#Propietario") ) {
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
	Propietario convertirRegistro(String registro) {
		String[] valores = registro.split(SEPARADOR);
		if (valores.length != NRO_CAMPOS) {
			throw new IllegalStateException("Error en el registro de Propietario");			
		}
		return new Propietario(valores[INDICE_ID], valores[INDICE_NOMBRE], valores[INDICE_POBLACION], valores[INDICE_EMAIL]);
	}
	
	@Override
	protected String getNombreArchivo() {
		return "comunidad.txt";
	}
		
}
