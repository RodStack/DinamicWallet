package com.curso04.dinamicwallet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso04.dinamicwallet.servicios.CuentaService;
import com.curso4.dinamicwallet.modelo.Cuenta;

/**
 * Servlet implementation class CreaCuenta
 */
@WebServlet("/cuentas")
public class CuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CuentaService servicio = new CuentaService();
				
		List<Cuenta> cuentas = servicio.obtenerCuentas();
		request.setAttribute("cuentas", cuentas);
        request.getRequestDispatcher("/ingresarCuenta.jsp").forward(request, response);
	}
 	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Capturamos parametros desde el formulario
		String cuentaNumero = request.getParameter("numeroCuenta");
		int numeroCuenta = Integer.parseInt(cuentaNumero);
		String titularCuenta = request.getParameter("titularCuenta");
		String saldo = request.getParameter("saldoCuenta");
		double saldoCuenta = Double.valueOf(saldo);
		
		CuentaService servicio = new CuentaService();
		Cuenta nuevaCuenta = new Cuenta(numeroCuenta, titularCuenta, saldoCuenta);
		servicio.insertarCuenta(nuevaCuenta);
		
		response.sendRedirect("cuentas");
		
	}


}
