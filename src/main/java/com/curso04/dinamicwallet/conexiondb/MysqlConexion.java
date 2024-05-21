package com.curso04.dinamicwallet.conexiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.curso04.dinamicwallet.constantes.Constantes;


public class MysqlConexion {
	
	private static MysqlConexion instancia;
	private Connection connection;
	
	private MysqlConexion() throws SQLException {
		try {
			Class.forName(Constantes.DRIVERMYSQL);
			connection = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.PASSWORD);
		} 
		catch(ClassNotFoundException e) {
			throw new SQLException(e);
		}
	}
	
	public static MysqlConexion getInstancia() throws SQLException {
		if(instancia == null) {
			instancia = new MysqlConexion();
		}
		return instancia;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
}