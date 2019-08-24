package com.mindwaresrl.egpp.casodeuso;

import java.util.List;

import com.mindwaresrl.egpp.casodeuso.dto.ReporteCuota;
import com.mindwaresrl.egpp.casodeuso.dto.ReportePropiedad;
import com.mindwaresrl.egpp.casodeuso.dto.ReportePropietario;
import com.mindwaresrl.egpp.casodeuso.dto.ReporteResumen;


public interface CasoUsoCrearReporte {
	public void ejecutar();
	public ReporteResumen getResumen();
	public List<ReportePropiedad> getPropiedades();
	public List<ReportePropietario> getPropietarios();
	public ReporteCuota getCuotas();
}
