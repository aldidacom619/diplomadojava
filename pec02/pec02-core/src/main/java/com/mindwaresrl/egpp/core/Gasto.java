package com.mindwaresrl.egpp.core;


public class Gasto implements Entidad {

	private String id;
	private String descripcion;
	private Double importe;
	private ZonaReparto zonaReparto;

	public Gasto(String id, String descripcion, Double importe, ZonaReparto zonaReparto) {
		this.id = id;
		this.descripcion = descripcion;
		this.importe = importe;
		this.zonaReparto = zonaReparto;
		this.zonaReparto.getGastos().add(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public ZonaReparto getZonaReparto() {
		return zonaReparto;
	}

	public void setZonaReparto(ZonaReparto zonaReparto) {
		this.zonaReparto = zonaReparto;
	}
}
