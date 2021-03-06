package com.mindwaresrl.egpp.core;

import java.util.Map;


public class PlazaGaraje extends Propiedad {
	
	public static enum TipoGaraje {
		ABIERTO,
		CERRADO;
		
		public static TipoGaraje convert(String tipo) {
			TipoGaraje tipoGaraje = null;
			switch (tipo) {
				case "A":
					tipoGaraje = ABIERTO;
					break;
				case "C":
					tipoGaraje = CERRADO;				
					break;
				default:
					throw new IllegalStateException("PlazaGaraje.TipoGaraje valor desconocido: " + tipo);
			}
			
			return tipoGaraje;
		}		
		
	}

	private TipoGaraje tipoGaraje;
	private Boolean conDeposito = false;

	
	public PlazaGaraje(String id, Double metrosCuadrados, Propietario propietario, Map<ZonaReparto, Double> porcentajePorZona
			, TipoGaraje tipoGaraje, Boolean conDeposito){
		
		super(id, metrosCuadrados,propietario, porcentajePorZona);		
		this.tipoGaraje =  tipoGaraje;
		this.conDeposito = conDeposito;
	}
	
	public TipoGaraje getTipoGaraje() {
		return tipoGaraje;
	}
	public void setTipoGaraje(TipoGaraje tipoGaraje) {
		this.tipoGaraje = tipoGaraje;
	}
	
	public Boolean isConDeposito() {
		return conDeposito;
	}
	public void setConDeposito(Boolean conDeposito) {
		this.conDeposito = conDeposito;
	}
}
