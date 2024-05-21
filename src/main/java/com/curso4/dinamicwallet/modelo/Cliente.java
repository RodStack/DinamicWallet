package com.curso4.dinamicwallet.modelo;

public class Cliente {
	
	private String nombre;
	private int numeroCuenta;
	
	
	public Cliente(String nombre, int numeroCuenta) {
		this.nombre = nombre;
		this.numeroCuenta = numeroCuenta;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNumeroCuenta() {
		return numeroCuenta;
	}


	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
}
