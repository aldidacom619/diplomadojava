package com.mindwaresrl.egpp.main;

import com.mindwaresrl.egpp.casodeuso.CasoUsoCrearReporte;

public class InicioMyBatis {

	public static void main(String[] args) {

		CasoUsoCrearReporte casoUso = CasoDeUsoMyBatis.crearCasoUsoCrearReporte();
		casoUso.ejecutar();
		
		Impresora impresora = new Impresora();
		impresora.imprimirResumen(casoUso.getResumen());
		impresora.imprimirPropiedades(casoUso.getPropiedades());
		impresora.imprimirPropietarios(casoUso.getPropietarios());
		impresora.imprimirCuotas(casoUso.getCuotas());
	}

}
