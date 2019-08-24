package com.mindwaresrl.egpp.repo.mybatis.dto;

public class RegistroGasto {
	public final String id;
	public final String descripcion;
	public final Double importe;
	public final String idZona;
	
	public RegistroGasto(String id, String descripcion, Double importe, String idZona)
	{
		this.id = id;
		this.descripcion = descripcion;
		this.importe= importe ;
		this.idZona = idZona;
	}
}
