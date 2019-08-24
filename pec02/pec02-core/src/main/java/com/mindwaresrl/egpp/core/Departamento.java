package com.mindwaresrl.egpp.core;

import java.util.Map;
public class Departamento extends Propiedad {
	
	public static enum TipoVivienda {
		HABITUAL,
		NO_HABITUAL;
		
		public static TipoVivienda convert(String tipo) {
			TipoVivienda tipoVivienda = null;
			switch (tipo) {
				case "VH":
					tipoVivienda = HABITUAL;
					break;
				case "VNH":
					tipoVivienda = NO_HABITUAL;				
					break;
				default:
					throw new IllegalStateException("Departamento.TipoVivienda valor desconocido: " + tipo);
			}
			
			return tipoVivienda;
		}		
	}
	
	private TipoVivienda tipoVivienda;
	private Integer numeroDomitorios;
	
	public Departamento(String id, Double metrosCuadrados, Propietario propietario, Map<ZonaReparto, Double> porcentajePorZona
						,TipoVivienda tipoVivienda, Integer numeroDomitorios){
		
		super(id, metrosCuadrados,propietario, porcentajePorZona);
		this.tipoVivienda = tipoVivienda;
		this.numeroDomitorios = numeroDomitorios;
	}	
	
	public TipoVivienda getTipoVivienda() {
		return tipoVivienda;
	}
	public void setTipoVivienda(TipoVivienda tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}
	
	public Integer getNumeroDomitorios() {
		return numeroDomitorios;
	}
	public void setNumeroDomitorios(Integer numeroDomitorios) {
		this.numeroDomitorios = numeroDomitorios;
	}
}
