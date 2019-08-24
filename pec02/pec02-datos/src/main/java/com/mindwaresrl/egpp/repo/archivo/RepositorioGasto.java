package com.mindwaresrl.egpp.repo.archivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.mindwaresrl.egpp.core.Gasto;
import com.mindwaresrl.egpp.core.ZonaReparto;
import com.mindwaresrl.egpp.repo.Repositorio;


public class RepositorioGasto extends RepositorioAbstracto<Gasto> {

	public static final Integer NRO_CAMPOS = 4;
	public static final Integer INDICE_ID = 0;
	public static final Integer INDICE_DESCRIPCION = 1;
	public static final Integer INDICE_IMPORTE = 2;
	public static final Integer INDICE_ID_ZONA_REPARTO = 3;	
	
	
	private Repositorio<ZonaReparto> repositorioZona;
	
	public RepositorioGasto(Repositorio<ZonaReparto> repositorioZona){
		this.repositorioZona = repositorioZona;
		obtenerRegistros();
	}
	
	@Override
	protected List<String> obtenerLineas(BufferedReader reader) throws IOException {
		List<String> lineasSeccion = new ArrayList<String>();
		
		String linea = null;
		while ( (linea = reader.readLine()) != null ) {
			
		   if (linea.startsWith("#") ) {
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
	Gasto convertirRegistro(String registro) {
		String[] valores = registro.split(SEPARADOR);
		if (valores.length != NRO_CAMPOS) {
			throw new IllegalStateException("Error en el registro de Gasto");			
		}
		ZonaReparto zonaReparto = repositorioZona.recuperar(valores[INDICE_ID_ZONA_REPARTO]);
		return new Gasto(valores[INDICE_ID], valores[INDICE_DESCRIPCION], Double.valueOf(valores[INDICE_IMPORTE]), zonaReparto);
	}
	
	@Override
	protected String getNombreArchivo() {
		return "gastos.txt";
	}

}
