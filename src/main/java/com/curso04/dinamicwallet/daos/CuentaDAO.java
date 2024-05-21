package com.curso04.dinamicwallet.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso04.dinamicwallet.conexiondb.MysqlConexion;
import com.curso4.dinamicwallet.modelo.Cuenta;

public class CuentaDAO {
	private Connection connection;

	public CuentaDAO() {
		try {
			connection = MysqlConexion.getInstancia().getConnection();
			} catch(SQLException ex) {
				
			}	
	}
	
	public boolean crearCuenta(Cuenta cuenta) {
		
		String sql = "INSERT INTO Cuenta (numeroCuenta, titular, saldo) VALUE (?, ?, ?)";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, cuenta.getNumeroCuenta());
			statement.setString(2, cuenta.getTitular());
			statement.setDouble(3, cuenta.getSaldo());
			
			int filasInsertadas = statement.executeUpdate();
			
			return filasInsertadas > 0;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return true;
	}
	
	public List<Cuenta> obtenerCuentas()
	{
		List<Cuenta> cuentas = new ArrayList<>();
		String sentencia_sql = "select * from cuenta";
		try(PreparedStatement statement = connection.prepareStatement(sentencia_sql)){			
				
			ResultSet rs =  statement.executeQuery();
			
			 while (rs.next()) {
	                int numeroCuenta = rs.getInt("numeroCuenta");
	                String nombre = rs.getString("titular");
	                double saldo = rs.getDouble("saldo");
	                Cuenta cuenta = new Cuenta(numeroCuenta, nombre, saldo);
	                cuentas.add(cuenta);
	            }
			
				return cuentas;
			}catch(SQLException ex) {
				ex.printStackTrace();
				return null;
			}
		
	}
	
	public boolean actualizarCuenta(Cuenta cuenta){
		boolean isModify = false;
		String sql = "UPDATE cuenta SET titular = ?, saldo= ? WHERE numeroCuenta = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			
			statement.setString(1, cuenta.getTitular());
			statement.setDouble(2, cuenta.getSaldo());
			statement.setInt(3, cuenta.getNumeroCuenta());
			
			int filasModify = statement.executeUpdate();
			
			if(filasModify > 0) {
				isModify = true;
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return isModify;
		
		
	}
	
	public boolean borrarCuenta(Cuenta cuenta) throws SQLException{
		boolean isDelete = false;
		String sql = "DELETE FROM cuenta WHERE numeroCuenta= ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, cuenta.getNumeroCuenta());
			
			int filasDelete = statement.executeUpdate();
			
			if(filasDelete > 0) {
				isDelete = true;
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return isDelete;	
	}
	
	
	
	
}
