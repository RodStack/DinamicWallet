package com.curso04.dinamicwallet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso04.dinamicwallet.servicios.CuentaService;
import com.curso4.dinamicwallet.modelo.Cuenta;

/**
 * Servlet implementation class CuentaModify
 */
@WebServlet("/update")
public class CuentaModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaModifyServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Capturamos parametros desde el formulario
    	String cuentaNumero = request.getParameter("numeroCuenta");
		int numeroCuenta = Integer.parseInt(cuentaNumero);
		String titularCuenta = request.getParameter("titularCuenta");
		String saldo = request.getParameter("saldoCuenta");
		double saldoCuenta = Double.valueOf(saldo);
		Cuenta cuenta = new Cuenta(numeroCuenta, titularCuenta, saldoCuenta);

		
		CuentaService servicio = new CuentaService();
		try {
			servicio.actualizarCuenta(cuenta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("cuentas");
		
	}

}
