package com.curso04.dinamicwallet.servicios;

import java.util.List;

import com.curso4.dinamicwallet.modelo.Cuenta;

public class BuscaCuenta {
	public static Cuenta buscador(int numeroCuenta){
		CuentaService servicio = new CuentaService();
		List<Cuenta> cuentas = servicio.obtenerCuentas();
		for(Cuenta cuenta : cuentas) {
			if(numeroCuenta == cuenta.getNumeroCuenta()) {
				return cuenta;
			}
		}
		return null;
	}
}
