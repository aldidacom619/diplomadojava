package com.mindwaresrl.egpp.repo.mybatis.dto;

public class RegistroPropiedad {

	public final String tipo;
	public final String id;
	public final Double metrosCuadrados;
	public final String idPropietario;
	public final String porcentajeReparto;
	public final String extra1;
	public final String extra2;
	
	public RegistroPropiedad(String tipo ,String id ,Double metrosCuadrados,String idPropietario
							,String porcentajeReparto, String extra1, String extra2)
	{
		this.tipo = tipo;
		this.id = id;
		this.metrosCuadrados = metrosCuadrados;
		this.idPropietario = idPropietario;
		this.porcentajeReparto = porcentajeReparto;
		this.extra1 = extra1;
		this.extra2 = extra2;
	}
}
