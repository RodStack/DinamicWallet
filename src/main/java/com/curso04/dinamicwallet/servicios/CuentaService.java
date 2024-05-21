package com.curso04.dinamicwallet.servicios;

import java.sql.SQLException;
import java.util.List;

import com.curso04.dinamicwallet.daos.CuentaDAO;
import com.curso4.dinamicwallet.modelo.Cuenta;

public class CuentaService {
    private final CuentaDAO cuentaDAO; // Instancia compartida de CuentaDAO
    public CuentaService() {
        this.cuentaDAO = new CuentaDAO();
    }

    // Create
    public boolean insertarCuenta(Cuenta cuenta) {
        return cuentaDAO.crearCuenta(cuenta);
    }

    // Select
    public List<Cuenta> obtenerCuentas(){
        return cuentaDAO.obtenerCuentas();
    }

    // Update
    public boolean actualizarCuenta(Cuenta cuenta) throws SQLException{
        return cuentaDAO.actualizarCuenta(cuenta);
    }

    // Delete
    public boolean eliminarCuenta(int numeroCuenta) throws SQLException {
    	cuentaDAO.borrarCuenta(BuscaCuenta.buscador(numeroCuenta));
    	if(BuscaCuenta.buscador(numeroCuenta) == null) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
